package fr.pierre.medhead.mapper;

import fr.pierre.medhead.model.dto.SpecialiteDto;
import fr.pierre.medhead.model.entity.SpecialiteEntity;

public class SpecialiteMapper {

    public static SpecialiteDto mapSpecialiteEntityToDto(SpecialiteEntity specialiteEntity) {
        return SpecialiteDto.builder()
                .id(specialiteEntity.getId())
                .nom(specialiteEntity.getNom())
                .groupe(specialiteEntity.getGroupeEntity().getNom())
                .build();
    }
}
