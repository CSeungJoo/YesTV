package kr.pah.pcs.yestv.domain.video.service;

import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public interface VideoService {

    Video createVideo(MultipartFile video, Cam cam);
    Video getVideoByIdx(int idx);
    List<Video> getVideosByStartTimeBetweenEndTime(LocalDateTime startTime, LocalDateTime endTime);
    Page<Video> getVideosByLocation(Location location, Pageable pageable);
    Video updateVideo(Video video);
    void deleteVideo(int idx);
}
