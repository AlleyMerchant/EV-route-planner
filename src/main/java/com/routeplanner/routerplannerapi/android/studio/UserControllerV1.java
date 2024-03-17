//package com.routeplanner.routerplannerapi.android.studio;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class UserControllerV1 {
//    @GetMapping("/login")
//    public void Login(){
//
//    }
//
//    @PostMapping("/register/{username}/{pw}")
//    public String Register(String username, String pw){
//        return username + ": " + pw;
//    }
//
//    @GetMapping("/register/{username}/{pw}")
//    public String Register2(@PathVariable String username, @PathVariable String pw){
//        MySqlConnection connection = new MySqlConnection();
//        return connection.count();
//    }
//}