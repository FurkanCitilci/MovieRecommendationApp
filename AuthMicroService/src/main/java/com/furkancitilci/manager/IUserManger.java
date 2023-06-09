package com.furkancitilci.manager;

import com.furkancitilci.dto.request.NewCreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.furkancitilci.constant.ApiUrl.ACTIVATESTATUS;

@FeignClient(name = "user-userprofile" ,decode404 = true,url = "http://localhost:8091/api/v1/user" )
public interface IUserManger {

    @PostMapping("/create")
    public ResponseEntity<Boolean> createUser(@RequestBody NewCreateUserRequestDto dto);

    @PostMapping(ACTIVATESTATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authId);
    @PostMapping(ACTIVATESTATUS)
    public ResponseEntity<Boolean> activateStatus2(@RequestParam Long authId);

}
