package com.furkancitilci.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(5100,"Sunucu Hatas�",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100,"Parametre Hatas�",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4110,"Boyle Bir kullan�c� bulunamad�",HttpStatus.BAD_REQUEST),
    USER_NOT_CREATED(4111,"Kullan�c� olusturulamad�",HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4112,"Böyle bir kullanıcı adı var",HttpStatus.BAD_REQUEST),
    ACTIVATE_CODE_ERROR(4113,"Aktivasyon kod hatası",HttpStatus.BAD_REQUEST),

    LOGIN_ERROR(4114,"Kullanici adi veya sifre hatali",HttpStatus.BAD_REQUEST),
    LOGIN_ERROR_STATUS(4115,"Yetkisiz kullanıcı girişi  ",HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4116,"Token oluşturulamadı",HttpStatus.BAD_REQUEST),
    ROLE_NOT_FOUND(4117,"Böyle Bir Kullanıcı Rolü Bulunamadı",HttpStatus.BAD_REQUEST);



    private   int code;
    private   String message;
    HttpStatus httpStatus;


}
