package com.hangman.jdbc.dao;

import java.util.List;

/**
 * Base Interface for releted operations with the Database.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 * @param <T>
 */
public interface BaseDAO<T> {

	/**
	 * Method for inserting a transferObject record to the database.
	 * 
	 * @param transferObject
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void add(T transferObject);

	/**
	 * Method for deleting a transferObject record from the database.
	 * 
	 * @param id
	 *            transferObject to be deleted, specified by id.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void delete(int id);

	/**
	 * Method for deleting a transferObject record from the database.
	 * 
	 * @param transferObject
	 *            transferObject to be deleted.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void delete(T transferObject);

	/**
	 * Method for updating a transferObject record to the database.
	 * 
	 * @param transferObject
	 *            transferObject to be updated.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void update(T transferObject);

	/**
	 * Method for finding all records of table.
	 * 
	 * @return a List of objects.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public List<T> findAll();

	/**
	 * Method for telling the user if the request has been completed
	 * successfully.
	 * 
	 * @param int rows the number of rows that have been affected.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void rowAffect(int rows);
}
