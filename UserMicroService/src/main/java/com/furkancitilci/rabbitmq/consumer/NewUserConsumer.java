package com.furkancitilci.rabbitmq.consumer;

import com.furkancitilci.mapper.IUserMapper;
import com.furkancitilci.rabbitmq.model.NewCreateUserRequestModel;
import com.furkancitilci.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewUserConsumer {

    private final UserProfileService userProfileService;

    @RabbitListener(queues = "${rabbitmq.queueregister}")
    public  void newUserCreate(NewCreateUserRequestModel model){
        log.info("User {}",model.toString());
        userProfileService.createUser(IUserMapper.INSTANCE.toNewCreateUserRequestDto(model));
    }

}
