package com.studio2h.javawebbbs.pojo.request;

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
public class PostQueryRequest {
    private Integer postId;
    private String postTitle;
    private LocalDateTime startCreateTime; //创建时间的起始时间
    private LocalDateTime endCreateTime; //创建时间的终止时间
    private LocalDateTime startUpdateTime; //更新时间的起始时间
    private LocalDateTime endUpdateTime; //更新时间的终止时间
    private Integer countOfComments;
    private Integer countOfLikes;
    private Integer countOfPrivate;
    private Integer countOfBrowsers;
    private Integer categoryId;
    private Integer authorId;
    private Integer postStatus;
    private Integer createTime;
    private Integer updateTime;
}
