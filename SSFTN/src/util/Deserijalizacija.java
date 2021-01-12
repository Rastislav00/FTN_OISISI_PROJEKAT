package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.Predmet;
import model.Profesor;
import model.Student;

public class Deserijalizacija {

	public Deserijalizacija() {}
	
	
	public static ArrayList<Student> studentDeserijalizacija() {
		ArrayList<Student> alStd = null;
		File f = new File("podaci"+File.separator+"BazaStudenti.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			try {
				alStd = (ArrayList<Student>) ois.readObject();
				return alStd;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				ois.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Student>();
	}
	
	public static ArrayList<Profesor> profesorDeserijalizacija() {
		ArrayList<Profesor> alProf = null;
		File f = new File("podaci"+File.separator+"BazaProfesori.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			try {
				alProf = (ArrayList<Profesor>) ois.readObject();
				return alProf;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				ois.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Profesor>();
	}
	
	public static ArrayList<Predmet> predmetDeserijalizacija() {
		ArrayList<Predmet> alPred = null;
		File f = new File("podaci"+File.separator+"BazaPredmeti.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			try {
				alPred = (ArrayList<Predmet>) ois.readObject();
				return alPred;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				ois.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Predmet>();
	}
}
