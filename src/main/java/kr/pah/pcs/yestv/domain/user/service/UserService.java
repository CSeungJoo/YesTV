package kr.pah.pcs.yestv.domain.user.service;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.user.dto.CreateUserDto;
import kr.pah.pcs.yestv.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User createUser(CreateUserDto createUserDto);
    User getUserByIdx(int idx);
    User updateUser(User user);
    void deleteUser(int idx);
}
