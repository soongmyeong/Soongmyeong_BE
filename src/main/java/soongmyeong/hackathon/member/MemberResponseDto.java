package soongmyeong.hackathon.member;

import lombok.Data;

@Data
public class MemberResponseDto {
    private Long memberId;
    private String nickname;

    public MemberResponseDto() {}

    public MemberResponseDto(Long memberId, String nickname) {
        this.memberId = memberId;
        this.nickname = nickname;
    }
}
