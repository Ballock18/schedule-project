package br.com.provider.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provider.schedule.entity.User;
import br.com.provider.schedule.service.PessoaService;

@RestController
@RequestMapping("/v1")
public class ContactsController {

	@Autowired
	private PessoaService service;

	@GetMapping("/contacts")
	public ResponseEntity getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/contacts/{id}")
	public ResponseEntity getById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PostMapping("/new-contact")
	public ResponseEntity post(@RequestBody User pessoa) {
		User p = service.post(pessoa);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/edit-contact/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody User user) {
		service.putById(user, id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
