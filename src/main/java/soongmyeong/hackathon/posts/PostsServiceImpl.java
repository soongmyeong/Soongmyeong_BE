package soongmyeong.hackathon.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soongmyeong.hackathon.comments.Comments;
import soongmyeong.hackathon.comments.CommentsRepository;
import soongmyeong.hackathon.member.Member;
import soongmyeong.hackathon.type.BoardCate;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService{

    @Autowired
    private final PostsRepository postsRepository;
    @Autowired
    private final CommentsRepository commentsRepository;
    @Autowired
    //private final MemberRepository memberRepository;

    @Override
    public List<PostsResponseDto> showAllPostsInCategory(BoardCate category) {
        List<Posts> postsList = postsRepository.findAll();
        List<PostsResponseDto> postsDtoList = new LinkedList<>();

        for(Posts posts : postsList){
            BoardCate boardCate = posts.getCategory();

            if(boardCate == category){
                PostsResponseDto postsResponseDto = new PostsResponseDto();

                postsResponseDto.setCategory(posts.getCategory());
                postsResponseDto.setContent(posts.getContent());
                postsResponseDto.setTitle(posts.getTitle());
                postsResponseDto.setNickname(posts.getMember().getNickname());
                postsResponseDto.setId(posts.getId_posts());

                postsDtoList.add(postsResponseDto);
            }
        }

        return postsDtoList;
    }

    @Override
    public Boolean enrollPosts(PostsRequestDto postsRequestDto) {
        //Member member = memberRepository.findById(postsRequestDto.id_user).get();

        //postsRepository.save(new Posts(postsRequestDto.getTitle(), postsRequestDto.getContent(), member));

        return true;
    }

    @Override
    public Boolean editPosts(PostsRequestDto postsRequestDto) {
        //Member member = memberRepository.findById(postsRequestDto.id_user).get();

        //Posts posts = new Posts(postsRequestDto.getTitle(), postsRequestDto.getContent()
        // , postsRequestDto.getLikeCnt(), member, postsRequestDto.getCategory());

        //postsRepository.save(posts);

        return true;
    }

    @Override
    public Boolean deletePosts(Long id_posts) {
        Posts posts = postsRepository.findById(id_posts).get();

        postsRepository.delete(posts);

        return true;
    }

    @Override
    public PostsAndCommentsDto getSinglePosts(Long id_posts) {
        PostsAndCommentsDto postsAndCommentsDto = new PostsAndCommentsDto();
        Posts posts = postsRepository.findById(id_posts).get();
        PostsResponseDto postsDto = new PostsResponseDto();

        postsDto.setCategory(posts.getCategory());
        postsDto.setContent(posts.getContent());
        postsDto.setTitle(posts.getTitle());

        postsAndCommentsDto.setPostsDto(postsDto);

        List<Comments> commentsList = commentsRepository.findAll();

        for(Comments comments : commentsList){
//            if(comments.getPost_id().)
        }

        return postsAndCommentsDto;
    }
}
