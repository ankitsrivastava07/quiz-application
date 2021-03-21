package quiz.translator;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class ObjectTranslate {

	ModelMapper mapper = new ModelMapper();

	public <D> D translate(Object source, Class<D> destinationType) {
		return mapper.map(source, destinationType);
	}

	public <S, T> List<T> translateToList(List<S> source, Class<T> destinationType) {

		return source.stream().map(obj -> mapper.map(obj, destinationType)).collect(Collectors.toList());

	}

}
