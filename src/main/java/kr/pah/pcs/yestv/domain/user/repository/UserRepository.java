package kr.pah.pcs.yestv.domain.user.repository;

import kr.pah.pcs.yestv.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByUsername(String username);
}
