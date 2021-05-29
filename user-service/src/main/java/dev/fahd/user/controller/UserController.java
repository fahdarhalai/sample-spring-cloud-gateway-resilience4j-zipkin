package dev.fahd.user.controller;

import dev.fahd.user.dto.UserDTO;
import dev.fahd.user.exception.DataNotFoundException;
import dev.fahd.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        log.info("Enter create of UserController");
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long userId) throws DataNotFoundException {
        log.info("Enter findById of UserController");
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }
}
