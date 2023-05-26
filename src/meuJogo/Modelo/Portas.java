package meuJogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Portas {
    private int x,y;
    private Image imagem;
    private int altura, largura;
    
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

	public Image getImagem() {
		return imagem;
	}
    
    
    
}
