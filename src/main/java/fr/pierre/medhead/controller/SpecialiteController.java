package fr.pierre.medhead.controller;

import fr.pierre.medhead.dto.SpecialiteDto;
import fr.pierre.medhead.service.api.SpecialiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SpecialiteController {

    private final SpecialiteService specialiteService;

    @GetMapping("/api/specialite")
    public ResponseEntity<List<SpecialiteDto>> getTest() {
        return ResponseEntity.ok(specialiteService.findSpecialites());
    }
}
