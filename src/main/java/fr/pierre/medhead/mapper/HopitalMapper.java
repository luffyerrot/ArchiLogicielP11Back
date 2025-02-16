package fr.pierre.medhead.mapper;

import fr.pierre.medhead.model.dto.HopitalDto;
import fr.pierre.medhead.model.dto.SpecialiteDto;
import fr.pierre.medhead.model.entity.HopitalEntity;
import fr.pierre.medhead.model.entity.SpecialiteEntity;

public class HopitalMapper {

    public static HopitalDto mapHopitalEntityToDto(HopitalEntity hopitalEntity) {
        return HopitalDto.builder()
                .id(hopitalEntity.getId())
                .adresse(hopitalEntity.getAdresse())
                .available_beds(hopitalEntity.getAvailableBeds())
                .city(hopitalEntity.getCity())
                .email(hopitalEntity.getEmail())
                .latitude(hopitalEntity.getLatitude())
                .longitude(hopitalEntity.getLongitude())
                .name(hopitalEntity.getName())
                .phone(hopitalEntity.getPhone())
                .post_code(hopitalEntity.getPost_code())
                .website(hopitalEntity.getWebsite())
                .build();
    }
}
