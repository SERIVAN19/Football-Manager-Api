package com.sergio.football.controller;

import com.sergio.football.dto.AssociationDTO;
import com.sergio.football.dto.CreateAssociationDTO;
import com.sergio.football.service.AssociationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associatios")
@RequiredArgsConstructor
public class AssociationController {

    private final AssociationService associationService;
    //Inyectamos el servicio

    @PostMapping
    public AssociationDTO createAssociation(@Valid @RequestBody CreateAssociationDTO dto){
        return associationService.createAssociation(dto);
    }

    @GetMapping
    public List<AssociationDTO> findAllAssociations(){
        return associationService.findAllAssociations();
    }

    @GetMapping("/{id}")
    public AssociationDTO findById(@PathVariable Long id){
        return associationService.findAssociationById(id);
    }

    @PutMapping("/{id}")
    public AssociationDTO updateAssociation(@PathVariable Long id,
                                            @Valid @RequestBody CreateAssociationDTO dto){
        return associationService.uddateAssociation(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAssociation(@PathVariable Long id){
        associationService.deleteAssociation(id);
    }
}
