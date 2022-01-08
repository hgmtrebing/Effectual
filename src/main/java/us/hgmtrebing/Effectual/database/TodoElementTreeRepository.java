package us.hgmtrebing.Effectual.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.hgmtrebing.Effectual.impl.TodoElementTree;

@Repository
public interface TodoElementTreeRepository extends JpaRepository<TodoElementTree, Long> {

}
