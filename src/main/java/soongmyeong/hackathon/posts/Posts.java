package soongmyeong.hackathon.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import soongmyeong.hackathon.member.Member;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name="posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_posts", unique = true, nullable = false)
    private Long id_posts;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column
    private int like_cnt;

    @Column(name = "id_member")
    @ManyToOne
    @JoinColumn(name = "id_member")
    private Member member;

    @Builder
    public Posts(String title, String content, int like_cnt, Member member){
        this.title=title;
        this.content=content;
        this.like_cnt=like_cnt;
        this.member=member;
    }

}
