package fr.pierre.medhead.service;

import fr.pierre.medhead.mapper.GroupeSpecialiteMapper;
import fr.pierre.medhead.mapper.HopitalMapper;
import fr.pierre.medhead.model.dto.GroupeSpecialiteDto;
import fr.pierre.medhead.model.dto.HopitalDto;
import fr.pierre.medhead.model.dto.MapPathDto;
import fr.pierre.medhead.model.dto.SpecialiteDto;
import fr.pierre.medhead.mapper.SpecialiteMapper;
import fr.pierre.medhead.model.entity.HopitalEntity;
import fr.pierre.medhead.model.entity.SpecialiteEntity;
import fr.pierre.medhead.repository.GroupeSpecialiteRepository;
import fr.pierre.medhead.repository.HopitalRepository;
import fr.pierre.medhead.repository.SpecialiteRepository;
import fr.pierre.medhead.service.api.SpecialiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultSpecialiteService implements SpecialiteService {

    private final GroupeSpecialiteRepository groupeSpecialiteRepository;
    private final SpecialiteRepository specialiteRepository;
    private final HopitalRepository hopitalRepository;
    private final RestTemplate restTemplate;

    private final String API_KEY = "AIzaSyB86d0Y3Drd6HxhN2aYDI-hnkLf6rw1WmE";
    private final String BASE_PATH = "https://maps.googleapis.com/maps/api/directions/json?";
    private final String PARAMETERS = "origin=%s&mode=driving&destination=%s&key=%s";
    private final String SEPARATOR = ",";

    @Override
    public List<GroupeSpecialiteDto> getAllGroups() {
        return groupeSpecialiteRepository.findAll()
                .stream()
                .map(GroupeSpecialiteMapper::mapGroupeSpecialiteEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SpecialiteDto> findSpecialitesWithGroup(Integer groupeId) {
        Optional<List<SpecialiteEntity>> specialites = specialiteRepository.findByGroupeEntityId(groupeId);
        return specialites
                .map(specialiteEntities -> specialiteEntities
                    .stream()
                    .map(SpecialiteMapper::mapSpecialiteEntityToDto)
                    .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<HopitalDto> findHopitauxWithSpecialite(Integer specialiteId) {
        Optional<List<HopitalEntity>> Hopitaux = hopitalRepository.findBySpecialitesIdOrderByAvailableBedsDesc(specialiteId);
        return Hopitaux
                .map(hopitalEntities -> hopitalEntities
                        .stream()
                        .map(HopitalMapper::mapHopitalEntityToDto)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    @Override
    public String findMapPath(MapPathDto mapPathDto) {
        final String originCoords = mapPathDto.getOrigin().getLatitude() + SEPARATOR + mapPathDto.getOrigin().getLongitude();
        final String targetCoords = mapPathDto.getTarget().getLatitude() + SEPARATOR + mapPathDto.getTarget().getLongitude();
        final String parametersFilled =  String.format(PARAMETERS, originCoords, targetCoords, API_KEY);
        return restTemplate.getForObject(BASE_PATH + parametersFilled, String.class);
    }
}
