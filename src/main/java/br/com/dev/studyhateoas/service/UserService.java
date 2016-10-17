package br.com.dev.studyhateoas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.studyhateoas.model.User;
import br.com.dev.studyhateoas.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userrepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	

	/**
	 * @author Lucas Isabel
	 * @return This method returns a list of users registered in database
	 */
	public List<User> listallUsers(){
		return userrepository.findAll();
	}
	
	/**
	 * @author Lucas Isabel
	 * @param user
	 * @return This method returns the current user created
	 */
	public User saveUser(User user){
		return userrepository.save(user);
	}
	
}
