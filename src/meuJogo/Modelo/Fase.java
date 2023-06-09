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

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image fundo, imagem;
	private Player player;
	// player = new Player(this);
	private Timer timer;
	private int altura, largura;
	private Portas porta;
	private ArrayList<Portas> portas;
	private boolean emJogo;

	// private ArrayList<Portas> listaPortas;
	// Portas[] listaPorta = (Portas[]) portas.portaChata();

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
		// player.loadParado();
		addKeyListener(new tecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		portas = new ArrayList<Portas>();
		Portas porta1 = new Portas();
		porta1.load();
		portas.add(porta1);

		Portas porta2 = new Portas();
		porta2.load();
		portas.add(porta2);

		Portas porta3 = new Portas();
		porta3.load();
		portas.add(porta3);
		
		verificarColisao();

		emJogo = true;

		// checarColisao();
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		super.paint(g);
		if (emJogo == true) {
			// Array[] listaDePortas = new Array[3];

			graficos.drawImage(fundo, 0, 0, null);

			for (int i = 0; i < portas.size(); i++) {
				Portas tempPortas = portas.get(i);
				graficos.drawImage(tempPortas.getImagem(null), tempPortas.getX(100), tempPortas.getY(246), null);
				graficos.drawImage(tempPortas.getImagem(null), tempPortas.getX(300), tempPortas.getY(246), null);
				graficos.drawImage(tempPortas.getImagem(null), tempPortas.getX(500), tempPortas.getY(246), null);

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

			// Array[] listaDePortas = new Array[3];

			/*
			 * for (int i = 0; i < listaPorta.length; i++) { Portas passagem =
			 * listaPorta[1]; passagem.load(); // graficos.drawImage(passagem.getImagem(),
			 * 100, 246, null);
			 * 
			 * }
			 */
			/*
			 * graficos.drawImage(portas.getImagem(listaDePortas[0]), 100, 246, null);
			 * graficos.drawImage(portas.getImagem(listaDePortas[1]), 300, 246, null);
			 * graficos.drawImage(portas.getImagem(listaDePortas[2]), 500, 246, null);
			 */
			// checarColisao();

		} /*
			 * else { System.out.println("ai ai ai"); }
			 */
		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		player.update();
		repaint();

	}

	/*
	 * public void checarColisao() { Rectangle formaPlayer = player.getBounds();
	 * Rectangle formaPorta = porta.getBounds(); boolean colidiu = false;
	 * 
	 * for (int i = 0; i < portas.size(); i++) { Portas tempPortas = portas.get(i);
	 * Rectangle formaPorta1 = tempPortas.getBounds(); formaPorta1 =
	 * tempPortas.getBounds(); if (formaPlayer.intersects(formaPorta1)) { ImageIcon
	 * referencia = new ImageIcon("res\\framewalkgiff.gif"); imagem =
	 * referencia.getImage();
	 * 
	 * System.out.println("bateu aqui"); colidiu = true;
	 * 
	 * } else { System.out.println("to passando liso"); }
	 * 
	 * }
	 * 
	 * emJogo = !colidiu;
	 * 
	 * }
	 */

	public boolean colide(Player player, ArrayList<Portas> portas) {
		Rectangle playerBounds = player.getBounds();
		
		for(Portas porta: portas) {
			Rectangle portaBounds = porta.getBounds();
			if(playerBounds.intersects(portaBounds)) {
				return true;
			}
		}
		return false;
		
	}

	public void verificarColisao() {
		if (colide(player, this.portas)) {
			System.out.println("GOOOOOOOOOOOOOLLL");
		}
	}

	/*
	 * public void checarColisao() { Rectangle formaPlayer = player.getBounds();
	 * Rectangle formaPorta = portas.getBounds();
	 * 
	 * for (int i = 0; i < listaPorta.size(); i++) { Portas tempPortas =
	 * listaPorta.get(i); if(formaPorta.intersects(formaPlayer)) {
	 * System.out.println("MDS DO CEU BERG");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

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
