package stückzahlrechner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.parser.Parser;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Window.Type;

public class Stückzahlrechner extends JFrame {

	private JPanel contentPane;
	private JTextField txtTakt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stückzahlrechner frame = new Stückzahlrechner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
	
	}

	/**
	 * Create the frame.
	 */
	public Stückzahlrechner() {
		setType(Type.POPUP);
		setTitle("St\u00FCckzahlrechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 286, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{101, 97, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblHProWoche = new JLabel("h pro Woche");
		GridBagConstraints gbc_lblHProWoche = new GridBagConstraints();
		gbc_lblHProWoche.insets = new Insets(0, 0, 5, 0);
		gbc_lblHProWoche.gridx = 1;
		gbc_lblHProWoche.gridy = 2;
		contentPane.add(lblHProWoche, gbc_lblHProWoche);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"358", "380", "391", "402"}));
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox, gbc_comboBox);
		
		JLabel lblMinProWoche = new JLabel("min pro Woche");
		GridBagConstraints gbc_lblMinProWoche = new GridBagConstraints();
		gbc_lblMinProWoche.insets = new Insets(0, 0, 5, 0);
		gbc_lblMinProWoche.gridx = 1;
		gbc_lblMinProWoche.gridy = 1;
		contentPane.add(lblMinProWoche, gbc_lblMinProWoche);
		
		JLabel lblAnzhwoche = new JLabel("");
		lblAnzhwoche.setText("33");
		GridBagConstraints gbc_lblAnzhwoche = new GridBagConstraints();
		gbc_lblAnzhwoche.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzhwoche.gridx = 0;
		gbc_lblAnzhwoche.gridy = 2;
		contentPane.add(lblAnzhwoche, gbc_lblAnzhwoche);
		
		
		JLabel txtAnzStückzahl = new JLabel("");
		GridBagConstraints gbc_txtAnzStückzahl = new GridBagConstraints();
		gbc_txtAnzStückzahl.insets = new Insets(0, 0, 5, 5);
		gbc_txtAnzStückzahl.gridx = 0;
		gbc_txtAnzStückzahl.gridy = 4;
		contentPane.add(txtAnzStückzahl, gbc_txtAnzStückzahl);
		
		
		txtTakt = new JTextField();
		txtTakt.setText("1");
		
		//Listener für das Textfeld bei Eingabe
		txtTakt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				txtAnzStückzahl.setText(""+ berechnen1(Double.parseDouble(txtTakt.getText().replace(',', '.')),Double.parseDouble((String)comboBox.getSelectedItem())));
				
				lblAnzhwoche.setText(txtHpWoche(1, (String)comboBox.getSelectedItem()));
				
			
			
			
			}
		
		});
		
		//Listener für die ComboBox
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				lblAnzhwoche.setText(txtHpWoche(1, (String)comboBox.getSelectedItem()));
				
				txtAnzStückzahl.setText(""+ berechnen1(Double.parseDouble(txtTakt.getText().replace(',', '.')),Double.parseDouble((String)comboBox.getSelectedItem())));
			}
		});
		
		
		GridBagConstraints gbc_txtTakt = new GridBagConstraints();
		gbc_txtTakt.insets = new Insets(0, 0, 5, 5);
		gbc_txtTakt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTakt.gridx = 0;
		gbc_txtTakt.gridy = 3;
		contentPane.add(txtTakt, gbc_txtTakt);
		txtTakt.setColumns(10);
		
		JLabel lblTaktzeit = new JLabel("Taktzeit");
		GridBagConstraints gbc_lblTaktzeit = new GridBagConstraints();
		gbc_lblTaktzeit.insets = new Insets(0, 0, 5, 0);
		gbc_lblTaktzeit.gridx = 1;
		gbc_lblTaktzeit.gridy = 3;
		contentPane.add(lblTaktzeit, gbc_lblTaktzeit);
		
		
		
		JLabel lblFzg = new JLabel("FZG");
		GridBagConstraints gbc_lblFzg = new GridBagConstraints();
		gbc_lblFzg.insets = new Insets(0, 0, 5, 0);
		gbc_lblFzg.gridx = 1;
		gbc_lblFzg.gridy = 4;
		contentPane.add(lblFzg, gbc_lblFzg);
	
		
	
	}//ende Stückzahlrechner
	/*
	public double berechnen(double takt_temp, double effektiveArbeitszeit_temp){
		
		double fzgD_temp=0;
		
		fzgD_temp = effektiveArbeitszeit_temp / takt_temp;
		
		return fzgD_temp;
		
	}//ende Berechnen
	*/
	
	
	public double berechnen1(double takt_temp, double effektiveArbeitszeit_temp) {
		
		
		//Berechnung der Fzg pro Schicht
		double fzgD_temp=0;
		fzgD_temp = effektiveArbeitszeit_temp / takt_temp;
		System.out.println("" + fzgD_temp);
		
		
			
		
		int fzg = (int) Math.round (fzgD_temp*100)/100;
		
		
		
		
		
		return  fzg;
		
	}// ende berechnen1
	
	public String txtHpWoche (double effektiveArbeitszeit, String comb ) {
		
		String h = "?";
		try {
			
			if (comb == "358") {
				h= "33";
			}
			if (comb == "380") {
				h="35";
			}
			if (comb == "391") {
				h= "36";
			}
			if (comb == "402") {
				h= "37";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		return h;
	}
	
}

//ende der KLasse

