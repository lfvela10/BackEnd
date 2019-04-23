package com.capgemini.controllers;



import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.capgemini.beans.AccountFormFields;
import com.capgemini.beans.AccountType;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@MockBean
	private AccountController accountController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void contexLoads() throws Exception {
        assertThat(accountController).isNotNull();
    }
	
	
	    @Test
	    public void putNewAccount() throws Exception {
	        this.mockMvc.perform(get("/getexample")).andExpect(status().isOk());
	    }
	    
	    @Test
	    public void putNewAccountResponceEmpty() throws Exception {
	        this.mockMvc.perform(get("/getexample")).andExpect(status().isOk())
	        	.andExpect(content().string(containsString("")));
	    }
	    
	    @Test
	    public void putNewAccountCustomerDetails() throws Exception {
	    	mockMvc.perform(put("/customerDetails").contentType(MediaType.APPLICATION_JSON)
	    	        .content(getExampleStr()))
	    	        .andExpect(status().isOk());
	    }
	    
	    private String getExampleStr () {
	    	return "{\r\n" + 
	    			"    \"firstName\": \"FirstName\",\r\n" + 
	    			"    \"lastName\": \"lastName\",\r\n" + 
	    			"    \"dob\": \"01-01-2000\",\r\n" + 
	    			"    \"ssn\": \"123-45-6789\",\r\n" + 
	    			"    \"email\": \"email@email.com\",\r\n" + 
	    			"    \"mobileNumber\": \"123456789\",\r\n" + 
	    			"    \"homeAddress\": \"100 homeAddress\",\r\n" + 
	    			"    \"mailingAddress\": \"100 mailingAddress\",\r\n" + 
	    			"    \"accountType\": \"CHECKING\",\r\n" + 
	    			"    \"balance\": 400\r\n" + 
	    			"}";
	    }
	    
	    private AccountFormFields getExample () {
	    		AccountFormFields accountFormFields = new AccountFormFields();
	    		accountFormFields.setAccountType(AccountType.CHECKING);
	    		accountFormFields.setBalance(400.0);
	    		accountFormFields.setDob("01/01/2000");
	    		accountFormFields.setEmail("email@email.com");
	    		accountFormFields.setFirstName("firstName");
	    		accountFormFields.setHomeAddress("100 homeAddress");
	    		accountFormFields.setLastName("lastName");
	    		accountFormFields.setMailingAddress("100 mailingAddress");
	    		accountFormFields.setMobileNumber("123456789");
	    		accountFormFields.setSsn("123-45-6789");
	            return accountFormFields;
	    }

}
