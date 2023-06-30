package soongmyeong.hackathon.comments;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soongmyeong.hackathon.member.Member;
import soongmyeong.hackathon.member.MemberRepository;
import soongmyeong.hackathon.posts.Posts;
import soongmyeong.hackathon.posts.PostsRepository;
import soongmyeong.hackathon.type.BoardCate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private final CommentsRepository commentsRepository;
    @Autowired
    private final MemberRepository memberRepository;
    
    @Autowired
    private final PostsRepository postsRepository;


    //댓글 생성
    @Override
    public void postComment(Long memberId, Long postsId, CommentsRequestDto requestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member does not exist"));
        Posts posts = postsRepository.findById(postsId)
                .orElseThrow(() -> new IllegalArgumentException("Member does not exist"));
        Comments comments = commentsRepository.save(new Comments(requestDto.getContent(), requestDto.getIs_like(), member,posts));
    }

    //댓글 수정
    @Override
    public void putComment(String content, CommentsRequestDto commentsRequestDto, Long id_comments) {
        Optional<Comments> putComments = commentsRepository.findById(id_comments);
        if(putComments.isPresent()){
            Comments comments = putComments.get();
            int isLike = comments.getIs_like();
            commentsRepository.delete(comments);
            //commentsRepository.save(new Comments(commentsRequestDto.getContent(), isLike,commentsRequestDto.getMemberId(),commentsRequestDto.getPostId()));
        }
    }

    @Override
    public void deleteComment(Long id_comments) {
        Optional<Comments> putComments = commentsRepository.findById(id_comments);
        if(putComments.isPresent()){
            Comments comments = putComments.get();
            commentsRepository.delete(comments);
        }
    }
}
