package org.sopt.cgv.service;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.dto.AdsDto;
import org.sopt.cgv.repository.AdvertisementRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    public AdsDto getAds() {
        return AdsDto.of(advertisementRepository.findAll());
    }
}
