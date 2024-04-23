package kr.pah.pcs.yestv.domain.videoReq.service.impl;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.video.repository.VideoRepository;
import kr.pah.pcs.yestv.domain.videoReq.domain.VideoReq;
import kr.pah.pcs.yestv.domain.videoReq.dto.CreateVideoReqDto;
import kr.pah.pcs.yestv.domain.videoReq.repository.VideoReqRepository;
import kr.pah.pcs.yestv.domain.videoReq.service.VideoReqService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoReqServiceImpl implements VideoReqService {

    private final VideoReqRepository videoReqRepository;

    @Override
    public VideoReq createVideoReq(CreateVideoReqDto createVideoReqDto) {
        VideoReq videoReq = VideoReq.builder()
                .title(createVideoReqDto.getTitle())
                .content(createVideoReqDto.getContent())
                .startTime(createVideoReqDto.getStartTime())
                .endTime(createVideoReqDto.getEndTime())
                .build();

        return videoReqRepository.save(videoReq);
    }

    @Override
    public VideoReq getVideoReqByIdx(int idx) {
        return videoReqRepository.findById(idx).orElseThrow(
                () -> new IllegalStateException("존재하지 않은 영상요청글 입니다.")
        );
    }

    @Override
    public List<VideoReq> getVideosReqByStartTimeBetweenEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        return videoReqRepository.findAllByStartTimeBetweenEndTime(startTime, endTime);
    }

    @Override
    public Page<VideoReq> getVideoReqsByLocation(Location location, Pageable pageable) {
        return videoReqRepository.findByLocation(location, pageable);
    }

    @Override
    public VideoReq updateVideoReq(VideoReq videoReq) {
        return videoReqRepository.save(videoReq);
    }

    @Override
    public void deleteVideoReq(int idx) {
        videoReqRepository.deleteById(idx);
    }
}
