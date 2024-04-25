package kr.pah.pcs.yestv.domain.user.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import kr.pah.pcs.yestv.domain.user.dto.CreateUserDto;
import kr.pah.pcs.yestv.domain.user.dto.ReturnUserDto;
import kr.pah.pcs.yestv.domain.user.dto.UpdateUserDto;
import kr.pah.pcs.yestv.domain.user.entity.User;
import kr.pah.pcs.yestv.domain.user.service.UserService;
import kr.pah.pcs.yestv.global.common.Result;
import kr.pah.pcs.yestv.global.common.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final Util util;
    private final PasswordEncoder pwdEncoder;

    @GetMapping("/get-user/{idx}")
    public ResponseEntity<?> getUserById(@Valid @PathVariable int idx) {
        try {
            User user = userService.getUserByIdx(idx);

            ReturnUserDto returnUserDto = ReturnUserDto.builder()
                    .username(user.getUsername())
                    .nickname(user.getNickname())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .build();

            return ResponseEntity.ok(new Result<>(returnUserDto));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto createUserDto) {
        User user = userService.createUser(createUserDto);

        ReturnUserDto returnUserDto = ReturnUserDto.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();

        return ResponseEntity.ok(new Result<>(returnUserDto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto updateUserDto) {
        try {
            User user = util.getLoginUser();

            updateUserDto.setPassword(pwdEncoder.encode(updateUserDto.getPassword()));

            user.updateUser(updateUserDto);

            userService.updateUser(user);
            return ResponseEntity.ok(new Result<>("성공적으로 정보가 변경되었습니다."));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser() {
        try {
            User user = util.getLoginUser();

            userService.deleteUser(user);

            return ResponseEntity.ok(new Result<>("정상적으로 삭제되었습니다."));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<?> deleteUserByIdx(@Valid @PathVariable int idx) {
        try {

            userService.deleteUser(idx);

            return ResponseEntity.ok(new Result<>("정상적으로 삭제되었습니다."));
        }catch (IllegalStateException e) {
            return ResponseEntity.ok(new Result<>(e.getMessage(), true));
        }
    }

}
