package com.furkancitilci.dto.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {

    @NotBlank
    @Size(min=3,max = 20 ,message = "Kullanici adi en az 3 karakter en fazla 20 karakter olabilir")
    private String username;

    @NotBlank
    @Size(min=8,max = 32 ,message = "Sifre  en az 8 karakter en fazla 32 karakter olabilir")
    private String password;
    @NotBlank
    @Email()
    private String email;
}
