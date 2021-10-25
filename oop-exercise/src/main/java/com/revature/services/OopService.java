package com.revature.services;

import com.revature.models.Dispatch;
import com.revature.models.Service;

public class OopService {

	public void doEncapsulation() {
		Service sdd = new Service();
		sdd.setName("HouseKeeping");
		System.out.println(sdd.getName());
		
		Dispatch disp = new Dispatch();
		disp.setName("AuditInspection");
		System.out.println(disp.getName());
		
		System.out.println(sdd.getId());
		}

	public void doInheritance() {
		Service sdh = new Service();
		System.out.println(sdh.getId());
		
		Dispatch disp = new Dispatch();
		disp.requested();
		System.out.println(disp);
		}

	public void doPolymorphism() {
		Service sdi = new Dispatch();
		System.out.println(sdi);
	}


	public void doAbstraction() {
		Service sd;
		try {
			sd = new Service();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
}