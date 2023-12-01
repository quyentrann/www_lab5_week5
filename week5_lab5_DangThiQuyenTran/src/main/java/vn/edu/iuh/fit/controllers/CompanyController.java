package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.models.RequestSkillCandidate;
import vn.edu.iuh.fit.models.ResponseCompany;
import vn.edu.iuh.fit.models.ResponseInfo;
import vn.edu.iuh.fit.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "*")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public boolean create(@RequestBody Company company) {
        return companyService.create(company) != null;
    }

    @PutMapping
    public boolean update(@RequestBody Company company) {
        return companyService.update(company) != null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        companyService.delete(id);
        return true;
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable long id) {
        return companyService.getByID(id);
    }

    @GetMapping("get-page/{page}")
    public ResponseEntity<ResponseCompany> getAll(@PathVariable int page) {
        Pageable pageable = Pageable.ofSize(4).withPage(page);
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAll(pageable));
    }

    @GetMapping("get-info/{id}")
    public ResponseEntity<List<ResponseInfo>> getInfo(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getInfo(id));
    }

    @PostMapping("get-skill-candidate")
    public ResponseEntity<List<ResponseInfo>> getSkillCandidate(@RequestBody RequestSkillCandidate requestSkillCandidate) {
        return ResponseEntity.status(HttpStatus.OK).body(
                companyService.getSkillCandidate(requestSkillCandidate.getCandidateID(), requestSkillCandidate.getCompanyID())
        );
    }
}
