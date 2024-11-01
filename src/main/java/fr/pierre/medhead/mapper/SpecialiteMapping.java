package fr.pierre.medhead.mapper;

import fr.pierre.medhead.dto.SpecialiteDto;
import fr.pierre.medhead.entity.SpecialiteEntity;

public class SpecialiteMapping {

    public static SpecialiteDto mapSpecialiteEntityToDto(SpecialiteEntity specialiteEntity) {
        return SpecialiteDto.builder()
                .id(specialiteEntity.getId())
                .nom(specialiteEntity.getNom())
                .groupe(specialiteEntity.getGroupeEntity().getNom())
                .build();
    }
}
