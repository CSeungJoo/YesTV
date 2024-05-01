package kr.pah.pcs.yestv.domain.user.service.impl;

import kr.pah.pcs.yestv.domain.location.service.LocationService;
import kr.pah.pcs.yestv.domain.user.dto.CreateUserDto;
import kr.pah.pcs.yestv.domain.user.domain.User;
import kr.pah.pcs.yestv.domain.user.repository.UserRepository;
import kr.pah.pcs.yestv.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder pwdEncoder;
    private final LocationService locationService;


    @Override
    @Transactional
    public User createUser(CreateUserDto createUserDto) {
        Optional<User> userOpt = userRepository.getUserByUsername(createUserDto.getUsername());

        if(userOpt.isPresent())
            throw new IllegalStateException("이미 존재하는 유저입니다.");

        User createUser = User.builder()
                    .username(createUserDto.getUsername())
                    .nickname(createUserDto.getNickname())
                    .password(pwdEncoder.encode(createUserDto.getPassword()))
                    .email(createUserDto.getEmail())
                    .location(locationService.getLocationByIdx(createUserDto.getLocation_id()))
                    .build();

            return userRepository.save(createUser);
    }

    @Override
    public User getUserByIdx(int idx) {
        return userRepository.findById(idx).orElseThrow(
                () -> new IllegalStateException("존재하지 않은 유저입니다.")
        );
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int idx) {
        getUserByIdx(idx).changeDelete();
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        user.changeDelete();
    }
}
