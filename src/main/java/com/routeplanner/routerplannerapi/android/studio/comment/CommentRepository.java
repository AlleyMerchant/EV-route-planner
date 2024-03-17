package com.routeplanner.routerplannerapi.android.studio.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface CommentRepository
        extends JpaRepository<Comment, UUID> {
    @Query(value = "SELECT * FROM Comment c WHERE c.userId=?1", nativeQuery = true)
    List<Comment> getAllCommentsForUser(UUID id);

   @Query(value = "SELECT * FROM comment c WHERE c.id=?1", nativeQuery = true)
   Comment getCommentById(UUID id);

}
