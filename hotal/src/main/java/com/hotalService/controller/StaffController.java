package com.hotalService.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {

	@GetMapping
	public ResponseEntity<List<String>> getStaff() {
		List<String> list = Arrays.asList("s1","s2","s3","s4","s5");
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
}
