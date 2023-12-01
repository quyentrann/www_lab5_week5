package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.entityID.CandidateSkillID;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.models.SkillLevel;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.repositories.CompanyRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;
import vn.edu.iuh.fit.services.CandidateService;
import vn.edu.iuh.fit.services.CandidateSkillService;
import vn.edu.iuh.fit.services.SkillService;

@SpringBootApplication
public class LabWeek05Application {
	public static void main(String[] args) {
		SpringApplication.run(LabWeek05Application.class, args);
	}



}
