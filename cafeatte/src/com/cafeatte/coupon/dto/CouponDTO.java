package com.cafeatte.coupon.dto;

public class CouponDTO {

	private int cno, cafe_no;
	private String sender, title, content, fileName, endDate, usedId;
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getUsedId() {
		return usedId;
	}
	public void setUsedId(String usedId) {
		this.usedId = usedId;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public int getCafe_no() {
		return cafe_no;
	}
	
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	@Override
	public String toString() {
		return "CouponDTO [cno=" + cno + ", cafe_no=" + cafe_no + ", sender=" + sender + ", title="
				+ title + ", content=" + content + ", fileName=" + fileName + ", endDate=" + endDate + ", usedId="
				+ usedId + "]";
	}
	
	
	
}
