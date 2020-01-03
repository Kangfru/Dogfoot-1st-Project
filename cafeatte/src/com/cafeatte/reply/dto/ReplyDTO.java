package com.cafeatte.reply.dto;


public class ReplyDTO {
	private int replyNo;
	private String id;
	private String content;
	private String writeDate;
	private int no;
	
	public ReplyDTO(){
		
	}
	public ReplyDTO(int no, String content, String id){
		super();
		this.no = no;
		this.content = content;
		this.id = id;
	}
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "ReplyDTO [replyNo=" + replyNo + ", id=" + id + ", content=" + content + ", writeDate=" + writeDate
				+ ", no=" + no + "]";
	}

}
