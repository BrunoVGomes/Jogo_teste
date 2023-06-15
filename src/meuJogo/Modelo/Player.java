package meuJogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	/**
	 * 
	 */
	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private final double GRAVIDADE = 7.8;

	public Player() {
		this.x = 1;
		this.y = 100;
	}

	public void loadAndando() {
		ImageIcon referencia = new ImageIcon("res\\framewalkgiff.gif");
		imagem = referencia.getImage();

		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);

		int novaLargura = 111;
		int novaAltura = (largura * novaLargura) / largura;
		imagem = imagem.getScaledInstance(novaLargura, novaAltura, Image.SCALE_DEFAULT);

		altura = novaAltura;
		largura = novaLargura;
	}
	public void update() {
		x += dx;
		y += dy;
		if (x < 0) {
			x = 0;
		}
		if (x > 1014 - largura) {
			x = 1014 - largura;
		}
		double velocidadeY = GRAVIDADE;
		y += velocidadeY;
		if (y > 364) {
			y = 364;
			velocidadeY = 0;
		}

	}
	public void updateDois() {
		x += dx;
		y += dy;
		if (x < 65) {
			x = 65;
		}
		if (x > 954 - largura) {
			x = 954 - largura;
		}
		double velocidadeY = GRAVIDADE;
		y += velocidadeY;
		if (y > 360) {
			y = 360;
			velocidadeY = 0;
		}

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
			dx = -11;
		}
		if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
			dx = 11;

		}
	}
	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) {
			dx = 0;
		}
		if (codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) {
			
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

	
	  public void actionPerformed(ActionEvent e) {
	  
	 }

}