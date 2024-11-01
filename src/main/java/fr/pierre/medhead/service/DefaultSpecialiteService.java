package fr.pierre.medhead.service;

import fr.pierre.medhead.dto.SpecialiteDto;
import fr.pierre.medhead.mapper.SpecialiteMapping;
import fr.pierre.medhead.repository.SpecialiteRepository;
import fr.pierre.medhead.service.api.SpecialiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultSpecialiteService implements SpecialiteService {

    private final SpecialiteRepository specialiteRepository;

    @Override
    public List<SpecialiteDto> findSpecialites() {
        return specialiteRepository
                .findAll()
                .stream()
                .map(SpecialiteMapping::mapSpecialiteEntityToDto)
                .collect(Collectors.toList());
    }
}
