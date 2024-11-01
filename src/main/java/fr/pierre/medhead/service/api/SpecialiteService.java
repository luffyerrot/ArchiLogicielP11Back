package fr.pierre.medhead.service.api;

import fr.pierre.medhead.dto.SpecialiteDto;

import java.util.List;

public interface SpecialiteService {

    List<SpecialiteDto> findSpecialites();
}
