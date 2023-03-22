package com.furkancitilci.mapper;

import com.furkancitilci.dto.request.NewCreateUserRequestDto;
import com.furkancitilci.dto.request.UpdateByEmailOrUserNameRequestDto;
import com.furkancitilci.dto.request.UpdateRequestDto;
import com.furkancitilci.rabbitmq.model.NewCreateUserRequestModel;
import com.furkancitilci.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {


    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);


    UserProfile toUserProfile(final NewCreateUserRequestDto dto);

    @Mapping(source = "authId" ,target = "id")
    UpdateByEmailOrUserNameRequestDto toUpdateByEmailOrUserNameRequestDto(final UpdateRequestDto dto);
    UserProfile toUserProfile(final UpdateRequestDto dto);

    NewCreateUserRequestDto toNewCreateUserRequestDto(final NewCreateUserRequestModel model);
}
