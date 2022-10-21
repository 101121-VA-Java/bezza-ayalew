//package com.horizon;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.RestTemplate;
//
//import com.horizon.models.ErsUser;
// 
// 
//public class ErsSystemTest {
// 
//    @Test
//    public void testCreateReadDelete() {
//        RestTemplate restTemplate = new RestTemplate();
// 
//        String url = "http://localhost:8080/user";
// 
//        ErsUser ersUser = new ErsUser();
//        ResponseEntity<ErsUser> entity = restTemplate.postForEntity(url, ersUser, ErsUser.class);
// 
//        ErsUser[] ersUsers = restTemplate.getForObject(url, ErsUser[].class);
//        Assertions.assertThat(ersUsers).extracting(ErsUser::getUserFirstName).containsOnly("fname");
// 
//        restTemplate.delete(url + "/" + entity.getBody().getErsUserId());
//        Assertions.assertThat(restTemplate.getForObject(url, ErsUser[].class)).isEmpty();
//    }
// 
//    @Test
//    public void testErrorHandlingReturnsBadRequest() {
// 
//        RestTemplate restTemplate = new RestTemplate();
// 
//        String url = "http://localhost:8080/wrong";
// 
//        try {
//            restTemplate.getForEntity(url, String.class);
//        } catch (HttpClientErrorException e) {
//            Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//        }
//    }
//}