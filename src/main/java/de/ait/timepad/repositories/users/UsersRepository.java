package de.ait.timepad.repositories.users;

import de.ait.timepad.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<User, Long> {
}
