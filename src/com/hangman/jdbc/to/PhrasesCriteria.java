package com.hangman.jdbc.to;

/**
 * 
 * PhrasesCriteria object serves as an argument to database related methods.
 * 
 * @author Tzanidou Alexandra
 * 
 */
public class PhrasesCriteria {

	private Integer PhraseID;
	private Integer PhraseCategoryID;
	private String PhraseName;
	private String PhraseHelp;

	public String toString() {
		return PhraseID + "." + PhraseCategoryID + "." + PhraseName + "."
				+ PhraseHelp;
	}

	public Integer getPhraseID() {
		return PhraseID;
	}

	public void setPhraseID(Integer phraseID) {
		PhraseID = phraseID;
	}

	public Integer getPhraseCategoryID() {

		return PhraseCategoryID;
	}

	public void setPhraseCategoryID(Integer phraseCategoryID) {
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
