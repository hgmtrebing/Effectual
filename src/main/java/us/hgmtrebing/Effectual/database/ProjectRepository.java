package us.hgmtrebing.Effectual.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.hgmtrebing.Effectual.impl.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
