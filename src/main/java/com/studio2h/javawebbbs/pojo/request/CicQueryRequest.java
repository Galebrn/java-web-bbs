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
public class CicQueryRequest {
    private Integer cicId;
    private Integer authorId;
    private Integer beCommentId;
    private Integer commentId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer cicStatus;
}
