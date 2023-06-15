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

	private static final long serialVersionUID = 1L;
	private Image fundo, imagem;
	private Player player;
	private Timer timer;
	private int altura, largura;
	private Portas porta;
	private ArrayList<Portas> portas;
	private boolean emJogo;

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
		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		portas = new ArrayList<Portas>();

		Portas portaUm = new Portas();
		portaUm.load();
		portas.add(portaUm);

		Portas portaDois = new Portas();
		portaDois.load();
		portas.add(portaDois);

		Portas portaTres = new Portas();
		portaTres.load();
		portas.add(portaTres);

		emJogo = true;

	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		super.paint(g);

		if (emJogo == true) {

			graficos.drawImage(fundo, 0, 0, null);

			for (int i = 0; i < portas.size(); i++) {

				Portas imgPortas = portas.get(i);
				graficos.drawImage(imgPortas.getImagem(null), imgPortas.getX(185), imgPortas.getY(270), null);
				graficos.drawImage(imgPortas.getImagem(null), imgPortas.getX(385), imgPortas.getY(270), null);
				graficos.drawImage(imgPortas.getImagem(null), imgPortas.getX(585), imgPortas.getY(270), null);
			}

			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		}

		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		player.update();
		repaint();

	}

	public boolean colide(Player player, Portas portas) {
		Rectangle playerBounds = player.getBounds();
		Rectangle portaBounds = portas.getBounds();

		if (playerBounds.intersects(portaBounds)) {
			return true;
		}
		return false;
	}

	public void verificarColisao() {
		Portas portaUm = portas.get(0);
		Portas portaDois = portas.get(1);
		Portas portaTres = portas.get(2);

		if (colide(player, portaUm)) {

			System.out.println("Golaço");

		} else if (colide(player, portaDois)) {

			System.out.println("Perneira");

		} else if (colide(player, portaTres)) {

			System.out.println("papi");
		}
	}

	private class TecladoAdapter extends KeyAdapter {

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
