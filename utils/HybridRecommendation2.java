package com.utils;

import java.util.*;

public class HybridRecommendation2 {
    // 定义喜欢、不喜欢的评分
    private final static int LIKE = 21;
    private final static int DISLIKE = 22;

    // 用户偏好数据
    private Map<String, Map<String, Set<Integer>>> userTopicPreferences;

    // 项目偏好数据
    private Map<String, Map<String, Set<Integer>>> topicUserPreferences;

    // 用户协同过滤权重
    private double userCFWeight;

    // 项目协同过滤权重
    private double itemCFWeight;

    public HybridRecommendation2(double userCFWeight, double itemCFWeight) {
        this.userCFWeight = userCFWeight;
        this.itemCFWeight = itemCFWeight;

        // 构造用户偏好数据集
        userTopicPreferences = new HashMap<>();
        // 添加示例数据（实际系统中，数据应从数据库中加载）
        Map<String, Set<Integer>> user1Preferences = new HashMap<>();
        user1Preferences.put("topic1", new HashSet<>(Arrays.asList(1, 21)));
        user1Preferences.put("topic2", new HashSet<>(Arrays.asList(1, 21)));
        user1Preferences.put("topic3", new HashSet<>(Arrays.asList(1, 21)));
        user1Preferences.put("topic4", new HashSet<>(Arrays.asList(22))); // 用户1不喜欢 topic4
        user1Preferences.put("topic5", new HashSet<>(Arrays.asList(22))); // 用户1不喜欢 topic5
        userTopicPreferences.put("user1", user1Preferences);

        Map<String, Set<Integer>> user2Preferences = new HashMap<>();
        user2Preferences.put("topic1", new HashSet<>(Arrays.asList(1, 21)));
        user2Preferences.put("topic2", new HashSet<>(Arrays.asList(1, 21)));
        user2Preferences.put("topic3", new HashSet<>(Arrays.asList(1, 21)));
        user2Preferences.put("topic6", new HashSet<>(Arrays.asList(1))); // 用户2喜欢 topic6
        user2Preferences.put("topic10", new HashSet<>(Arrays.asList(22))); // 用户2不喜欢 topic10
        user2Preferences.put("topic8", new HashSet<>(Arrays.asList(22))); // 用户2不喜欢 topic8
        userTopicPreferences.put("user2", user2Preferences);

        Map<String, Set<Integer>> user3Preferences = new HashMap<>();
        user3Preferences.put("topic1", new HashSet<>(Arrays.asList(1, 21)));
        user3Preferences.put("topic2", new HashSet<>(Arrays.asList(1, 21)));
        user3Preferences.put("topic3", new HashSet<>(Arrays.asList(21)));
        user3Preferences.put("topic7", new HashSet<>(Arrays.asList(1))); // 用户3喜欢 topic7
        user3Preferences.put("topic10", new HashSet<>(Arrays.asList(22))); // 用户3不喜欢 topic10
        userTopicPreferences.put("user3", user3Preferences);

        // 构造项目偏好数据集
        topicUserPreferences = new HashMap<>();
        // 添加示例数据（实际系统中，数据应从数据库中加载）
        for (String user : userTopicPreferences.keySet()) {
            Map<String, Set<Integer>> userPreferences = userTopicPreferences.get(user);
            for (String topic : userPreferences.keySet()) {
                if (!topicUserPreferences.containsKey(topic)) {
                    topicUserPreferences.put(topic, new HashMap<>());
                }
                topicUserPreferences.get(topic).put(user, userPreferences.get(topic));
            }
        }
    }

    // 计算两个用户之间的相似度
    private double calculateUserSimilarity(Map<String, Set<Integer>> user1Preferences, Map<String, Set<Integer>> user2Preferences) {
        // 计算用户1的评分总和
        double sumUser1 = 0.0;
        for (String topic : user1Preferences.keySet()) {
            sumUser1 += user1Preferences.get(topic).stream().mapToInt(Integer::intValue).sum();
        }
        double meanUser1 = sumUser1 / user1Preferences.size();

        // 计算用户2的评分总和
        double sumUser2 = 0.0;
        for (String topic : user2Preferences.keySet()) {
            sumUser2 += user2Preferences.get(topic).stream().mapToInt(Integer::intValue).sum();
        }
        double meanUser2 = sumUser2 / user2Preferences.size();

        // 计算协方差和方差
        double covariance = 0.0;
        double varianceUser1 = 0.0;
        double varianceUser2 = 0.0;
        Set<String> commonTopics = new HashSet<>(user1Preferences.keySet());
        commonTopics.retainAll(user2Preferences.keySet());
        for (String topic : commonTopics) {
            Set<Integer> ratingsUser1 = user1Preferences.get(topic);
            Set<Integer> ratingsUser2 = user2Preferences.get(topic);
            double deviationUser1 = ratingsUser1.stream().mapToDouble(r -> r - meanUser1).sum();
            double deviationUser2 = ratingsUser2.stream().mapToDouble(r -> r - meanUser2).sum();
            covariance += deviationUser1 * deviationUser2;
            varianceUser1 += Math.pow(deviationUser1, 2);
            varianceUser2 += Math.pow(deviationUser2, 2);
        }

        // 计算皮尔逊相关系数
        double pearsonSimilarity = covariance / (Math.sqrt(varianceUser1) * Math.sqrt(varianceUser2));
        return pearsonSimilarity;
    }

    // 计算两个项目之间的相似度 
    private double calculateItemSimilarity(Map<String, Set<Integer>> topic1Preferences, Map<String, Set<Integer>> topic2Preferences) {
        // 计算两个项目的交集大小
        Set<String> intersection = new HashSet<>(topic1Preferences.keySet());
        intersection.retainAll(topic2Preferences.keySet());

        // 计算两个项目的并集大小
        Set<String> union = new HashSet<>(topic1Preferences.keySet());
        union.addAll(topic2Preferences.keySet());

        // 计算 Jaccard 相似度
        double jaccardSimilarity = (double) intersection.size() / union.size();
        return jaccardSimilarity;
    }


    // 为用户生成推荐列表
    public List<String> generateRecommendations(String userId, int topN) {
        Map<String, Set<Integer>> userPreferences = userTopicPreferences.get(userId);
        if (userPreferences == null) {
            return Collections.emptyList(); //userId 对应的用户偏好不存在
        }

        // 计算用户与其他用户之间的相似度
        Map<String, Double> userSimilarityScores = new HashMap<>();
        for (String otherUser : userTopicPreferences.keySet()) {
            if (!otherUser.equals(userId)) {
                double similarity = calculateUserSimilarity(userPreferences, userTopicPreferences.get(otherUser));
                userSimilarityScores.put(otherUser, similarity * userCFWeight);
            }
        }

        // 计算项目与其他项目之间的相似度
        Map<String, Double> itemSimilarityScores = new HashMap<>();
        for (String topic : topicUserPreferences.keySet()) {
            double similarity = calculateItemSimilarity(userPreferences, topicUserPreferences.get(topic));
            itemSimilarityScores.put(topic, similarity * itemCFWeight);
        }

        // 合并用户相似度和项目相似度
        Map<String, Double> combinedScores = new HashMap<>();
        for (String user : userSimilarityScores.keySet()) {
            combinedScores.put(user, userSimilarityScores.get(user));
        }
        for (String topic : itemSimilarityScores.keySet()) {
            combinedScores.put(topic, itemSimilarityScores.get(topic));
        }

        // 根据综合相似度对用户和项目进行排序
        List<Map.Entry<String, Double>> sortedCombinedScores = new ArrayList<>(combinedScores.entrySet());
        sortedCombinedScores.sort((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));

        // 获取推荐的话题
        List<String> recommendations = new ArrayList<>();
        for (Map.Entry<String, Double> entry : sortedCombinedScores) {
            String key = entry.getKey();
            if (!key.startsWith("user")) { // 如果推荐项不是用户，则添加到推荐列表中
                recommendations.add(key);
                if (recommendations.size() >= topN) {
                    break;
                }
            }
        }

        return recommendations;
    }

    public static void main(String[] args) {
        double userCFWeight = 0.7; // 用户协同过滤权重
        double itemCFWeight = 0.3; // 项目协同过滤权重
        HybridRecommendation2 hybridRecommendation = new HybridRecommendation2(userCFWeight, itemCFWeight);
        List<String> recommendations = hybridRecommendation.generateRecommendations("user1", 4);
        System.out.println("用户1的推荐话题:");
        for (String topic : recommendations) {
            System.out.println(topic);
        }
    }
}
