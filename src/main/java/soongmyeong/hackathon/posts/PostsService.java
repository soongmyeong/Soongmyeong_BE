package soongmyeong.hackathon.posts;

import soongmyeong.hackathon.type.BoardCate;

import java.util.List;

public interface PostsService {

    List<PostsDto> showAllPostsInCategory(BoardCate category);
    Boolean enrollPosts(PostsDto postsDto);
    Boolean editPosts(PostsDto postsDto);
    Boolean deletePosts(Long id_posts);
    PostsAndCommentsDto getSinglePosts(Long id_posts);
}
