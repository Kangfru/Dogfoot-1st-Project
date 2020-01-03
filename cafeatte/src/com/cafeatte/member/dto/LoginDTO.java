package com.cafeatte.member.dto;

public class LoginDTO {
	
	private String id, pw, nickName;
	private int state, grade;
	private String gradeName, stateName, photo;
	
	public LoginDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public LoginDTO() {	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", pw=" + pw + ", nickName=" + nickName + ", state=" + state + ", grade=" + grade
				+ ", gradeName=" + gradeName + ", stateName=" + stateName + ", photo=" + photo + "]";
	}	

	
	
}
