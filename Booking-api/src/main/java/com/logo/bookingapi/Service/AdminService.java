package com.logo.bookingapi.Service;

import com.logo.bookingapi.Dto.*;
import com.logo.bookingapi.Model.Admin;
import com.logo.bookingapi.Repository.AdminRepository;
import com.logo.bookingapi.exceptions.UserNotFoundException;
import com.logo.bookingapi.security.Encryptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminService {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Encryptor encryptor;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RabbitMQService rabbitMQService;

    public Admin register(AdminRegisterRequest adminRegisterRequest) {

        //Sistemde böyle bir kullanıcının zaten olup olmadığının kontrolünü yapar:
        boolean isExists = adminRepository.findByEmail(adminRegisterRequest.getEmail()).isPresent();
        if (isExists) {
            log.info("this email address already used");
            return null;
        }
        //Request'ten alınan datanın yeni oluşturulan user'a set edilmesi:
        Admin admin = new Admin();
        admin.setCompany(adminRegisterRequest.getCompany());
        admin.setName(adminRegisterRequest.getName());
        admin.setSurname(adminRegisterRequest.getSurname());
        admin.setEmail(adminRegisterRequest.getEmail());
        //Şifrenin hash algoritması ile db'ye kaydedilmesini sağlar.
        admin.setPassword(encryptor.encryptGivenPassword(adminRegisterRequest.getPassword()));
        admin.setPhone(adminRegisterRequest.getPhone());

        log.info("Admin sign up!");

        rabbitMQService.sendEmail(admin.getEmail());
        //User'ı db'ye kaydeder:
        return adminRepository.save(admin);

    }
    public String login(AdminLoginRequest request){
        request.setPassword(encryptor.encryptGivenPassword(request.getPassword()));
        boolean isExists = adminRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()).isPresent();
        if(isExists) {
            log.info("Admin login!");
            return "LOG IN SUCCESSFULLY";

        }else{
            return "USER NOT FOUND" ;
        }
    }
    public List<Admin> getAllAdmin() { // tüm adminleri listelemek için metod
        return adminRepository.findAll();
    }

    public Admin updateAdmin(int adminId, AdminChangeInfoRequest adminChangeInfoRequest) {
        Admin foundAdmin = adminRepository.findById(adminId).orElseThrow(()-> new UserNotFoundException());
        foundAdmin.setName(adminChangeInfoRequest.getName());
        foundAdmin.setPassword(encryptor.encryptGivenPassword(adminChangeInfoRequest.getPassword()));
        log.info("Admin update!");
        return adminRepository.save(foundAdmin);
    }

    public List<String> getAllEmails(){
        return getAllAdmin().stream().map(u -> u.getEmail()).toList();
    }
    public Admin findById(Integer id){
        return adminRepository.findById(id).orElseThrow(()-> new UserNotFoundException());
    }
}
