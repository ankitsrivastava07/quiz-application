package quiz.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String question;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "qid", referencedColumnName = "id")
	private List<OptionsEntity> options;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "qid", referencedColumnName = "id")
	private List<AnswerEntity> answer;
}
