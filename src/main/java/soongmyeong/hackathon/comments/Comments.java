package soongmyeong.hackathon.comments;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import soongmyeong.hackathon.member.Member;
import soongmyeong.hackathon.posts.Posts;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comments", unique = true, nullable = false)
    private Long id_comments;

    @Column(nullable = false)
    private String content;

    @Column
    private int is_like;


    @ManyToOne
    @JoinColumn(name = "id_member")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "id_posts")
    private Posts posts;

    @Builder
    public Comments(String content, int is_like, Member member, Posts posts){
        this.content=content;
        this.is_like=is_like;
        this.member = member;
        this.posts = posts;
    }
}
