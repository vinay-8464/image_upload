package com.example.demo.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Attachment;
import com.example.demo.Repository.AttachmentRepo;

@Service
public class HandleFileUpload {

	@Autowired
	private AttachmentRepo attachmentRepo;
	
	public List<Map<String,Object>> HandleFileUpload(MultipartFile file) {
		
	    List<Map<String, Object>> response = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
			if (!file.isEmpty()) {
		        map.put("SCODE","1");
		        map.put("SDESC", "Please select a file to upload.");
		        
		    	System.out.println("file.getOriginalFilename()"+file.getOriginalFilename());
		        String filePath = "C:/Users/SRIKANTH G/Documents/documents/" + file.getOriginalFilename();
		        File dest = new File(filePath);
		        file.transferTo(dest);
		        System.out.println("File uploaded successfully!");
		        Attachment attachment =new Attachment();
		       // attachment.
		        int insertNewTableDetails=0;
		        insertNewTableDetails= attachmentRepo.insertNewTableDetails(filePath);
		        
		        if(insertNewTableDetails>=0) {
		        	 map.put("SCODE","1");
				     map.put("SDESC", "File uploaded successfully!");
		        }
		        else {
		        	map.put("SCODE","0");
					map.put("SDESC", "Files not uploaded");
		        }
		        
		       
		        
			}
			else {
			   	 map.put("SCODE","0");
				 map.put("SDESC", "Files not uploaded");
			}
       } catch (IOException e) {
 	       // return "Failed to upload the file: " + e.getMessage();
 	    	 map.put("SCODE","0");
 		     map.put("SDESC", "Files not uploaded"); 
 	    }
		response.add(map);
		return response;
	}
}
