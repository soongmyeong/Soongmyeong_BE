package soongmyeong.hackathon.comments;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommentsResponseDto {
    //private Long id_comments;
    //private Long id_posts;
    //private Long id_user;
    private String content;

    public CommentsResponseDto(String content){
        this.content = content;
    }
}
