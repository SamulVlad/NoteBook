package com.samul.javaсorelessons.notebook.entity;

import java.time.*;
import java.util.Objects;

public class Note {
	private LocalDate date;
	private String note;
	
	private Note() {
	}

	public Note(String note) {
		this.date = LocalDate.now();
		this.note = note;
	}

	public Note(LocalDate date, String note) {
		this.date = date;
		this.note = note;
	}
	

	public LocalDate getDate() {
		return this.date;
	}

	public String getNote() {
		return this.note;
	}

	public String toString() {
		return "Note [date=" + date + ", Note=" + note + "]";
	}

	public int hashCode() {
		return Objects.hash(note, date);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(note, other.note) && Objects.equals(date, other.date);
	}
	
	
	
	
	
	

}
