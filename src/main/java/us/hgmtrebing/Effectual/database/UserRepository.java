package us.hgmtrebing.Effectual.database;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.hgmtrebing.Effectual.impl.UserImpl;

@Repository
public interface UserRepository extends JpaRepository<UserImpl, Long> {
}
