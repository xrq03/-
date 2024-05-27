package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.GroupMsgContent;
import com.entity.Message;
import com.entity.UserEntity;
import com.entity.YonghuEntity;
import com.github.binarywang.java.emoji.EmojiConverter;
import com.service.GroupMsgContentService;
import com.service.UserService;
import com.service.YonghuService;
import com.utils.TuLingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * websocket聊天
 * @date 2020/6/16 - 23:34
 */
@Controller
public class WsController {

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;


  @Resource
  private YonghuService yonghuService;


  @Resource
  private UserService userService;

  /**
   * 单聊的消息的接受与转发
   * @param
   * @param message
   */
  @MessageMapping("/ws/chat")
  public void handleMessage(Message message){


    YonghuEntity yonghuView = null;
    UserEntity username = null;
    Long fromId=null;
    String name = null;
    String touxiang=null;
    String userName = null;
    if("yonghu".equals(message.getTableName())) {
      yonghuView = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("username", message.getFrom()));
      fromId = yonghuView.getId();
      name = yonghuView.getYonghuxingming();
      touxiang = yonghuView.getTouxiang();
      userName = yonghuView.getUsername();
    }else {
      username = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",message.getFrom()));
      fromId = username.getId();
      name = username.getYonghuxingming();
      touxiang = username.getTouxiang();
      userName = username.getUsername();
    }
    message.setFromNickname(name);
    message.setFrom(userName);
    message.setCreateTime(new Date());
    simpMessagingTemplate.convertAndSendToUser(message.getTo(),"/queue/chat",message);
  }

  @Autowired
  GroupMsgContentService groupMsgContentService;
  EmojiConverter emojiConverter = EmojiConverter.getInstance();

  SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  /**
   * 群聊的消息接受与转发
   * @param
   * @param groupMsgContent
   */
  @MessageMapping("/ws/groupChat")
  public void handleGroupMessage(GroupMsgContent groupMsgContent){

    YonghuEntity yonghuView = null;
    UserEntity username = null;
    Long fromId=null;
    String name = null;
    String touxiang=null;
    if("yonghu".equals(groupMsgContent.getTableName())) {
      yonghuView = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("username", groupMsgContent.getUsername()));
      fromId = yonghuView.getId();
      name = yonghuView.getYonghuxingming();
      touxiang = yonghuView.getTouxiang();
    }else {
      username = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", groupMsgContent.getUsername()));
      fromId = username.getId();
      name = username.getYonghuxingming();
      touxiang = username.getTouxiang();
    }
    //处理emoji内容,转换成unicode编码
    groupMsgContent.setContent(emojiConverter.toHtml(groupMsgContent.getContent()));
    //保证来源正确性，从Security中获取用户信息
    groupMsgContent.setFromId(fromId);
    groupMsgContent.setFromName(name);
    groupMsgContent.setFromProfile(touxiang);
    groupMsgContent.setCreateTime(new Date());
    //保存该条群聊消息记录到数据库中
    groupMsgContentService.insert(groupMsgContent);
    //转发该条数据
    simpMessagingTemplate.convertAndSend("/topic/greetings",groupMsgContent);
  }

  /**
   * 接受前端发来的消息，获得图灵机器人回复并转发回给发送者
   * @param
   * @param message
   * @throws IOException
   */
  @MessageMapping("/ws/robotChat")
  public void handleRobotChatMessage(Message message) throws IOException {

    YonghuEntity yonghuView = null;
    UserEntity username = null;
    Long fromId=null;
    String name = null;
    String touxiang=null;
    String uName = null;
    if("yonghu".equals(message.getTableName())) {
      yonghuView = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("username", message.getFrom()));
      fromId = yonghuView.getId();
      name = yonghuView.getYonghuxingming();
      touxiang = yonghuView.getTouxiang();
      uName = yonghuView.getUsername();
    }else {
      username = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", message.getFrom()));
      fromId = username.getId();
      name = username.getYonghuxingming();
      touxiang = username.getTouxiang();
      uName = username.getUsername();
    }
    //接收到的消息
    message.setFrom(uName);
    message.setCreateTime(new Date());
    message.setFromNickname(name);
    message.setFromUserProfile(touxiang);
    //发送消息内容给机器人，获得回复
    String result = TuLingUtil.replyMessage(message.getContent());
    //构建返回消息JSON字符串
    Message resultMessage = new Message();
    resultMessage.setFrom("瓦力");
    resultMessage.setCreateTime(new Date());
    resultMessage.setFromNickname("瓦力");
    resultMessage.setContent(result);
    //回送机器人回复的消息给发送者
    simpMessagingTemplate.convertAndSendToUser(message.getFrom(),"/queue/robot",resultMessage);

  }

}
