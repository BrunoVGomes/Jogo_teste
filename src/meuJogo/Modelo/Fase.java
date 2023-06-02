package meuJogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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
	private List<Portas> porta;
	private boolean emJogo;
	
	
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
		porta = new ArrayList<Portas>();
		portas = new Portas();
		portas.load();
		porta.add(portas);
		
		emJogo = true;
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if (emJogo == true) {
			//Array[] listaDePortas = new Array[3];

			graficos.drawImage(fundo, 0, 0, null);
			
			for(int i = 0; i<porta.size();i++) {
				Portas tempPortas = porta.get(i);
				graficos.drawImage(tempPortas.getImagem(null), tempPortas.getX(), tempPortas.getY(), null);
				
			}
			
			/*
			 * for (Portas tempPortas : porta) { graficos.drawImage(porta.getImagem(null),
			 * porta.getX(), porta.getY(), null); }
			 */
			
			/*
			 * graficos.drawImage(portas.getImagem(listaDePortas[0]), 100, 246, null);
			 * graficos.drawImage(portas.getImagem(listaDePortas[1]), 300, 246, null);
			 * graficos.drawImage(portas.getImagem(listaDePortas[2]), 500, 246, null);
			 */

			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

		}else {
			System.out.println("ai ai ai");
		}
		g.dispose();

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		player.update();
		repaint();

	}
	
	
	
	

	
	public void checarColisao() {
		Rectangle formaPlayer = player.getBounds();
		Rectangle formaPorta = portas.getBounds();

		for (int i = 0; i < porta.size(); i++) {
			Portas tempPortas = porta.get(i);
			formaPorta = tempPortas.getBounds();
			
			if(formaPlayer.intersects(formaPorta)) {
				emJogo = false;
				System.out.println("papi do céu");
			}

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
