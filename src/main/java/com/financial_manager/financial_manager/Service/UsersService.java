package com.financial_manager.financial_manager.Service;

import com.financial_manager.financial_manager.dto.UsersDTO;
import com.financial_manager.financial_manager.entity.Users;
import com.financial_manager.financial_manager.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder){
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UsersDTO dto){

        /*if(usersRepository.existsByUsername(dto.getUsername())){
            throw new RuntimeException("Failed to create account. Please try another username");
        }*/

        Users newuser = new Users(
                dto.getUsername(),
                dto.getFullname(),
                dto.getPassword()
        );

        //hash password
        String hashedPassword = passwordEncoder.encode(newuser.getPassword());
        newuser.setPassword(hashedPassword);

        usersRepository.save(newuser);
    }
}
