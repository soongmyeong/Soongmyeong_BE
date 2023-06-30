package soongmyeong.hackathon.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soongmyeong.hackathon.type.BoardCate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping("/{category}/main")
    public ResponseEntity<List<PostsDto>> enterBoardWithCategory(@PathVariable String category){
        List<PostsDto> postsDtoList = postsService.showAllPostsInCategory(BoardCate.valueOf(category));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postsDtoList);
    }

    @PostMapping("/{category}/main")
    public ResponseEntity<HttpStatus> enrollPosts(@PathVariable String category,
                                                  @RequestBody PostsDto postsDto){
        postsService.enrollPosts(postsDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    @PutMapping("/{category}/main/{id_posts}")
    public ResponseEntity<HttpStatus> editPosts(@PathVariable String category,
                                                @RequestBody PostsDto postsDto){
        postsService.editPosts(postsDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    @DeleteMapping("/{category}/main/{id_posts}")
    public ResponseEntity<HttpStatus> deletePosts(@PathVariable String category,
                                                  @PathVariable Long id_posts){
        postsService.deletePosts(id_posts);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    @GetMapping("/{category}/main/{id_posts}")
    public ResponseEntity<PostsAndCommentsDto> getSinglePosts(@PathVariable String category,
                                                              @PathVariable Long id_posts){
        PostsAndCommentsDto singlePosts = postsService.getSinglePosts(id_posts);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(singlePosts);
    }
}
