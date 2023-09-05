package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.UserEntity;

public interface UserRepository  extends JpaRepository<UserEntity, Long>{

}
