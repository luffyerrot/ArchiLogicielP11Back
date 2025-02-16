package fr.pierre.medhead.mapper;

import fr.pierre.medhead.model.dto.GroupeSpecialiteDto;
import fr.pierre.medhead.model.entity.GroupeSpecialiteEntity;

public class GroupeSpecialiteMapper {

    public static GroupeSpecialiteDto mapGroupeSpecialiteEntityToDto(GroupeSpecialiteEntity groupeSpecialiteEntity) {
        return GroupeSpecialiteDto.builder()
                .id(groupeSpecialiteEntity.getId())
                .nom(groupeSpecialiteEntity.getNom())
                .build();
    }
}
