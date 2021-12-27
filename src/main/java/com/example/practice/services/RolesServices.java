//package com.example.practice.services;
//
////import com.example.practice.DAO.RolesDao;
//
////import com.example.practice.DAO.RolesDao;
//import com.example.practice.DAO.RolesDao;
//import com.example.practice.controller.roleController.RoleRepository;
//import com.example.practice.controller.userController.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RolesServices {
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    RolesDao rolesDao;
//
//
//    public Integer userNameService(String username) {
//        rolesDao.getRecordByName(username);     //"select * from table where name=:username);
//
//        return null ;
//    }
//
////    public Integer userNameService(String username) {
////    Integer uid=    userRepository.findByUsername(username).;     //"select * from table where name=:username);
////        return uid;
////    }
//
////    public String userRolesServices(Integer rid) {
////       String role= roleRepository.findById(rid) ;
////        //"select * from table where name=:username);
////        return role;
////    }
//
//    public String userRolesServices(Integer uid) {
//
//        rolesDao.getEmployeeRolesById(uid);     //"select * from table where name=:username);
//        return null;
//    }
//
//
//}
