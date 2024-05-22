package pack4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor //매개변수 없는 생성자
//@AllArgsConstructor //매개변수 있는 생성자
@Data
public class Ex31studDto {
	private String name;
	private int korean, english;
}
