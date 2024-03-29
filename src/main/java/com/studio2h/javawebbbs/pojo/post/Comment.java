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
public class Comment {
    private Integer commentId;
    private Integer postId;
    private Integer authorId;
    private Integer commentStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String commentText;
}
