package com.studio2h.javawebbbs.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Galebrn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryRequest {
    private Integer userId;
    private String userName;
    private String userPassword;
    private Integer userSex;
    private Integer userExp;
    private Integer userLevel;
    private String userEmail;
    private String userPhoneNumber;
    private Integer userIfOp;
    private Integer userStatus;
    private Integer countOfFollow;
    private Integer countOfBeFollow;
    private Integer countOfPrivatePosts;
    private Integer countOfPosts;
    private Integer countOfComments;

    public UserQueryRequest(UserLoginRequest userLoginRequest) {
        this.userId = null;
        this.userName = userLoginRequest.getUserName();
        this.userPassword = userLoginRequest.getUserPassword();
        this.userSex = null;
        this.userExp = null;
        this.userLevel = null;
        this.userEmail = null;
        this.userPhoneNumber = null;
        this.userIfOp = null;
        this.userStatus = null;
        this.countOfFollow = null;
        this.countOfBeFollow = null;
        this.countOfPrivatePosts = null;
        this.countOfPosts = null;
        this.countOfComments = null;
    }
}
