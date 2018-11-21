package com.lidong.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class fileuploadController {
	@RequestMapping("/fileUploadController")
	public Map<String, String> fileupload(MultipartFile filename) throws Exception{
		System.out.println(filename.getOriginalFilename());
		filename.transferTo(new File("/Users/lidong/"+filename.getOriginalFilename())
				);
		Map<String, String> ll=new HashMap<>();
		ll.put("lidong", "lidong");
		return ll;
	}
}
