package com.sbrestapi.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrestapi.configuration.ProfileTypes;
import com.sbrestapi.model.Address;

/**
* <h1>AddressControllerTest for Address!</h1>
* It is used test AddressController API.
* 
* @author  Yugandhara Reddy Kuraakula 
* @version 1.0
* @since   2021-02-07
*/

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(ProfileTypes.NO_AUTH)
public class AddressControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	private ObjectMapper objectMapper;
	
	@Test
	void saveAddress() throws Exception {
		Address address = new Address();
		address.setPostCode("101"); 
		address.setSuburb("S1");
		mockMvc.perform(MockMvcRequestBuilders.post("/address/saveAddress")
											  .contentType(MediaType.APPLICATION_JSON)
											  .accept(MediaType.APPLICATION_JSON)
											  .content(objectMapper.writeValueAsString(address))
					    )
				.andExpect(status().isOk()).andExpect(content().string(equalTo("Address saved successfully.")));
	}
	
	@Test
	void getPostCodeBySuburb() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/address/getPostCodeBySuburb/S1")
											  .contentType(MediaType.APPLICATION_JSON)
											  .accept(MediaType.APPLICATION_JSON)
					    )
				.andExpect(status().isOk());
	}

	@Test
	void getSuburbByPostCode() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/address/getSuburbByPostCode/1001")
											  .contentType(MediaType.APPLICATION_JSON)
											  .accept(MediaType.APPLICATION_JSON)
					    )
				.andExpect(status().isOk());
	}
	
}
