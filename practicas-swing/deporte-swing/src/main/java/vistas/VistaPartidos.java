package vistas;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import org.springframework.core.io.ClassPathResource;

public class VistaPartidos extends JPanel {

	public VistaPartidos() {
		
		setLayout(new BorderLayout());
		
		// Barra de herramientas
		JToolBar tbOpciones = new JToolBar();	
		add(tbOpciones, BorderLayout.PAGE_START);
		
		try {
			ImageIcon iconoCrear = new ImageIcon(new ClassPathResource("imagenes/crear.png").getURL());
			JButton btCrearPartido = new JButton("Crear partidos", iconoCrear);
			tbOpciones.add(btCrearPartido);
			
			ImageIcon iconoBorrar = new ImageIcon(new ClassPathResource("imagenes/borrar.png").getURL());
			JButton btBorrarPartido = new JButton("Borrar partidos", iconoBorrar);
//			tbOpciones.add(btBorrarPartido);
			
			ImageIcon iconoEditar = new ImageIcon(new ClassPathResource("imagenes/editar.png").getURL());
			JButton btEditarPartido = new JButton("Editat partidos", iconoEditar);
			tbOpciones.add(btEditarPartido);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Vista maestro detalle
		
		JSplitPane pnContenido = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(pnContenido, BorderLayout.CENTER);
		
		JPanel pnMaestro = new JPanel();
		pnContenido.add(pnMaestro);
		
		JPanel pnDetalle = new JPanel();
		pnContenido.add(pnDetalle);
		
		
		// Vista maestro
		
		pnMaestro.setLayout(new BorderLayout());
		
		JPanel pnFiltroPartidos = new JPanel();
		pnMaestro.add(pnFiltroPartidos, BorderLayout.PAGE_START);
		
		pnFiltroPartidos.add(new JLabel("Filtrar por equipo"));
		JComboBox<String> cbFiltroParticipante = new JComboBox<String>(new String[] 
				{"(Mostrar todos)", "ATLETICO", "MADRID"});
		pnFiltroPartidos.add(cbFiltroParticipante);
		
		JButton btFiltrar = new JButton("filtrar");
		pnFiltroPartidos.add(btFiltrar);
		
		// Table de partidos
		
		JTable gridPartidos = new JTable(new Object[][] {
			
			{"25/4/2020", "20:00", "REAL MADRID", "ATLETICO"},
			{"22/4/2020", "10:00", "BETIS", "REAL ZARAGOZA"}
		}, new Object[] {"Fecha", "Hora", "Local", "Visitante"});
		
		pnMaestro.add(new JScrollPane(gridPartidos), BorderLayout.CENTER);
	}

}



