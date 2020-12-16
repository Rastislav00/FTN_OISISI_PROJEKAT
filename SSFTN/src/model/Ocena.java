package model;

public class Ocena {

	// POLJA
	private Student student;
	private Predmet predmet;
	private int ocena;
	private String datumPolaganjaIspita;
	

	// KONSTRUKTOR
	// public Ocena() {}
	public Ocena(Student student, Predmet predmet, int ocena, String datumPolaganjaIspita) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}
	
	
	
	
	// SETERI I GETERI
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public String getDatumPolaganjaIspita() {
		return datumPolaganjaIspita;
	}
	public void setDatumPolaganjaIspita(String datumPolaganjaIspita) {
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}



	// STRING
	
	@Override
	public String toString() {
		return info();
	}
	
	public String info() {
		String str = "Ocena: "+ocena+"\nstudent: "+student.getIme()+" "+student.getPrezime()+"\n"+
					 "predmet: "+predmet.getNazivPredmeta()+"\ndatum polaganja: "+datumPolaganjaIspita;
		return str;
	}
	
	
	
	
}
