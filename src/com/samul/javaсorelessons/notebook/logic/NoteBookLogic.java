package com.samul.javaсorelessons.notebook.logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.samul.javaсorelessons.notebook.entity.Note;
import com.samul.javaсorelessons.notebook.entity.NoteBook;

public class NoteBookLogic {
	public static List<Note> findNotesByContent(NoteBook noteBook, String stringToFind){
		List<Note> result = new ArrayList<Note>();
		
		for (Note elem : noteBook.getNotes()) {
			if (elem.getNote().toLowerCase().indexOf(stringToFind.toLowerCase()) != -1) {
				result.add(elem);
			}
		}
		
		return result;
	}

	public static List<Note> findNotesByDate(NoteBook noteBook, LocalDate dateToFind){
		List<Note> result = new ArrayList<Note>();
		
		for (Note elem : noteBook.getNotes()) {
			if (elem.getDate().isEqual(dateToFind)) {
				result.add(elem);
			}
		}
		
		return result;
	}
	
}
