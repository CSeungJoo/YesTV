package kr.pah.pcs.yestv.domain.cam.service;

import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.cam.dto.CreateCamDto;
import kr.pah.pcs.yestv.domain.location.domain.Location;

import java.util.List;

public interface CamService {
    Cam createCam(CreateCamDto createCamDto);
    Cam getCamByIdx(int idx);
    List<Cam> getCamsByLocation(Location location);
    Cam updateCamBy(Cam cam);
    void deleteCam(int idx);
    boolean isDelete(Cam cam);
}
