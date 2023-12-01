package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.entityID.CandidateSkillID;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.services.CandidateSkillService;

@RestController
@RequestMapping("/candidate-skill")
@CrossOrigin(origins = "*")
public class CandidateSkillController {
    @Autowired
    private CandidateSkillService candidateSkillService;

    @PostMapping
    public boolean create(@RequestBody CandidateSkill candidateSkill) {
        return candidateSkillService.create(candidateSkill) != null;
    }

    @PutMapping
    public boolean update(@RequestBody CandidateSkill candidateSkill) {
        return candidateSkillService.update(candidateSkill) != null;
    }

    @DeleteMapping
    public boolean delete(@RequestBody CandidateSkillID candidateSkillID) {
        candidateSkillService.delete(candidateSkillID);
        return true;
    }

    @GetMapping
    public CandidateSkill getById(@RequestParam long candidate, @RequestParam long skill) {
        CandidateSkillID candidateSkillID = new CandidateSkillID(candidate, skill);
        return candidateSkillService.getByID(candidateSkillID);
    }

    @GetMapping("get-page/{page}")
    public ResponseEntity<ResponsePages> getAll(@PathVariable int page) {
        Pageable pageable = Pageable.ofSize(4).withPage(page);
        return ResponseEntity.status(HttpStatus.OK).body(candidateSkillService.getAll(pageable));
    }
}
