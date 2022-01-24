package com.classstudies.classquiz.dumpExcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classstudies.classquiz.dumpExcel.entity.Excel;

public interface ExcelRepository extends JpaRepository<Excel, Double> {

}
