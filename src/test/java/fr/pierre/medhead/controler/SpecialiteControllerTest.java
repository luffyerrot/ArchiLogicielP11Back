package fr.pierre.medhead.controler;

import fr.pierre.medhead.controller.SpecialiteController;
import fr.pierre.medhead.model.dto.*;
import fr.pierre.medhead.service.api.SpecialiteService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SpecialiteControllerTest {

    @Mock
    private SpecialiteService specialiteService;
    @InjectMocks
    private SpecialiteController specialiteController;

    @Test
    public void getAllGroups_expectToBeOk_ReturnList() {
        // Given
        final GroupeSpecialiteDto groupeSpecialite = GroupeSpecialiteDto.builder()
                .id(1)
                .nom("group")
                .build();
        final List<GroupeSpecialiteDto> list = Collections.singletonList(groupeSpecialite);
        Mockito
                .when(specialiteService.getAllGroups())
                .thenReturn(list);

        // When
        ResponseEntity<List<GroupeSpecialiteDto>> response = specialiteController.getAllGroups();

        // Then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(Boolean.FALSE, response.getBody().isEmpty());
        Assertions.assertEquals(1, response.getBody().size());
        Assertions.assertEquals(1, response.getBody().get(0).getId());
        Assertions.assertEquals("group", response.getBody().get(0).getNom());
    }

    @Test
    public void findSpecialitesWithGroup_expectToBeOk_ReturnList() {
        // Given
        final SpecialiteDto specialite = SpecialiteDto.builder()
                .id(1)
                .nom("specialite")
                .groupe("group")
                .build();
        final List<SpecialiteDto> list = Collections.singletonList(specialite);
        Mockito
                .when(specialiteService.findSpecialitesWithGroup(Mockito.anyInt()))
                .thenReturn(list);

        // When
        ResponseEntity<List<SpecialiteDto>> response = specialiteController.findSpecialitesWithGroup(1);

        // Then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(Boolean.FALSE, response.getBody().isEmpty());
        Assertions.assertEquals(1, response.getBody().size());
        Assertions.assertEquals(1, response.getBody().get(0).getId());
        Assertions.assertEquals("specialite", response.getBody().get(0).getNom());
        Assertions.assertEquals("group", response.getBody().get(0).getGroupe());
    }

    @Test
    public void findHopitauxWithSpecialite_expectToBeOk_ReturnList() {
        // Given
        final HopitalDto hopital = HopitalDto.builder()
                .id(1)
                .website("website.fr")
                .post_code("42478")
                .phone("0202020202")
                .name("hopital")
                .email("hopital@test.fr")
                .city("city")
                .longitude(0.1f)
                .latitude(0.1f)
                .available_beds(8)
                .adresse("adresse")
                .build();
        final List<HopitalDto> list = Collections.singletonList(hopital);
        Mockito
                .when(specialiteService.findHopitauxWithSpecialite(Mockito.anyInt()))
                .thenReturn(list);

        // When
        ResponseEntity<List<HopitalDto>> response = specialiteController.findHopitauxWithSpecialite(1);

        // Then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(Boolean.FALSE, response.getBody().isEmpty());
        Assertions.assertEquals(1, response.getBody().size());
        Assertions.assertEquals(1, response.getBody().get(0).getId());
        Assertions.assertEquals("hopital", response.getBody().get(0).getName());
        Assertions.assertEquals(0.1f, response.getBody().get(0).getLatitude());
        Assertions.assertEquals(0.1f, response.getBody().get(0).getLongitude());
        Assertions.assertEquals(8, response.getBody().get(0).getAvailable_beds());
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
                .when(specialiteService.findMapPath(Mockito.eq(mapPathDto)))
                .thenReturn(RESULT);

        // When
        ResponseEntity<String> response = specialiteController.findMapPath(mapPathDto);

        // Then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(RESULT, response.getBody());
    }
}
