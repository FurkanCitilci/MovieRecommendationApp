package com.furkancitilci.controller;

import com.furkancitilci.dto.request.NewCreateUserRequestDto;
import com.furkancitilci.dto.request.UpdateRequestDto;
import com.furkancitilci.repository.entity.UserProfile;
import com.furkancitilci.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static com.furkancitilci.constant.ApiUrl.*;

/*
    update metodu yazalım
    update ettiğimiz bilgilerde
    email veya username değişir ise auth servicedeki guncelleme metodunu çalıştırsın
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createUser(@RequestBody NewCreateUserRequestDto dto){
        return ResponseEntity.ok(userProfileService.createUser(dto));
    }

    @PutMapping(UPDATE)                             //güncelleme için putmapping kullandık
    public ResponseEntity<Boolean> update(@RequestBody @Valid UpdateRequestDto dto){

        return ResponseEntity.ok(userProfileService.update(dto));
    }

    @PostMapping(ACTIVATESTATUS+"/{authId}")
    public ResponseEntity<Boolean> activateStatus(@PathVariable  Long authId){
        return   ResponseEntity.ok(userProfileService.activateStatus(authId));
        //  ....... activatestatsus/1
    }
    @PostMapping(ACTIVATESTATUS)
    public ResponseEntity<Boolean> activateStatus2(@RequestParam Long authId){
        return   ResponseEntity.ok(userProfileService.activateStatus(authId));
        // .......activatestatsus?authId=1
    }

    @GetMapping(FINDALL)
    public  ResponseEntity<List<UserProfile>> findAll(){
        return  ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping(FINDBYUSERNAME)
    public ResponseEntity<UserProfile> findbyUsername(@PathVariable String username){
        return ResponseEntity.ok(userProfileService.findByUserName(username));
    }

    @GetMapping("/findbyrole/{role}")
    public ResponseEntity<List<UserProfile>> findbyRole(@PathVariable String role){
        return ResponseEntity.ok(userProfileService.findByRole(role));
    }
}
