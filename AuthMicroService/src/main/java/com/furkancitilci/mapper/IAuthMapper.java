package com.furkancitilci.mapper;

import com.furkancitilci.dto.request.NewCreateUserRequestDto;
import com.furkancitilci.dto.request.RegisterRequestDto;
import com.furkancitilci.dto.request.UpdateByEmailOrUserNameRequestDto;
import com.furkancitilci.dto.response.LoginResponseDto;
import com.furkancitilci.dto.response.RegisterResponseDto;
import com.furkancitilci.dto.response.RoleResponseDto;
import com.furkancitilci.rabbitmq.model.NewCreateUserRequestModel;
import com.furkancitilci.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {

    IAuthMapper INSTANCE= Mappers.getMapper(IAuthMapper.class);

    Auth toAuth(final RegisterRequestDto dto);

    RegisterResponseDto toRegisterResponseDto(final  Auth auth);

    LoginResponseDto toLoginResponseDto(final Auth auth);

    @Mapping(source = "id",target = "authId")       //id ler eşleşsin diye yaptım
    NewCreateUserRequestDto toNewCreateUserRequestDto(final Auth auth);

    Auth  toAuth(final UpdateByEmailOrUserNameRequestDto dto);
    @Mapping(source = "id",target = "authId")       //auth id ile newcreateuser daki id yi match ettim
    NewCreateUserRequestModel toNewCreateUserRequestModel(final Auth auth);

    RoleResponseDto toRoleResponseDto(final  Auth auth);
    List<RoleResponseDto> toRoleResponseDtos(final List<Auth> authList);

}
