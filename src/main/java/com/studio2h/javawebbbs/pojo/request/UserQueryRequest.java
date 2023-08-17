package com.studio2h.javawebbbs.pojo.request;

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
public class UserQueryRequest {
    private Integer userId;
    private String userName;
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
}
