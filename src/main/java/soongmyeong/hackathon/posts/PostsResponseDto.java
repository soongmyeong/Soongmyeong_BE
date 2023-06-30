package soongmyeong.hackathon.posts;

import lombok.Data;

@Data
public class PostsResponseDto { //서버는 클라이언트에 이걸 보냄
    private Long id;
    private String title;
    private String content;
    private int likeCnt;
    private String nickname; // 멤버의 닉네임
}

//사용자에 보내야할  정보  -> x, 제목, 내용, 좋아요수, 맴버 닉네임(이게 더 의미있음)
