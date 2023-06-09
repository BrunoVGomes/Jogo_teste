package meuJogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player implements ActionListener{
	private int x,y;
	private int dx,dy;
	private Image imagem;
	private int altura, largura;
	private final double GRAVIDADE = 7.8;
	private boolean andando;
	
	public Player() {
		this.x = 1;
		this.y = 100;
		andando = false;
		
	}

	public void loadParado() {

		ImageIcon referencia = new ImageIcon("res\\projetopersonagem.png");
		imagem = referencia.getImage();

		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);

		int novaLargura = 88;
		int novaAltura = (largura * novaLargura) / largura;
		imagem = imagem.getScaledInstance(novaLargura, novaAltura, Image.SCALE_DEFAULT);

		altura = novaAltura;
		largura = novaLargura;

	}
	
	public void loadAndando() {
		ImageIcon referencia = new ImageIcon("res\\framewalkgiff.gif");
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		int novaLargura = 88;
		int novaAltura = (largura * novaLargura) / largura;
		imagem = imagem.getScaledInstance(novaLargura, novaAltura, Image.SCALE_DEFAULT);
		
		altura = novaAltura;
	    largura = novaLargura;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(andando == true) {
			paraDireita();
		}
		
	}
	
	public void paraDireita() {
		andando = true;
		loadAndando();
	}
	
	
	/*
	 * public Rectangle getBounds1() { return new Rectangle(x,y,largura,altura); }
	 */
	
	public void update() {
		x += dx;
		y += dy;
		
		if (x < 0) {
	        x = 0;
	    }
		if (x > 800 - largura) {
	        x = 800- largura;
	    }
		
		double velocidadeY = GRAVIDADE;
		y += velocidadeY;
		if (y > 362) { 
	        y = 362;
	        velocidadeY = 0;
	    }
		
	}
	/*public Rectangle getBounds() {
		return new Rectangle(x,y,largura,altura);
    	
    }*/
	
	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		
		/*if(codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_W ) {
            dy = -15;

		}
		if(codigo == KeyEvent.VK_DOWN || codigo == KeyEvent.VK_S ) {
			dy = 0;
		}*/
		
		if(codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A ) {
			
			dx = -5;
			
		}
		if(codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D ) {
			paraDireita();
			dx = 5;
			
		}
	}
	
	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		loadParado();
		
		/*
		 * if(codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_W ) { dy = 0; }
		 * if(codigo == KeyEvent.VK_DOWN || codigo == KeyEvent.VK_S ) { dy = 0; }
		 */
		
		if(codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A ) {
			dx = 0;
		}
		if(codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D ) {
			dx = 0;
		}
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImagem() {
		return imagem;
	}

	


}
