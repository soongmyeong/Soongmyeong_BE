package soongmyeong.hackathon.posts;

import lombok.Data;

@Data
public class PostsRequestDto {  //클라이언트가 서버로 이걸 보냄

    private String title;
    private String content;
    private int likeCnt;
    private Long memberId;
}
//보내는 정보  -> 제목, 내용, 좋아요수?(이건애매), 맴버  id
