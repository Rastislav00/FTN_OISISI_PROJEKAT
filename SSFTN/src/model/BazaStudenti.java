package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

import util.Deserijalizacija;


public class BazaStudenti {

	private static BazaStudenti instance = null;
	
	public static BazaStudenti getInstance() {
		if(instance == null) {
			instance = new BazaStudenti();
		}
		return instance;
	}
	
	private ArrayList<Student> alStudenti;
	private ArrayList<String> alKolone;
	
	private ArrayList<Student> alTrazeniStudenti;
	private boolean searchMode;
	
	private void initStudents() {
		
		// napraviti deserijalizaciju
		alStudenti = Deserijalizacija.studentDeserijalizacija();
		
		/*
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		Date datumRodjenja = null;
		try {
			datumRodjenja = dateFormat.parse("7.1.2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Student st1 = new Student("Kukucka", "Rastislav", datumRodjenja, "Novi Sad", "5846868", 
								  "ras@gmail.com", "ra-129-2018", 2018, 3, Status.B);
		
		try {
			datumRodjenja = dateFormat.parse("29.7.1999");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student st2 = new Student("Vucinic", "Milica", datumRodjenja, "Novi Sad", "24233", 
				        		  "milica@uns", "ra-139-2018", 2018, 3, Status.B);
		
		
		Predmet pr2 = new Predmet("E15", "OISISI", Semestar.ZIMSKI, 3, 6);
		Predmet pr3 = new Predmet("AN1", "Analiza 1", Semestar.ZIMSKI, 1, 9);
		
		Ocena ocena1 = new Ocena(st1, pr2, 10, datumRodjenja);
		Ocena ocena2 = new Ocena(st1, pr3, 9, datumRodjenja);
		
		st1.dodajPolozenIspit(ocena1);
		st1.dodajPolozenIspit(ocena2);
		
		
		alStudenti.add(st1);
		alStudenti.add(st2);
		*/
	}
	
	
	private BazaStudenti() {
		searchMode = false;
		alTrazeniStudenti = new ArrayList<Student>();
		alStudenti = new ArrayList<Student>();
		initStudents(); 		// neka metoda koja ce da ucita u bazu studente pri paljenju app
		
		
		
		alKolone = new ArrayList<String>();
		alKolone.add("Indeks");
		alKolone.add("Ime");
		alKolone.add("Prezime");
		alKolone.add("Godina studija");
		alKolone.add("Status");
		alKolone.add("Prosek");

	}
	
	
	public ArrayList<Student> getStudenti(){
		return alStudenti;
	}
	
	public void setStudenti(ArrayList<Student> studenti) {
		alStudenti = studenti;
	}
	
	public int getBrKolona() {
		return 6;
	}
	
	public String getNazivKolona(int index) {
		return alKolone.get(index);
	}
	
	public Student getStudent(int rowIndex) {
		return alStudenti.get(rowIndex);
	}
	
	public Student getStudentByIndex(String indeks) {
		for (Student student : alStudenti) {
			if(student.getIndeks().equals(indeks)) {
				return student;
			}
		}
		return null;
	}
	
	public String getVrednostU(int x, int y) {
		Student student = null;
		if(searchMode) {
			student = alTrazeniStudenti.get(x);
		}else {
			student = alStudenti.get(x);
		}
		if(student == null) return null;
		
		switch (y) {
		case 0:
			return student.getIndeks();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getTrenGodStudija());
		case 4:
			return student.getStatus().toString();
		case 5:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	
	public void dodajStudenta(Student student) {
		alStudenti.add(student);
	}
	

	public void dodajStudenta(String prezime, String ime, Date datumRodjenja, 

			   String adresa, String kontaktTelefon, String email,
			   String indeks, int godinaUpisa, int trenGodStudija, Status status) 
	{
		Student student = new Student(prezime, ime, datumRodjenja, adresa, kontaktTelefon, 
										email, indeks, godinaUpisa, trenGodStudija, status);
		alStudenti.add(student);
	}
	
	
	
	// brisanje studenta kad znamo indeks
	public void izbrisiStudenta(String indeks) {
		for (Student student : alStudenti) {
			if(student.getIndeks().equals(indeks)) {
				alStudenti.remove(student);
				break;
			}
		}
	}
	
	// brisanje studenta kad znamo studenta
	public void izbrisiStudenta(Student student) {
		alStudenti.remove(student);
	}
	
	

	public void izmeniStudenta(String prezime, String ime, Date datumRodjenja, 

							   String adresa, String kontaktTelefon, String email,
							   String indeks, int godinaUpisa, int trenGodStudija, Status status) 
	{
		for (Student student : alStudenti) {
			if(student.getIndeks().equals(indeks)) {
				
				student.setIndeks(indeks);
				student.setPrezime(prezime);
				student.setIme(ime);
				student.setDatumRodjenja(datumRodjenja);
				student.setAdresa(adresa);
				student.setKontaktTelefon(kontaktTelefon);
				student.setEmail(email);
				student.setGodinaUpisa(godinaUpisa);
				student.setTrenGodStudija(trenGodStudija);
				student.setStatus(status);
				
				break;
			}
		}
		
	}
	
	public boolean jedinstvenIndeks(String noviIndeks) {
		for (Student student : alStudenti) {
			if(student.getIndeks().equals(noviIndeks)) {
				return false;
			}
		}
		return true;
	}

	public boolean getSearchMode() {return searchMode;}

	public void setSearchMode(boolean b) {
		searchMode = b;
	}


	public void izbrisiStudentaIzTrazenihStudenata(Student student) {
		
		if(searchMode) {
			alTrazeniStudenti.remove(student);
		}
		
	}
	
	public ArrayList<Student> getTrazeniStudenti(){
		return alTrazeniStudenti;
	}
	
	public void setTrazeniStudenti(ArrayList<Student> trazeni) {
		alTrazeniStudenti = trazeni;
	}


	public void izbrisiPredmetUnutarStudenta(String sifra) {
		
		int i1;
		for(Student p: alStudenti) {
			i1=p.getlNePolIspita().indexOf(BazaPredmeti.getInstance().getPredmet(sifra));
			if(i1>=0) p.getlNePolIspita().remove(i1);
		}
		
	}



	
	
	
	
	
	
	
	
	
}
