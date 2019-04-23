package com.capgemini.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.beans.AccountFormFields;
import com.capgemini.beans.AccoutDetails;
import com.capgemini.entities.AccountEntity;
import com.capgemini.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public AccoutDetails putNewAccount(AccountFormFields accountFormFields) {
		AccountEntity accountEntity = new AccountEntity();
		converter(accountFormFields, accountEntity);
		return new AccoutDetails((accountRepository.save(accountEntity)).getIdcustomers_account().intValue());
	}
	
	private void converter(AccountFormFields accountFormFields, AccountEntity accountEntity) {
		
		accountEntity.setAccountType(accountFormFields.getAccountType().toString());
		accountEntity.setBalance(accountFormFields.getBalance());
		accountEntity.setDob(accountFormFields.getDob());
		accountEntity.setEmail(accountFormFields.getEmail());
		accountEntity.setFirstName(accountFormFields.getFirstName());
		accountEntity.setHomeAddress(accountFormFields.getHomeAddress());
		accountEntity.setLastName(accountFormFields.getLastName());
		accountEntity.setMailingAddress(accountFormFields.getMailingAddress());
		accountEntity.setMobileNumber(accountFormFields.getMobileNumber());
		accountEntity.setSsn(accountFormFields.getSsn());
		
	}
	
}
