package com.classstudies.classquiz.dumpExcel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.classstudies.classquiz.dumpExcel.entity.Excel;
import com.classstudies.classquiz.dumpExcel.helper.ExcelHelper;
import com.classstudies.classquiz.dumpExcel.repository.ExcelRepository;

@Service
public class ExcelService {
	
	@Autowired
	private ExcelRepository excelRepo;
	
	public void save(MultipartFile file) {
		
		try {
			List<Excel> data = ExcelHelper.convertExcelToList(file.getInputStream());
			this.excelRepo.saveAll(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Excel> getAllData(){
		return this.excelRepo.findAll();
	}

}
