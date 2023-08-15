package com.example.usermanagementrestapi.model.mapper;

import com.example.usermanagementrestapi.entity.User;
import com.example.usermanagementrestapi.model.dto.UserDto;
import com.example.usermanagementrestapi.model.request.CreateUserReq;
import org.mindrot.jbcrypt.BCrypt;

public class UserMapper {
    public static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());
        tmp.setEmail(user.getEmail());

        return tmp;
    }

    public static User toUser(CreateUserReq req){
        User user = new User();
        user.setName(req.getName());
        user.setPhone(req.getPhone());
        user.setEmail(req.getEmail());
        String hash = BCrypt.hashpw(req.getPassword(),BCrypt.gensalt(12));
        user.setPassword(hash);
        return user;
    }
}
