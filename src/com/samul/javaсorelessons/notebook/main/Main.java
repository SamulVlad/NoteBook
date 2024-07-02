package com.samul.javaсorelessons.notebook.main;

import java.time.LocalDate;
import java.util.List;

import com.samul.javaсorelessons.notebook.entity.Note;
import com.samul.javaсorelessons.notebook.entity.NoteBook;
import com.samul.javaсorelessons.notebook.entity.NoteBookProvider;
import com.samul.javaсorelessons.notebook.logic.NoteBookLogic;
import com.samul.javaсorelessons.notebook.view.Interaction;

public class Main {

	public static void main(String[] args) {
		NoteBookProvider nbProvider = NoteBookProvider.INSTANCE;
		NoteBook nb = nbProvider.getNoteBook();
		
		
		 nb.addNote(new Note("Позавтракал")); 
		 nb.addNote(new Note("Пошел на работу"));
		 nb.addNote(new Note("Вернулся с работы"));
		 nb.addNote(new Note("Сделал домашку"));
		 		
		Interaction menu = new Interaction(nbProvider.getNoteBook());
		
		menu.runMenu();
		
	}

}
