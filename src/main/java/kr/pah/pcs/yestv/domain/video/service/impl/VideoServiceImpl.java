package kr.pah.pcs.yestv.domain.video.service.impl;

import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import kr.pah.pcs.yestv.domain.video.domain.Video;
import kr.pah.pcs.yestv.domain.video.repository.VideoRepository;
import kr.pah.pcs.yestv.domain.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final LocationService locationService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public Video createVideo(MultipartFile video, Cam cam, LocalDateTime startTime) {
        String url = video.getOriginalFilename().substring(video.getOriginalFilename().lastIndexOf("."));

        Video createVideo = Video.builder()
                .startTime(startTime)
                .endTime(startTime.plusMinutes(10))
                .url(UUID.randomUUID() + url)
                .cam(cam)
                .location(cam.getLocation())
                .build();

        try {
            Path path = Paths.get(uploadDir += createVideo.getUrl());
            Files.write(path, video.getBytes());
        }catch (IOException e) {
            throw new IllegalStateException("동영상을 저장하지 못했습니다.");
        }

        return videoRepository.save(createVideo);
    }

    @Override
    public Video getVideoByIdx(int idx) {
        return videoRepository.findById(idx).orElseThrow(
                () -> new IllegalStateException("존재하지 않은 동영상입니다.")
        );
    }

    @Override
    public byte[] getVideoFileByIdx(int idx) {
        Video video = getVideoByIdx(idx);

        try {
            ClassPathResource resource = new ClassPathResource(video.getUrl());
            Path path = resource.getFile().toPath();

            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new IllegalStateException("알수없는 오류가 발생하였습니다.");
        }
    }

    @Override
    public List<Video> getVideosByStartTimeBetweenEndTime(LocalDateTime startTime, LocalDateTime endTime) {
        return videoRepository.findAllByStartTimeBetweenEndTime(startTime, endTime);
    }

    @Override
    public Page<Video> getVideosByLocation(Location location, Pageable pageable) {
        return videoRepository.findAllByLocation(location, pageable);
    }

    @Override
    public void deleteVideo(int idx) {
        getVideoByIdx(idx)
                .changeDelete();
    }
}
