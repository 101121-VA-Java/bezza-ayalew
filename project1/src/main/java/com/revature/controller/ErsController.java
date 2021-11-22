package com.revature.controller;

import java.io.IOException;
import java.util.List;
import com.revature.model.ErsReimbursement;
import com.revature.service.ErsService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ErsController {

	private static ErsService ers = new ErsService();

	public static void getReimbursements(Context ctx) throws IOException {

		ctx.json(ers.getAllReimbursements());
		ctx.status(HttpCode.OK);
	}

	public static void registerReimbursementClaim(Context ctx) throws IOException {

		ErsReimbursement newClaim = ers.addReimbursement(ctx.bodyAsClass(ErsReimbursement.class)); 

		if (newClaim == null) {
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			ctx.status(HttpCode.CREATED);
		}

	}
	public static void updateReimbursementClaim(Context ctx) throws IOException {

		boolean newClaim = ers.updateReimbursement(ctx.bodyAsClass(ErsReimbursement.class)); 

		if (!newClaim) {
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			ctx.status(HttpCode.CREATED);
		}

	}

	public static void getReimbursementClaimById(Context ctx) throws IOException {
		int id = Integer.parseInt(ctx.pathParam("reimbId"));

		ErsReimbursement reimbClaim = ers.getReimbById(id);

		if (reimbClaim != null) {
			ctx.json(reimbClaim);
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
	public static void getReimbursementClaimsByStatus(Context ctx) throws IOException {

		ctx.json(ers.getReimbByStatus(ctx.queryString()));
		ctx.status(HttpCode.OK);
	}
}
