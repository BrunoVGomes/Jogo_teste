package meuJogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.lang.reflect.Array;

import javax.swing.ImageIcon;

public class Portas {
    private int x,y;
    private Image imagem;
    private int altura, largura;
    private int[] listaPortas;
    
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
		return new Rectangle(x,y,largura,altura);
    	
    }
    public Portas[] portaChata() {
    	listaPortas[1] = largura*altura;
    	listaPortas[2] = largura*altura;
    	listaPortas[3] = 65*25;
		return null;
    }

	public int getX() {
		return 100;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
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
