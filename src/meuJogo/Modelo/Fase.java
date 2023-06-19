
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

import perguntas.ImagemPerguntas;

public class Fase extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Image fundo;
	private Player player;
	private ImagemPerguntas imgPerguntas;
	Timer timer;
	private int altura, largura;
	private ArrayList<Portas> portas = new ArrayList<Portas>();
	private boolean emJogo;
	private boolean[] portasFechadas = new boolean[3];

	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon referencia = new ImageIcon("res//cenario1.png");
		fundo = referencia.getImage();
		altura = fundo.getHeight(null);
		largura = fundo.getWidth(null);

		int novaLargura = 999;
		int novaAltura = 595;
		fundo = fundo.getScaledInstance(novaLargura, novaAltura, Image.SCALE_DEFAULT);

		altura = novaAltura;
		largura = novaLargura;
        
		player = new Player();
		player.loadAndando();
		addKeyListener(new tecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		Portas porta1 = new Portas();
		porta1.setX(185);
		porta1.setY(270);
		porta1.load();
		portas.add(porta1);

		Portas porta2 = new Portas();
		porta2.setX(385);
		porta2.setY(270);
		porta2.load();
		portas.add(porta2);

		Portas porta3 = new Portas();
		porta3.setX(585);
		porta3.setY(270);
		porta3.load();
		portas.add(porta3);

		for (int i = 0; i < 3; i++) {
			portasFechadas[i] = true;
		}
		
		imgPerguntas = new ImagemPerguntas();
        imgPerguntas.setX(255);
        imgPerguntas.setY(10);
        imgPerguntas.load();
        
		emJogo = true;
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		super.paint(g);

		if (emJogo) {
			graficos.drawImage(fundo, 0, 0, null);
			graficos.drawImage(portas.get(0).getImagem(), portas.get(0).getX(), portas.get(0).getY(), null);
			graficos.drawImage(portas.get(1).getImagem(), portas.get(1).getX(), portas.get(1).getY(), null);
			graficos.drawImage(portas.get(2).getImagem(), portas.get(2).getX(), portas.get(2).getY(), null);
			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
			graficos.drawImage(imgPerguntas.getImagem(),imgPerguntas.getX(),imgPerguntas.getY(),null);
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		verificarColisao();
		repaint();
	}
	
	public boolean entrarPorta(KeyEvent tecla) {
		
		if (tecla.getKeyCode() == KeyEvent.VK_SPACE);
		return true;
	}

	public boolean colide(Player player, Portas porta) {
		Rectangle playerBounds = player.getBounds();
		Rectangle portaBounds = porta.getBounds();

		return playerBounds.intersects(portaBounds);
	}

	public void verificarColisao() {
			if (colide(player, portas.get(0)) && portasFechadas[0]) {
				
//				if(entrarPorta()) {
//					
//				}
				System.out.println("Golaco");
				portasFechadas[0] = false;
			} else if (colide(player, portas.get(1)) && portasFechadas[1]) {
				System.out.println("Perneira");
				portasFechadas[1] = false;
			} else if (colide(player, portas.get(2)) && portasFechadas[2]) {
				System.out.println("papi");
				portasFechadas[2] = false;
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

/*
 * package meuJogo.Modelo;
 * 
 * import java.awt.Graphics; import java.awt.Graphics2D; import java.awt.Image;
 * import java.awt.Rectangle; import java.awt.event.ActionEvent; import
 * java.awt.event.ActionListener; import java.awt.event.KeyAdapter; import
 * java.awt.event.KeyEvent; import java.util.ArrayList;
 * 
 * import javax.swing.ImageIcon; import javax.swing.JPanel; import
 * javax.swing.Timer;
 * 
 * public class Fase extends JPanel implements ActionListener {
 * 
 * private static final long serialVersionUID = 1L; private Image fundo, imagem;
 * private Player player; private Timer timer; private int altura, largura;
 * private Portas porta; private ArrayList<Portas> portas; private boolean
 * emJogo; private boolean[] portaFechadas = new boolean[3];
 * 
 * public Fase() { setFocusable(true); setDoubleBuffered(true);
 * 
 * ImageIcon referencia = new ImageIcon("res//cenario1.png"); fundo =
 * referencia.getImage(); altura = fundo.getHeight(null); largura =
 * fundo.getWidth(null);
 * 
 * int novaLargura = 999; int novaAltura = 595; fundo =
 * fundo.getScaledInstance(novaLargura, novaAltura, Image.SCALE_DEFAULT);
 * 
 * altura = novaAltura; largura = novaLargura;
 * 
 * player = new Player(); player.loadAndando(); addKeyListener(new
 * TecladoAdapter());
 * 
 * timer = new Timer(5, this); timer.start();
 * 
 * portas = new ArrayList<Portas>();
 * 
 * Portas portaUm = new Portas(); portaUm.load(); portas.add(portaUm);
 * 
 * Portas portaDois = new Portas(); portaDois.load(); portas.add(portaDois);
 * 
 * Portas portaTres = new Portas(); portaTres.load(); portas.add(portaTres);
 * 
 * for (int i = 0; i < 3; i++) { portaFechadas[i] = true; }
 * 
 * 
 * emJogo = true;
 * 
 * }
 * 
 * public void paint(Graphics g) { Graphics2D graficos = (Graphics2D) g;
 * super.paint(g);
 * 
 * if (emJogo) {
 * 
 * graficos.drawImage(fundo, 0, 0, null);
 * 
 * for (int i = 0; i < portas.size(); i++) {
 * 
 * Portas imgPortas = portas.get(i);
 * graficos.drawImage(imgPortas.getImagem(null), imgPortas.getX(185),
 * imgPortas.getY(270), null); graficos.drawImage(imgPortas.getImagem(null),
 * imgPortas.getX(385), imgPortas.getY(270), null);
 * graficos.drawImage(imgPortas.getImagem(null), imgPortas.getX(585),
 * imgPortas.getY(270), null); }
 * 
 * graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this); }
 * 
 * g.dispose();
 * 
 * }
 * 
 * @Override public void actionPerformed(ActionEvent e) {
 * 
 * player.update(); verificarColisao(); repaint();
 * 
 * }
 * 
 * public boolean colide(Player player, Portas porta) { Rectangle playerBounds =
 * player.getBounds(); Rectangle portaBounds = porta.getBounds();
 * 
 * return playerBounds.intersects(portaBounds); }
 * 
 * public void verificarColisao() {
 * 
 * Portas portaUm = portas.get(0); Portas portaDois = portas.get(1); Portas
 * portaTres = portas.get(2);
 * 
 * 
 * if (colide(player, portas.get(0)) && portaFechadas[0]) {
 * 
 * System.out.println("Golaço"); portaFechadas[0] = false;
 * 
 * } else if (colide(player, portas.get(1)) && portaFechadas[1]) {
 * 
 * System.out.println("Perneira"); portaFechadas[1] = false;
 * 
 * } else if (colide(player, portas.get(2)) && portaFechadas[2]) {
 * 
 * System.out.println("papi"); portaFechadas[2] = false; } }
 * 
 * private class TecladoAdapter extends KeyAdapter {
 * 
 * @Override public void keyPressed(KeyEvent e) { player.keyPressed(e);
 * 
 * }
 * 
 * @Override public void keyReleased(KeyEvent e) { player.keyRelease(e); } }
 * 
 * }
 */