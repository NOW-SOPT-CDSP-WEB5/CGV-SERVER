package org.sopt.cgv.dto;

import org.sopt.cgv.domain.Advertisement;

import java.util.List;

public record AdsDto(
        List<AdDto> advertisements
){
    public static AdsDto of(List<Advertisement> ads) {
        return new AdsDto(ads.stream()
                .map(ad -> new AdDto(ad.getId(), ad.getUrl()))
                .toList());
    }
}
