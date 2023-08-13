package com.studio2h.javawebbbs.pojo.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Galebrn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer postId;
    private String postTitle;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String postText;
    private Integer countOfComments;
    private Integer countOfLikes;
    private Integer countOfPrivate;
    private Integer countOfBrowsers;
    private Integer categoryId;
    private Integer authorId;
    private Integer postIfVisible;
}
