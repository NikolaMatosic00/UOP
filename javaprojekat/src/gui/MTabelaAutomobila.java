package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import moduli.Administrator;
import moduli.Automobil;
import moduli.Musterija;
import moduli.Servis;
import rad_sa_listama.SveListe;

public class MTabelaAutomobila extends JFrame {

	private JToolBar main_tool_bar = new JToolBar();

	
	private DefaultTableModel table_model;
	private JTable automobili_tabela;
	
	private SveListe sv;
	private Musterija musterija;
	
	public MTabelaAutomobila(SveListe sv, Musterija m) {
		this.sv = sv;
		this.musterija = m;
		setTitle("Pregled automobila");
		setSize(800, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		initGUI();
		
	}
	private void initGUI() {


		add(main_tool_bar, BorderLayout.SOUTH);
		String[] zaglavlje = new String[] {"ID", "Vlasnik", "Marka", "Model" ,"Godiste", "Zapremina u ccm", "Snaga u ks", "Vrsta goriva"};
		Object[][] sadrzaj = new Object[musterija.getAutomobili().size()][zaglavlje.length];
		
		for(int i = 0; i < musterija.getAutomobili().size(); i ++) {
			Automobil aut = musterija.getAutomobili().get(i);
			sadrzaj[i][0] = aut.getId();
			sadrzaj[i][1] = aut.getVlasnik().getKorisnicko_ime();
			sadrzaj[i][2] = aut.getMarka();
			sadrzaj[i][3] = aut.getModel();
			sadrzaj[i][4] = aut.getGodina_proizvodnje();
			sadrzaj[i][5] = aut.getZapremina_motora();
			sadrzaj[i][6] = aut.getSnaga_motora();
			sadrzaj[i][7] = aut.getVrsta_goriva();

		
		
		}
		
		table_model = new DefaultTableModel(sadrzaj, zaglavlje);
		automobili_tabela = new JTable(table_model);
		
		automobili_tabela.setRowSelectionAllowed(true);
		automobili_tabela.setColumnSelectionAllowed(false);
		automobili_tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		automobili_tabela.setDefaultEditor(Object.class, null);
		automobili_tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(automobili_tabela);
		add(jsp, BorderLayout.CENTER);
	
	}
}
	
	
