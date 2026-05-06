package com.sergio.football.controller;

import com.sergio.football.dto.CompetitionCreateDTO;
import com.sergio.football.dto.CompetitionDTO;
import com.sergio.football.service.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;
    //Inyeccion de dependecia del service
    //public CompetitionController(CompetitionService competitionService){
    //    this.competitionService = competitionService;
    //}

    //Create
    @PostMapping
    public CompetitionDTO createCompetition(@Valid @RequestBody CompetitionCreateDTO dto){
        return competitionService.createCompetition(dto);
    }

    //Get all competitions
    @GetMapping
    public List<CompetitionDTO> getCompetitions(){
        return competitionService.findAllCompetitions();
    }

    //Get competition by id
    @GetMapping("/{id}")
    public CompetitionDTO getCompetitionById(@PathVariable Long id){
        return competitionService.findCompetitionById(id);
    }

    //Update competition
    @PutMapping("/{id}")
    public CompetitionDTO updateCompetition(@PathVariable Long id, @Valid @RequestBody CompetitionCreateDTO dto){
        return competitionService.updateCompetition(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompetition(@PathVariable Long id){
        competitionService.deleteCompetition(id);
    }

}





















