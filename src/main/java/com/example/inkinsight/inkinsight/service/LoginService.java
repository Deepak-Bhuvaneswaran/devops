package com.example.inkinsight.inkinsight.service;

import com.example.inkinsight.inkinsight.model.Login;
import com.example.inkinsight.inkinsight.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepo repo;

    public Login log(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }

    public Object loginCheck(String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginCheck'");
    }
}