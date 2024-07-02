package com.samul.javaсorelessons.notebook.entity;

public enum NoteBookProvider {
	INSTANCE;

	private NoteBook noteBook = null;

	private NoteBookProvider() {
		noteBook = new NoteBook();
	}
	
	public NoteBook getNoteBook() {
		return this.noteBook;
	}

}
