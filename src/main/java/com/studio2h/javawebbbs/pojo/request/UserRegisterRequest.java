package com.studio2h.javawebbbs.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Galebrn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    private String userName;
    private String userPassword;
    private String repeatPassword;
    private String userAvatarPath;
    private Integer userSex;
}
