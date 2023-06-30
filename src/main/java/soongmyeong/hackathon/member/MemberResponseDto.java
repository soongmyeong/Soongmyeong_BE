package soongmyeong.hackathon.member;

import lombok.Data;

@Data
public class MemberResponseDto {
    private String nickname;

    public MemberResponseDto() {}

    //private String message;   ->회원가입 및 로그인 결과를 나타내기 위함


    public MemberResponseDto(String nickname) {
        this.nickname = nickname;
    }
}
