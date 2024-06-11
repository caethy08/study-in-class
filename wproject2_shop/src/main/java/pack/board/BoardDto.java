package pack.board;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BoardDto {
	private String name,pass,mail,title,count,bip,bdate;
	private int num,readcnt,gnum,onum,nested;
	
}
