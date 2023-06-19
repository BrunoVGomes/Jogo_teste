package meuJogo;

import javax.swing.JFrame;

import meuJogo.Modelo.Fase;
/*import meuJogo.Modelo.Fase2;*/

public class Container extends JFrame {
	private static final long serialVersionUID = 1L;

	public Container(){
		add(new Fase());
		setTitle("Meu Jogo");
		setSize(1014,631);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Container();
	}
	
}
