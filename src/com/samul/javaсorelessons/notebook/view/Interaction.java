package com.samul.javaсorelessons.notebook.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.samul.javaсorelessons.notebook.entity.Note;
import com.samul.javaсorelessons.notebook.entity.NoteBook;
import com.samul.javaсorelessons.notebook.logic.NoteBookLogic;

public class Interaction {

	private NoteBook noteBook;

	private Interaction() {
	}

	public Interaction(NoteBook noteBook) {
		this.noteBook = noteBook;
	}

	public void runMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("\n\n======================");
			System.out.println("Выберите пункт меню:");
			System.out.println("----------------------");
			System.out.println("1. Добавить запись в блокнот");
			System.out.println("2. Найти записи в блокноте по содержимому");
			System.out.println("3. Найти записи в блокноте по дате создания");
			System.out.println("4. Показать записи в блокноте");
			System.out.println("5. Завершить программу");
			System.out.println("======================");

			int choice = 0;
			boolean validInput = false;

			while (!validInput) {
				try {
					System.out.print("Введите номер пункта: ");
					choice = scanner.nextInt();
					if (choice < 1 || choice > 5) {
						System.out.println("Неверный выбор. Пожалуйста, выберите номер от 1 до 4.");
					} else {
						validInput = true;
					}
				} catch (InputMismatchException e) {
					System.out.println("Ошибка ввода. Пожалуйста, введите числовое значение.");
					scanner.next();
				}
			}

			clearScreen();

			switch (choice) {
			case 1:
				addNote();
				break;
			case 2:
				findAndPrintNotesByContent();
				break;
			case 3:
				findAndPrintNotesByDate();
				break;
			case 4:
				System.out.println("Все записи блокнота: ");
				NoteBookView.printNotes(this.noteBook);
				break;
			case 5:
				exit = true;
				System.out.println("Программа завершена.");
				break;
			default:
				break;
			}
		}

		scanner.close();

	}

	private void addNote() {
		Scanner scanner = new Scanner(System.in);
		LocalDate date = null;

		boolean validDate = false;

		while (!validDate) {
			System.out.print("Введите дату в формате yyyy-MM-dd: ");
			String dateInput = scanner.nextLine();
			try {
				date = LocalDate.parse(dateInput);
				validDate = true;
			} catch (DateTimeParseException e) {
				System.out.println("Ошибка: неверный формат даты. Попробуйте снова.");
			}
		}

		String text = "";
		boolean validText = false;

		while (!validText) {
			System.out.print("Введите строку: ");
			text = scanner.nextLine();
			if (text != null && !text.trim().isEmpty()) {
				validText = true;
			} else {
				System.out.println("Ошибка: строка не должна быть пустой. Попробуйте снова.");
			}
		}

		Note note = new Note(date, text);

		if (this.noteBook.addNote(note)) {
			System.out.println("Запись добавлена в блокнот");
		} else {
			System.out.println("Запись не была добавлена в блокнот!!!");
		}
	}

	private void findAndPrintNotesByContent() {
		Scanner scanner = new Scanner(System.in);

		String text = "";
		boolean validText = false;

		while (!validText) {
			System.out.print("Введите текст для поиска в блокноте: ");
			text = scanner.nextLine();
			if (text != null && !text.trim().isEmpty()) {
				validText = true;
			} else {
				System.out.println("Ошибка: строка не должна быть пустой. Попробуйте снова.");
			}
		}

		List<Note> listOfNotes = NoteBookLogic.findNotesByContent(noteBook, text);

		if (listOfNotes.size() > 0) {
			System.out.println("Найденные записи:");
			NoteBookView.printNotes(listOfNotes);
		} else {
			System.out.println("Записей с таким текстом в блокноне не найдено!");
		}
	}

	private void findAndPrintNotesByDate() {
		Scanner scanner = new Scanner(System.in);

		LocalDate date = null;

		boolean validDate = false;

		while (!validDate) {
			System.out.print("Введите дату в формате yyyy-MM-dd для поиска записей в блокноте: ");
			String dateInput = scanner.nextLine();
			try {
				date = LocalDate.parse(dateInput);
				validDate = true;
			} catch (DateTimeParseException e) {
				System.out.println("Ошибка: неверный формат даты. Попробуйте снова.");
			}
		}

		List<Note> listOfNotes = NoteBookLogic.findNotesByDate(noteBook, date);

		if (listOfNotes.size() > 0) {
			System.out.println("Найденные записи:");
			NoteBookView.printNotes(listOfNotes);
//			System.out.println(listOfNotes.toString());
		} else {
			System.out.println("Записей на такую дату в блокноне не найдено!");
		}
	}

	private void clearScreen() {

		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

}
