package com.my.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.dao.EmployeeDao;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/list")
	public String list(Map<String, Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
	public static void main(String[] args) {
		EmployeeDao abc = new EmployeeDao();
		System.out.println(abc.getAll());
	}
	
}
