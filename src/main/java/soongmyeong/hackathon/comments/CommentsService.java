package soongmyeong.hackathon.comments;

import soongmyeong.hackathon.type.BoardCate;

public interface CommentsService {
    void postComment(Long memberId, Long postsId, CommentsRequestDto requestDto);

    void putComment(String content, CommentsRequestDto commentsRequestDto, Long id_comments);

    void deleteComment(Long id_comments);
}
