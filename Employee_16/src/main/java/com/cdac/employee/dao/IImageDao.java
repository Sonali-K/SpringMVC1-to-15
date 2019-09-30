package com.cdac.employee.dao;

import java.util.List;

import com.cdac.employee.bean.Image;



public interface IImageDao {
	//public int save(Image i);
	public List<Image> getImages();
	public int update(Image image);
	public int delete(int id);
	public Image getImageById(int id);
	public int insertRecords(Image image);

}
