package com.config;

import com.annotation.IgnoreAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.List;


/**
 * @author Hai
 * @date 2020/6/16 - 23:31
 */
@Configuration
@EnableWebSocketMessageBroker
public  class WebSocketConfig implements WebSocketMessageBrokerConfigurer  { //extend AbstractWebSocketMessageBrokerConfigurer
  /**
   * 注册stomp站点
   * @param registry
   */
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {

    registry.addEndpoint("/ws/ep").setAllowedOrigins("*").withSockJS();

  }
  /**
   * 注册拦截"/topic","/queue"的消息
   * @param registry
   */
  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic","/queue");
  }


  /**
   * 定义用户入端通道拦截器
   * @param registration
   */
  @Override
  public void configureClientInboundChannel(ChannelRegistration registration) {
    registration.interceptors(createUserInterceptor());
  }

  /**
   * 将自定义的客户端渠道拦截器加入IOC容器中
   * @return
   */
  @Bean
  public UserChannelInterceptor createUserInterceptor(){
    return new UserChannelInterceptor();
  }

}
