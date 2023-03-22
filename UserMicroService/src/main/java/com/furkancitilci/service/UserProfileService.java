package com.furkancitilci.service;

import com.furkancitilci.dto.request.NewCreateUserRequestDto;
import com.furkancitilci.dto.request.UpdateRequestDto;
import com.furkancitilci.dto.response.RoleResponseDto;
import com.furkancitilci.exception.ErrorType;
import com.furkancitilci.exception.UserManagerException;
import com.furkancitilci.manager.IAuthManager;
import com.furkancitilci.mapper.IUserMapper;
import com.furkancitilci.repository.IUserProfileRepository;
import com.furkancitilci.repository.entity.UserProfile;
import com.furkancitilci.repository.enums.EStatus;
import com.furkancitilci.utility.ServiceManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {

    private final IUserProfileRepository userProfileRepository;
    private final IAuthManager authManager;


    public UserProfileService(IUserProfileRepository userProfileRepository, IAuthManager authManager) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.authManager = authManager;
    }

    public Boolean createUser(NewCreateUserRequestDto dto) {
        try {
            UserProfile userProfile= IUserMapper.INSTANCE.toUserProfile(dto);

            save(userProfile);
            return  true;
        }catch (Exception e){
            throw  new UserManagerException(ErrorType.USER_NOT_CREATED);
        }

    }

    public Boolean update(UpdateRequestDto dto) {
        Optional<UserProfile> userProfile=userProfileRepository.findOptionalByAuthId(dto.getAuthId());

        if (userProfile.isEmpty()){
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }


        if (!dto.getEmail().equals(userProfile.get().getEmail())||!dto.getUsername().equals(userProfile.get().getUsername())){
            userProfile.get().setUsername(dto.getUsername());
            userProfile.get().setEmail(dto.getEmail());
            authManager.updateByUsernameOrEmail(IUserMapper.INSTANCE.toUpdateByEmailOrUserNameRequestDto(dto));
        }
        userProfile.get().setAbout(dto.getAbout());
        userProfile.get().setAddress(dto.getAddress());
        userProfile.get().setPhone(dto.getPhone());
        userProfile.get().setAvatar(dto.getAvatar());
        update(userProfile.get());
        return true;
    }

    public Boolean activateStatus(Long id) {
        Optional<UserProfile> userProfile=userProfileRepository.findOptionalByAuthId(id);
        if (userProfile.isEmpty()){
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        userProfile.get().setStatus(EStatus.ACTIVE);
        update(userProfile.get());
        return  true;
    }

    @Cacheable(value = "username", key = "#username.toLowerCase()") //key ile gelen stringi tek formasyonda almak için yaptım
    public UserProfile findByUserName(String username) {

        try {
            Thread.sleep(500);

        }catch (Exception e){
            e.printStackTrace();

        }

        Optional<UserProfile> userProfile=userProfileRepository.findOptionalByUsernameEqualsIgnoreCase(username);
        if (userProfile.isPresent()){
            return userProfile.get();
        }else {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }


    }

    @Cacheable(value = "myrole",key = "#role.toLowerCase()")
    public List<UserProfile> findByRole(String role) {
        List<RoleResponseDto> list= authManager.findbyRole(role).getBody();
        List<Optional<UserProfile>> users = list.stream().map(x->userProfileRepository.findOptionalByAuthId(x.getId())).collect(Collectors.toList());
        return users.stream().map(y->{
            if (y.isPresent()){
                return y.get();
            }else {
                return null;
            }
        }).collect(Collectors.toList());
    }
}
