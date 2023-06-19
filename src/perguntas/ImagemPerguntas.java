package perguntas;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImagemPerguntas {

	private int x, y;
	private Image imagem;
	private int altura, largura;


	public void load() {
		
		ImageIcon referencia1 = new ImageIcon("res\\caixinhaPergunta1.png");
		imagem = referencia1.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);

		
	}

	public Image getImagem() {
		return imagem;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
