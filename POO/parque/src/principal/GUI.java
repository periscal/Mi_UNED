package principal;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI extends JFrame{
	private JTabbedPane pestanas;
	private JPanel registroCliente;
	private JPanel registroTrabajador;
	private JPanel registroAtraccion;
	private JPanel visitantes;
	private JPanel precios;
	private JPanel atracciones;
	private JPanel panelEstad;
	private Estadisticas estadisticas;

	public GUI() {
		/* Almacenamos en la variable objeto "mipantalla" el sistema nativo de ventanas*/
		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		/* Almacenamos en la variable Dimension la resoluci�n de la pantalla de mi monit*/
		Dimension resolucionPantalla = miPantalla.getScreenSize();

		int alturaPantalla = resolucionPantalla.height;
		int anchoPantalla = resolucionPantalla.width;

		super.setBounds(anchoPantalla /2, alturaPantalla / 2, anchoPantalla / 2, alturaPantalla / 2);

		this.estadisticas = parque.estadisticas;

		//=============================================================//
		//------------- PESTAÑA registroCliente -----------------------//
		//=============================================================//
		registroCliente = new JPanel(new GridLayout(4,2)); 

		registroCliente.add( new JLabel("Nombre"));
		JTextField nombreTu = new JTextField(6);
		registroCliente.add(nombreTu);

		registroCliente.add( new JLabel("Apellidos"));
		JTextField apellidosTu = new JTextField(6);
		registroCliente.add(apellidosTu);

		registroCliente.add( new JLabel("Nacimiento"));
		JTextField nacimiento = new JTextField(6);
		registroCliente.add(nacimiento);

		JButton botonCliente = new JButton("Guardar");
		registroCliente.add(botonCliente);

		//=============================================================//
		//------------- PESTAÑA registroTrabajador --------------------//
		//=============================================================//
		registroTrabajador = new JPanel(new GridLayout(4,2)); 

		registroTrabajador.add( new JLabel("Nombre"));
		JTextField nombreTra = new JTextField(6);
		registroTrabajador.add(nombreTra );

		registroTrabajador.add( new JLabel("Apellidos"));
		JTextField apellidosTra  = new JTextField(6);
		registroTrabajador.add(apellidosTra );

		JButton botonTrabajador = new JButton("Guardar");
		registroTrabajador.add(botonTrabajador);

		//=============================================================//
		//------------- PESTAÑA registroAtraccion ---------------------//
		//=============================================================//
		registroAtraccion = new JPanel(); 

		//=============================================================//
		//------------- PESTAÑA estadisticas --------------------------//
		//=============================================================//   	 

		//------ JComboBox de visitantes
		JComboBox<Integer> cvd = new JComboBox<>((Integer[]) estadisticas.visitantesDias.keySet().toArray(new Integer[0]));
		JComboBox<Integer> cvs = new JComboBox<>((Integer[]) estadisticas.visitantesSemanas.keySet().toArray(new Integer[0]));
		JComboBox<Integer> cvm = new JComboBox<>((Integer[]) estadisticas.visitantesMeses.keySet().toArray(new Integer[0]));
		JComboBox<Integer> cva = new JComboBox<>(new Integer[0]);
		
		JTextField tvd = new JTextField();
		JTextField tvs = new JTextField();
		JTextField tvm = new JTextField();
		JTextField tva = new JTextField();

		cvd.addItemListener(new ItemListener() {
			@Override public void itemStateChanged(ItemEvent arg0) {
				tvd.setText(String.valueOf(estadisticas.visitantesDia((int) cvd.getSelectedItem())));
			}});
		cvs.addItemListener(new ItemListener() {
			@Override public void itemStateChanged(ItemEvent arg0) {
				tvs.setText(String.valueOf(estadisticas.visitantesSemana((int)cvs.getSelectedItem())));
			}});
		cvm.addItemListener(new ItemListener() {
			@Override public void itemStateChanged(ItemEvent arg0) {
				tvm.setText(String.valueOf(estadisticas.visitantesMes((int)cvm.getSelectedItem())));
			}});
		cva.addItemListener(new ItemListener() {
			@Override public void itemStateChanged(ItemEvent arg0) {
				tva.setText(String.valueOf(estadisticas.visitantesAno((int)cva.getSelectedItem())));
			}});

		//------- JComboBox  de Precios
		JComboBox<Integer> cpd = new JComboBox<>((Integer[]) estadisticas.preciosDia.keySet().toArray(new Integer[0]));
		JComboBox<Integer> cps = new JComboBox<>((Integer[]) estadisticas.preciosSemana.keySet().toArray(new Integer[0]));
		JComboBox<Integer> cpm = new JComboBox<>((Integer[]) estadisticas.preciosMes.keySet().toArray(new Integer[0]));
		JComboBox<Integer> cpa = new JComboBox<>(new Integer[0]);
		
		JTextField tpd = new JTextField();
		JTextField tps = new JTextField();
		JTextField tpm = new JTextField();
		JTextField tpa = new JTextField();

		cpd.addItemListener(new ItemListener() {
			@Override public void itemStateChanged(ItemEvent arg0) {
				tpd.setText(String.valueOf(estadisticas.precioDia((int)cpd.getSelectedItem())));
			}});
		cps.addItemListener(new ItemListener() {
			@Override public void itemStateChanged(ItemEvent arg0) {
				tps.setText(String.valueOf(estadisticas.precioSemana((int)cps.getSelectedItem())));
			}});
		cpm.addItemListener(new ItemListener() {
			@Override public void itemStateChanged(ItemEvent arg0) {
				tpm.setText(String.valueOf(estadisticas.precioMes((int)cpm.getSelectedItem())));
			}});
		cpa.addItemListener(new ItemListener() {
			@Override public void itemStateChanged(ItemEvent arg0) {
				tpa.setText(String.valueOf(estadisticas.visitantesAno((int)cpa.getSelectedItem())));
			}});

		// ========================================================================
		visitantes 	= new JPanel(new GridLayout(6,3,2,2));
		precios 	= new JPanel(new GridLayout(6,3,2,2));
		atracciones = new JPanel();
		
		visitantes.add(new JLabel("VISITANTES"));
		visitantes.add(new JLabel("Promedio"));
		visitantes.add(new JLabel("Indice"));
		visitantes.add(new JLabel("Específico"));
		
		visitantes.add(new JLabel("Dia"));
		JTextField tpvd = new JTextField(3);visitantes.add(tpvd);visitantes.add(cvd);visitantes.add(tvd);
		visitantes.add(new JLabel("Semana"));
		JTextField tpvs = new JTextField(3);visitantes.add(tpvs);visitantes.add(cvs);visitantes.add(tvs);
		visitantes.add(new JLabel("Mes"));
		JTextField tpvm = new JTextField(3);visitantes.add(tpvm);visitantes.add(cvm);visitantes.add(tvm);
		visitantes.add(new JLabel("Año"));
		JTextField tpva = new JTextField(3);visitantes.add(tpva);visitantes.add(cva);visitantes.add(tva);
		
		precios.add(new JLabel("PRECIOS"));
		precios.add(new JLabel("Promedio"));
		precios.add(new JLabel("Indice"));
		precios.add(new JLabel("Específico"));
		
		precios.add(new JLabel("Dia"));
		JTextField tppd = new JTextField(3);precios.add(tppd);precios.add(cpd);precios.add(tpd);
		precios.add(new JLabel("Semana"));
		JTextField tpps = new JTextField(3);precios.add(tpps);precios.add(cps);precios.add(tps);
		precios.add(new JLabel("Mes"));
		JTextField tppm = new JTextField(3);precios.add(tppm);precios.add(cpm);precios.add(tpm);
		precios.add(new JLabel("Año"));
		JTextField tppa = new JTextField(3);precios.add(tppa);precios.add(cpa);precios.add(tpa);

		//----------------------------------------------------------------
		panelEstad = new JPanel();
		panelEstad.setLayout(new BoxLayout(panelEstad,BoxLayout.Y_AXIS));
		JTabbedPane pestanasEstad = new JTabbedPane();
		JButton calcularEstad = new JButton(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				estadisticas.calcular();
				pestanasEstad.repaint();
				tpvd.setText(String.valueOf(estadisticas.visitantesPromDia()));
				tpvs.setText(String.valueOf(estadisticas.visitantesPromSemana()));
				tpvm.setText(String.valueOf(estadisticas.visitantesPromMes()));
				tpva.setText(String.valueOf(estadisticas.visitantesPromAno()));

				tppd.setText(String.valueOf(estadisticas.precioPromDia()));
				tpps.setText(String.valueOf(estadisticas.precioPromSemana()));
				tppm.setText(String.valueOf(estadisticas.precioPromMes()));
				tppa.setText(String.valueOf(estadisticas.precioPromAno()));

				pestanasEstad.repaint();
			}
		});

		calcularEstad.setText("Calcular");
		pestanasEstad.add("Visitantes",visitantes);
		pestanasEstad.add("Precios", precios);
		pestanasEstad.add("Atracciones", atracciones);

		panelEstad.add(pestanasEstad);
		panelEstad.add(calcularEstad);

		//=============================================================//
		//-------------------------------------------------------------//
		//=============================================================//  
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pestanas = new JTabbedPane(); 
		pestanas.add("Turistas",registroCliente);
		pestanas.add("Trabajadores",registroTrabajador);
		pestanas.add("Atracciones",registroAtraccion);
		pestanas.add("Estadísticas",panelEstad);
		super.getContentPane().add(pestanas);
		super.pack();
	}
}
