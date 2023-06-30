package soongmyeong.hackathon.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    CommentsRepository commentsRepository;


    @Override
    public CommentsResponseDto postComment(String category, Long id_posts, String content) {
        return null;
    }

    @Override
    public CommentsResponseDto putComment(String category, Long id_posts, Long id_comments, String content) {
        return null;
    }
}
