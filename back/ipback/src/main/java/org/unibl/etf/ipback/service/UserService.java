package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.UserEntity;
import org.unibl.etf.ipback.repository.UserAccountRepository;
import org.unibl.etf.ipback.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    public UserEntity createUser(UserEntity userEntity){
        System.out.println("Sifra"+ userEntity.getUserAccount().getPassword());
        if(this.getUserByUsername(userEntity.getUserAccount().getUsername()) == null){
            userAccountRepository.save(userEntity.getUserAccount());
            return userRepository.save(userEntity);
        }
        else
            return null;
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity getUserByUsername(String username){
        return userRepository.findUserEntityByUserAccount_Username(username);
    }

    public UserEntity getUserById(Integer id){
        return userRepository.findUserEntityById(id);
    }

    public void updateUser(UserEntity userEntity){
        UserEntity user = userRepository.findUserEntityByUserAccount_Username(userEntity.getUserAccount()
                .getUsername());
        user.setCity(userEntity.getCity());
        user.setName(userEntity.getName());
        user.setMail(userEntity.getMail());
        user.getUserAccount().setPassword(userEntity.getUserAccount().getPassword());
        userRepository.save(user);
    }
}
