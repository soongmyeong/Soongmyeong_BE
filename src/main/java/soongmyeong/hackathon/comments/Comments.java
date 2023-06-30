package soongmyeong.hackathon.comments;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import soongmyeong.hackathon.member.Member;

import javax.persistence.*;

@Entity
@NoArgsConstructor
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

    @Builder
    public Comments(String title, String content, int is_like){
        this.content=content;
        this.is_like=is_like;
    }
}
