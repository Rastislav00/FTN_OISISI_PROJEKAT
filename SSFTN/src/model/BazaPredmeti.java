package model;

import java.io.Serializable;
import java.util.ArrayList;
import model.Predmet;



public class BazaPredmeti implements Serializable{

	private static final long serialVersionUID = 3997779363529257330L;
	private static BazaPredmeti instance = null;
	
	public static BazaPredmeti getInstance() {
		if(instance == null) {
			instance = new BazaPredmeti();
		}
		return instance;
	}
	
	private ArrayList<Predmet> alPredmeti;
	private ArrayList<String> alKolone;
	
	private ArrayList<Predmet> trazeniPredmeti;
	private boolean SearchMode;
	
	
	private BazaPredmeti() {
		
		
		alPredmeti = new ArrayList<Predmet>();
		
		alKolone = new ArrayList<String>();
		alKolone.add("Šifra predmeta");
		alKolone.add("Naziv predmeta");
		alKolone.add("Broj ESPB bodova");
		alKolone.add("Godina u kojoj se predmet izvodi");
		alKolone.add("Semestar u kome se predmet izvodi");				

	}
	
	
	public ArrayList<Predmet> getPredmeti(){
		return alPredmeti;
	}
	
	public void setPredmeti(ArrayList<Predmet> Predmeti) {
		alPredmeti = Predmeti;
	}
	
	public int getBrKolona() {
		return 5;
	}
	
	public Predmet getPredmet(int rowIndex) {
		return alPredmeti.get(rowIndex);
	}
	
	public Predmet getPredmet(String sifra) {
		for(Predmet p: alPredmeti) {
			if(p.getSifraPredmeta().equals(sifra))
			return p;
		}
		return null;
	}
	
	public String getNazivKolona(int index) {
		return alKolone.get(index);
	}
	

	public Object getVrednostU(int x, int y) {
		
		if(SearchMode == false) {
		Predmet predmet = alPredmeti.get(x);
		switch (y) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getBrojESPBbodova();
		case 3:
			return predmet.getGodinaStudijaUKojojSePredmetIzvodi();
		case 4:
			return predmet.getSemestar().toString();
			
		default:
			return null;
		}
		}else {
		Predmet predmet = trazeniPredmeti.get(x);
		switch (y) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getBrojESPBbodova();
		case 3:
			return predmet.getGodinaStudijaUKojojSePredmetIzvodi();
		case 4:
			return predmet.getSemestar().toString();
				
		default:
			return null;
					
					}
		}
	}

	
	public void dodajPredmet(Predmet predmet) {
		alPredmeti.add(predmet);
	}
	
	public void izbrisiPredmet(String sifra) {
		alPredmeti.remove(getPredmet(sifra));		
	}

	public void dodajPredmeta(String sifraPredmeta, String nazivPredmeta, Semestar semestar,
			int godinaStudijaUKojojSePredmetIzvodi, Profesor predmetniProfesor, int brojESPBbodova) 
	{
		Predmet Predmet = new Predmet(sifraPredmeta,nazivPredmeta, semestar,
				godinaStudijaUKojojSePredmetIzvodi,predmetniProfesor,brojESPBbodova);
		alPredmeti.add(Predmet);
	}
	
	
	
	public void izbrisiPredmeta(String sifraPredmeta) {
		for (Predmet Predmet : alPredmeti) {
			if(Predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				alPredmeti.remove(Predmet);
				break;
			}
		}
	}
	
	
	public void izmeniPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar,
			int godinaStudijaUKojojSePredmetIzvodi, Profesor predmetniProfesor, int brojESPBbodova) 
	{
		for (Predmet predmet : alPredmeti) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				
		predmet.setSifraPredmeta(sifraPredmeta);
		predmet.setNazivPredmeta(nazivPredmeta);
		predmet.setSemestar(semestar);
		predmet.setGodinaStudijaUKojojSePredmetIzvodi(godinaStudijaUKojojSePredmetIzvodi);
		predmet.setPredmetniProfesor( predmetniProfesor);
		predmet.setBrojESPBbodova(brojESPBbodova);
				
				break;
			}
		}
		
	}


	public boolean jedinstvenaSifra(String novaSifra) {
		for (Predmet predmet : alPredmeti) {
			if(predmet.getSifraPredmeta().equals(novaSifra)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isSearchMode() {
		return SearchMode;
	}
	public void setSearchMode(boolean searchMode) {
		SearchMode = searchMode;
	}
	
	public ArrayList<Predmet> getTrazeniPredmeti() {
		return trazeniPredmeti;
	}

	public void setTrazeniPredmeti(ArrayList<Predmet> trazeniPredmeti) {
		this.trazeniPredmeti = trazeniPredmeti;
	}
	

	
	/*
	 *  Ova metoda prima studenta, i vraca ArrayList predmeta koje student moze da polaze
	 *  tj da mu dodamo kao nepolozene predmete
	 *  predmeti moraju da zadovolje dva uslova
	 *  	1. Predmet nije polozio
	 *  	2. Godina izvodjenja Predmeta je ista ili niza od godine studije studenta 
	 */
	public ArrayList<Predmet> getMoguciPredmetiZaStudenta(Student student){
		ArrayList<Predmet> alMoguciPredmeti = new ArrayList<Predmet>();
		
		// predjimo kroz sve predmete
		for (Predmet predmet : alPredmeti) {
			// ako je godina izvodjenja predmeta manja ili jednaka od god studije studenta 
			if(predmet.getGodinaStudijaUKojojSePredmetIzvodi() <= student.getTrenGodStudija()) {
				// ok sada proverimo dal je on taj predmet vec polozio
				// al proverimo dal slucajno vec ima taj predmet u nepolozenim
				if( !student.jePolozioPredmet(predmet) && !student.trebaDaPolozi(predmet)) {
					// student nije polozio taj predmet, znaci mozemo ga dodati da polaze :)
					alMoguciPredmeti.add(predmet);
				}
			}
		}

		
		return alMoguciPredmeti;
	}


	public ArrayList<Predmet> formPredmetiZaDodavanje(Profesor p) {
		ArrayList<Predmet> ret=new ArrayList<Predmet>(alPredmeti);
		
		for(Predmet pre: p.getPredmetiNaKojimaJeProfesor())
			ret.remove(pre);
		
		return ret;
	}


	public void ukloniProfesoraSaPredmeta(Profesor aktuelniProfesor, Predmet predmet) {
		// ako posaljemo nullo ve nista bezimo 
		if(aktuelniProfesor == null || predmet == null )return;
		
		// proverimo da li predmet uopste ima profesora
		if(predmet.getPredmetniProfesor() != null) {
			// proverimo da li je to taj profesor
			if(predmet.getPredmetniProfesor().equals(aktuelniProfesor)) {
				// brisemo ga
				predmet.setPredmetniProfesor(null);
			}
		}
	}





	

}

