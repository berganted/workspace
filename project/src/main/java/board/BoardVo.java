package board;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BoardVo {
	
	private int pageRow;
	private int strIdx;
	private int reqPage;
	private int totCount;
	private int totPage;
	private int endPage;
	private int strPage;
	private int pageRange;
	private String stype;
	private String sval;;
	private String orderby; // 정렬 컬럼
	private String direct; //오름차순 내림차순
	private String filename_org;
	private String filename_real;
	private String isDel;
	
	
	private int no;
	private String title;
	private String content;
	private Timestamp regdate;
	private int readcount;
	
	public BoardVo() {
		this.pageRow = 5;
		this.reqPage = 1;
		this.pageRange = 5;
		this.orderby ="regdate";
		this.direct = "DESC";
	}
	
	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getFilename_org() {
		return filename_org;
	}

	public void setFilename_org(String filename_org) {
		this.filename_org = filename_org;
	}

	public String getFilename_real() {
		return filename_real;
	}

	public void setFilename_real(String filename_real) {
		this.filename_real = filename_real;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		if(!"".equals(orderby))this.orderby = orderby;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		if(!"".equals(direct)) this.direct = direct;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getSval() {
		return sval;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}

	public int getPageRange() {
		return pageRange;
	}
	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}
	public int getStrPage() {
		return strPage;
	}
	public void setStrPage(int strPage) {
		this.strPage = strPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotCount() {
		return totCount;
	}
	public void setTotCount(int totCount) {
		this.totCount = totCount;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getReqPage() {
		return reqPage;
	}
	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}
	public int getPageRow() {
		return pageRow;
	}
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}
	public int getStrIdx() {
//		return strIdx;
		return (getReqPage()-1)*getPageRow();
	}
	public void setStrIdx(int strIdx) {
		this.strIdx = strIdx;
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
