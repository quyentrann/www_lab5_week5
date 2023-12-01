package vn.edu.iuh.fit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Page<Skill> findAll(Pageable pageable);
}
