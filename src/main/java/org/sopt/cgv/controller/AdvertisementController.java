package org.sopt.cgv.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.cgv.dto.AdsDto;
import org.sopt.cgv.service.AdvertisementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping("/advertisements")
    public ResponseEntity<AdsDto> getAdvertisements() {
        return ResponseEntity.ok(advertisementService.getAds());
    }
}
