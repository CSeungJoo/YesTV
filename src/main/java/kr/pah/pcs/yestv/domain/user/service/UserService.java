package kr.pah.pcs.yestv.domain.user.service;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User createUser(User user);
    User getUserByIdx(int idx);
    User updateUser(Location location);
    void deleteUser(int idx);
}
