package br.com.dev.studyhateoas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.dev.studyhateoas.dto.MessageRequestError;
import br.com.dev.studyhateoas.model.User;
import br.com.dev.studyhateoas.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController extends ControllerLinkBuilderFactory{

	@Autowired
	private UserService userservice;

	@ResponseBody
	@GetMapping(value = "/show/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity allUsers() {
		List<User> userList = userservice.listallUsers();
		
		userList.forEach(data -> {
			data.add(linkTo(UserController.class).slash(data.getName()).slash("email").slash(data.getEmail()).withSelfRel());
			data.add(linkTo(UserController.class).slash(data.getCodigo()).slash("name").slash(data.getName()).withSelfRel());
		});
		
		if(userList.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageRequestError("Nenhum resultado encontrado"));	
		}else{
			return ResponseEntity.status(HttpStatus.OK).body(userList);
		}
	}

	@ResponseBody
	@PostMapping(value = "/register/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveUser(User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.saveUser(user));
	}


}
