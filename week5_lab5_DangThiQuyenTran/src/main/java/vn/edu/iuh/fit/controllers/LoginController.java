package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.models.RequestLogin;
import vn.edu.iuh.fit.models.ResponseLogin;
import vn.edu.iuh.fit.services.CandidateService;
import vn.edu.iuh.fit.services.CompanyService;

import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public ResponseEntity<ResponseLogin> checkLogin(@RequestBody RequestLogin requestLogin) {
        Optional<?> user = null;

        if ("company".equalsIgnoreCase(requestLogin.getType())) {
            user = companyService.findByEmailAndPhone(requestLogin.getEmail(), requestLogin.getPhone());
        } else {
            user = candidateService.findByEmailAndPhone(requestLogin.getEmail(), requestLogin.getPhone());
        }

        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseLogin("company".equalsIgnoreCase(requestLogin.getType()), true, user.get())
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseLogin(false, false, null)
        );
    }
}
