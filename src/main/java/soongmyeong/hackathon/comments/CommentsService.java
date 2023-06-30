package soongmyeong.hackathon.comments;

public interface CommentsService {
    CommentsResponseDto postComment(String category, Long id_posts,String content);

    CommentsResponseDto putComment(String category, Long id_posts,Long id_comments,String content);
}
