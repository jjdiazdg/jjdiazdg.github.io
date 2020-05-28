package vistas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class VentanaPrincipal extends JFrame {

	private JPanel pnZonaTrabajo;
	private VistaPartidos pnPartidos;

	public VentanaPrincipal() {
		super();
		setTitle("Datos Deportivos DIM XLII");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 700);

		// menu principal

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnVistas = new JMenu("Vistas");
		menuBar.add(mnVistas);

		JMenuItem miPartidos = new JMenuItem("Partidos");
		miPartidos.setActionCommand("mostrar-partidos");
		miPartidos.addActionListener(listenerNavegacion);
		mnVistas.add(miPartidos);

		JMenuItem miParticipantes = new JMenuItem("Participantes");
		miParticipantes.setActionCommand("mostrar-participantes");
		miParticipantes.addActionListener(listenerNavegacion);
		mnVistas.add(miParticipantes);

		JMenuItem miSucesos = new JMenuItem("Sucesos");
		miSucesos.setActionCommand("mostrar-sucesos");
		miSucesos.addActionListener(listenerNavegacion);
		mnVistas.add(miSucesos);

		JSeparator separator = new JSeparator();
		mnVistas.add(separator);

		JMenuItem miSalir = new JMenuItem("Salir");
		miSalir.setActionCommand("salir");
		miSalir.addActionListener(listenerNavegacion);
		mnVistas.add(miSalir);

		// Cabecera

		JPanel pnCabecera = new JPanel();
		pnCabecera.setLayout(new BoxLayout(pnCabecera, BoxLayout.X_AXIS));
		pnCabecera.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnCabecera.setBackground(Color.BLUE);

		JLabel lbTitulo = new JLabel("Datos deportivos");
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTitulo.setForeground(Color.BLUE);
		pnCabecera.add(lbTitulo);

		pnCabecera.add(Box.createHorizontalGlue());

		JButton btpartidos = new JButton("Partidos");
		btpartidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btpartidos.setActionCommand("mostrar-partidos");
		btpartidos.addActionListener(listenerNavegacion);
		pnCabecera.add(btpartidos);

		JButton btparticipantes = new JButton("Participantes");
		btparticipantes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btparticipantes.setActionCommand("mostrar-participantes");
		btparticipantes.addActionListener(listenerNavegacion);
		pnCabecera.add(btparticipantes);

		JButton btsucesos = new JButton("Sucesos");
		btsucesos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btsucesos.setActionCommand("mostrar-sucesos");
		btsucesos.addActionListener(listenerNavegacion);
		pnCabecera.add(btsucesos);

		getContentPane().add(pnCabecera, BorderLayout.PAGE_START);

		// Barra de estado

		JPanel pnBarraEstado = new JPanel();
		pnBarraEstado.add(new JLabel("(c) 2020 DIM XLII"));
		pnBarraEstado.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		getContentPane().add(pnBarraEstado, BorderLayout.PAGE_END);

		// Zona de trabajo

		JPanel pnZonaTrabajo = new JPanel();
		pnZonaTrabajo.setLayout(new CardLayout());

		JPanel pnInicio = new JPanel();
		try {
			JLabel lbFoto = new JLabel(new ImageIcon(new ClassPathResource("imagenes/partidos.jpg").getURL()));
			pnInicio.add(lbFoto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pnZonaTrabajo.add(pnInicio);

//		JPanel pnPartidos = new JPanel();
//		pnPartidos.add(new JLabel("Vista partidos"));
//		pnZonaTrabajo.add(pnPartidos, "partidos");
//		
		JPanel pnParticipantes = new JPanel();
		pnParticipantes.add(new JLabel("Vista participantes"));
		pnZonaTrabajo.add(pnParticipantes, "participantes");

		JPanel pnSucesos = new JPanel();
		pnSucesos.add(new JLabel("Vista sucesos"));
		pnZonaTrabajo.add(pnSucesos, "sucesos");

		getContentPane().add(pnZonaTrabajo, BorderLayout.CENTER);

		setVisible(true);
	}

	private ActionListener listenerNavegacion = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "mostrar-partidos":
				mostrarPartidos();
				break;
			case "mostrar-participantes":
				mostrarParticipantes();
				break;
			case "mostrar-sucesos":
				mostrarSucesos();
				break;
			case "salir":
				System.exit(0);

			default:
				break;

			}

		}
	};

		private void mostrarPartidos() {
			CardLayout layout = (CardLayout) this.pnZonaTrabajo.getLayout();

			if (pnPartidos == null) {
				this.pnPartidos = new VistaPartidos();
				pnZonaTrabajo.add(pnPartidos, "partidos");
			}
			layout.show(pnZonaTrabajo, "partidos");
		}

		private void mostrarParticipantes() {
			CardLayout layout = (CardLayout) this.pnZonaTrabajo.getLayout();
			layout.show(pnZonaTrabajo, "sucesos");


		}

		private void mostrarSucesos() {
			CardLayout layout = (CardLayout) this.pnZonaTrabajo.getLayout();
			layout.show(pnZonaTrabajo, "participantes");

		}

}
