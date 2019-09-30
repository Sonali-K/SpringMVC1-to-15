package com.cdac.employee.bean;

import java.util.Arrays;

public class Image {

	private int id;
	private String img_title;
	private byte [] img_data;
	private String img_path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg_title() {
		return img_title;
	}
	public void setImg_title(String img_title) {
		this.img_title = img_title;
	}
	public byte[] getImg_data() {
		return img_data;
	}
	public void setImg_data(byte[] img_data) {
		this.img_data = img_data;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", img_title=" + img_title + ", img_data=" + Arrays.toString(img_data)
				+ ", img_path=" + img_path + "]";
	}
	
}
