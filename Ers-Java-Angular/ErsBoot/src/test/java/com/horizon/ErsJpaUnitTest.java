package com.horizon;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.horizon.models.ErsReimbursement;
import com.horizon.models.ErsReimbursementStatus;
import com.horizon.models.ErsReimbursementType;
import com.horizon.models.ErsUser;
import com.horizon.repository.ErsReimbursementRepository;
import com.horizon.repository.ErsReimbursementTypeRepository;
import com.horizon.repository.ErsReimbursementStatusRepository;
import com.horizon.repository.ErsUserRepository;

@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ErsJpaUnitTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	ErsReimbursementRepository reimbRepo;
	
	@Autowired
	ErsUserRepository userRepo;
	
	@Autowired
	ErsReimbursementTypeRepository typeRepo;
	
	@Autowired
	ErsReimbursementStatusRepository statusRepo;
	
//	@Test
//	public void should_find_no_reimbursement_if_repository_is_empty() {
//    Iterable<ErsReimbursement> reimbs = reimbRepo.findAll();
//
//    assertThat(reimbs).isEmpty();
//	}
	
//	@Test
//	public void should_store_a_reimbursement() {
//		ErsUser user = userRepo.findById(1);
//		ErsReimbursementType ersType = typeRepo.findById(3).orElse(null);
//		ErsReimbursement newReimb = new ErsReimbursement();
//		newReimb.setReimbAmount(356.15);
//		newReimb.setReimbDescription("description3");
//		newReimb.setReimbReceipt("Hellyes3");
//		newReimb.setReimbAuthor(user);
//		newReimb.setReimbType(ersType);
//	    ErsReimbursement reimb = reimbRepo.save(newReimb);
//	
//	    assertThat(reimb).hasFieldOrPropertyWithValue("reimbAmount", 356.15);
//	    assertThat(reimb).hasFieldOrPropertyWithValue("reimbDescription", "description3");
//	    assertThat(reimb).hasFieldOrPropertyWithValue("reimbReceipt", "Hellyes3");
//	    assertThat(reimb).hasFieldOrPropertyWithValue("reimbAuthor", user);
//	    assertThat(reimb).hasFieldOrPropertyWithValue("reimbType", ersType);
//	    assertThat(reimb).hasFieldOrProperty("reimbSubmitted").isNotNull();
//	    assertThat(reimb).hasFieldOrProperty("reimbSubmitted").isNotNull();
//	    assertThat(reimb).hasFieldOrPropertyWithValue("reimbResolved", null);
//	    assertThat(reimb).hasFieldOrPropertyWithValue("reimbResolver", null);
//		}

//	@Test
//	public void should_find_all_ErsReimbursements() {
//		ErsUser user2 = userRepo.findById(2);
//		ErsReimbursementType ersType2 = typeRepo.findById(4).orElse(null);
//		ErsReimbursement reimb2 = new ErsReimbursement();
//		reimb2.setReimbAmount(222.32);
//		reimb2.setReimbDescription("description2");
//		reimb2.setReimbReceipt("received2");
//		reimb2.setReimbAuthor(user2);
//		reimb2.setReimbType(ersType2);
//		entityManager.persist(reimb2);
//
//		ErsUser user3 = userRepo.findById(1);
//		ErsReimbursementType ersType3 = typeRepo.findById(1).orElse(null);
//		ErsReimbursement reimb3 = new ErsReimbursement();
//		reimb3.setReimbAmount(97.46);
//		reimb3.setReimbDescription("description3");
//		reimb3.setReimbReceipt("received3");
//		reimb3.setReimbAuthor(user3);
//		reimb3.setReimbType(ersType3);
//		entityManager.persist(reimb3);
//
//
//		ErsUser user4 = userRepo.findById(2);
//		ErsReimbursementType ersType4 = typeRepo.findById(3).orElse(null);
//		ErsReimbursement reimb4 = new ErsReimbursement();
//		reimb4.setReimbAmount(150.10);
//		reimb4.setReimbDescription("description4");
//		reimb4.setReimbReceipt("received4");
//		reimb4.setReimbAuthor(user4);
//		reimb4.setReimbType(ersType4);
//		entityManager.persist(reimb4);
//
//		Iterable<ErsReimbursement> reimbs = reimbRepo.findAll();
//
//		assertThat(reimbs).hasSize(3).contains(reimb2, reimb3, reimb4);
//	}

//	@Test
//	public void should_find_reimbursement_by_id() {
//		ErsUser user4 = userRepo.findById(2);
//		ErsReimbursementType ersType4 = typeRepo.findById(3).orElse(null);
//		ErsReimbursement reimb4 = new ErsReimbursement();
//		reimb4.setReimbAmount(150.10);
//		reimb4.setReimbDescription("description4");
//		reimb4.setReimbReceipt("received4");
//		reimb4.setReimbAuthor(user4);
//		reimb4.setReimbType(ersType4);
//		entityManager.persist(reimb4);
//
//		ErsUser user3 = userRepo.findById(1);
//		ErsReimbursementType ersType3 = typeRepo.findById(1).orElse(null);
//		ErsReimbursement reimb3 = new ErsReimbursement();
//		reimb3.setReimbAmount(97.46);
//		reimb3.setReimbDescription("description3");
//		reimb3.setReimbReceipt("received3");
//		reimb3.setReimbAuthor(user3);
//		reimb3.setReimbType(ersType3);
//		entityManager.persist(reimb3);
//
//		ErsReimbursement foundErsReimbursement = reimbRepo.findById(reimb3.getReimbId()).get();
//
//		assertThat(foundErsReimbursement).isEqualTo(reimb3);
//	}

//	@Test
//	public void should_find_pending_reimbursements() {
//		ErsUser user2 = userRepo.findById(2).orElse(null);
//		ErsReimbursementType ersType2 = typeRepo.findById(4).orElse(null);
//		ErsReimbursement reimb2 = new ErsReimbursement();
//		ErsReimbursementStatus ersStatus = statusRepo.findById(1).orElse(null);
//		reimb2.setReimbAmount(222.32);
//		reimb2.setReimbDescription("description2");
//		reimb2.setReimbReceipt("received2");
//		reimb2.setReimbAuthor(user2);
//		reimb2.setReimbType(ersType2);
//		reimb2.setReimbStatus(ersStatus);
//		entityManager.persist(reimb2);
//
//		ErsUser user3 = userRepo.findById(1).orElse(null);
//		ErsReimbursementType ersType3 = typeRepo.findById(1).orElse(null);
//		ErsReimbursement reimb3 = new ErsReimbursement();
//		reimb3.setReimbAmount(97.46);
//		reimb3.setReimbDescription("description3");
//		reimb3.setReimbReceipt("received3");
//		reimb3.setReimbAuthor(user3);
//		reimb3.setReimbType(ersType3);
//		reimb3.setReimbStatus(ersStatus);
//		entityManager.persist(reimb3);
//
//
//		ErsUser user4 = userRepo.findById(2).orElse(null);
//		ErsReimbursementType ersType4 = typeRepo.findById(3).orElse(null);
//		ErsReimbursement reimb4 = new ErsReimbursement();
//		reimb4.setReimbAmount(150.10);
//		reimb4.setReimbDescription("description4");
//		reimb4.setReimbReceipt("received4");
//		reimb4.setReimbAuthor(user4);
//		reimb4.setReimbType(ersType4);
//		reimb4.setReimbStatus(ersStatus);
//		entityManager.persist(reimb4);
//
//		Iterable<ErsReimbursement> reimbs = reimbRepo.findByStatus(ersStatus.getReimbStatus());
//
//		assertThat(reimbs).hasSize(3).contains(reimb2, reimb3, reimb4);
//	}
//
//	@Test
//  	public void should_find_reimbursements_by_title_containing_string() {
//	    ErsReimbursement tut1 = new ErsReimbursement("Spring Boot Tut#1", "Desc#1", true);
//	    entityManager.persist(tut1);
//	
//	    ErsReimbursement tut2 = new ErsReimbursement("Java Tut#2", "Desc#2", false);
//	    entityManager.persist(tut2);
//	
//	    ErsReimbursement tut3 = new ErsReimbursement("Spring Data JPA Tut#3", "Desc#3", true);
//	    entityManager.persist(tut3);
//	
//	    Iterable<ErsReimbursement> reimbs = repository.findByTitleContaining("ring");
//	
//	    assertThat(reimbs).hasSize(2).contains(tut1, tut3);
//	}
//
//	@Test
//	public void should_update_reimbursement_by_id() {
//	    ErsReimbursement tut1 = new ErsReimbursement("Tut#1", "Desc#1", true);
//	    entityManager.persist(tut1);
//
//	    ErsReimbursement tut2 = new ErsReimbursement("Tut#2", "Desc#2", false);
//	    entityManager.persist(tut2);
//
//	    ErsReimbursement updatedTut = new ErsReimbursement("updated Tut#2", "updated Desc#2", true);
//
//	    ErsReimbursement tut = reimbRepo.findById(tut2.getId()).get();
//	    tut.setTitle(updatedTut.getTitle());
//	    tut.setDescription(updatedTut.getDescription());
//	    tut.setPublished(updatedTut.isPublished());
//	    reimbRepo.save(tut);
//
//	    ErsReimbursement checkTut = repository.findById(tut2.getId()).get();
//	    
//	    assertThat(checkTut.getId()).isEqualTo(tut2.getId());
//	    assertThat(checkTut.getTitle()).isEqualTo(updatedTut.getTitle());
//	    assertThat(checkTut.getDescription()).isEqualTo(updatedTut.getDescription());
//	    assertThat(checkTut.isPublished()).isEqualTo(updatedTut.isPublished());
//	  }
//
//	@Test
//	public void should_delete_reimbursement_by_id() {
//	    ErsReimbursement tut1 = new ErsReimbursement("Tut#1", "Desc#1", true);
//	    entityManager.persist(tut1);
//
//	    ErsReimbursement tut2 = new ErsReimbursement("Tut#2", "Desc#2", false);
//	    entityManager.persist(tut2);
//
//	    ErsReimbursement tut3 = new ErsReimbursement("Tut#3", "Desc#3", true);
//	    entityManager.persist(tut3);
//
//	    reimbRepo.deleteById(tut2.getId());
//
//	    Iterable<ErsReimbursement> reimbs = reimbRepo.findAll();
//
//	    assertThat(reimbs).hasSize(2).contains(tut1, tut3);
//	  }
//
//	@Test
//	public void should_delete_all_reimbursements() {
//	    entityManager.persist(new ErsReimbursement("Tut#1", "Desc#1", true));
//	    entityManager.persist(new ErsReimbursement("Tut#2", "Desc#2", false));
//
//	    reimbRepo.deleteAll();
//
//	    assertThat(reimbRepo.findAll()).isEmpty();
//	}

}
