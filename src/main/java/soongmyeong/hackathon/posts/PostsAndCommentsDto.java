package soongmyeong.hackathon.posts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostsAndCommentsDto {
    PostsDto postsDto;

    //List<CommentsDto> commentsDtoList;
}
