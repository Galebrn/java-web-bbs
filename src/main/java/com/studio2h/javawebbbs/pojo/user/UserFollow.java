package com.studio2h.javawebbbs.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Galebrn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollow {
    private Integer userId;
    private Integer followedUserId;
}
