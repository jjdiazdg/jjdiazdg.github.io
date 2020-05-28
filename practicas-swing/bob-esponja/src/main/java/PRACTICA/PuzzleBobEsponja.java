package PRACTICA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PuzzleBobEsponja extends JFrame {

	JPanel pnTablero;
	List<PiezaPuzzle> piezas;
	
	public PuzzleBobEsponja() {
		super();
	
//		Aspectos visuales basicos
		setTitle("Puzzle Bob Esponja");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Inicializar las propiedades		
		pnTablero = new JPanel();
		piezas = new ArrayList<PiezaPuzzle>();
		
		
//		Establecer el Layout del panel contenido	
		getContentPane().setLayout(new BorderLayout());
		
		
//		Cabecera
		JPanel pnCabecera = new JPanel();
		JLabel lbTitulo = new JLabel("Use las teclas del cursor");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnCabecera.add(lbTitulo);
	
		getContentPane().add(pnCabecera, BorderLayout.PAGE_START);
		
//		Tablero
		pnTablero.setLayout(new GridLayout(3, 3, 2, 2));
		pnTablero.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		pnTablero.setFocusable(true);
		
		
//		Anadir piezas
		for (int i = 1; i<=8; i++) {
			PiezaPuzzle pieza = new PiezaPuzzle(i);
			pnTablero.add(pieza);
			piezas.add(pieza);
		}
		
		PiezaPuzzle hueco = new PiezaPuzzle(0);
		pnTablero.add(hueco);
		piezas.add(hueco);
		
		getContentPane().add(pnTablero, BorderLayout.CENTER);
		
// 		Ajustar el tamano		
		
		pack();
		
	}

	private class PiezaPuzzle extends JLabel{
		
		private int numPieza;
		
		public int getNumPieza() {
		return this.numPieza;
	}
		
		public PiezaPuzzle(int numPieza) {
			super();		
			this.numPieza = numPieza;
			setText(numPieza + "");
			setBackground(Color.CYAN);
			setOpaque(true);
			}
	}
	
	public static void main(String[] args) {
		PuzzleBobEsponja puzzle = new PuzzleBobEsponja();
		puzzle.setVisible(true);
				
	}

}
