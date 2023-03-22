package com.furkancitilci.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(5200,"Sunucu Hatas�",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4200,"Parametre Hatas�",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4210,"Boyle Bir kullan�c� bulunamad�",HttpStatus.BAD_REQUEST),
    USER_NOT_CREATED(4211,"Kullan�c� olusturulamad�",HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4212,"Böyle bir kullanıcı adı var",HttpStatus.BAD_REQUEST),



    TOKEN_NOT_CREATED(4216,"Token oluşturulamadı",HttpStatus.BAD_REQUEST);



    private   int code;
    private   String message;
    HttpStatus httpStatus;


}
