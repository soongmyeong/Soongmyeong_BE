package soongmyeong.hackathon.posts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import soongmyeong.hackathon.type.BoardCate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostsResponseDto {

    Long id;        //postId
    String title;
    String content;
    String nickname;
    BoardCate category;
}
