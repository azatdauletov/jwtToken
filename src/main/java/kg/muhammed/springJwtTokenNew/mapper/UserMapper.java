package kg.muhammed.springJwtTokenNew.mapper;

import kg.muhammed.springJwtTokenNew.dto.UserDto;
import kg.muhammed.springJwtTokenNew.model.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole()
        );
    }
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getRole()
        );
    }
}
