package com.capgemini.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.AccountFormFields;
import com.capgemini.beans.AccountType;
import com.capgemini.beans.AccoutDetails;
import com.capgemini.beans.TokenCorrect;
import com.capgemini.beans.TokenValidationEntity;
import com.capgemini.entities.AccountEntity;
import com.capgemini.exception.AccountValidationException;
import com.capgemini.repositories.AccountRepository;
import com.capgemini.services.AccountService;
import com.capgemini.services.AccountValidation;

@RestController
public class AccountController {

	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountValidation accountValidation;
	
	@Autowired
	private AccountService accountService;
	
	//for security purpose we have to add Authorization (SSO) to the header
	
	@GetMapping("/getexample")
    public ResponseEntity<AccountFormFields> getExample() {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Access-Control-Allow-Origin","*");
		
		AccountFormFields accountFormFields = new AccountFormFields();
		accountFormFields.setAccountType(AccountType.CHECKING);
		accountFormFields.setBalance(400.0);
		accountFormFields.setDob("01/01/2000");
		accountFormFields.setEmail("falko@email.com");
		accountFormFields.setFirstName("firstName");
		accountFormFields.setHomeAddress("100 homeAddress");
		accountFormFields.setLastName("lastName");
		accountFormFields.setMailingAddress("100 mailingAddress");
		accountFormFields.setMobileNumber("123456789");
		accountFormFields.setSsn("123-45-6789");
		
        return new ResponseEntity<>(
        	      accountFormFields, headers, HttpStatus.OK);
    }
    
	@PutMapping("/customerDetails")
	public AccoutDetails putNewAccount(@RequestBody AccountFormFields accountFormFields) {
		try {
			accountValidation.accountFormFieldsValidate(accountFormFields);
		} catch (AccountValidationException e) {
			System.err.println(e.getMessage());
			log.error(e.getMessage());
			System.out.println(accountFormFields);
			return new AccoutDetails(0);
		}
		
		return accountService.putNewAccount(accountFormFields);
		
	}
	
	@PostMapping("/save")
	public AccoutDetails save(@RequestBody AccountFormFields fields) {
		try {
			accountValidation.accountFormFieldsValidate(fields);
		}catch(AccountValidationException e) {
			System.err.println(e.getMessage());
			log.error(e.getMessage());
			System.out.println(fields);
			return new AccoutDetails(0);
		}
		return accountService.saveNewAccount(fields);
	}
	
//	@GetMapping("/sendlogin/{username}/{password}")
//	public ResponseEntity<String> sendLogin(@PathVariable String username, @PathVariable String password) {
//		if(!accountService.getLogin(username, password)) {
//			return null;
//		}else {
//			HttpHeaders headers = new HttpHeaders();
//			return new ResponseEntity<>("123", headers, HttpStatus.OK);
//		}
//	}
	
	@GetMapping("/providetoken")
	public ResponseEntity<TokenValidationEntity> sendToken(){
		TokenValidationEntity tokenValidationEntity = new TokenValidationEntity();
		tokenValidationEntity.setToken("123");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", tokenValidationEntity.getToken());
		
		return new ResponseEntity<>(tokenValidationEntity, headers, HttpStatus.OK);
	}
	
	@PostMapping("/checktoken")
	public TokenCorrect checkToken(@RequestBody TokenValidationEntity token){
		TokenCorrect tokenCorrect = new TokenCorrect();
		if(validateToken(token) == 0) {
			tokenCorrect.setTokenCorrect("0");
			return tokenCorrect;
		}
		return tokenCorrect;
	}
	
	public int validateToken(TokenValidationEntity token) {
		if(accountService.validateToken(token.getToken()))
			return 0;
		return 1;
	}
	
}
