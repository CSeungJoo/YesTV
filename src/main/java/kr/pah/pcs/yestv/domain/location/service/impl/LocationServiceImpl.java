package kr.pah.pcs.yestv.domain.location.service.impl;

import kr.pah.pcs.yestv.domain.location.domain.Location;
import kr.pah.pcs.yestv.domain.location.dto.CreateLocationDto;
import kr.pah.pcs.yestv.domain.location.repository.LocationRepository;
import kr.pah.pcs.yestv.domain.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public Location createLocation(CreateLocationDto createLocationDto) {
        Location location = Location.builder()
                .name(createLocationDto.getName())
                .build();

        return locationRepository.save(location);
    }

    @Override
    public Location getLocationByIdx(int idx) {
        Location location = locationRepository.findById(idx).orElseThrow(
                () -> new IllegalStateException("존재하지 않은 장소입니다.")
        );

        if (!location.isDelete())
            return location;

        throw new IllegalStateException("존재하지 않은 장소입니다.");
    }

    @Override
    public Page<Location> getLocations(Pageable pageable) {
        return locationRepository.findLocationsByDeleteIsFalse(pageable);
    }

    @Override
    @Transactional
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    @Transactional
    public void deleteLocation(int idx) {
        getLocationByIdx(idx).changeDelete();
    }
}
