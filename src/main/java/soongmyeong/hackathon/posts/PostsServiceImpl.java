package soongmyeong.hackathon.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soongmyeong.hackathon.type.BoardCate;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService{

    private final PostsRepository postsRepository;
    @Override
    public List<PostsDto> showAllPostsInCategory(BoardCate category) {
        List<Posts> postsList = postsRepository.findAll();
        List<PostsDto> postsDtoList = new LinkedList<>();

        for(Posts posts : postsList){
            BoardCate boardCate = posts.getCategory();

            if(boardCate == category);
        }

        return null;
    }

    @Override
    public Boolean enrollPosts(PostsDto postsDto) {

        return null;
    }

    @Override
    public Boolean editPosts(PostsDto postsDto) {
        return null;
    }

    @Override
    public Boolean deletePosts(Long id_posts) {
        return null;
    }

    @Override
    public PostsAndCommentsDto getSinglePosts(Long id_posts) {
        return null;
    }
}
