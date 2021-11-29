//package com.example.practice.controller;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.data.mongodb.repository.Aggregation;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//public interface SalaryRepository extends MongoRepository<Salary, Integer> {
//
//	@Query("{'date':{$gt:?0,$lt:?1}}")
//	List<Salary> getByDate(Date fromdate, Date todate);
//
//	@Aggregation(pipeline = { "{$match: {'month': ?0}}", "{$group: { _id: '', total: {$max: $salary}}}" })
//	public int maxsalary(int month);
//
//	public Salary findBySalary(int month);
//
//	@Aggregation(pipeline = { "{$match: {'month': ?0}}", "{$group: { _id: '', total: {$min: $salary }}}" })
//	public int minsalary(int month);
//
//	public Salary findBysalary(int month);
//
//	@Aggregation(pipeline = { "{$match: {'month': ?0}}" })
//	public List<Salary> findAvg(int month);
//
//}
