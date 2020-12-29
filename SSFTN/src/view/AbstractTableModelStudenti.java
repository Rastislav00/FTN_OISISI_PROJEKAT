package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenti;

public class AbstractTableModelStudenti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;

	public AbstractTableModelStudenti(){}
	
	// broj redova
		@Override
		public int getRowCount() {
			return BazaStudenti.getInstance().getStudenti().size();
		}
		
		// broj kolona
		@Override
		public int getColumnCount() {
			return BazaStudenti.getInstance().getBrKolona();
		}

		// nazivi kolona u zaglavlju
		@Override
		public String getColumnName(int column) {
			return BazaStudenti.getInstance().getNazivKolona(column);
		}
		
		// sadrzaj celije
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaStudenti.getInstance().getVrednostU(rowIndex, columnIndex);
		}
		
		
		public Class<?> getColumnClass(int columnIndex) {
		    if (BazaStudenti.getInstance().getStudenti().isEmpty()) {
		        return Object.class;
		    }
		    //System.out.println(getValueAt(0, columnIndex).getClass());
		    //return getValueAt(0, columnIndex).getClass(); 	// OVO je kao kod milice
		    
		    // Zasto baca error kod ovog dela 
		    /*
		    switch (columnIndex) {
			case 0:
				return String.class; 			// indeks
			case 1:
				return String.class; 			// ime
			case 2:
				return String.class; 			// prezime
			case 3:
				return Integer.class;		 	// trenutna godina studija
			case 4:
				return String.class; 			// status
			case 5:
				return Double.class; 			// prosecna ocena
			default:
				return String.class;
			}
			*/
		    return String.class;
		}
		
	
	
	
}
