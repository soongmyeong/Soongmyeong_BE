package soongmyeong.hackathon.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import soongmyeong.hackathon.member.Member;
import soongmyeong.hackathon.type.BoardCate;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column
    private BoardCate category;

    @ManyToOne
    @JoinColumn(name = "id_member")
    private Member member;

    @Builder
    public Posts(String title, String content, int like_cnt, Member member, BoardCate category){
        this.title=title;
        this.content=content;
        this.like_cnt=like_cnt;
        this.member=member;
        this.category=category;
    }

    @Builder
    public Posts(String title, String content, Member member){
        this.title=title;
        this.content=content;
        this.member = member;
    }

    @Builder
    public Posts(Long id_posts, String title, String content, int like_cnt, Member member, BoardCate category){
        this.id_posts=id_posts;
        this.title=title;
        this.content=content;
        this.like_cnt=like_cnt;
        this.member=member;
        this.category=category;
    }
}
