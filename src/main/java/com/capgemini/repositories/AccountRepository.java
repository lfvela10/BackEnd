package com.capgemini.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.entities.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

	}
