package kr.pah.pcs.yestv.domain.cam.service;

import kr.pah.pcs.yestv.domain.cam.domain.Cam;
import kr.pah.pcs.yestv.domain.location.domain.Location;

import java.util.List;

public interface CamService {
    Cam createCam(Cam cam);
    Cam getCamByIdx(int idx);
    List<Cam> getCamsByLocation(Location location);
    Cam updateCamBy(Cam cam);
    void deleteCam(int idx);
}
