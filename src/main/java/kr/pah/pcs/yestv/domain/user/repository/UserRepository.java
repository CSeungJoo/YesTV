package kr.pah.pcs.yestv.domain.user.repository;

import kr.pah.pcs.yestv.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}