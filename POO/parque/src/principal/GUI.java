package principal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import atracciones.Atraccion;
import entradas.Entrada;
import turistas.Turista;
/**
 * Write a description of class GUI here.
 * 

 * @author Periscal Porteiro, Juan
 * @version 17/05/2019
 */
public class GUI extends JFrame{
	private Estadisticas estadisticas;
	private AtraccionesFuncionando gastoPersonal;
	
	int atraccionSeleccionada=0;

	public GUI() {
		/* Almacenamos en la variable objeto "mipantalla" el sistema nativo de ventanas*/
		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		/* Almacenamos en la variable Dimension la resolucion de la pantalla de mi monit*/
		Dimension resolucionPantalla = miPantalla.getScreenSize();

		int alturaPantalla = resolucionPantalla.height;
		int anchoPantalla = resolucionPantalla.width;

		super.setBounds(anchoPantalla /2, alturaPantalla / 2, anchoPantalla / 2, alturaPantalla / 2);

		this.estadisticas = Parque.estadisticas;
		this.gastoPersonal = Parque.gastoPersonal;

		// ---------------------------------------------------------------
		Integer[] numDias = new Integer[Year.of(Parque.ANO).length()];
		Integer[] numSemanas = new Integer [53];
		Integer[] numMeses = new Integer [12];

		for(int dia 	= 0; dia<numDias.length;		dia++) 		numDias[dia]=dia+1;
		for(int semana 	= 0; semana<numSemanas.length;	semana++) 	numSemanas[semana]=semana+1;
		for(int mes 	= 0; mes<numMeses.length;		mes++) 		numMeses[mes]=mes+1;

		//=============================================================//
		//------------- PESTAÑA registroCliente -----------------------//
		//=============================================================//
		JPanel registroCliente = new JPanel(new GridLayout(7,2)); 

		registroCliente.add( new JLabel("Nombre"));
		JTextField nombreTu = new JTextField(6);registroCliente.add(nombreTu);

		registroCliente.add( new JLabel("Apellidos"));
		JTextField apellidosTu = new JTextField(6);registroCliente.add(apellidosTu);

		registroCliente.add( new JLabel("Nacimiento (AAAA-MM-dd)"));
		// Mascara para cada cuadro de texto de fecha
		MaskFormatter mascara=new MaskFormatter();
		try {
			mascara.setMask("####-##-##");
		} catch (ParseException e1) {e1.printStackTrace();	}
		mascara.setPlaceholderCharacter('_');
		JTextField nacimiento = new JFormattedTextField(mascara);
		registroCliente.add(nacimiento);

		JCheckBox vip 			= new JCheckBox("VIP");			registroCliente.add(vip);
		JCheckBox familiar 		= new JCheckBox("Familiar");	registroCliente.add(familiar);
		JCheckBox joven 		= new JCheckBox("Carnet Joven");registroCliente.add(joven);
		JCheckBox estudiante 	= new JCheckBox("Estudiante");	registroCliente.add(estudiante);
		JCheckBox discFuncional = new JCheckBox("Discapacidad");registroCliente.add(discFuncional);


		JButton botonCliente = new JButton(new AbstractAction() {
			@Override public void actionPerformed(ActionEvent arg0) {
				Turista t= null;
				Entrada e =null;
				t =Turista.altaTurista(nombreTu.getText(), apellidosTu.getText(), LocalDate.parse(nacimiento.getText()), Parque.fechaActual.toLocalDate());
				e =Entrada.nuevaEntrada(t, Parque.fechaActual, vip.isSelected(), familiar.isSelected());
				if(estudiante.isSelected()) e.descuento(Entrada.Descuentos.ESTUDIANTE);
				if(joven.isSelected()) e.descuento(Entrada.Descuentos.JOVEN);
				if(discFuncional.isSelected()) e.descuento(Entrada.Descuentos.DISCAPACIDAD);
				e.ticket();
			}
		});
		botonCliente.setText("Guardar");
		registroCliente.add(botonCliente);

		//=============================================================//
		//------------- PESTAÑA registroTrabajador --------------------//
		//=============================================================//
		JPanel registroTrabajador = new JPanel(new GridLayout(4,2)); 

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
		JPanel registroAtraccion = new JPanel(); 

		//=============================================================//
		//------------- PESTAÑA estadisticas --------------------------//
		//=============================================================//   	 

		//------ PANEL de TURISTAS -------------
		JComboBox<Integer> cvd = new JComboBox<>((Integer[]) numDias);
		JComboBox<Integer> cvs = new JComboBox<>((Integer[]) numSemanas);
		JComboBox<Integer> cvm = new JComboBox<>((Integer[]) numMeses);
		JComboBox<Integer> cva = new JComboBox<>(new Integer[0]);

		JTextField tvd = new JTextField(3);
		JTextField tvs = new JTextField(3);
		JTextField tvm = new JTextField(3);
		JTextField tva = new JTextField(3);

		cvd.addItemListener( arg0 -> tvd.setText(String.valueOf(estadisticas.visitantesDia((int) cvd.getSelectedItem()))));
		cvs.addItemListener( arg0 -> tvs.setText(String.valueOf(estadisticas.visitantesSemana((int)cvs.getSelectedItem()))));
		cvm.addItemListener( arg0 -> tvm.setText(String.valueOf(estadisticas.visitantesMes((int)cvm.getSelectedItem()))));
		cva.addItemListener( arg0 -> tva.setText(String.valueOf(estadisticas.visitantesAno((int)cva.getSelectedItem()))));

		JPanel visitantes 	= new JPanel(new GridLayout(6,3,2,2));
		visitantes.add(new JLabel("TURISTAS"));
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

		//------- PANEL  de PRECIOS -------------
		JComboBox<Integer> cpd = new JComboBox<>((Integer[]) numDias);
		JComboBox<Integer> cps = new JComboBox<>((Integer[]) numSemanas);
		JComboBox<Integer> cpm = new JComboBox<>((Integer[]) numMeses);
		JComboBox<Integer> cpa = new JComboBox<>(new Integer[0]);

		JTextField tpd = new JTextField(3);
		JTextField tps = new JTextField(3);
		JTextField tpm = new JTextField(3);
		JTextField tpa = new JTextField(3);

		cpd.addItemListener( arg0 -> tpd.setText(String.valueOf(estadisticas.precioDia((int)cpd.getSelectedItem()))));
		cps.addItemListener( arg0 -> tps.setText(String.valueOf(estadisticas.precioSemana((int)cps.getSelectedItem()))));
		cpm.addItemListener(arg0 -> tpm.setText(String.valueOf(estadisticas.precioMes((int)cpm.getSelectedItem()))));
		cpa.addItemListener( arg0 -> tpa.setText(String.valueOf(estadisticas.precioAno((int)cpa.getSelectedItem()))));

		JPanel precios 	= new JPanel(new GridLayout(6,3,2,2));
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


		//------ PANEL de ATRACCIONES -------------
		atraccionSeleccionada=0;

		JComboBox<Integer> cad = new JComboBox<>((Integer[]) numDias);
		JComboBox<Integer> cas = new JComboBox<>((Integer[]) numSemanas);
		JComboBox<Integer> cam = new JComboBox<>((Integer[]) numMeses);
		JComboBox<Integer> caa = new JComboBox<>(new Integer[0]);

		JTextField tad = new JTextField(3);
		JTextField tas = new JTextField(3);
		JTextField tam = new JTextField(3);
		JTextField taa = new JTextField(3);

		cad.addItemListener( arg0 -> tad.setText(String.valueOf(estadisticas.atraccionDia((int) cad.getSelectedItem(),atraccionSeleccionada))));
		cas.addItemListener( arg0 -> tas.setText(String.valueOf(estadisticas.atraccionSemana((int)cas.getSelectedItem(),atraccionSeleccionada))));
		cam.addItemListener( arg0 -> tam.setText(String.valueOf(estadisticas.atraccionMes((int)cam.getSelectedItem(),atraccionSeleccionada))));
		caa.addItemListener( arg0 -> taa.setText(String.valueOf(estadisticas.atraccionAno((int)caa.getSelectedItem(),atraccionSeleccionada))));
	
		//Se crean 2 paneles. Un panel izquierdo donde se podrá seleccionar la la atraccion
		// y otro panel,derecho, donde se visualizará sus estadísticas
		JPanel atracciones = new JPanel();									//Panel que contendrá los dos paneles
		JPanel pEstadAtracc = new JPanel(new GridLayout(6,3,2,2));  //Panel que contendrá las estadísticas de la atracciones seleccionada

		//Conseguimos un array con los identificadores de cada una de las atracciones
		Integer[] a = new Integer[Atraccion.atracciones.size()];
		int i=0;
		for(Atraccion at :Atraccion.atracciones.values()) a[i++]=at.getId();

		JList<Integer> lSelecAtrac = new JList<>(a); // Panel que contendrá las diferentes atracciones a seleccionar
		lSelecAtrac.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lSelecAtrac.setLayoutOrientation(JList.VERTICAL);
		lSelecAtrac.setVisibleRowCount(6);
		JScrollPane listScroller = new JScrollPane(lSelecAtrac);
		
		lSelecAtrac.addListSelectionListener(arg0 -> atraccionSeleccionada = lSelecAtrac.getSelectedValue());
		
		pEstadAtracc.add(new JLabel("ATRACCIONES"));
		pEstadAtracc.add(new JLabel("Promedio"));
		pEstadAtracc.add(new JLabel("Indice"));
		pEstadAtracc.add(new JLabel("Específico"));

		pEstadAtracc.add(new JLabel("Dia"));
		JTextField tpad = new JTextField(3);pEstadAtracc.add(tpad);pEstadAtracc.add(cad);pEstadAtracc.add(tad);
		pEstadAtracc.add(new JLabel("Semana"));
		JTextField tpas = new JTextField(3);pEstadAtracc.add(tpas);pEstadAtracc.add(cas);pEstadAtracc.add(tas);
		pEstadAtracc.add(new JLabel("Mes"));
		JTextField tpam = new JTextField(3);pEstadAtracc.add(tpam);pEstadAtracc.add(cam);pEstadAtracc.add(tam);
		pEstadAtracc.add(new JLabel("Año"));
		JTextField tpaa = new JTextField(3);pEstadAtracc.add(tpaa);pEstadAtracc.add(caa);pEstadAtracc.add(taa);

		atracciones.add(listScroller);
		atracciones.add(pEstadAtracc);
		//----------------------------------------------------------------

		JPanel panelEstad = new JPanel();
		panelEstad.setLayout(new BoxLayout(panelEstad,BoxLayout.Y_AXIS));
		JTabbedPane pestanasEstad = new JTabbedPane();
		JButton calcularEstad = new JButton(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				estadisticas.calcular();
				tpvd.setText(String.valueOf(estadisticas.visitantesPromDia()));
				tpvs.setText(String.valueOf(estadisticas.visitantesPromSemana()));
				tpvm.setText(String.valueOf(estadisticas.visitantesPromMes()));
				tpva.setText(String.valueOf(estadisticas.visitantesPromAno()));

				tppd.setText(String.valueOf(estadisticas.precioPromDia()));
				tpps.setText(String.valueOf(estadisticas.precioPromSemana()));
				tppm.setText(String.valueOf(estadisticas.precioPromMes()));
				tppa.setText(String.valueOf(estadisticas.precioPromAno()));

				tpad.setText(String.valueOf(estadisticas.atraccionPromDia(atraccionSeleccionada)));
				tpas.setText(String.valueOf(estadisticas.atraccionPromSemana(atraccionSeleccionada)));
				tpam.setText(String.valueOf(estadisticas.atraccionPromMes(atraccionSeleccionada)));
				tpaa.setText(String.valueOf(estadisticas.atraccionPromAno(atraccionSeleccionada)));
				/* */				
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
		//------------- PESTAÑA gasto ---------------------------------//
		//=============================================================// 
		
		//------- Informacion de atracciones
		JList<Integer> lSelecAtrac2 = new JList<>(a); // Panel que contendrá las diferentes atracciones a seleccionar
		lSelecAtrac2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lSelecAtrac2.setLayoutOrientation(JList.VERTICAL);
		lSelecAtrac2.setVisibleRowCount(6);
		JScrollPane listScroller2 = new JScrollPane(lSelecAtrac2);
		
		JPanel empleados = new JPanel();
		empleados.setLayout(new BoxLayout(empleados,BoxLayout.Y_AXIS));
		empleados.add(new JLabel("Responsable"));
		JTextField responsable = new JTextField(3);empleados.add(responsable);
		empleados.add(new JLabel("Ayudantes"));
		
		JList<String> ayudantes = new JList<>();
		ayudantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ayudantes.setLayoutOrientation(JList.VERTICAL);
		ayudantes.setVisibleRowCount(6);
		JScrollPane listScroller3 = new JScrollPane(ayudantes);
		
		lSelecAtrac2.addListSelectionListener(arg0 -> {atraccionSeleccionada = lSelecAtrac2.getSelectedValue();
											responsable.setText(Atraccion.atracciones.get(atraccionSeleccionada).getResponsable().getNombre());
											ayudantes.setListData(gastoPersonal.listaAyudantes(atraccionSeleccionada));});
		empleados.add(listScroller3);
		JPanel empleadosAtraccion = new JPanel();
		empleadosAtraccion.add(listScroller2);
		empleadosAtraccion.add(empleados);
		
		//------- JComboBox  de Gastos
		JComboBox<Integer> cgd = new JComboBox<>((Integer[]) numDias);
		JComboBox<Integer> cgs = new JComboBox<>((Integer[]) numSemanas);
		JComboBox<Integer> cgm = new JComboBox<>((Integer[]) numMeses);
		JComboBox<Integer> cga = new JComboBox<>(new Integer[0]);
		
		JTextField tgd = new JTextField();
		JTextField tgs = new JTextField();
		JTextField tgm = new JTextField();
		JTextField tga = new JTextField();

		cgd.addItemListener( arg0 -> tgd.setText(String.valueOf(gastoPersonal.gastoDia((int)cgd.getSelectedItem()))));
		cgs.addItemListener( arg0 -> tgs.setText(String.valueOf(gastoPersonal.gastoSemana((int)cgs.getSelectedItem()))));
		cgm.addItemListener( arg0 -> tgm.setText(String.valueOf(gastoPersonal.gastoMes((int)cgm.getSelectedItem()))));
		cga.addItemListener( arg0 -> tga.setText(String.valueOf(gastoPersonal.gastoAno((int)cga.getSelectedItem()))));

		JPanel panelEstadGasto = new JPanel(new GridLayout(6,3,2,2));
		panelEstadGasto.add(new JLabel("GASTO"));
		panelEstadGasto.add(new JLabel("Promedio"));
		panelEstadGasto.add(new JLabel("Indice"));
		panelEstadGasto.add(new JLabel("Específico"));

		panelEstadGasto.add(new JLabel("Dia"));
		JTextField tpgd = new JTextField(3);panelEstadGasto.add(tpgd);panelEstadGasto.add(cgd);panelEstadGasto.add(tgd);
		panelEstadGasto.add(new JLabel("Semana"));
		JTextField tpgs = new JTextField(3);panelEstadGasto.add(tpgs);panelEstadGasto.add(cgs);panelEstadGasto.add(tgs);
		panelEstadGasto.add(new JLabel("Mes"));
		JTextField tpgm = new JTextField(3);panelEstadGasto.add(tpgm);panelEstadGasto.add(cgm);panelEstadGasto.add(tgm);
		panelEstadGasto.add(new JLabel("Año"));
		JTextField tpga = new JTextField(3);panelEstadGasto.add(tpga);panelEstadGasto.add(cga);panelEstadGasto.add(tga);

		//----------------------------------------------------------------
		
		JPanel panelGasto = new JPanel();
		panelGasto.setLayout(new BorderLayout());
		
		JButton calcularGasto = new JButton(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gastoPersonal.calcular();

				tpgd.setText(String.valueOf(gastoPersonal.gastoPromDia()));
				tpgs.setText(String.valueOf(gastoPersonal.gastoPromSemana()));
				tpgm.setText(String.valueOf(gastoPersonal.gastoPromMes()));
				tpga.setText(String.valueOf(gastoPersonal.gastoPromAno()));

				panelGasto.repaint();
			}
		});
		calcularGasto.setText("Calcular");
		
		panelGasto.add(empleadosAtraccion, BorderLayout.WEST);
		panelGasto.add(panelEstadGasto, BorderLayout.CENTER );
		panelGasto.add(calcularGasto, BorderLayout.SOUTH);
		//=============================================================//
		//-------------------------------------------------------------//
		//=============================================================//  
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane pestanas = new JTabbedPane(); 
		pestanas.add("Turistas",registroCliente);
		pestanas.add("Trabajadores",registroTrabajador);
		pestanas.add("Atracciones",registroAtraccion);
		pestanas.add("Estadísticas",panelEstad);
		pestanas.add("Gasto",panelGasto);
		super.getContentPane().add(pestanas);
		super.pack();
	}
}
