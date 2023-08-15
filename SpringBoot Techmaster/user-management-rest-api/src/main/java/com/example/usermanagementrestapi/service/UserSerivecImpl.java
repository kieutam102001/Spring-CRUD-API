package com.example.usermanagementrestapi.service;


import com.example.usermanagementrestapi.entity.User;
import com.example.usermanagementrestapi.exception.DuplicateRecordException;
import com.example.usermanagementrestapi.exception.NotFoundException;
import com.example.usermanagementrestapi.model.dto.UserDto;
import com.example.usermanagementrestapi.model.mapper.UserMapper;
import com.example.usermanagementrestapi.model.request.CreateUserReq;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserSerivecImpl implements UserService{
    private static ArrayList<User> users = new ArrayList<>();
    static {
        users.add(new User(1,"Kieu Trung tAm","kieu@gmail.com","0123","1.jpg","123"));
        users.add(new User(2,"Hoang","hoang@gmail.com","0345","2.jpg","456"));
        users.add(new User(3,"Le","le@gmail.com","0123","3.jpg","123"));
        users.add(new User(4,"Kieu ","f@gmail.com","0123","1.jpg","123"));

    }


    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<>();
        for (User user : users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserbyId(int id) {
        for (User user : users){
            if (user.getId()==id){
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User không tồn tại trong hệ thống");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for(User user : users){
            if(user.getName().contains(keyword)){
                    result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        for (User user : users){
            if(user.getEmail().equals(req.getEmail())){
                throw new DuplicateRecordException("Email already exists in the system");
            }
        }
        User user = UserMapper.toUser(req);
        user.setId(users.size()+1);
        users.add(user);
        return UserMapper.toUserDto(user);
    }


}
