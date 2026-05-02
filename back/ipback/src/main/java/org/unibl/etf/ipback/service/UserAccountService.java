package org.unibl.etf.ipback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ipback.entities.UserAccountEntity;
import org.unibl.etf.ipback.repository.UserAccountRepository;

import java.io.*;
import java.util.Date;
import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public UserAccountEntity getOneUser(UserAccountEntity userAccountEntity){
        UserAccountEntity user = userAccountRepository.findUserAccountEntitiesByUsername(userAccountEntity.getUsername());
        System.out.println("USER:"+ userAccountEntity.getUsername());
        if (user != null){
           if(user.getPassword().equals(userAccountEntity.getPassword())){
               this.createLoggs(userAccountEntity);
               return user;
           }
           else
               return null;
        }
        return null;
    }
    public List<UserAccountEntity> getAll(){
        return  userAccountRepository.findAll();
    }

    public UserAccountEntity createUserAcc(UserAccountEntity userAccountEntity) {
        UserAccountEntity userAccount = userAccountRepository.findUserAccountEntitiesByUsername(userAccountEntity.getUsername());
        if(userAccount == null) {
            System.out.println("NULL"+userAccountEntity.getUsername());
            userAccountRepository.save(userAccountEntity);
            return userAccountEntity;
        }
        else
            return null;
    }

    public void deleteUserAcc(UserAccountEntity userAccountEntity){
        userAccountRepository.delete(userAccountEntity);
    }

    public void updateUserAcc(UserAccountEntity userAccountEntity){
        userAccountRepository.save(userAccountEntity);
    }

    private void createLoggs(UserAccountEntity userAccountEntity){
        String tekst = this.readFile();
        File file = new File("loggs.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            pw.println(tekst+"\n"+userAccountEntity.getUsername()+"#"+userAccountEntity.getPassword()+"#"+new Date().toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(pw != null)
                pw.close();
        }
    }
    private String readFile(){
        try {
            File file = new File("loggs.txt");
            BufferedReader inputStream = new BufferedReader(new FileReader(file));
            String line = "";
            String tekst = "";

            while((line = inputStream.readLine())!=null){
                tekst += line + "\n";
            }

            return tekst ;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
