package com.revature;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import java.io.IOException;
import java.util.stream.Collectors;

import com.revature.controller.AuthController;
import com.revature.controller.ErsController;
import com.revature.controller.ErsUsersController;
import com.revature.service.ErsService;

public class Driver {
	public static void main(String[] args) throws IOException {
		
//		ErsService reimbByStatus = new ErsService();
//		System.out.println(reimbByStatus.getReimbByStatus("rejected").stream()
//		.map(reimb -> reimb.getReimbId())
//		.collect(Collectors.toList()));

		Javalin app = Javalin.create((config) -> {
     		config.enableCorsForAllOrigins();
//     		config.addStaticFiles(null, null)
     			/*
     			 * Enables CORS: Cross Origin Resource Sharing - protective mechanism built into
     			 * most browsers - restricts resources to be allowed only by webpages on the
     			 * same domain
     			 */
     		config.defaultContentType = "application/json";
     	});
     	app.start(7000);

     		/*
     		 * Headers to tell the browser that the Authorization header that we're using for our "token" 
     		 * in the Response body is safe to use, otherwise the browser may not accept it
     		 */
     	app.before(ctx -> {
     		   ctx.header("Access-Control-Allow-Headers", "Authorization");
     		   ctx.header("Access-Control-Expose-Headers", "Authorization");
     	});
     		
     	app.routes(() -> {
            path("reimbursements", () -> {
            	get(ErsController::getReimbursements);
            	put(ErsController::updateReimbursementClaim);
            	post(ErsController::registerReimbursementClaim);
            	path("{reimbId}", () -> {
            		get(ErsController::getReimbursementClaimById);
            	});
            });
     		path("auth", () ->{
     			post(AuthController::login);
     		});
     		path("ersUsers", () -> {
     			get(ErsUsersController::getErsUsers);
     			put(ErsUsersController::updateErsUserInfo);
     			path("{id}", () -> {
     				get(ErsUsersController::getErsUsersById);
     		});

     	});
     	
     	});
	}
}
