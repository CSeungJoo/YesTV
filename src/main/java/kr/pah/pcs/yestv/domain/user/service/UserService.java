package kr.pah.pcs.yestv.domain.user.service;

import kr.pah.pcs.yestv.domain.user.dto.CreateUserDto;
import kr.pah.pcs.yestv.domain.user.domain.User;

public interface UserService {
    User createUser(CreateUserDto createUserDto);
    User getUserByIdx(int idx);
    User updateUser(User user);
    void deleteUser(int idx);
    void deleteUser(User user);
}
