package soongmyeong.hackathon.comments;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentsResponseDto {
    private Long id_comments;
    private Long id_posts;
    private Long id_user;
    private String content;
    private boolean is_like;
}
