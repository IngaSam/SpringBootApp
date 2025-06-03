package com.example.demo.service;

import com.example.demo.repository.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll(); //возвращает все записи из БД

    }
    public User create(User user){
        Optional <User> optionalUser=userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()){
            throw new IllegalArgumentException("Пользователь с таким имейлом уже существует");
        }
        user.setAge(Period.between(user.getBirth(), LocalDate.now()).getYears()); //подсчет возраста
        return userRepository.save(user);
    }
}
