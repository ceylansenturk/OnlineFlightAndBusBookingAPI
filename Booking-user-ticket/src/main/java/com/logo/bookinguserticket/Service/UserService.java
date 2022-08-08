package com.logo.bookinguserticket.Service;


import com.logo.bookinguserticket.Dto.UserChangeInfoRequest;
import com.logo.bookinguserticket.Dto.UserLoginRequest;
import com.logo.bookinguserticket.Dto.UserRegisterRequest;
import com.logo.bookinguserticket.Exceptions.UserNotFoundException;
import com.logo.bookinguserticket.Model.User;
import com.logo.bookinguserticket.Repository.UserRepository;
import com.logo.bookinguserticket.Security.Encryptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService{
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Encryptor encryptor;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RabbitMQService rabbitMQService;


    //Kullanıcı sisteme kayıt olur:
    public User register(UserRegisterRequest userRegisterRequest) {
        // bu mail ile daha önce kayıt olunmuş mu kontrolü
        boolean isExists = userRepository.findByEmail(userRegisterRequest.getEmail()).isPresent();
        if (!isExists) {
            User user = new User();
            user.setName(userRegisterRequest.getName());
            user.setSurname(userRegisterRequest.getSurname());
            user.setEmail(userRegisterRequest.getEmail());
            // password hashlenerek database e kaydedilir
            user.setPassword(encryptor.encryptGivenPassword(userRegisterRequest.getPassword()));
            user.setPhone(userRegisterRequest.getPhone());
            user.setUserType(userRegisterRequest.getUserType());

            log.info("User sign up!");
            rabbitMQService.sendEmail(user.getEmail());
            //User'ı db'ye kaydeder:
            return userRepository.save(user);


        }
        log.info("this email address already used");
         return null;
    }
    // Kullanıcı email ve şifresi ile login olur
    public String login(UserLoginRequest request){
        request.setPassword(encryptor.encryptGivenPassword(request.getPassword()));
        boolean isExists = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()).isPresent();
        if(isExists) {
            log.info("User login!");
            return "LOG IN SUCCESSFULLY";

        }else{
            return "USER NOT FOUND" ;
        }
    }
    // Kullanıcı id le isim ve şifre güncellenir
    public User updateUser(int userId, UserChangeInfoRequest userChangeInfoRequest) {
        User foundUser = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException());
        foundUser.setName(userChangeInfoRequest.getName());
        foundUser.setPassword(encryptor.encryptGivenPassword(userChangeInfoRequest.getPassword()));
        log.info("Kullanıcı bilgileri güncellendi.");
        return userRepository.save(foundUser);
    }
    public List<User> getAllUsers() { // tüm user'ları listelemek için metod
        return userRepository.findAll();
    }

    public List<String> getAllEmails(){
        return getAllUsers().stream().map(u -> u.getEmail()).toList();
    }
    public User findById(Integer userId){
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException());
    }

}
