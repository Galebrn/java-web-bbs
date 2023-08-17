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
public class CommentInComment {
    private Integer cicId;
    private Integer authorId;
    private Integer commentAuthorId;
    private Integer commentId;
    private String cicText;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer cicStatus;
}
