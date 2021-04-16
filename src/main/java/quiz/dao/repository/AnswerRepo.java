package quiz.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quiz.dao.entity.AnswerEntity;

public interface AnswerRepo extends JpaRepository<AnswerEntity,Long> {

	@Query(value = "select opt_id from answers", nativeQuery = true)
	List<Long> getAllAnswers();
}