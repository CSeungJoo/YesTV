package kr.pah.pcs.yestv.domain.videoReq.repository.impl;

import jakarta.persistence.EntityManager;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import kr.pah.pcs.yestv.domain.video.repository.CustomVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VideoReqRepositoryImpl implements CustomVideoRepository {

    private final EntityManager em;

    @Override
    public List<Video> findAllByStartTimeBetweenEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        return em.createQuery("select vr from VideoReq vr where vr.startTime >= :startTime AND vr.endTime <= :endTime", Video.class)
                .setParameter("startTime", startTime)
                .setParameter("endTime", endTime)
                .getResultList();
    }
}
