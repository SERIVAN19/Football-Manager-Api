package com.sergio.football.controller;

import com.sergio.football.dto.CoachCreateDTO;
import com.sergio.football.dto.CoachDTO;
import com.sergio.football.service.CoachService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;

    @PostMapping
    public CoachDTO create(@Valid @RequestBody CoachCreateDTO dto) {
        return coachService.createCoach(dto);
    }

    @GetMapping
    public List<CoachDTO> findAll() {
        return coachService.findAllCoachs();
    }

    @GetMapping("/{id}")
    public CoachDTO findById(@PathVariable Long id) {
        return coachService.findCoachById(id);
    }

    @PutMapping("/{id}")
    public CoachDTO update(@PathVariable Long id,
                           @Valid @RequestBody CoachCreateDTO dto) {
        return coachService.updateCoach(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        coachService.deleteCoach(id);
    }
}
