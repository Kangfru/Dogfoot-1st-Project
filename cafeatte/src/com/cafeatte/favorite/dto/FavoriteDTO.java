package com.cafeatte.favorite.dto;

public class FavoriteDTO {
	private String id;
	private int no;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "FavoriteDTO [id=" + id + ", no=" + no + "]";
	}
}
