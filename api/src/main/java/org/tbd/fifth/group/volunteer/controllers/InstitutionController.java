package org.tbd.fifth.group.volunteer.controllers;

import org.springframework.web.bind.annotation.*;
import org.tbd.fifth.group.volunteer.services.InstitutionService;
import org.tbd.fifth.group.volunteer.models.InstitutionModel;

@RestController
@CrossOrigin
public class InstitutionController {

    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @PostMapping("/institution")
    @ResponseBody
    public InstitutionModel createInstitution(@RequestBody InstitutionModel institution) {
        return institutionService.createInstitution(institution);
    }

    @GetMapping("/institution/{institution_id}")
    @ResponseBody
    public InstitutionModel getInstitution(@PathVariable int institution_id) {
        return institutionService.getInstitution(institution_id);
    }

}
