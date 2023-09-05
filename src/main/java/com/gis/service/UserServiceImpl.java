package com.gis.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.dto.UserDto;
import com.gis.entity.UserEntity;
import com.gis.repo.UserRepository;

@Service
public class UserServiceImpl {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	public String createUser(UserDto userDto) {

		UserEntity entity = new UserEntity();
		modelMapper.map(userDto, entity);
		userRepository.save(entity);
		return "success";
	}

	public UserDto getUserById(Long userId) {
		UserEntity user = userRepository.findById(userId).get();
		UserDto dto = new UserDto();
		modelMapper.map(user, dto);
		return dto;
	}

	public List<UserDto> getAllUsers() {
		List<UserEntity> users = userRepository.findAll();

		List<UserDto> userdto = new ArrayList<>();
		;

		for (UserEntity x : users) {
			UserDto dto = new UserDto();
			modelMapper.map(x, dto);
			userdto.add(dto);

		}
		return userdto;
	}

	public String updateUser(UserDto user) {

		UserEntity existingUser = userRepository.findById(user.getId()).get();

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		UserEntity entity = userRepository.save(existingUser);

		modelMapper.map(entity, entity);
		return "success";
	}

	public void deleteUser(Long userId) {

		userRepository.deleteById(userId);
	}
}
