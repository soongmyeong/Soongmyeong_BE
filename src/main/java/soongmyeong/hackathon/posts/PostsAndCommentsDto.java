package soongmyeong.hackathon.posts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import soongmyeong.hackathon.comments.CommentsResponseDto;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostsAndCommentsDto {
    PostsResponseDto postsDto;

    List<CommentsResponseDto> commentsDtoList;
}
