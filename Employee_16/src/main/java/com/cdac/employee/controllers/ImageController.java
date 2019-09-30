package com.cdac.employee.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.employee.bean.Image;
import com.cdac.employee.dao.IImageDao;



@Controller
public class ImageController {
	@Autowired    
	IImageDao dao; 
	
	
	private static final String UPLOAD_DIRECTORY ="/home/cdac-kharghar2/eclipse-workspace1/SpringMVCCRUDSimple/src/main/webapp/images/";
	private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB

	
	@RequestMapping("upload")
	public ModelAndView uploadForm(){
		return new ModelAndView("upload");	
	}
	
	
	
	
	
	/*It saves object into database. The @ModelAttribute puts request data   *  into model object. You need to mention RequestMethod.POST method   
	 *  because default request is GET*/ 
	
	
	@RequestMapping(value="savefile1",method=RequestMethod.POST)
	public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,HttpSession session) throws Exception
	{
		
	DiskFileItemFactory factory = new DiskFileItemFactory();
	factory.setSizeThreshold(THRESHOLD_SIZE);
	factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	ServletFileUpload upload = new ServletFileUpload(factory);
	//ServletContext context = session.getServletContext();

	String uploadPath =UPLOAD_DIRECTORY;
	String filename = file.getOriginalFilename();
	System.out.println(uploadPath);	    

	byte[] bytes = file.getBytes();
	BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(uploadPath + File.separator + file.getOriginalFilename())));
	stream.write(bytes);
	
	
	 Image image=new Image();
		image.setImg_title(file.getOriginalFilename());
		image.setImg_data(file.getBytes());
		image.setImg_path(uploadPath);

	dao.insertRecords(image);

	stream.flush();
	stream.close();
	     
	return new ModelAndView("upload","filesuccess","File successfully saved!");
	}
	
	
	  /*it display uploaded file from given location*/
	@RequestMapping(value = "/displayFile")
	public String displayFile(Model model, HttpServletRequest request)
	{
		File uploadLocationDir = new File("/home/cdac-kharghar2/eclipse-workspace1/SpringMVCCRUDSimple/src/main/webapp/images/");
		String[] files = uploadLocationDir.list();
		System.out.println("files " + Arrays.toString(files));
		model.addAttribute("fileList", files);
		return "displayFile";
	}

	
		@RequestMapping("/displayFileDB")    
		public String displayFiledb(Model model, HttpServletRequest request){    
			List<Image> list=dao.getImages();    
			model.addAttribute("list2",list);  
			return "displayFileDB";    
		} 
	
		
		
		/* It provides list of Images in model object */    
		@RequestMapping("/viewImageTable")    
		public String viewImage(Model m){    
			List<Image> list1=dao.getImages();
			for (Image image : list1) {
				System.out.println("******");
				System.out.println(image);
			}
			m.addAttribute("list1",list1);  
			return "viewImageTable";    
		} 
	
	/*
     * Download a file from 
     *   - inside project, located in resources folder.
     *   - outside project, located in File system somewhere. 
     */

	@ResponseBody
    @RequestMapping(value = "/downloadFile/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] downloadFile(@PathVariable("fileName") String fileName) throws IOException {
        InputStream in = new FileInputStream(UPLOAD_DIRECTORY +fileName +".jpeg");
        return IOUtils.toByteArray(in);
    }


}
