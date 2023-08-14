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
public class UserLoginRequest {
    private String userName;
    private String userPassword;
}
