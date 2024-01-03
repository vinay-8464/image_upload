package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.HandleFileUpload;


@RestController
public class AttachmentController {
	
	@Autowired
	private HandleFileUpload handleUpload;
	
	@PostMapping("/upload")
	public List<Map<String, Object>> fileUpload(@RequestParam("file") MultipartFile file) {
		return handleUpload.HandleFileUpload(file);
		//return "file uploaded successfully";
	}
	
}
