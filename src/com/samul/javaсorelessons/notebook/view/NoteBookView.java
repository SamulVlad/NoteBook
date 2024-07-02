package com.samul.javaсorelessons.notebook.view;

import java.util.List;

import com.samul.javaсorelessons.notebook.entity.Note;
import com.samul.javaсorelessons.notebook.entity.NoteBook;

public class NoteBookView {

	public static void printNotes(List<Note> notes) {
		for (Note elem : notes) {
			printNote(elem);
		}
	}

	public static void printNotes(NoteBook noteBook) {
		printNotes(noteBook.getNotes());
	}

	public static void printNote(Note note) {
		System.out.println("Date: " + note.getDate() + ": [" + note.getNote() + "]");
		System.out.println("============================================================================");
	}

}
