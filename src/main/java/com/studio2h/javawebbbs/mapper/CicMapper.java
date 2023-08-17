package com.studio2h.javawebbbs.mapper;

import com.studio2h.javawebbbs.pojo.post.CommentInComment;
import com.studio2h.javawebbbs.pojo.request.CicQueryRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Galebrn
 */
@Mapper
public interface CicMapper {
    CommentInComment getByConditions(CicQueryRequest cicQueryRequest);

    List<CommentInComment> listByConditions(CicQueryRequest cicQueryRequest);

    Integer countByConditions(CicQueryRequest cicQueryRequest);
}
