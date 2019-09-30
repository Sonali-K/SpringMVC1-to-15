package com.cdac.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cdac.employee.bean.Image;

public class ImageDaoImpl implements IImageDao{


	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	

	@Override
	public int insertRecords(Image image) {
		String sql="insert into Images(img_title,img_data,img_path) values('"+image.getImg_title()+"','"+image.getImg_data()+"','"+image.getImg_path()+"')";    
		System.out.println(sql);
		return template.update(sql);
		
	}
	@Override
	public List<Image> getImages() {
		return template.query("select * from images",new RowMapper<Image>(){    
	        public Image mapRow(ResultSet rs, int row) throws SQLException {    
	        	Image i=new Image();    
	            i.setId(rs.getInt(1));    
	            i.setImg_title(rs.getString(2));  
	   
	            //need byte array conversion
	            byte[] fileData=rs.getBytes(3);
				i.setImg_data(fileData);
				
	            i.setImg_path(rs.getString(4)); 
	              
	        	System.out.println(i);
	          
	            
	            return i;    
	        }    
	    });    
	} 
	

	@Override
	public int update(Image image) {
		
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql="delete from images where id="+id+"";    
		return template.update(sql);
	}

	@Override
	public Image getImageById(int id) {
		String sql="select * from images where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Image>(Image.class));   
	}
	

}
