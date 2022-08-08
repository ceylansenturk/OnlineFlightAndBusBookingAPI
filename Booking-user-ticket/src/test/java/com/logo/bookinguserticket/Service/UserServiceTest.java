package com.logo.bookinguserticket.Service;

import com.logo.bookinguserticket.Dto.UserRegisterRequest;
import com.logo.bookinguserticket.Model.User;
import com.logo.bookinguserticket.Repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;




    @Test
    @DisplayName("it should register the user")
    void it_should_register_the_user(){
        //When
        UserRegisterRequest user = prepareUser();
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        //given
        User response = userService.register(user);
        //then
        verify(userRepository).save(Mockito.any());
        assertThat(response.getName()).isEqualTo(user.getName());
        assertThat(response.getEmail()).isEqualTo("ceylan@gmail.com");

    }
    private UserRegisterRequest prepareUser(){
        UserRegisterRequest user = new UserRegisterRequest();
        user.setName("Ceylan");
        user.setEmail("ceylan@gmail.com");
        return user;
    }
}
