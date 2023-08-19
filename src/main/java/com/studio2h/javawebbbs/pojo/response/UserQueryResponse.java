package com.studio2h.javawebbbs.pojo.response;

import com.studio2h.javawebbbs.pojo.user.User;
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
public class UserQueryResponse {
    private Integer userId;
    private String userName;
    //    private String userPassword;
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
    //    private LocalDateTime updateTime;
    private Integer userStatus;
    private Integer countOfFollow;
    private Integer countOfBeFollow;
    private Integer countOfPrivatePosts;
    private Integer countOfPosts;
    private Integer countOfComments;

    public UserQueryResponse(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userAvatarPath = user.getUserAvatarPath();
        this.userSex = user.getUserSex();
        this.userBirthday = user.getUserBirthday();
        this.userSignature = user.getUserSignature();
        this.userExp = user.getUserExp();
        this.userLevel = user.getUserLevel();
        this.userEmail = user.getUserEmail();
        this.userPhoneNumber = user.getUserPhoneNumber();
        this.userIfOp = user.getUserIfOp();
        this.createTime = user.getCreateTime();
        this.userStatus = user.getUserStatus();
        this.countOfFollow = user.getCountOfFollow();
        this.countOfBeFollow = user.getCountOfBeFollow();
        this.countOfPrivatePosts = user.getCountOfPrivatePosts();
        this.countOfPosts = user.getCountOfPosts();
        this.countOfComments = user.getCountOfComments();
    }
}
