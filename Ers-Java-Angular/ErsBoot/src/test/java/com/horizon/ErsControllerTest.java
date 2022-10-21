//package com.horizon;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.horizon.controllers.ErsController;
//import com.horizon.dtos.ReimbursementDto;
//import com.horizon.services.ErsService;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ErsController.class)
//public class ErsControllerTest {
//	
//	@MockBean
//	ErsService es;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	public void testfindAll() throws Exception {
//		ReimbursementDto reimb = new ReimbursementDto();
//		List<ReimbursementDto> reimbs = Arrays.asList(reimb);
//		
//		Mockito.when(es.getAllReimbursement()).thenReturn(reimbs);
//		
//		mockMvc.perform(get("/reimb"))
//		.andExpect(status().isOk())
//		.andExpect(jsonPath("$", Matchers.hasSize(1)))
//		.andExpect(jsonPath("$[0}.description", Matchers.is("desc")));
//	}
//
//}
