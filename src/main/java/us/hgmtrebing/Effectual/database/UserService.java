package us.hgmtrebing.Effectual.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.hgmtrebing.Effectual.impl.UserImpl;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<UserImpl> list() {
    return userRepository.findAll();
  }
}
