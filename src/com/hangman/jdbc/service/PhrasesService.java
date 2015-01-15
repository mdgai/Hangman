package com.hangman.jdbc.service;

import java.util.List;

import com.hangman.jdbc.dao.BaseDAO;
import com.hangman.jdbc.dao.PhrasesDAO;
import com.hangman.jdbc.to.Phrases;
import com.hangman.jdbc.to.PhrasesCriteria;

/**
 * Class that provides services to table Phrases, such as INSERT, DELETE, UPDATE
 * etc.
 * 
 * @author Tzanidou Alexandra
 * 
 */

public class PhrasesService {

	private BaseDAO<Phrases> PhrasesDAO = new PhrasesDAO();

	public void add(Phrases Phrases) {
		PhrasesDAO.add(Phrases);
	}

	public void delete(Phrases Phrases) {
		PhrasesDAO.delete(Phrases);
	}

	public void update(Phrases Phrases) {
		PhrasesDAO.update(Phrases);
	}

	public List<Phrases> findAll(PhrasesCriteria Phrases) {
		return PhrasesDAO.findAll(Phrases);

	}
}
