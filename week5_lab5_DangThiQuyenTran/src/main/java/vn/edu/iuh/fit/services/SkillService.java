package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.AddressRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public Skill create(Skill skill){
        return skillRepository.save(skill);
    }

    public Skill update(Skill skill){
        return skillRepository.save(skill);
    }

    public void delete(long id){
        skillRepository.deleteById(id);
    }

    public Skill getByID(long id){
        return skillRepository.findById(id).get();
    }

    public ResponsePages getAll(Pageable pageable){
        ResponsePages responsePages = new ResponsePages(skillRepository.findAll(pageable).getTotalPages(), skillRepository.findAll(pageable).getContent());
        return responsePages;
    }
}
