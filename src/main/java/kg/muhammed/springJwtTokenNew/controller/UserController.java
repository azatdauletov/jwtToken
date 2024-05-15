package kg.muhammed.springJwtTokenNew.controller;

import kg.muhammed.springJwtTokenNew.dto.UserDto;
import kg.muhammed.springJwtTokenNew.service.Impl.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImp userServiceImp;

    @PostMapping("/user")
    @PreAuthorize("hasAuthority(ADMIN)")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userServiceImp.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
