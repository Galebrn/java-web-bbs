package com.studio2h.javawebbbs.pojo.request;

import com.studio2h.javawebbbs.pojo.post.Post;
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
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public PostQueryRequest(Post post) {
        this.postId = post.getPostId();
        this.postTitle = post.getPostTitle();
        this.countOfComments = post.getCountOfComments();
        this.countOfLikes = post.getCountOfLikes();
        this.countOfPrivate = post.getCountOfPrivate();
        this.countOfBrowsers = post.getCountOfBrowsers();
        this.categoryId = post.getCategoryId();
        this.authorId = post.getAuthorId();
        this.postStatus = post.getPostStatus();
        this.createTime = post.getCreateTime();
        this.updateTime = post.getUpdateTime();
        this.startCreateTime = null;
        this.endCreateTime = null;
        this.startUpdateTime = null;
        this.endUpdateTime = null;
    }
}
