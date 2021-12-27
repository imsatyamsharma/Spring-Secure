package com.example.practice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@Component
@RestController
@RequestMapping("/Salary")
public class SalaryController {

	@Autowired
	private SalaryRepository salaryrepository;

	Logger logger = LoggerFactory.getLogger(getClass());

	public Date setDate(int month1, int year1) {

		int day = createRandomInBetween(1, 28);
		int month = createRandomInBetween(month1, month1);
		int year = createRandomInBetween(year1, year1);
		LocalDate localDate = LocalDate.of(year, month, day);

		Date date = Date.from(Instant.from(localDate.atStartOfDay(ZoneId.of("GMT"))));

//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String date1 = df.format(date);
//		Date date2 = date_conversion(date1);

		return date;

	}

	private int createRandomInBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));

	}

	private Date date_conversion(String date11) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		try {
			date1 = df.parse(date11);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return date1;

	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/add")
	public String empsalary(@RequestBody Salary e) {
		Date date = setDate(e.month, e.year);
		e.setDate(date);
		salaryrepository.insert(e);
		return "salary added";

	}
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/fetch/{one_date}/{two_date}")
	public List<Salary> getData_between(@PathVariable(value = "one_date") String fromdate,
			@PathVariable(value = "two_date") String todate) {
		Date fromdate1 = date_conversion(String.valueOf(fromdate));
		Date todate1 = date_conversion(String.valueOf(todate));

		List<Salary> allEmployees = salaryrepository.getByDate(fromdate1, todate1);

		return allEmployees;
	}

	public int minsalary(int month) {
		return salaryrepository.minsalary(month);
	}

	public int maxsalary(int month) {
		return salaryrepository.maxsalary(month);
	}

	public double findAverage(int month) {
		List<Salary> salary = salaryrepository.findAvg(month);

		int sum = 0;
		for (int i = 0; i < salary.size(); i++) {
			sum = salary.get(i).getSalary() + sum;
		}
		int avg = 0;
		avg = sum / salary.size();
		return avg;
	}
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/max_min_avg/{month}")
	public SalaryData findSalaryDetails(@PathVariable(value = "month") int month) {
		int minSalary = minsalary(month);
		int maxSalary = maxsalary(month);
		double avgSalary = findAverage(month);
		SalaryData salaryData = new SalaryData();
		salaryData.setMinsalary(minSalary);
		salaryData.setMaxsalary(maxSalary);
		salaryData.setAvgsalary(avgSalary);
		return salaryData;
	}
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/maxsalary/{month}")
	public Salary findMaxSalarydetail(@PathVariable(value = "month") int month) {
		return salaryrepository.findBySalary(maxsalary(month));
	}
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/minsalary/{month}")
	public Salary findMinSalarydetail(@PathVariable(value = "month") int month) {
		return salaryrepository.findBysalary(minsalary(month));
	}

}
