package soongmyeong.hackathon.posts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import soongmyeong.hackathon.type.BoardCate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostsDto {

    String title;
    String content;
    Long id_user;
    Long id_posts;
    BoardCate category;
}
