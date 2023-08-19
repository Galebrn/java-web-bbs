package com.studio2h.javawebbbs.pojo.user;

import com.studio2h.javawebbbs.constant.PermissionConstant;
import com.studio2h.javawebbbs.constant.SexConstant;
import com.studio2h.javawebbbs.constant.StatusConstant;
import com.studio2h.javawebbbs.pojo.request.UserRegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Galebrn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userAvatarPath;
    private Integer userSex;
    private LocalDate userBirthday;
    private String userSignature;
    private Integer userExp;
    private Integer userLevel;
    private String userEmail;
    private String userPhoneNumber;
    private Integer userIfOp;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer userStatus;
    private Integer countOfFollow;
    private Integer countOfBeFollow;
    private Integer countOfPrivatePosts;
    private Integer countOfPosts;
    private Integer countOfComments;

    public User(UserRegisterRequest userRegisterRequest) {
        this.userId = null;
        this.userName = userRegisterRequest.getUserName();
        this.userPassword = userRegisterRequest.getUserPassword();
        this.userAvatarPath = null;
        this.userSex = SexConstant.NULL;
        this.userBirthday = null;
        this.userSignature = null;
        this.userExp = 0;
        this.userLevel = 0;
        this.userEmail = null;
        this.userPhoneNumber = null;
        this.userIfOp = PermissionConstant.ORDINARY;
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
        this.userStatus = StatusConstant.ENABLE;
        this.countOfFollow = 0;
        this.countOfBeFollow = 0;
        this.countOfPrivatePosts = 0;
        this.countOfPosts = 0;
        this.countOfComments = 0;
    }
}
