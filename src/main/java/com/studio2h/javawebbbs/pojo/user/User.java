package com.studio2h.javawebbbs.pojo.user;

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
    private Integer userIfUsed;
    private Integer countOfFollow;
    private Integer countOfBeFollow;
    private Integer countOfPrivatePosts;
    private Integer countOfPosts;
    private Integer countOfComments;
}
