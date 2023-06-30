package soongmyeong.hackathon.posts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import soongmyeong.hackathon.type.BoardCate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostsRequestDto {

    String title;
    String content;
    int likeCnt;
    Long memberId;
    BoardCate category;
}
