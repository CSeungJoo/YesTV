package kr.pah.pcs.yestv.domain.video.repository;

import kr.pah.pcs.yestv.domain.video.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
