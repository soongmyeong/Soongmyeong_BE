package soongmyeong.hackathon.comments;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soongmyeong.hackathon.posts.Posts;
import soongmyeong.hackathon.posts.PostsRepository;
import soongmyeong.hackathon.type.BoardCate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private final CommentsRepository commentsRepository;



    //댓글 생성
    @Override
    public void postComment(String content,CommentsRequestDto commentsRequestDto) {
        Comments comments = commentsRepository.save(new Comments(commentsRequestDto.getContent(), commentsRequestDto.getIs_like()));
    }

    //댓글 수정
    @Override
    public void putComment(String content, CommentsRequestDto commentsRequestDto, Long id_comments) {
        Optional<Comments> putComments = commentsRepository.findById(id_comments);
        if(putComments.isPresent()){
            Comments comments = putComments.get();
            int isLike = comments.getIs_like();
            commentsRepository.delete(comments);
            commentsRepository.save(new Comments(commentsRequestDto.getContent(), isLike));
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
