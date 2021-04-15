package quiz.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quiz.dao.entity.OptionsEntity;

public interface OptionRepo extends JpaRepository<OptionsEntity, Long> {

	@Query(value = "select * from options where opt=?1 and qid=?2", nativeQuery = true)
	OptionsEntity findByOpt(String opt, Long qid);

}
