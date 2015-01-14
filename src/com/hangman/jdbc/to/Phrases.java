package com.hangman.jdbc.to;

/**
 * Transfer Object Phrases
 * @author Tzanidou Alexandra
 *
 */
/**
 * @author Maria - Despoina Gkaintatzi
 * 
 */
public class Phrases {

	private int PhraseID;
	private int PhraseCategoryID;
	private String PhraseName;
	private String PhraseHelp;

	public int getPhraseID() {
		return PhraseID;
	}

	public void setPhraseID(int phraseID) {
		PhraseID = phraseID;
	}

	public int getPhraseCategoryID() {
		return PhraseCategoryID;
	}

	public void setPhraseCategoryID(int phraseCategoryID) {
		PhraseCategoryID = phraseCategoryID;
	}

	public String getPhraseName() {
		return PhraseName;
	}

	public void setPhraseName(String phraseName) {
		PhraseName = phraseName;
	}

	public String getPhraseHelp() {
		return PhraseHelp;
	}

	public void setPhraseHelp(String phraseHelp) {
		PhraseHelp = phraseHelp;
	}

}
