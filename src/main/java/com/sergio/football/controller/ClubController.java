package com.sergio.football.controller;

import com.sergio.football.dto.ClubCreateDTO;
import com.sergio.football.dto.ClubDTO;
import com.sergio.football.service.ClubService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    // ✅ CREATE
    @PostMapping
    public ClubDTO createClub(@Valid @RequestBody ClubCreateDTO dto) {
        return clubService.createClub(dto);
    }

    // ✅ GET ALL
    @GetMapping
    public List<ClubDTO> getAllClubs() {
        return clubService.findAllClubs();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public ClubDTO getClubById(@PathVariable Long id) {
        return clubService.findClubById(id);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ClubDTO updateClub(@PathVariable Long id,
                              @Valid @RequestBody ClubCreateDTO dto) {
        return clubService.updateClub(id, dto);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable Long id) {
        clubService.deleteClub(id);
    }
}