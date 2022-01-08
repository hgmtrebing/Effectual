package us.hgmtrebing.Effectual.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.hgmtrebing.Effectual.impl.TodoElement;

@Repository
public interface TodoElementRepository extends JpaRepository<TodoElement, Long> {
}
