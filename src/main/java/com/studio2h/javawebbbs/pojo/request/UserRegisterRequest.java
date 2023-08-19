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
public class UserRegisterRequest {
    private String userName;
    private String userPassword;
    private String repeatPassword;
}
