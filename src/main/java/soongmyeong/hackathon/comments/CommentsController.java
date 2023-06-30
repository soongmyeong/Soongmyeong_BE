package soongmyeong.hackathon.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soongmyeong.hackathon.type.BoardCate;

@RestController
@RequestMapping()
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @PostMapping("{category}/main/{id_posts}/comments")
    public ResponseEntity<HttpStatus> postComment(
            @PathVariable("category") BoardCate category,
            @PathVariable("id_posts") Long id_posts,
            @RequestBody CommentsRequestDto commentsRequestDto){
        String content = commentsRequestDto.getContent();
        commentsService.postComment(commentsRequestDto.getMemberId(),commentsRequestDto.getPostId(),commentsRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    //댓글 수정
    @PutMapping("{category}/main/{id_posts}/comments/{id_comments}")
    public ResponseEntity<HttpStatus> putComment(
            @PathVariable("category") BoardCate category,
            @PathVariable("id_posts") Long id_posts,
            @PathVariable("id_comments") Long id_comments,
            @RequestBody CommentsRequestDto commentsRequestDto){
        String content = commentsRequestDto.getContent();
        commentsService.putComment(commentsRequestDto.getMemberId(),commentsRequestDto.getPostId(),commentsRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    //댓글 삭제
    @DeleteMapping("{category}/main/{id_posts}/comments/{id_comments}")
    public ResponseEntity<HttpStatus> deleteComment(
            @PathVariable("category") BoardCate category,
            @PathVariable("id_posts") Long id_posts,
            @PathVariable("id_comments") Long id_comments){
        commentsService.deleteComment(id_comments);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);

    }
}
