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

    //category별 게시판 접속
    @GetMapping("/{category}/main")
    public ResponseEntity<List<PostsResponseDto>> enterBoardWithCategory(@PathVariable String category){
        List<PostsResponseDto> postsDtoList = postsService.showAllPostsInCategory(BoardCate.valueOf(category));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postsDtoList);
    }

    //게시글 등록
    @PostMapping("/{category}/main")
    public ResponseEntity<HttpStatus> enrollPosts(@PathVariable String category,
                                                  @RequestBody PostsRequestDto postsDto){
        postsService.enrollPost(postsDto.getMemberId(),postsDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    //게시글 수정
    @PutMapping("/{category}/main/{id_posts}")
    public ResponseEntity<HttpStatus> editPosts(@PathVariable String category,
                                                @PathVariable Long id_posts,
                                                @RequestBody PostsRequestDto postsDto){
        postsService.editPosts(id_posts, postsDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    //게시글 삭제
    @DeleteMapping("/{category}/main/{id_posts}")
    public ResponseEntity<HttpStatus> deletePosts(@PathVariable String category,
                                                  @PathVariable Long id_posts){
        postsService.deletePosts(id_posts);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpStatus.OK);
    }

    //게시글 한 개 조회
    @GetMapping("/{category}/main/{id_posts}")
    public ResponseEntity<PostsAndCommentsDto> getSinglePosts(@PathVariable String category,
                                                              @PathVariable Long id_posts){
        PostsAndCommentsDto singlePosts = postsService.getSinglePosts(id_posts);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(singlePosts);
    }
}
