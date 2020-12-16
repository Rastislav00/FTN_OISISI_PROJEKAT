package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3968963718257174797L;
	private String infoProj;
	private String rastislavBiografija;
	private String milicaBiografija;
	
	public AboutDialog(Frame parent, String naslov) {
		super(parent,naslov,true);
		
		setSize(400,650);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		
		//ovaj deo sluzi kao ukras dodacemo panele levo desno i gore kako bi bile komponente odmaknute od ivice prozora
		JPanel leviPanel = new JPanel();
		leviPanel.setPreferredSize(new Dimension(10,10));
		JPanel desniPanel = new JPanel();
		desniPanel.setPreferredSize(new Dimension(10,10));
		JPanel gornjiPanel = new JPanel();
		gornjiPanel.setPreferredSize(new Dimension(10,10));
		add(leviPanel,BorderLayout.WEST);
		add(desniPanel,BorderLayout.EAST);
		add(gornjiPanel,BorderLayout.NORTH);
		// to je za estetiku
		
		JPanel glAPanel = new JPanel();				// glavni panel tu sve stavljamo
		BoxLayout boxACentar = new BoxLayout(glAPanel, BoxLayout.Y_AXIS);
		glAPanel.setLayout(boxACentar);
		
		
		
		infoProj = "Projekat iz predmete OISISI\n"+
				   "Razvijanje Informacionog Sistema za studentsku sluzbu \nFakulteta Tehnkickih Nauka\n"+
				   "Aplikacija olaksava evidenciju studenata FTN-a kao i njihov \nuspeh na ispitima.\n"+
				   "Vodi se evidencia o Profesorima i o Predmetima koji \npostoje na FTN-u";
		infoProj += "\n\n\nAlat koriscen je Java JDK10 i Swing Biblioteka";
		
		JTextArea textAProj = new JTextArea(infoProj,10,34);
		textAProj.setPreferredSize(new Dimension(250,250));
		textAProj.setEditable(false);
		textAProj.setLineWrap(true);
		JScrollPane scrollAboutProj = new JScrollPane(textAProj, 
											JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
											JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAboutProj.setPreferredSize(new Dimension(250,250));
		
		// napravimo klasu za panel gde pisu nase informacije
		
		rastislavBiografija = "Biografija dashjdkasdjhkashdashdkjashdkjhasjdhkasdhjkashdkashdkjhaskdhkasjhdkjahsdjhaskdjh";
		milicaBiografija = "Biografija duhauhdeiaihdfeuhesiudheuihs8383yodh38wh3whd3w8wd3o83wd8ushudhakshadhasudhaushdkashda";
		String Rfimg = "images"+File.separator+"rastislav.png";
		StudentPanel rastislavPan = new StudentPanel(Rfimg, rastislavBiografija,1);
		StudentPanel milicaPan = new StudentPanel(Rfimg, milicaBiografija,2);
		
		

		glAPanel.add(scrollAboutProj);
		glAPanel.add(Box.createVerticalStrut(40));
		glAPanel.add(rastislavPan);
		glAPanel.add(Box.createVerticalStrut(10));
		glAPanel.add(milicaPan);
		glAPanel.add(Box.createVerticalStrut(10));
		
		add(glAPanel, BorderLayout.CENTER);
		
		// donji deo panela sluzi samo za zatvaranje ovog dialoga
		JPanel panelZatvori = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelZatvori.setBackground(new Color(255,255,255));
		DiaButton bZatvori = new DiaButton("zatvori");
		bZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panelZatvori.add(bZatvori);
		add(panelZatvori, BorderLayout.SOUTH);
		
	}
	
	// dodatna klasa
	private class StudentPanel extends JPanel{
		/* fimg putanja do slike
		 * biografija - string opis biografije
		 * orjentacija - 1 slika levo, biografija desno
		 * orjenatijca - 2 slika desno, biografija levo
		 */
		public StudentPanel(String fimg, String biografija, int orjentacija) {
			setLayout(new BorderLayout());
			setPreferredSize(new Dimension(100,100));
			setBackground(new Color(255,255,255));
			
			JButton img = new JButton();
			img.setIcon(new ImageIcon(fimg));
			img.setContentAreaFilled(false);
			img.setMargin(new Insets(10,10,10,10));
			img.setBorderPainted(false);
			
			JTextArea txt = new JTextArea(biografija);
			txt.setEditable(false);
			txt.setLineWrap(true);
			
			if(orjentacija == 1) { 	
				add(img,BorderLayout.WEST);
				add(txt,BorderLayout.CENTER);
			}else {
				add(img,BorderLayout.EAST);
				add(txt,BorderLayout.CENTER);
			}
			
			
		}
	}
	
	
}
