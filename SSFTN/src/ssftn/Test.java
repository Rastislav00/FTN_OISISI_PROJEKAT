package ssftn;

import java.util.ArrayList;

import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;

public class Test {

	public static void main(String[] args) {
		System.out.println("Pozz SSFTN");
		System.out.println("test test");
		System.out.println("Drugi komit");

		for(int i = 0; i < 10; i++){
			System.out.println("test");			
		}
		
		Student st1 = new Student("Rastislav", "Kukucka", "07.01.2020", "BackiPetrovac", 
								  "324", "ras@gmail.com", "RA129/2018", 2018, 3, model.Status.B);
		
		Student st2 = new Student("Vucinic", "Milica", "26.7.1999", "Bosna", 
							 	  "42342", "mi@", "RA139/2018", 2018, 3, model.Status.B);
		
		
		
		
		Profesor prof1 = new Profesor("petrovic", "velko", "1970", "negde", "000", "v@", "NTP111", "333", "prof", "dr");
		
		
		Predmet pr1 = new Predmet("34s", "OS", model.Semestar.LETNJI, 2, prof1, 8);
		
		Ocena o1 = new Ocena(st1, pr1, 10, "12.16.2020");
		
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(prof1);
		
		st1.dodajPolozenIspit(o1);
		// System.out.println(st1); // ovo se ne sme izvrsiti zbog rekurcije
		/*
		 *  javlja se problem je u klasi strudent postoji to string tj postoji lista ocena i on ce za svaku ocenu
		 *  da poziva ocena.toString() a u oceni imamo studenta pa ce se pozbati student.toString() pa ce se u studentu
		 *  pozvati ocena.toString() i tako imamo beskonacnu petlju
		 *  treba nam promeniti te klase toString ili napraviti novu .info() npr 
		 * 
		 */
		System.out.println();
		System.out.println(st1.info());
		
		Profesor proErdeljan = new Profesor("Erdeljan", "Aleksa", "1900", "nema", "000", "erdedeljan@", "NTP333", "3334", "dr", "prof");
		
		Predmet pr2 = new Predmet("432", "MISS", Semestar.ZIMSKI, 2, proErdeljan, 8);
		Ocena o2 = new Ocena(st1, pr2, 5, "12.15.2222");
		
		st1.dodajNePolozenIspit(o2);
		System.out.println(st1.info());
		
		
		
	}

}
