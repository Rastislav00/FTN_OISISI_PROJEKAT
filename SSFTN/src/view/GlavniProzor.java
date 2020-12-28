package view;

import java.io.FileNotFoundException;
import java.io.IOException;

import controller.ProfesorController;
import controller.StudentController;
import model.BazaProfesori;
import model.BazaStudenti;
import util.Serijalizacija;

public class GlavniProzor {

	public static void main(String[] args) {
		
		BazaStudenti.getInstance();
		BazaProfesori.getInstance().init();
		
		
		StudentController.getInstance();
		ProfesorController.getInstance();
		
		
		try {
			Serijalizacija.writeToFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Frame1.getInstance();
		
	}

}
