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
        Member member = memberRepository.save(new Member(memberRequestDto.getNickname(), memberRequestDto.getPassword()));
        return new MemberResponseDto(member.getNickname());
    }

    @Override
    public MemberResponseDto login(MemberRequestDto memberRequestDto) {
        Member member = memberRepository.findByNickname(memberRequestDto.getNickname());
        if (member != null && member.getPassword().equals(memberRequestDto.getPassword())) {
            return new MemberResponseDto(member.getNickname());
        } else {
            return null;
        }
    }
}
