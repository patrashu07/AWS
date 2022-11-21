package com.green.nowon.domain.entty;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Test {
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	@Column(nullable= false) 
	private String title;
	
	@CreatedDate  
	@Column(columnDefinition = "timestamp")
	private LocalDateTime created_date;
}
