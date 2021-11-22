package com.revature.dao;

public class DaoFactory {

	private static DaoFactory df;
	private ErsUsersDao eud;
	private ErsReimbursementDao erd;

	// private constructor to restrict instantiation of DaoFactory class
	private DaoFactory() {
	}

	// public getter to retrieve an existing daofactory instance otherwise creates one.
	public static synchronized DaoFactory getDaoFactory() {
		if (df == null) {
			df = new DaoFactory();
		}
		return df;
	}
	
	public ErsUsersDao getErsUsersDao() {
		if(eud == null) {
			eud = new ErsUsersPostgres();
		}
		return eud;
	}
	public ErsReimbursementDao getErsReimbursementDao() {
		if(erd == null) {
			erd = new ErsReimbursementPostgres();
		}
		return erd;
	}
}
