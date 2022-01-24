package com.classstudies.classquiz.dumpExcel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.classstudies.classquiz.dumpExcel.entity.Excel;
import com.classstudies.classquiz.dumpExcel.helper.ExcelHelper;
import com.classstudies.classquiz.dumpExcel.service.ExcelService;

@RestController
@CrossOrigin("*")
@RequestMapping("/excel")
public class ExcelController {
	
	@Autowired
	private ExcelService excelService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		
		if(ExcelHelper.checkFileType(file)) {
			
			this.excelService.save(file);
			return ResponseEntity.ok(Map.of("message", "File uploaded successfully abd date is saved."));
			
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select Excel file only.");
	}
	
	@GetMapping("get-all")
	public List<Excel> getAll(){
		return this.excelService.getAllData();
	}

}
