package quiz.dao.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import quiz.dao.entity.OptionsEntity;

public interface OptionRepo extends JpaRepository<OptionsEntity,Long> {

}
