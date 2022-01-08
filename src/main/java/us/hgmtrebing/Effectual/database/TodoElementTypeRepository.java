package us.hgmtrebing.Effectual.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.hgmtrebing.Effectual.impl.TodoElementType;

@Repository
public interface TodoElementTypeRepository extends JpaRepository<TodoElementType, Long> {
}
