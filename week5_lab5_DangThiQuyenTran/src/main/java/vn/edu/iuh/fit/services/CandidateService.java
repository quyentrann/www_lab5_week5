package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.CandidateRepository;

import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateService() {
    }

    public Candidate create(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public Candidate update(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public void delete(long id){
        candidateRepository.deleteById(id);
    }

    public Candidate getByID(long id){
        return candidateRepository.findById(id).get();
    }

    public ResponsePages getAll(Pageable pageable){
        ResponsePages responsePages = new ResponsePages(candidateRepository.findAll(pageable).getTotalPages(), candidateRepository.findAll(pageable).getContent());
        return responsePages;
    }

    public Optional<Candidate> findByEmailAndPhone(String email, String phone){
        return candidateRepository.findByEmailAndPhone(email, phone);
    }
}
