package soongmyeong.hackathon.member;

import org.springframework.stereotype.Service;


public interface MemberService {
    MemberResponseDto signup(MemberRequestDto memberRequestDto);
    MemberResponseDto login(MemberRequestDto memberRequestDto);
}
