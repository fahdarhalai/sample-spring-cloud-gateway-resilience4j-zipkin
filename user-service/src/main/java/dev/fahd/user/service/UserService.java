package dev.fahd.user.service;

import dev.fahd.user.dto.UserDTO;
import dev.fahd.user.exception.DataNotFoundException;
import dev.fahd.user.mapper.UserMapper;
import dev.fahd.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO save(UserDTO userDTO) {
        log.info("Enter save method of UserService");
        var user = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDTO(user);
    }

    public UserDTO findById(Long userId) throws DataNotFoundException {
        log.info("Inside findById of UserService");
        var user = userRepository
                .findById(userId)
                .orElseThrow(
                        () -> new DataNotFoundException(String.format("User with id %d not found", userId))
                );

        return userMapper.toDTO(user);
    }
}
