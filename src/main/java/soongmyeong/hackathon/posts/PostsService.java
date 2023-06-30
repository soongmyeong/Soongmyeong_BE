package soongmyeong.hackathon.posts;

import soongmyeong.hackathon.type.BoardCate;

import java.util.List;

public interface PostsService {

    List<PostsResponseDto> showAllPostsInCategory(BoardCate category);
    Boolean enrollPosts(PostsRequestDto postsDto);
    Boolean editPosts(PostsRequestDto postsDto);
    Boolean deletePosts(Long id_posts);
    PostsAndCommentsDto getSinglePosts(Long id_posts);
}
