package soongmyeong.hackathon.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import soongmyeong.hackathon.comments.Comments;
import soongmyeong.hackathon.posts.Posts;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_member", unique = true, nullable = false)
    private Long id_member;

    @Column(length = 25, nullable = false)
    private String nickname;

    @Column(length = 25, nullable = false)
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Posts> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comments> comments = new ArrayList<>();


    @Builder
    public Member(String nickname, String password){
        this.nickname=nickname;
        this.password=password;
    }
}
