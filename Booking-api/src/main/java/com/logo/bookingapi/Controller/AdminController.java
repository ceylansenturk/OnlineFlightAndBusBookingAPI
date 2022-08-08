package com.logo.bookingapi.Controller;

import com.logo.bookingapi.Dto.*;
import com.logo.bookingapi.Model.Admin;
import com.logo.bookingapi.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;
    //Yeni admin kaydı oluşturma
    @PostMapping("/signup")
    public Admin register(@RequestBody AdminRegisterRequest adminRegisterRequest){
        return adminService.register(adminRegisterRequest);
    }
    // Admin login sistemi
    @GetMapping("/login")
    public String login(@RequestBody AdminLoginRequest adminLoginRequest){
        return adminService.login(adminLoginRequest);
    }
    // Admin id'si ile isim ve şifre güncellenebilir
    @PutMapping("/{id}")
    public void changeName(@PathVariable int id, @RequestBody AdminChangeInfoRequest adminChangeInfoRequest){
        adminService.updateAdmin(id, adminChangeInfoRequest);
    }
    //Bütün adminlerin get edilmesi
    @GetMapping
    public List<Admin> getAllAdmin() {
        return adminService.getAllAdmin();
    }
    //id ile admin sorgulama
    @GetMapping(value = "/{id}")
    public List<Admin> findById(@PathVariable("id") Integer id) {
        return (List<Admin>) adminService.findById(id);
    }

}
