package us.hgmtrebing.Effectual.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.hgmtrebing.Effectual.impl.TodoElementStatus;

@Repository
public interface TodoElementStatusRepository extends JpaRepository<TodoElementStatus, Long> {
}
