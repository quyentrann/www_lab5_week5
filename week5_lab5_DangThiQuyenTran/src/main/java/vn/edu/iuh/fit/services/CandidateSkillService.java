package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.entityID.CandidateSkillID;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.repositories.AddressRepository;
import vn.edu.iuh.fit.repositories.CandidateSkillRepository;

@Service
public class CandidateSkillService {
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    public CandidateSkill create(CandidateSkill obj){
        return candidateSkillRepository.save(obj);
    }

    public CandidateSkill update(CandidateSkill obj){
        return candidateSkillRepository.save(obj);
    }

    public void delete(CandidateSkillID candidateSkillID){
        candidateSkillRepository.deleteById(candidateSkillID);
    }

    public CandidateSkill getByID(CandidateSkillID candidateSkillID){
        return candidateSkillRepository.findById(candidateSkillID).get();
    }

    public ResponsePages getAll(Pageable pageable){
        ResponsePages responsePages = new ResponsePages(candidateSkillRepository.findAll(pageable).getTotalPages(), candidateSkillRepository.findAll(pageable).getContent());
        return responsePages;
    }
}
