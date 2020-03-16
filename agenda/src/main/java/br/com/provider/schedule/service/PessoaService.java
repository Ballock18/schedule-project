package br.com.provider.schedule.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.provider.schedule.entity.User;
import br.com.provider.schedule.repository.UserRepository;

@Service
public class PessoaService {

	@Autowired
	UserRepository pessoaRepository;

	public List<User> getAll() {
		return pessoaRepository.findAll();
	}

	public Optional<User> getById(Long id) {
		return pessoaRepository.findById(id);
	}

	public User post(User pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public void deleteById(Long id) {
		Optional<User> user = getById(id);
		if (user.isPresent())
			pessoaRepository.deleteById(id);
	}

	public void putById(User user, Long id) {
		Optional<User> optional = pessoaRepository.findById(id);
		if (optional.isPresent()) {
			User userInformation = optional.get();

			userInformation.setName(user.getName());
			userInformation.setAddress(user.getAddress());
			userInformation.setCellphone(user.getCellphone());

			System.out.println(userInformation.getName());
			System.out.println(userInformation.getAddress());
			System.out.println(userInformation.getCellphone());

			pessoaRepository.save(userInformation);
		}
	}

}
