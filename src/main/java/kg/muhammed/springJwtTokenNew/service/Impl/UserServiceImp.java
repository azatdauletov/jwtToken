package kg.muhammed.springJwtTokenNew.service.Impl;

import kg.muhammed.springJwtTokenNew.dto.UserDto;
import kg.muhammed.springJwtTokenNew.mapper.UserMapper;
import kg.muhammed.springJwtTokenNew.model.User;
import kg.muhammed.springJwtTokenNew.repository.UserRepository;
import kg.muhammed.springJwtTokenNew.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository repository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = repository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }
}
