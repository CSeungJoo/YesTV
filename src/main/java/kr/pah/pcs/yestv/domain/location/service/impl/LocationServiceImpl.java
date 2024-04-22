package kr.pah.pcs.yestv.domain.location.service.impl;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.repository.LocationRepository;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocationByIdx(int idx) {
        return locationRepository.findById(idx).orElseThrow(
                () -> new IllegalStateException("존재하지 않은 장소입니다.")
        );
    }

    @Override
    public Page<Location> getLocations(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(int idx) {
        locationRepository.deleteById(idx);
    }
}
