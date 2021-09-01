package org.ada.school.service;

import org.ada.school.repository.UserRepository;
import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.model.document.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService{

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private final UserRepository userRepository;


    public UserServiceMongoDB(@Autowired UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    @Override
    public User create(User user) {
        user.DocToUser( userRepository.save( new UserDocument( user ) ) );
        return user;
    }

    @Override
    public User findById(String id) {
        Optional< UserDocument > op = userRepository.findById( id );
        if( op.isPresent() ){ return new User( op.get() ); }
        throw new RuntimeException( );
    }

    @Override
    public List<User> all() {
        List<User> users = new ArrayList<>();
        for( UserDocument userDocument : userRepository.findAll() ){
            users.add( new User( userDocument ) );
        }
        return users ;
    }

    @Override
    public boolean deleteById(String id) {
        boolean deleted = true;
        try{
            findById(id);
            userRepository.deleteById( id );
        }catch (Exception e){
            deleted = false;
        }
        return deleted;

    }

    @Override
    public User update(UserDto userDto, String id) {
        findById(id);
        User user = new User(userDto, id);
        user.DocToUser(userRepository.save(new UserDocument(user)));
        return user;
    }


}
