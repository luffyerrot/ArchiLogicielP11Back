package fr.pierre.medhead.service.api;

import fr.pierre.medhead.model.dto.GroupeSpecialiteDto;
import fr.pierre.medhead.model.dto.HopitalDto;
import fr.pierre.medhead.model.dto.MapPathDto;
import fr.pierre.medhead.model.dto.SpecialiteDto;

import java.util.List;

public interface SpecialiteService {

    List<GroupeSpecialiteDto> getAllGroups();

    List<SpecialiteDto> findSpecialitesWithGroup(Integer groupeId);

    List<HopitalDto> findHopitauxWithSpecialite(Integer specialiteId);

    String findMapPath(MapPathDto mapPathDto);
}
