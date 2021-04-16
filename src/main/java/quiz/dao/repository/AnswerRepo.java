package quiz.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.dao.entity.AnswerEntity;

public interface AnswerRepo extends JpaRepository<AnswerEntity, Long> {

}