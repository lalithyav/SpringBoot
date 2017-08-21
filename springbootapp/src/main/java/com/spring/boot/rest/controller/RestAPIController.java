package com.spring.boot.rest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rest")
public class RestAPIController {


	private final Logger logger = LoggerFactory.getLogger(RestAPIController.class);


	private static final String PERSIS_FOLD_LOC ="C://temp//";
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/uploadFile")
	public ResponseEntity<?> uploadMyFile(
			@RequestParam("inFile") MultipartFile uploadFile){

		logger.info("Lodged uploadMyFile API call");

		if(uploadFile.isEmpty()){
			return new ResponseEntity("Please provide a file to upload", HttpStatus.OK);
		}

		try{
			logger.info("Performing read and writing file data to local storage");
			
				
			byte[] dataBytes = uploadFile.getBytes();
			Path path = Paths.get(PERSIS_FOLD_LOC+uploadFile.getOriginalFilename());
			Files.write(path, dataBytes);
			
			BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
			logger.info("size: "+attr.size()+" bytes");
			logger.info("created time: "+attr.creationTime());
			
			
					
		}catch(IOException e){
			return new ResponseEntity("Improper file received !! ",HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity("Successfully uploaded file "+uploadFile.getOriginalFilename(), 
				new HttpHeaders(), HttpStatus.OK);
	}


}
