package memo.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MemoDTO {
	
	private Integer no;
	private String writer;
	private String memo;
	private LocalDateTime reg_date;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public LocalDateTime getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date.toLocalDateTime();
	}
	
	public MemoDTO() {
		super();
	}
	public MemoDTO(String writer, String memo) {
		super();
		this.writer = writer;
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "MemoDTO [no=" + no + ", writer=" + writer + ", memo=" + memo + ", reg_date=" + reg_date + "]";
	}
	
}
