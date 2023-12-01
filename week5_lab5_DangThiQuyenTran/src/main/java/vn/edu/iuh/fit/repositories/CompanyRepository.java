package vn.edu.iuh.fit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Page<Company> findAll(Pageable pageable);

    @Query(
            value = "SELECT c.com_id, js.job_id, js.skill_id, js.skill_level, js.more_infos FROM company AS c INNER JOIN job AS j ON c.com_id = j.company INNER JOIN job_skill AS js ON j.job_id = js.job_id INNER JOIN skill AS s ON js.skill_id = s.skill_id WHERE c.com_id = :companyId",
            nativeQuery = true
    )
    Optional<List<Object[]>> getInfo(@Param("companyId") long companyId);

    Optional<Company> findByEmailAndPhone(String email, String phone);

    @Query(
            value = "SELECT co.com_id, js.job_id, js.skill_id, js.skill_level, js.more_infos FROM candidate AS c INNER JOIN candidate_skill AS cs ON c.can_id = cs.can_id\n" +
                    "INNER JOIN job_skill AS js ON cs.skill_id = js.skill_id AND cs.skill_level = js.skill_level\n" +
                    "INNER JOIN job AS j ON j.job_id = js.job_id\n" +
                    "INNER JOIN company AS co ON co.com_id = j.company\n" +
                    "WHERE c.can_id = :candidateId AND co.com_id = :companyId",
            nativeQuery = true
    )
    Optional<List<Object[]>> getSkillCandidate(@Param("candidateId") long candidateId, @Param("companyId") long companyId);
}
