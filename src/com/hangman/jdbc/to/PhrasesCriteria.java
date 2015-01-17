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

	public int getPhraseID() {
		return PhraseID;
	}

	public void setPhraseID(Integer phraseID) {
		PhraseID = phraseID;
	}

	public int getPhraseCategoryID() {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhrasesCriteria [PhraseID=" + PhraseID + ", PhraseCategoryID="
				+ PhraseCategoryID + ", PhraseName=" + PhraseName
				+ ", PhraseHelp=" + PhraseHelp + "]";
	}
}
