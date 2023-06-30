package soongmyeong.hackathon.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
