package kr.pah.pcs.yestv.domain.cam.service.impl;

import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.cam.dto.CreateCamDto;
import kr.pah.pcs.yestv.domain.cam.repository.CamRepository;
import kr.pah.pcs.yestv.domain.cam.service.CamService;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CamServiceImpl implements CamService {

    private final CamRepository camRepository;
    private final LocationService locationService;

    @Override
    @Transactional
    public Cam createCam(CreateCamDto createCamDto) {

        Cam cam = Cam.builder()
                .name(createCamDto.getName())
                .ip(createCamDto.getIp())
                .detailedLocation(createCamDto.getDetailedLocation())
                .location(locationService.getLocationByIdx(createCamDto.getLocationId()))
                .build();

        return camRepository.save(cam);
    }

    @Override
    public Cam getCamByIdx(int idx) {
        Cam cam = camRepository.findById(idx).orElseThrow(
                () -> new IllegalStateException("존재하지 않은 카메라 입니다.")
        );

        if (!isDelete(cam))
            return cam;

        throw new IllegalStateException("존재하지 않은 카메라 입니다.");
    }

    @Override
    public List<Cam> getCamsByLocation(Location location) {
        return camRepository.findAllByLocation(location).stream()
                .filter(Predicate.not(this::isDelete))
                .toList();
    }

    @Override
    @Transactional
    public Cam updateCamBy(Cam cam) {
        return camRepository.save(cam);
    }

    @Override
    @Transactional
    public void deleteCam(int idx) {
        getCamByIdx(idx).changeDeleteStatus();
    }

    @Override
    public boolean isDelete(Cam cam) {
        return cam.isDelete();
    }
}
