package com.horizon.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.horizon.Horizon2Application;
import com.horizon.dtos.Mapper;
import com.horizon.dtos.ReimbCreationDto;
import com.horizon.models.ErsReimbursement;

@SpringBootTest(classes = Horizon2Application.class)
public class ReimbursementRepositoryTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    EntityManager entityManager;
	
	@Autowired
	Mapper mapper;
	
	@Test
    public void findById() {
        ErsReimbursement reimb = entityManager.find(ErsReimbursement.class, 1);
        assertEquals(1, reimb.getReimbId());
    }
	
	@Test
	@Transactional
	public void insertTest() throws ParseException {
		ReimbCreationDto newReimb = new ReimbCreationDto(0,320.50,"test Description", "test Receipt",1,"","",0,1,1);
		ErsReimbursement createdReimb = mapper.toReimbursement(newReimb);
		entityManager.persist(createdReimb);
		assertNotNull(createdReimb.getReimbId());
	}

	@Test
	@Transactional
	public void updateTest() {
		ErsReimbursement reimbToUpdate = entityManager.find(ErsReimbursement.class,5);
		reimbToUpdate.setReimbAmount(200.20);
		entityManager.merge(reimbToUpdate);

		ErsReimbursement reimbUpdated = entityManager.find(ErsReimbursement.class,5);
		assertEquals(200.20, reimbUpdated.getReimbAmount());
	}

}
