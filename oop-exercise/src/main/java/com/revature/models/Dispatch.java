package com.revature.models;

import java.util.Random;

import com.revature.interfaces.Available;

public class Dispatch extends Service implements Available{
	
	public Dispatch() {
		super();
	}
	
	public Dispatch(String id, String name) {
		super(id, name);
	}
	
	@Override
	public boolean requested() {
		return true;
	}
	
	@Override
	public String assignAssociate() {
		int ind = new Random().nextInt(driver.length);
	    return driver[ind];
	}

	public String dispatched() {
		return assignAssociate()+" is dispatched for the requested service";
	}
}
