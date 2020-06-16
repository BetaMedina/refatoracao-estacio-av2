package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Models.Livro;

public final class CadastroLivroController implements ActionListener {
        static private CadastroLivroController INSTANCE;

        final static private int initialYearLoop = 1900; 
	private JTextField fieldTitle;
	private JTextField fieldAuthor;
	private JComboBox comboGender;
	private JComboBox comboYear;
	private JCheckBox isRead;
	private List<Livro> listLivros;

	
	public CadastroLivroController(
			JTextField fieldTitle, 
			JTextField fieldAuthor,
			JComboBox comboGender,
			JComboBox comboYear,
			JCheckBox isRead) {
		
		this.fieldTitle = fieldTitle;
		this.fieldAuthor = fieldAuthor;
		this.isRead = isRead;

		listLivros = new ArrayList<>();
		
		this.populateComboYear(comboYear);
		this.populateComboGener(comboGender);
                

	}

    private CadastroLivroController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	private void populateComboYear(JComboBox comboYear) {
		this.comboYear = comboYear;
		
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR); 
		
		for (int yearLoop = anoAtual ; yearLoop >= this.initialYearLoop ; yearLoop --) {
			this.comboYear.addItem(yearLoop);
		}
	}
	
	private void populateComboGener(JComboBox comboGender) {
		this.comboGender = comboGender;
		String[] genders = new String[] { "Terror", "Ficção", "Drama", "Aventura", "Comédia", "Técnico" };
		for (String genderLoop : genders) {
			this.comboGender.addItem(genderLoop);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.getActionCommand());
		this.cadastrarLivro();
	}
        
        public static CadastroLivroController getInstance(
			JTextField fieldTitle, 
			JTextField fieldAuthor,
			JComboBox comboGender,
			JComboBox comboYear,
			JCheckBox isRead){
            
            INSTANCE = new CadastroLivroController(fieldTitle, fieldAuthor,comboGender,comboYear,isRead);
            return INSTANCE;
        }
	
	public void cadastrarLivro() {
		
		Livro livro = new Livro(
				this.fieldTitle.getText(), 
				this.fieldAuthor.getText(),
				this.comboGender.getSelectedItem().toString(),
				Integer.parseInt(this.comboYear.getSelectedItem().toString()),
				this.isRead.isSelected()
				);
		
		listLivros.add(livro);
		
		for (int i = 0 ; i < listLivros.size() ; i ++ ) {
			System.out.println(listLivros.get(i).toString());
		}
		
	}

}
