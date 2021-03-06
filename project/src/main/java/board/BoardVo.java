package board;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import util.CommonVo;

public class BoardVo extends CommonVo {
	
	
	
	private int no;
	private String title;
	private String content;
	private Timestamp regdate;
	private int readcount;
	private int user_no;
	private String name;
	private int rcnt;
	private int[] nos;
	
	public int[] getNos() {
		return nos;
	}
	public void setNos(int[] nos) {
		this.nos = nos;
	}
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getDate2() {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(regdate);
	}
}
