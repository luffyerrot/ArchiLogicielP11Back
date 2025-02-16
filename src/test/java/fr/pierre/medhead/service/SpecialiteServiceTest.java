package fr.pierre.medhead.service;

import fr.pierre.medhead.model.dto.*;
import fr.pierre.medhead.model.entity.GroupeSpecialiteEntity;
import fr.pierre.medhead.model.entity.HopitalEntity;
import fr.pierre.medhead.model.entity.SpecialiteEntity;
import fr.pierre.medhead.repository.GroupeSpecialiteRepository;
import fr.pierre.medhead.repository.HopitalRepository;
import fr.pierre.medhead.repository.SpecialiteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SpecialiteServiceTest {

    @Mock
    private GroupeSpecialiteRepository groupeSpecialiteRepository;
    @Mock
    private SpecialiteRepository specialiteRepository;
    @Mock
    private HopitalRepository hopitalRepository;
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private DefaultSpecialiteService specialiteService;

    @Test
    public void getAllGroups_expectToBeOk_ReturnList() {
        // Given
        final GroupeSpecialiteEntity groupeSpecialite = new GroupeSpecialiteEntity();
        groupeSpecialite.setId(1);
        groupeSpecialite.setNom("group");
        final List<GroupeSpecialiteEntity> list = Collections.singletonList(groupeSpecialite);
        Mockito
                .when(groupeSpecialiteRepository.findAll())
                .thenReturn(list);

        // When
        List<GroupeSpecialiteDto> response = specialiteService.getAllGroups();

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(Boolean.FALSE, response.isEmpty());
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(1, response.get(0).getId());
        Assertions.assertEquals("group", response.get(0).getNom());
    }

    @Test
    public void findSpecialitesWithGroup_expectToBeOk_ReturnList() {
        // Given
        final GroupeSpecialiteEntity groupeSpecialite = new GroupeSpecialiteEntity();
        groupeSpecialite.setId(1);
        groupeSpecialite.setNom("group");
        final SpecialiteEntity specialite = new SpecialiteEntity();
        specialite.setId(1);
        specialite.setNom("specialite");
        specialite.setGroupeEntity(groupeSpecialite);
        final List<SpecialiteEntity> list = Collections.singletonList(specialite);
        Mockito
                .when(specialiteRepository.findByGroupeEntityId(Mockito.anyInt()))
                .thenReturn(Optional.of(list));

        // When
        List<SpecialiteDto> response = specialiteService.findSpecialitesWithGroup(1);

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(Boolean.FALSE, response.isEmpty());
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(1, response.get(0).getId());
        Assertions.assertEquals("specialite", response.get(0).getNom());
        Assertions.assertEquals("group", response.get(0).getGroupe());
    }

    @Test
    public void findHopitauxWithSpecialite_expectToBeOk_ReturnList() {
        // Given
        final HopitalEntity hopital = new HopitalEntity();
        hopital.setId(1);
        hopital.setWebsite("website.fr");
        hopital.setPost_code("42478");
        hopital.setPhone("0202020202");
        hopital.setName("hopital");
        hopital.setEmail("hopital@test.fr");
        hopital.setCity("city");
        hopital.setLongitude(0.1f);
        hopital.setLatitude(0.1f);
        hopital.setAvailableBeds(8);
        hopital.setAdresse("adresse");
        final List<HopitalEntity> list = Collections.singletonList(hopital);
        Mockito
                .when(hopitalRepository.findBySpecialitesIdOrderByAvailableBedsDesc(Mockito.anyInt()))
                .thenReturn(Optional.of(list));

        // When
        List<HopitalDto> response = specialiteService.findHopitauxWithSpecialite(1);

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(Boolean.FALSE, response.isEmpty());
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(1, response.get(0).getId());
        Assertions.assertEquals("hopital", response.get(0).getName());
        Assertions.assertEquals(0.1f, response.get(0).getLatitude());
        Assertions.assertEquals(0.1f, response.get(0).getLongitude());
        Assertions.assertEquals(8, response.get(0).getAvailable_beds());
    }

    @Test
    public void findMapPath_expectToBeOk_ReturnString() {
        // Given
        final String RESULT = "Retour api ok";
        final MapPathDto mapPathDto = MapPathDto.builder()
                .origin(PointDto.builder().latitude(0.4f).latitude(0.2f).build())
                .target(PointDto.builder().latitude(2.4f).latitude(2.2f).build())
                .build();
        Mockito
                .when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(String.class)))
                .thenReturn(RESULT);

        // When
        String response = specialiteService.findMapPath(mapPathDto);

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(RESULT, response);
    }
}
