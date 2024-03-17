package com.routeplanner.routerplannerapi.android.studio.comment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create")
    public void createComment(@RequestBody CreateCommentRequest request) {
        commentService.saveNewComment(request);
    }

    @PostMapping("/update")
    public void updateRouteForUser(@RequestBody UpdateCommentRequest request) {
        commentService.updateComment(request);
    }


    @GetMapping(path = "/delete")
    public void deleteComment(@RequestParam("commentId") UUID commentId) {
        commentService.deleteComment(commentId);
    }
    @GetMapping(value = "/get")
    public ResponseEntity<Comment> getComment(@RequestBody CommentRequest request) {
        Optional<Comment> maybeComment = commentService.getComment(request);
        return maybeComment.map(this::commentResponse).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Comment>> getAllCommentsForUser(@RequestParam("userId") UUID userId) {
        return commentService.getAll(userId);
    }

    private ResponseEntity<Comment> commentResponse(Comment comment){
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

}

