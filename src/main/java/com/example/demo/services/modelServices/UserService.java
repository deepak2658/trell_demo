package com.example.demo.services.modelServices;

import com.example.demo.model.movies.Movies;
import com.example.demo.model.user.Users;
import com.example.demo.pojo.Login;
import com.example.demo.pojo.Search;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.DbSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Encoder;
import java.util.Base64;

import static com.example.demo.model.movies.Movies.SEQUENCE_NAME;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DbSequenceService dbSequenceService;
    @Autowired
    MoviesServices moviesServices;


    @Transactional
    public String  save(Users user){
        try {
            user.setId((long)dbSequenceService.getSequenceNumber(SEQUENCE_NAME));
            Users users = null;
                    users = userRepository.findAllByUsername(user.getUsername());
                    if(users!=null) return "User already exisits";
                    else{
                        Base64.Encoder encoder = Base64.getEncoder();
                        String originalString = user.getPassword();
                        String encodedString = encoder.encodeToString(originalString.getBytes());
                        user.setPassword(encodedString);



                        System.out.println(encodedString);
                        userRepository.save(user);
                        return user.toString();
                    }

        }catch (Exception e){
            return e.toString();
        }
    }
    @Transactional
    public Integer login(Login login){
        Users users = userRepository.findAllByUsername(login.getUsername());
        if(users==null) return -1;
        else{

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(users.getPassword());
            String res  = new String(bytes);
            if(res.equals(login.getPassword())) return 1;
            else return -1;
        }
        }


}
