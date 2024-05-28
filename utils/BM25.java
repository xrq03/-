package com.utils;

import java.util.*;

public class BM25 {
    private List<List<String>> corpus;
    private double k1;
    private double b;
    private double avgdl;
    private Map<String, Double> idf;
    private List<Integer> docLen;
    private int N;

    public BM25(List<List<String>> corpus, double k1, double b) {
        this.corpus = corpus;
        this.k1 = k1;
        this.b = b;
        this.N = corpus.size();
        this.docLen = new ArrayList<>();
        this.idf = new HashMap<>();
        this.initialize();
    }

    private void initialize() {
        double totalDocLen = 0.0;
        for (List<String> doc : corpus) {
            totalDocLen += doc.size();
            docLen.add(doc.size());
            for (String term : doc) {
                idf.put(term, idf.getOrDefault(term, 0.0) + 1.0);
            }
        }
        this.avgdl = totalDocLen / N;

        for (Map.Entry<String, Double> entry : idf.entrySet()) {
            String term = entry.getKey();
            double df = entry.getValue();
            idf.put(term, Math.log((N - df + 0.5) / (df + 0.5) + 1));
        }
    }

    public List<Double> score(List<String> query) {
        List<Double> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            double score = 0.0;
            for (String term : query) {
                if (!idf.containsKey(term)) continue;
                double idfTerm = idf.get(term);
                int freq = countFreq(corpus.get(i), term);
                score += idfTerm * freq * (k1 + 1) / (freq + k1 * (1 - b + b * docLen.get(i) / avgdl));
            }
            scores.add(score);
        }
        return scores;
    }

    private int countFreq(List<String> doc, String term) {
        int count = 0;
        for (String t : doc) {
            if (t.equals(term)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<List<String>> corpus = new ArrayList<>();
        corpus.add(Arrays.asList("hello", "world", "hello"));
        corpus.add(Arrays.asList("world", "world", "world", "world"));
        corpus.add(Arrays.asList("hello", "hello", "world", "world", "world"));

        BM25 bm25 = new BM25(corpus, 1.5, 0.75);
        List<String> query = Arrays.asList("hello");
        List<Double> scores = bm25.score(query);
        System.out.println("BM25 Scores: " + scores);
    }
}

