package com.samul.javaсorelessons.notebook.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NoteBook {
	private List<Note> notes;
	
	NoteBook() {
		this.notes = new ArrayList<Note>();
	}

	NoteBook(ArrayList<Note> notes) {
		this.notes = notes;
	}

	

	public boolean addNote(Note note) {
		return this.notes.add(note);
		
	}

	public List<Note> getNotes() {
		return this.notes;
		
	}
	
	public String toString() {
		return "NoteBook [notes=" + notes + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(notes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteBook other = (NoteBook) obj;
		return Objects.equals(notes, other.notes);
	}
	
	

}
