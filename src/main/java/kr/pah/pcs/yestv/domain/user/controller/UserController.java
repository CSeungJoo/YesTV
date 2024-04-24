package kr.pah.pcs.yestv.domain.user.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import kr.pah.pcs.yestv.domain.user.dto.CreateUserDto;
import kr.pah.pcs.yestv.domain.user.dto.ReturnUserDto;
import kr.pah.pcs.yestv.domain.user.dto.UpdateUserDto;
import kr.pah.pcs.yestv.domain.user.entity.User;
import kr.pah.pcs.yestv.domain.user.service.UserService;
import kr.pah.pcs.yestv.global.common.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get-ser/{idx}")
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
    @PermitAll
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
//        try {
//          로그인된 user객체를 가져와 수정하는 코드

//            userService.updateUser()
//        }
        return ResponseEntity.ok(new Result<>("test"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser() {
//        로그인 되어있는 유저의 isDelete true로 바꾸는 로직
        return ResponseEntity.ok(new Result<>("test"));
    }

}
