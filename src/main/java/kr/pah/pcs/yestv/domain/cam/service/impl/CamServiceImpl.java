package kr.pah.pcs.yestv.domain.cam.service.impl;

import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.cam.repository.CamRepository;
import kr.pah.pcs.yestv.domain.cam.service.CamService;
import kr.pah.pcs.yestv.domain.location.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CamServiceImpl implements CamService {

    private final CamRepository camRepository;

    @Override
    public Cam createCam(Cam cam) {
        return camRepository.save(cam);
    }

    @Override
    public Cam getCamByIdx(int idx) {
        return camRepository.findById(idx).orElseThrow(
                () -> new IllegalStateException("존재하지 않은 카메라 입니다.")
        );
    }

    @Override
    public List<Cam> getCamsByLocation(Location location) {
        return camRepository.findAllByLocation(location);
    }

    @Override
    public Cam updateCamBy(Cam cam) {
        return camRepository.save(cam);
    }

    @Override
    public void deleteCam(int idx) {
        camRepository.deleteById(idx);
    }
}
