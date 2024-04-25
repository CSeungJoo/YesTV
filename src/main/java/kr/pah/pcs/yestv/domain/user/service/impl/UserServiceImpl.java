package kr.pah.pcs.yestv.domain.user.service.impl;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.user.dto.CreateUserDto;
import kr.pah.pcs.yestv.domain.user.entity.User;
import kr.pah.pcs.yestv.domain.user.repository.UserRepository;
import kr.pah.pcs.yestv.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder pwdEncoder;

    @Override
    public User createUser(CreateUserDto createUserDto) {

        User user = User.builder()
                .username(createUserDto.getUsername())
                .nickname(createUserDto.getNickname())
                .password(pwdEncoder.encode(createUserDto.getPassword()))
                .email(createUserDto.getEmail())
                .build();

        return userRepository.save(user);
    }

    @Override
    public User getUserByIdx(int idx) {
        return userRepository.findById(idx).orElseThrow(
                () -> new IllegalStateException("존재하지 않은 유저입니다.")
        );
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int idx) {
        getUserByIdx(idx).changeDelete();
    }

    @Override
    public void deleteUser(User user) {
        user.changeDelete();
    }
}
