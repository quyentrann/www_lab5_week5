package vn.edu.iuh.fit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entityID.CandidateSkillID;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.CandidateSkill;

@Repository
@EnableJpaRepositories
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillID> {
    Page<CandidateSkill> findAll(Pageable pageable);
}
