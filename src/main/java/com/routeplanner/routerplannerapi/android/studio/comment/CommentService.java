package com.routeplanner.routerplannerapi.android.studio.comment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void saveNewComment(CreateCommentRequest request){
        commentRepository.save(new Comment(UUID.randomUUID(), request.getUserId(), UUID.randomUUID(), request.getComment(), LocalDateTime.now()));
    }

    public void updateComment(UpdateCommentRequest request){
        Comment savedComment = commentRepository.getOne(request.getCommentId());
        commentRepository.save(savedComment.update(request.getComment()));
    }

    public Optional<Comment> getComment(CommentRequest request){
        return commentRepository.findById(request.getCommentId());
    }

    public void deleteComment(UUID commentId){
        commentRepository.deleteById(commentId);
    }


    public ResponseEntity<List<Comment>> getAll(UUID userId){
        ArrayList<UUID> userIds = new ArrayList<UUID>();
        userIds.add(userId);
        List<Comment> results = commentRepository.getAllCommentsForUser(userId);
        return new ResponseEntity<List<Comment>>(results, HttpStatus.OK);
    }
}


