package com.example.usermanagementrestapi.controller;

import com.example.usermanagementrestapi.entity.User;
import com.example.usermanagementrestapi.model.dto.UserDto;
import com.example.usermanagementrestapi.model.request.CreateUserReq;
import com.example.usermanagementrestapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


        @GetMapping("/search")
        public ResponseEntity<?> seachUser(@RequestParam(name = "keyword",required = false,defaultValue = "") String name){
            List<UserDto> users = userService.searchUser(name);
            return ResponseEntity.ok(users);
        }

    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.ok(users) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getListUserbyID(@PathVariable int id ){
        UserDto result = userService.getUserbyId(id);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Create user", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code=400,message = "Email already exists in the system"),
            @ApiResponse(code=500,message = "")
    })
    @PostMapping("")
    public ResponseEntity<?>  createListUser(@Valid @RequestBody CreateUserReq req){
        UserDto result = userService.createUser(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateListUser(){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListUser(){
        return null;
    }
}
