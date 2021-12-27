//package com.example.practice.DAO;
//
//import com.example.practice.controller.userController.User;
//import org.springframework.data.mongodb.repository.Aggregation;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
//@Component
//public class RolesDao {
//
//
//    Map<String, String> l = new HashMap();
//    RolesDao(){
////        l.put("springuser", "Admin");
////        l.put("XYZ", "Dev");
//    }
//
//    //  @Aggregation(pipeline = { "{$match: {'username': ?0}}" })
//    public Integer getRecordByName(String username) {
//
//     // this wil return Id from employees tables
//
//       if (username.contains(username)) {
//           System.out.println(username);
//       }
//
//        return null;
//    }
//    //@Query("{ 'uid' : ?0 }")
//    public String getEmployeeRolesById(Integer uid) {
//        /// this will fetch data from EmpRoles table where uId is 123
//
//
//        return "role";
//    }
//}
