package me.aboullaite.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.aboullaite.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	User save(User user);

	User findByEmail(String email);
}
