package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import DAO.LivroDAO;
import Views.CadastroLivroView;

public final class IniitController implements ActionListener {

	static private IniitController INSTANCE;
	private CadastroLivroView cadastroView;
	
	public IniitController(CadastroLivroView cadastroView) {
		this.cadastroView = cadastroView;
	}
	
        
        public static IniitController getInstance(CadastroLivroView cadastroView){
            INSTANCE = new IniitController(cadastroView);
            return INSTANCE;
        }
        
        
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getActionCommand()){
		case "Cadastrar": this.abrirCadastroView();
		break;
		case "Exibir": this.abrirExibirView();
		break;
		}
	}
	
	
	private void abrirCadastroView() {
		cadastroView = new CadastroLivroView();
		cadastroView.setVisible(true);
		
		abrirExibirView();
	}
	
	public void abrirExibirView() {
		LivroDAO livroDao;
		try {
			livroDao = new LivroDAO();
			System.out.println(livroDao.getAllLivros());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
