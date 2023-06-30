package soongmyeong.hackathon.comments;

import lombok.Getter;

@Getter
public class CommentsRequestDto {
    private String content;
    private int is_like;
    private Long memberId;
    private Long postId;

}
