package soongmyeong.hackathon.comments;

import soongmyeong.hackathon.type.BoardCate;

public interface CommentsService {
    void postComment(Long memberId, Long postsId, CommentsRequestDto requestDto);

    void putComment(Long memberId, Long postsId, CommentsRequestDto requestDto);

    void deleteComment(Long id_comments);
}
