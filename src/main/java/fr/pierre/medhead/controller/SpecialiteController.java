package fr.pierre.medhead.controller;

import fr.pierre.medhead.model.dto.GroupeSpecialiteDto;
import fr.pierre.medhead.model.dto.HopitalDto;
import fr.pierre.medhead.model.dto.MapPathDto;
import fr.pierre.medhead.model.dto.SpecialiteDto;
import fr.pierre.medhead.service.api.SpecialiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api")
public class SpecialiteController {

    private final SpecialiteService specialiteService;

    @GetMapping("/groupes")
    public ResponseEntity<List<GroupeSpecialiteDto>> getAllGroups() {
        return ResponseEntity.ok(specialiteService.getAllGroups());
    }

    @GetMapping("/specialites")
    public ResponseEntity<List<SpecialiteDto>> findSpecialitesWithGroup(@RequestParam("id") Integer groupeId) {
        return ResponseEntity.ok(specialiteService.findSpecialitesWithGroup(groupeId));
    }

    @GetMapping("/hopitaux")
    public ResponseEntity<List<HopitalDto>> findHopitauxWithSpecialite(@RequestParam("id") Integer specialiteId) {
        return ResponseEntity.ok(specialiteService.findHopitauxWithSpecialite(specialiteId));
    }

    @PutMapping("/path")
    public ResponseEntity<String> findMapPath(@RequestBody MapPathDto mapPathDto) {
        return ResponseEntity.ok(specialiteService.findMapPath(mapPathDto));
    }
}
