package meuJogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.lang.reflect.Array;

import javax.swing.ImageIcon;

public class Portas {
    private int x,y;
    private Image imagem;
    private int altura, largura;
    //private int[] listaPortas;
    
    public Portas() {
    	this.x = 50;
    	this.y = 50;
    }
    
    public void load() {
    	ImageIcon referencia = new ImageIcon("res\\portaframe1.png");
    	imagem = referencia.getImage();
    	
    	largura = imagem.getWidth(null);	
    	altura = imagem.getHeight(null);
    	
    }
	public Rectangle getBounds() {
		return new Rectangle(x,y,altura,largura);
	}

	/*
	 * public Portas[] portaChata() { listaPortas[1] = largura*altura;
	 * listaPortas[2] = largura*altura; listaPortas[3] = 65*25;
	 * 
	 * }
	 */

	public int getX(int x) {
		/*
		 * int [] valoresX = new int[3]; valoresX[0]=100; valoresX[1]=200;
		 * valoresX[2]=300;
		 */
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY(int y) {
		return 246;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImagem(Array listaPorta) {
		return imagem;
	}

	public Portas get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
}
