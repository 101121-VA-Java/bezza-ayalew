//package com.horizon;
//
//import javax.validation.Valid;
//import javax.validation.ValidationException;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.horizon.controllers.ErsController;
//import com.horizon.dtos.ReimbCreationDto;
//
// 
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class ErsIntegrationTest {
//	
//	@Autowired
//	ErsController ersController;
//	
//	@Test
//	public void testCreate() {
//		@Valid ReimbCreationDto reimb = new ReimbCreationDto();
//		ResponseEntity<String> reimbResult = ersController.registerReimbursementClaim(reimb);
//		Assertions.assertThat(reimbResult).asList();
//	}
//	
//	@Test
//	public void errorHandlingValidationExceptionThrown() {
//		Assertions.assertThatExceptionOfType(ValidationException.class);
//	}
//
//
//}
