package kr.pah.pcs.yestv.domain.video.service;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VideoService {

    Video createVideo(Video video);
    Video getVideoByIdx(int idx);
    List<Video> getVideosByStartTimeBetweenEndTime();
    Page<Video> getVideosByLocation(Location location);
    Video updateVideo(Video video);
    void deleteVideo(int idx);
}
