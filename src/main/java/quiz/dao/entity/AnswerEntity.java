package quiz.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answers")
@Getter
@Setter
public class AnswerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "qid", referencedColumnName = "id")
	private QuestionEntity qid;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="option_id")
	private OptionsEntity option;
	@Column(name = "is_correct")
	private Boolean isCorrect;
	
	private String answer;
}
