package board.bean;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class BoardDTO {
	private int seq;
	private String id;
	private String nameString;
	private String content;
	private String subject;
	private String email;
	private int ref;
	private int lev;
	private int step;
	private int pseq;
	private int reply;
	private int hit;
	private Date logtime;
	
	
}
