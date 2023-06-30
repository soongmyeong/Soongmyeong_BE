package soongmyeong.hackathon.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @PostMapping("{category}/main/{id_posts}/comments")
    public ResponseEntity<HttpStatus> postComment(
            @PathVariable("category") String category,
            @PathVariable("id_posts") Long id_posts,
            @RequestBody CommentsRequestDto commentsRequestDto){
        String content = commentsRequestDto.getContent();
        CommentsResponseDto commentsResponseDto = commentsService.postComment(category,id_posts,content);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    @PutMapping("{category}/main/{id_posts}/comments/{id_comments}")
    public ResponseEntity<HttpStatus> putComment(
            @PathVariable("category") String category,
            @PathVariable("id_posts") Long id_posts,
            @PathVariable("id_comments") Long id_comments,
            @RequestBody CommentsRequestDto commentsRequestDto){
        String content = commentsRequestDto.getContent();
        CommentsResponseDto commentsResponseDto = commentsService.putComment(category,id_posts,id_comments,content);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    @DeleteMapping("{category}/main/{id_posts}/comments/{id_comments}")
    public ResponseEntity<HttpStatus> deleteComment(
            @PathVariable("category") String category,
            @PathVariable("id_posts") Long id_posts,
            @PathVariable("id_comments") Long id_comments,
            @RequestBody CommentsRequestDto commentsRequestDto){
        String content = commentsRequestDto.getContent();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);

    }
}
