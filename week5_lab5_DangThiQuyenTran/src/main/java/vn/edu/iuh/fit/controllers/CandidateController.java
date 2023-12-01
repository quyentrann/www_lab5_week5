package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.services.CandidateService;

@RestController
@RequestMapping("/candidate")
@CrossOrigin(origins = "*")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public boolean create(@RequestBody Candidate candidate) {
        return candidateService.create(candidate) != null;
    }

    @PutMapping
    public boolean update(@RequestBody Candidate candidate) {
        return candidateService.update(candidate) != null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        candidateService.delete(id);
        return true;
    }

    @GetMapping("/{id}")
    public Candidate getById(@PathVariable long id) {
        return candidateService.getByID(id);
    }

    @GetMapping("get-page/{page}")
    public ResponseEntity<ResponsePages> getAll(@PathVariable int page) {
        return ResponseEntity.status(HttpStatus.OK).body(candidateService.getAll(Pageable.ofSize(4).withPage(page)));
    }
}
