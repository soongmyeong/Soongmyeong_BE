package soongmyeong.hackathon.member;



import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponseDto signup(MemberRequestDto memberRequestDto) {
        if(memberRepository.findByNickname(memberRequestDto.getNickname()) != null) {
            throw new IllegalArgumentException("이미 사용중인 닉네임입니다!");
        }
        Member member = memberRepository.save(new Member(memberRequestDto.getNickname(), memberRequestDto.getPassword()));
        return new MemberResponseDto(member.getId_member(), member.getNickname());
    }

    @Override
    public MemberResponseDto login(MemberRequestDto memberRequestDto) {
        Member member = memberRepository.findByNickname(memberRequestDto.getNickname());
        if (member != null && member.getPassword().equals(memberRequestDto.getPassword())) {
            return new MemberResponseDto(member.getId_member(), member.getNickname());
        } else {
            throw new IllegalArgumentException("닉네임이 없거나 비밀번호가 틀렸습니다!");
        }
    }
}