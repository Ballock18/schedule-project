package br.com.provider.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.provider.schedule.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
