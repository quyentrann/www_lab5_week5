package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.*;
import vn.edu.iuh.fit.repositories.CompanyRepository;
import vn.edu.iuh.fit.repositories.JobRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;

    public Company create(Company company){
        return companyRepository.save(company);
    }

    public Company update(Company company){
        return companyRepository.save(company);
    }

    public void delete(long id){
        companyRepository.deleteById(id);
    }

    public Company getByID(long id){
        return companyRepository.findById(id).get();
    }

    public ResponseCompany getAll(Pageable pageable){
        ResponseCompany responseCompany = new ResponseCompany(companyRepository.findAll(pageable).getTotalPages(), companyRepository.findAll(pageable).getContent());
        return responseCompany;
    }

    public Optional<Company> findByEmailAndPhone(String email, String phone){
        return companyRepository.findByEmailAndPhone(email, phone);
    }


}
