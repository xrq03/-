package com.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.TokenEntity;
import com.entity.UserEntity;
import com.entity.YonghuEntity;
import com.service.TokenService;
import com.service.UserService;
import com.service.YonghuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

/**
 * 功能描述：
 * websocket用户相关渠道拦截
 * @Author: nickel
 * @Date: 2021/4/2 14:30
 */
@Slf4j
public class UserChannelInterceptor implements ChannelInterceptor {
    @Autowired
    private SimpUserRegistry simpUserRegistry;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;
    @Autowired
    private YonghuService yonghuService;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())){
            String username=null;
            try {
                String token = accessor.getNativeHeader("Authorization").get(0);
                //校验token
                TokenEntity tokenEntity = null;
                if(StringUtils.isNotBlank(token)) {
                    tokenEntity = tokenService.getTokenEntity(token);
                }
                username = tokenEntity.getUsername();
            } catch (Exception e) {
                e.printStackTrace();
                log.error("token is error");
                throw new IllegalStateException("The token is illegal");
            }
            if(StringUtils.isEmpty(username)){
                log.error("token is overtime");
                throw new IllegalStateException("The token is illegal");
            }
            accessor.setUser(new MyPrincipal(username));
            ///修改用户在线状态
            UserEntity user = new UserEntity();
            user.setUserStateId(1);
            userService.update(user, new EntityWrapper<UserEntity>().eq("username", username));
            YonghuEntity yonghuEntity = new YonghuEntity();
            yonghuEntity.setUserStateId(1);
            yonghuService.update(yonghuEntity, new EntityWrapper<YonghuEntity>().eq("username", username));
            log.info("【{}】用户上线了",username);
        }else if(StompCommand.DISCONNECT.equals(accessor.getCommand())){
            log.info("【{}】用户下线了",accessor.getUser().getName());
        }
        return message;
    }


}