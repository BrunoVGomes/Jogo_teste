package meuJogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image fundo;
	private Player player;
	private Timer timer;
	private int altura, largura;
	private Portas portas;

	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon referencia = new ImageIcon("res//cenario1.png");
		fundo = referencia.getImage();
		altura = fundo.getHeight(null);
		largura = fundo.getWidth(null);

		int novaLargura = 800;
		int novaAltura = 565;
		fundo = fundo.getScaledInstance(novaLargura, novaAltura, Image.SCALE_DEFAULT);

		altura = novaAltura;
		largura = novaLargura;

		player = new Player();
		player.loadAndando();
		//player.loadParado();
		addKeyListener(new tecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		portas = new Portas();
		portas.load();
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;

		Array[] listaDePortas = new Array[3];

		graficos.drawImage(fundo, 0, 0, null);

		graficos.drawImage(portas.getImagem(listaDePortas[0]), 100, 246, null);
		graficos.drawImage(portas.getImagem(listaDePortas[1]), 300, 246, null);
		graficos.drawImage(portas.getImagem(listaDePortas[2]), 500, 246, null);

		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		player.update();
		repaint();

	}
	
	
	
	

	
	public void checarColisao() {
		Rectangle formaPlayer = player.getBounds1();
		Rectangle formaPorta = portas.getBounds();

		for (int i = 0; i < portas.getX(); i++) {
			Portas tempPortas = portas.get(i);

		}

	}
	 

	private class tecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}
	}

}
