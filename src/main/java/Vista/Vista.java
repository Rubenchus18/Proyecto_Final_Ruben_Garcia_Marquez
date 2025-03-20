package Vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Controlador.*;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.border.LineBorder;

import Controlador.Controlador;

import javax.swing.JComboBox;

import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import javax.swing.JTextField;
import javax.swing.JSpinner;


import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;
import com.sun.tools.javac.main.Main;
import com.toedter.calendar.JCalendar;
import javax.swing.JPasswordField;
import org.jxmapviewer.google.GoogleMapsTileFactoryInfo;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import javax.swing.JTextPane;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.internal.chartpart.Chart;


public class Vista extends JFrame {

	public static final long serialVersionUID = 1L;
	public  JPanel contentPane;
	public JPanel panelInicio;
	public JLabel lblLogo;
	public JLabel lblFondo;
	public Object lblSaliraddMouseLis;
	public JLabel lblSalirMenu;
	public JLabel lblMinutos;
	public JTextField textFieldNombreUsuario;
	public JTextField textFieldContraseña;
	public JLabel lblNewLabelContraseña;
	public JButton btnNewButtonInicioSesion;
	public JLabel lblNewLabelNombreUsuario;
	public JPanel panelMedico;
	public JPanel panelPacientes;
	public JPanel panelRececipnista;
	public JPanel panelAdmin;
	public JLabel lblNewLabelError;
	public JLabel labelHora;
	public JLabel lblNewLabel;
	public JLabel lblContraseña;
	public JLabel lblErrorCrear;
	public JTextField textFieldNombreUsuarioCrear;
	public JTextField textFieldContraseñaCrear;
	public JTextField textFieldNombreUsuarioEditar;
	public JTextField textFieldContraseñaEditar;
	public JLabel lblNewLabelSalida;
	public JLabel lblNewLabelLogo;
	public JLabel lblNewLabelNombre;
	public JLabel lblNewLabelCara;
	public JLabel lblNewLabelNombreUsuarioMostrar;
	public JButton btnNewButtonCrear;
	public JButton btnNewButtonEditar;
	public JButton btnNewButtonEliminar;
	public JPanel panelCrearAdmin;
	public JLabel lblNewLabelVolverCrear;
	public JButton btnCrearTotal;
	public JPanel panelEditarUsuario;
	public JLabel lblErrorEditar;
	public JLabel lblNewLabelVolverEditar;
	public JButton btnEditarTotal;
	public JLabel lblNewLabelFondoAdmin;
	public JLabel lblLabor;
	public JComboBox comboBoxRoles;
	public JTable tablaUsuarios;
	public JScrollPane scrollPane;
	public JLabel lblNewLabelFondeEditar;
	public JLabel lblNewLabelFondoCrear;
	public JLabel lblLaborNombre;
	public JSeparator separator_1;
	public JLabel lblNewLabelSalidaMedico;
	public JLabel lblNewLabelFondoMedico;
	public JLabel lblNewLabelCaraMedico;
	public JLabel lblNewLabelNombreUsuarioMostrarMedico;
	public JLabel lblVerCitas;
	public JLabel lblHistorialPaciente;
	public JLabel lblRegistro;
	public JLabel lblNewLabelLogoMedico;
	public JLabel lblNewLabelNombre_1;
	public JPanel panelVerDatosMedicos;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabelNombreMedico;
	public JLabel lblNewLabelEspecialidadMedica;
	public JButton btnRellenarDatos;
	public JLabel lblNewLabelFondoPerfilMedico;
	public JLabel lblNewLabel_5;
	public JTextField textFieldHorarioMedico;
	public JTextField textFieldEspecialidadMedico;
	public JLabel lblNewLabelErrorPefilMedico;
	public JPanel panelFiltar;
	public JTable tableHistorialMedico;
	public JLabel lblNombreDelCliente;
	public JTextField textFieldBuscarHistorialPaciente;
	public JButton btnBuscarHistorial;
	public JLabel lblFondoFiltrarHistorial;
	public JLabel lblErrorFiltro;
	public JLabel lblDireccion;
	public JTextField textFieldDireccionPaciente;
	public JScrollPane scrollPane_1;
	public JPanel panelCrearHistorialMedico;
	public JLabel lblNewLabelNombre_2;
	public JTextField textFieldNombrePaciente;
	public JLabel lblNewLabelNombre_3;
	public JTextField textFieldNombreMedico;
	public JLabel lblNewLabelNombre_4;
	public JTextField textFieldDiagnostico;
	public JLabel lblNewLabelNombre_5;
	public JTextField textFieldTratamiento;
	public JLabel lblNewLabelNombre_6;
	public JTextField textFieldReceta;
	public JLabel lblNewLabelNombre_7;
	public JCalendar calendarioMedico;
	public JButton btnGuardarHistorialMedico;
	public JLabel lblNewLabelFondoHistorialMedico;
	public JLabel lblErrorRegistroMedico;
	public JSeparator separator_2;
	public JLabel lblFondoEfecto;
	public JLabel lblFotoMedicoInicio;
	public JPanel panelFiltrarCitas;
	public JLabel lblNewLabelFondoFiltrarCita;
	public JLabel lblNewLabelNombreMecicoCita;
	public JLabel lblNewLabelFechaCita;
	public JTextField textFieldNombreMedicoCita;
	public JCalendar calendarioCitas;
	public JButton btnFiltrarCitas;
	public JLabel lblNewLabelErrorCitas;
	public JTable tableMostrarResultadoCitas;
	public JScrollPane scrollPane_2;
	public JSeparator separator_3;
	public JLabel lblRegistro_Nuevo_Pacientes;
	public JLabel lbl_Programacion_Citas;
	public JLabel lblEmision_de_Facturas;
	public JLabel lblNewLabelCaraRecepcionista;
	public JLabel lblNewLabelNombreUsuarioMostrarRecepcionista;
	public JLabel lblNewLabelLogoRecepcionista;
	public JLabel lblNewLabelNombre_8;
	public JLabel lblNewLabelFondoRecepcionista;
	public JPanel panelInformacionPaciente;
	public JLabel lblNewLabelNombre_9;
	public JLabel lblNewLabelNombrePaciente;
	public JPanel panelInformacionPaciente_1;
	public JLabel lblNewLabelNombre_13;
	public JLabel lblNewLabelNombrePaciente_1;
	public JLabel lblNewLabelNombre_14;
	public JTextField textFieldDireccion_PanelPaciente;
	public JLabel lblNewLabelNombre_15;
	public JTextField textField_Telefono_PanelPaciente;
	public JLabel lblNewLabelNombre_16;
	public JCalendar calendarFechaNacimientoPaciente_1;
	public JLabel lblNewLabelFondoPerfilRecepcionista;
	public JPanel panelCrearPacienteRecepcion;
	public JLabel lblNewLabelNombre_10;
	public JLabel lblNewLabelNombre_11;
	public JTextField textFieldDireccionPacienteRecepcion;
	public JLabel lblNewLabelNombre_12;
	public JTextField textFieldTelefonoPacienteRecepcion;
	public JLabel lblNewLabelNombre_17;
	public JCalendar calendarFechaNacimientoPacienteRecepcion;
	public JLabel lblNewLabelNombre_18;
	public JTextField textField_NombrePaciente;
	public JPasswordField passwordFieldContraseñaPacienteRecepcion;
	public JButton btnNewButtonCrearPacienteRecepcion;
	public JLabel lblNewLabelErrorCrearPacienteRecepcion;
	public JLabel lblNewLabelFondoPanelCrearPaciente;
	public JLabel lblNewLabelSalidaRecepcionista;
	public JXMapKit mapKit;
	public JLabel lblNewLabelMarcoMapa;
	public JLabel lblEncontrarnos;
	public JXMapKit mapKit_1;
	public JPanel panelProgramarCitasRecpecionosta;
	public JLabel lblNewLabelNombre_19;
	public JLabel lblNewLabelNombre_20;
	public JLabel lblNewLabelNombre_21;
	public JLabel lblNewLabelNombre_22;
	public JLabel lblNewLabelNombre_23;
	public JTextField textFieldNombrePacienteCitaRecepcion;
	public JTextField textFieldNombreMedicoCitaRecepcion;
	public JCalendar calendarCitaPaciente;
	public JTextField textFieldHoraCitaPaciente;
	public JButton btnNewButtonCrearCitaRecepcion;
	public JLabel lblNewLabelErrorCrearCitaRecpecion;
	public JLabel lblNewLabelFondoPanelCrearCitaRecepcion;
	public JTextField textFieldMotivoCitaRecepcion;
	public ChartFrame chartFrame;
	public XChartPanel chartPanel;
	public XChartPanel chartPanel_1;
	public XChartPanel chartPanel_2;
	public JPanel panelEmisiondeFacturasRecepcionista;
	public XChartPanel chartPanel_3;
	public JLabel lblNewLabel_3;
	public JButton btnNewButtonCrearCitaRecepcion_2;
	public JPanel panelExportacion;
	public JButton btnNewButtonExportarPDF;
	public JButton btnNewButtonExprotarCSV;
	public JLabel lblNewLabelFondoEmisionFacturasRecepcion;
	public JSeparator separator_4;
	public JLabel lblNewLabelFondoPaciente;
	public JLabel lblNewLabelSalida_Paciente;
	public JLabel lblNewLabelNombreUsuarioMostrarPaciente;
	public JLabel lblNewLabelCaraPaciente;
	public JLabel lblPagarFacturas;
	public JLabel lblVerHistorialMedico;
	public JLabel lblVerCitasPaciente;
	public JLabel lblNewLabelLogoMedico_Paciente;
	public JLabel lblNewLabelNombre_24;
	public JLabel lblNewLabel_FondoInformacionPaciente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		IntelliJTheme.setup(Vista.class.getResourceAsStream("/solarized_light_theme.theme.json"));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista vista = new Vista();
					Controlador controlador=new Controlador(vista);

					vista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 773);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		  ImageIcon imagenApp = (ajustarTamañoImg("imagenes/logo.png", 64, 64));
		  setTitle("VitalMed");
	       setIconImage(imagenApp.getImage()); 
	       setLocationRelativeTo(null);
	       setResizable(false); 
	        
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		   
		    panelAdmin = new JPanel();
		    panelAdmin.setBounds(0, 0, 1329, 734);
		    panelAdmin.setVisible(false);
		 
		  panelMedico = new JPanel();
		  panelMedico.setBounds(0, 0, 1329, 734);
		  panelMedico.setVisible(false);
		
		 panelRececipnista = new JPanel();
		 panelRececipnista.setBounds(0, 0, 1329, 734);
		 panelRececipnista.setVisible(false);
		 panelRececipnista.setVisible(false);
		    
		     panelPacientes = new JPanel();
		     panelPacientes.setBounds(0, 0, 1329, 734);
		     panelPacientes.setVisible(false);
		     contentPane.add(panelPacientes);
		     panelPacientes.setLayout(null);
		     
		     lblPagarFacturas = new JLabel("");
		     lblPagarFacturas.setHorizontalAlignment(SwingConstants.RIGHT);
		     lblPagarFacturas.setForeground(new Color(255, 128, 0));
		     lblPagarFacturas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblPagarFacturas.setBounds(379, -23, 113, 134);
		     panelPacientes.add(lblPagarFacturas);
		     
		     lblVerHistorialMedico = new JLabel("");
		     lblVerHistorialMedico.setHorizontalAlignment(SwingConstants.CENTER);
		     lblVerHistorialMedico.setForeground(new Color(255, 128, 0));
		     lblVerHistorialMedico.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblVerHistorialMedico.setBounds(264, -23, 113, 134);
		     panelPacientes.add(lblVerHistorialMedico);
		     
		     lblVerCitasPaciente = new JLabel("");
		     lblVerCitasPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		     lblVerCitasPaciente.setForeground(new Color(255, 128, 0));
		     lblVerCitasPaciente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblVerCitasPaciente.setBounds(141, -23, 113, 134);
		     panelPacientes.add(lblVerCitasPaciente);
		     
		     lblNewLabelNombreUsuarioMostrarPaciente = new JLabel("");
		     lblNewLabelNombreUsuarioMostrarPaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		     lblNewLabelNombreUsuarioMostrarPaciente.setForeground(new Color(255, 128, 0));
		     lblNewLabelNombreUsuarioMostrarPaciente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblNewLabelNombreUsuarioMostrarPaciente.setBounds(1015, 11, 189, 68);
		     panelPacientes.add(lblNewLabelNombreUsuarioMostrarPaciente);
		     
		     lblNewLabelCaraPaciente = new JLabel("");
		     lblNewLabelCaraPaciente.setBounds(1235, 11, 84, 68);
		     panelPacientes.add(lblNewLabelCaraPaciente);
		     
		     lblNewLabelLogoMedico_Paciente = new JLabel("");
		     lblNewLabelLogoMedico_Paciente.setBounds(485, 0, 108, 79);
		     panelPacientes.add(lblNewLabelLogoMedico_Paciente);
		     
		     lblNewLabelNombre_24 = new JLabel("VitalMed");
		     lblNewLabelNombre_24.setHorizontalAlignment(SwingConstants.CENTER);
		     lblNewLabelNombre_24.setForeground(new Color(255, 128, 0));
		     lblNewLabelNombre_24.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblNewLabelNombre_24.setBounds(462, 0, 424, 68);
		     panelPacientes.add(lblNewLabelNombre_24);
		     
		     lblNewLabelSalida_Paciente = new JLabel("");
		     lblNewLabelSalida_Paciente.setBounds(0, 0, 84, 79);
		     panelPacientes.add(lblNewLabelSalida_Paciente);
		     
		     panelInformacionPaciente_1 = new JPanel();
		     panelInformacionPaciente_1.setLayout(null);
		     panelInformacionPaciente_1.setBounds(1015, 90, 272, 633);
		     panelInformacionPaciente_1.setVisible(false);
		     panelPacientes.add(panelInformacionPaciente_1);
		     
		     lblNewLabelNombre_13 = new JLabel("Nombre");
		     lblNewLabelNombre_13.setHorizontalAlignment(SwingConstants.CENTER);
		     lblNewLabelNombre_13.setForeground(new Color(255, 128, 0));
		     lblNewLabelNombre_13.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblNewLabelNombre_13.setBounds(-83, 0, 424, 68);
		     panelInformacionPaciente_1.add(lblNewLabelNombre_13);
		     
		     lblNewLabelNombrePaciente_1 = new JLabel("");
		     lblNewLabelNombrePaciente_1.setHorizontalAlignment(SwingConstants.CENTER);
		     lblNewLabelNombrePaciente_1.setForeground(new Color(255, 128, 0));
		     lblNewLabelNombrePaciente_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblNewLabelNombrePaciente_1.setBounds(10, 54, 252, 68);
		     panelInformacionPaciente_1.add(lblNewLabelNombrePaciente_1);
		     
		     lblNewLabelNombre_14 = new JLabel("Direccion");
		     lblNewLabelNombre_14.setHorizontalAlignment(SwingConstants.CENTER);
		     lblNewLabelNombre_14.setForeground(new Color(255, 128, 0));
		     lblNewLabelNombre_14.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblNewLabelNombre_14.setBounds(-83, 118, 424, 68);
		     panelInformacionPaciente_1.add(lblNewLabelNombre_14);
		     
		     textFieldDireccion_PanelPaciente = new JTextField();
		     textFieldDireccion_PanelPaciente.setColumns(10);
		     textFieldDireccion_PanelPaciente.setBounds(10, 177, 252, 41);
		     panelInformacionPaciente_1.add(textFieldDireccion_PanelPaciente);
		     
		     lblNewLabelNombre_15 = new JLabel("Telefono");
		     lblNewLabelNombre_15.setHorizontalAlignment(SwingConstants.CENTER);
		     lblNewLabelNombre_15.setForeground(new Color(255, 128, 0));
		     lblNewLabelNombre_15.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblNewLabelNombre_15.setBounds(-83, 229, 424, 68);
		     panelInformacionPaciente_1.add(lblNewLabelNombre_15);
		     
		     textField_Telefono_PanelPaciente = new JTextField();
		     textField_Telefono_PanelPaciente.setColumns(10);
		     textField_Telefono_PanelPaciente.setBounds(10, 288, 252, 41);
		     panelInformacionPaciente_1.add(textField_Telefono_PanelPaciente);
		     
		     lblNewLabelNombre_16 = new JLabel("Fecha Nacimeinto");
		     lblNewLabelNombre_16.setHorizontalAlignment(SwingConstants.CENTER);
		     lblNewLabelNombre_16.setForeground(new Color(255, 128, 0));
		     lblNewLabelNombre_16.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		     lblNewLabelNombre_16.setBounds(-73, 340, 424, 68);
		     panelInformacionPaciente_1.add(lblNewLabelNombre_16);
		     
		     calendarFechaNacimientoPaciente_1 = new JCalendar();
		     calendarFechaNacimientoPaciente_1.setBounds(10, 390, 252, 153);
		     panelInformacionPaciente_1.add(calendarFechaNacimientoPaciente_1);
		     
		     lblNewLabel_FondoInformacionPaciente = new JLabel("");
		     lblNewLabel_FondoInformacionPaciente.setBounds(0, 0, 272, 633);
		     panelInformacionPaciente_1.add(lblNewLabel_FondoInformacionPaciente);
		     
		     separator_4 = new JSeparator();
		     separator_4.setForeground(new Color(255, 128, 0));
		     separator_4.setBounds(0, 77, 1319, 2);
		     panelPacientes.add(separator_4);
		     
		     lblNewLabelFondoPaciente = new JLabel("");
		     lblNewLabelFondoPaciente.setBounds(0, 0, 1321, 734);
		     panelPacientes.add(lblNewLabelFondoPaciente);
		 
		  
		 
		    contentPane.add(panelRececipnista);
		    panelRececipnista.setLayout(null);
		    
		    panelInformacionPaciente = new JPanel();
		    panelInformacionPaciente.setBounds(1014, 104, 272, 337);
		    panelInformacionPaciente.setVisible(false);
		    
		    panelCrearPacienteRecepcion = new JPanel();
		    panelCrearPacienteRecepcion.setLayout(null);
		    panelCrearPacienteRecepcion.setBounds(50, 90, 878, 633);
		    panelCrearPacienteRecepcion.setVisible(false);
		    
		    panelProgramarCitasRecpecionosta = new JPanel();
		    panelProgramarCitasRecpecionosta.setBounds(50, 90, 878, 633);
		    panelProgramarCitasRecpecionosta.setVisible(false);
		    
		    panelExportacion = new JPanel();
		    panelExportacion.setBounds(40, 90, 892, 633);
		    panelRececipnista.add(panelExportacion);
		    panelExportacion.setVisible(false);
		    panelExportacion.setLayout(null);
		    
		    btnNewButtonExprotarCSV = new JButton("");
		    btnNewButtonExprotarCSV.setOpaque(false);
		    btnNewButtonExprotarCSV.setContentAreaFilled(false);
		    btnNewButtonExprotarCSV.setBorderPainted(false);
		    btnNewButtonExprotarCSV.setBounds(107, 461, 225, 182);
		    panelExportacion.add(btnNewButtonExprotarCSV);
		    
		    btnNewButtonExportarPDF = new JButton("");
		    btnNewButtonExportarPDF.setOpaque(false);
		    btnNewButtonExportarPDF.setContentAreaFilled(false);
		    btnNewButtonExportarPDF.setBorderPainted(false);
		    btnNewButtonExportarPDF.setBounds(553, 461, 225, 182);
		    panelExportacion.add(btnNewButtonExportarPDF);
		    
		    panelEmisiondeFacturasRecepcionista = new JPanel();
		    panelEmisiondeFacturasRecepcionista.setBounds(20, 11, 835, 482);
		    panelExportacion.add(panelEmisiondeFacturasRecepcionista);
		    panelEmisiondeFacturasRecepcionista.setVisible(false);
		    panelEmisiondeFacturasRecepcionista.setLayout(null);
		    
		    lblNewLabelFondoEmisionFacturasRecepcion = new JLabel("New label");
		    lblNewLabelFondoEmisionFacturasRecepcion.setBounds(0, 0, 892, 633);
		    panelExportacion.add(lblNewLabelFondoEmisionFacturasRecepcion);
		    
		   
		    panelRececipnista.add(panelProgramarCitasRecpecionosta);
		    panelProgramarCitasRecpecionosta.setLayout(null);
		    
		    textFieldMotivoCitaRecepcion = new JTextField();
		    textFieldMotivoCitaRecepcion.setColumns(10);
		    textFieldMotivoCitaRecepcion.setBounds(548, 360, 231, 43);
		    panelProgramarCitasRecpecionosta.add(textFieldMotivoCitaRecepcion);
		    
		    lblNewLabelNombre_19 = new JLabel("Nombre paciente");
		    lblNewLabelNombre_19.setBounds(84, 56, 231, 31);
		    lblNewLabelNombre_19.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_19.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_19.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    panelProgramarCitasRecpecionosta.add(lblNewLabelNombre_19);
		    
		    lblNewLabelNombre_20 = new JLabel("Nombre medico");
		    lblNewLabelNombre_20.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_20.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_20.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_20.setBounds(548, 56, 231, 31);
		    panelProgramarCitasRecpecionosta.add(lblNewLabelNombre_20);
		    
		    lblNewLabelNombre_21 = new JLabel("Fecha cita");
		    lblNewLabelNombre_21.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_21.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_21.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_21.setBounds(84, 208, 231, 31);
		    panelProgramarCitasRecpecionosta.add(lblNewLabelNombre_21);
		    
		    lblNewLabelNombre_22 = new JLabel("Hora");
		    lblNewLabelNombre_22.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_22.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_22.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_22.setBounds(560, 208, 231, 31);
		    panelProgramarCitasRecpecionosta.add(lblNewLabelNombre_22);
		    
		    lblNewLabelNombre_23 = new JLabel("Motivo");
		    lblNewLabelNombre_23.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_23.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_23.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_23.setBounds(548, 318, 231, 31);
		    panelProgramarCitasRecpecionosta.add(lblNewLabelNombre_23);
		    
		    textFieldNombrePacienteCitaRecepcion = new JTextField();
		    textFieldNombrePacienteCitaRecepcion.setBounds(84, 98, 231, 43);
		    panelProgramarCitasRecpecionosta.add(textFieldNombrePacienteCitaRecepcion);
		    textFieldNombrePacienteCitaRecepcion.setColumns(10);
		    
		    textFieldNombreMedicoCitaRecepcion = new JTextField();
		    textFieldNombreMedicoCitaRecepcion.setColumns(10);
		    textFieldNombreMedicoCitaRecepcion.setBounds(548, 98, 231, 43);
		    panelProgramarCitasRecpecionosta.add(textFieldNombreMedicoCitaRecepcion);
		    
		    calendarCitaPaciente = new JCalendar();
		    calendarCitaPaciente.setBounds(84, 250, 231, 153);
		    panelProgramarCitasRecpecionosta.add(calendarCitaPaciente);
		    
		    textFieldHoraCitaPaciente = new JTextField();
		    textFieldHoraCitaPaciente.setColumns(10);
		    textFieldHoraCitaPaciente.setBounds(548, 264, 231, 43);
		    panelProgramarCitasRecpecionosta.add(textFieldHoraCitaPaciente);
		    
		    btnNewButtonCrearCitaRecepcion = new JButton("");
		    btnNewButtonCrearCitaRecepcion.setOpaque(false);
		    btnNewButtonCrearCitaRecepcion.setContentAreaFilled(false);
		    btnNewButtonCrearCitaRecepcion.setBorderPainted(false);
		    btnNewButtonCrearCitaRecepcion.setBounds(99, 428, 225, 182);
		    panelProgramarCitasRecpecionosta.add(btnNewButtonCrearCitaRecepcion);
		    
		    lblNewLabelErrorCrearCitaRecpecion = new JLabel("");
		    lblNewLabelErrorCrearCitaRecpecion.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelErrorCrearCitaRecpecion.setForeground(new Color(255, 128, 0));
		    lblNewLabelErrorCrearCitaRecpecion.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelErrorCrearCitaRecpecion.setBounds(409, 487, 424, 68);
		    panelProgramarCitasRecpecionosta.add(lblNewLabelErrorCrearCitaRecpecion);
		    
		    lblNewLabelFondoPanelCrearCitaRecepcion = new JLabel("");
		    lblNewLabelFondoPanelCrearCitaRecepcion.setBounds(0, 0, 878, 633);
		    panelProgramarCitasRecpecionosta.add(lblNewLabelFondoPanelCrearCitaRecepcion);
		    
		    btnNewButtonCrearCitaRecepcion_2 = new JButton("");
		    btnNewButtonCrearCitaRecepcion_2.setOpaque(false);
		    btnNewButtonCrearCitaRecepcion_2.setContentAreaFilled(false);
		    btnNewButtonCrearCitaRecepcion_2.setBorderPainted(false);
		    btnNewButtonCrearCitaRecepcion_2.setBounds(99, 428, 225, 182);
		    panelProgramarCitasRecpecionosta.add(btnNewButtonCrearCitaRecepcion_2);
		    
		    lblNewLabelSalidaRecepcionista = new JLabel("");
		    lblNewLabelSalidaRecepcionista.setBounds(0, 0, 84, 79);
		    panelRececipnista.add(lblNewLabelSalidaRecepcionista);
		    panelRececipnista.add(panelCrearPacienteRecepcion);
		    
		    lblNewLabelNombre_10 = new JLabel("Nombre");
		    lblNewLabelNombre_10.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_10.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_10.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_10.setBounds(10, 39, 424, 68);
		    panelCrearPacienteRecepcion.add(lblNewLabelNombre_10);
		    
		    lblNewLabelNombre_11 = new JLabel("Contraseña");
		    lblNewLabelNombre_11.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_11.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_11.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_11.setBounds(444, 39, 424, 68);
		    panelCrearPacienteRecepcion.add(lblNewLabelNombre_11);
		    
		    textFieldDireccionPacienteRecepcion = new JTextField();
		    textFieldDireccionPacienteRecepcion.setColumns(10);
		    textFieldDireccionPacienteRecepcion.setBounds(100, 245, 252, 41);
		    panelCrearPacienteRecepcion.add(textFieldDireccionPacienteRecepcion);
		    
		    lblNewLabelNombre_12 = new JLabel("Telefono");
		    lblNewLabelNombre_12.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_12.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_12.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_12.setBounds(10, 297, 424, 68);
		    panelCrearPacienteRecepcion.add(lblNewLabelNombre_12);
		    
		    textFieldTelefonoPacienteRecepcion = new JTextField();
		    textFieldTelefonoPacienteRecepcion.setColumns(10);
		    textFieldTelefonoPacienteRecepcion.setBounds(100, 376, 252, 41);
		    panelCrearPacienteRecepcion.add(textFieldTelefonoPacienteRecepcion);
		    
		    lblNewLabelNombre_17 = new JLabel("Fecha Nacimeinto");
		    lblNewLabelNombre_17.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_17.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_17.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_17.setBounds(439, 200, 424, 68);
		    panelCrearPacienteRecepcion.add(lblNewLabelNombre_17);
		    
		    calendarFechaNacimientoPacienteRecepcion = new JCalendar();
		    calendarFechaNacimientoPacienteRecepcion.setBounds(516, 264, 252, 153);
		    panelCrearPacienteRecepcion.add(calendarFechaNacimientoPacienteRecepcion);
		    
		    lblNewLabelNombre_18 = new JLabel("Direccion");
		    lblNewLabelNombre_18.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_18.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_18.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_18.setBounds(10, 186, 424, 68);
		    panelCrearPacienteRecepcion.add(lblNewLabelNombre_18);
		    
		    textField_NombrePaciente = new JTextField();
		    textField_NombrePaciente.setColumns(10);
		    textField_NombrePaciente.setBounds(100, 118, 252, 41);
		    panelCrearPacienteRecepcion.add(textField_NombrePaciente);
		    
		    passwordFieldContraseñaPacienteRecepcion = new JPasswordField();
		    passwordFieldContraseñaPacienteRecepcion.setBounds(516, 118, 252, 41);
		    panelCrearPacienteRecepcion.add(passwordFieldContraseñaPacienteRecepcion);
		    
		    btnNewButtonCrearPacienteRecepcion = new JButton("");
		    btnNewButtonCrearPacienteRecepcion.setBounds(100, 428, 225, 182);
		    btnNewButtonCrearPacienteRecepcion.setOpaque(false);
		    btnNewButtonCrearPacienteRecepcion.setContentAreaFilled(false);
		    btnNewButtonCrearPacienteRecepcion.setBorderPainted(false);
		    panelCrearPacienteRecepcion.add(btnNewButtonCrearPacienteRecepcion);
		    
		    lblNewLabelErrorCrearPacienteRecepcion = new JLabel("");
		    lblNewLabelErrorCrearPacienteRecepcion.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelErrorCrearPacienteRecepcion.setForeground(new Color(255, 128, 0));
		    lblNewLabelErrorCrearPacienteRecepcion.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelErrorCrearPacienteRecepcion.setBounds(410, 487, 424, 68);
		    panelCrearPacienteRecepcion.add(lblNewLabelErrorCrearPacienteRecepcion);
		    
		    lblNewLabelFondoPanelCrearPaciente = new JLabel("");
		    lblNewLabelFondoPanelCrearPaciente.setBounds(0, 0, 878, 633);
		    panelCrearPacienteRecepcion.add(lblNewLabelFondoPanelCrearPaciente);
		    
		    panelRececipnista.add(panelInformacionPaciente);
		    panelInformacionPaciente.setLayout(null);
		    
		    lblNewLabelNombre_9 = new JLabel("Nombre");
		    lblNewLabelNombre_9.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_9.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_9.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_9.setBounds(-81, 105, 424, 68);
		    panelInformacionPaciente.add(lblNewLabelNombre_9);
		    
		    lblNewLabelNombrePaciente = new JLabel("");
		    lblNewLabelNombrePaciente.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombrePaciente.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombrePaciente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombrePaciente.setBounds(10, 184, 252, 68);
		    panelInformacionPaciente.add(lblNewLabelNombrePaciente);
		    
		    lblNewLabelFondoPerfilRecepcionista = new JLabel("");
		    lblNewLabelFondoPerfilRecepcionista.setBounds(0, 0, 272, 483);
		    panelInformacionPaciente.add(lblNewLabelFondoPerfilRecepcionista);
		    
		    separator_3 = new JSeparator();
		    separator_3.setForeground(new Color(255, 128, 0));
		    separator_3.setBounds(0, 77, 1319, 2);
		    panelRececipnista.add(separator_3);
		    
		    lblRegistro_Nuevo_Pacientes = new JLabel("");
		    lblRegistro_Nuevo_Pacientes.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblRegistro_Nuevo_Pacientes.setForeground(new Color(255, 128, 0));
		    lblRegistro_Nuevo_Pacientes.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblRegistro_Nuevo_Pacientes.setBounds(142, -23, 113, 134);
		    panelRececipnista.add(lblRegistro_Nuevo_Pacientes);
		    
		    lbl_Programacion_Citas = new JLabel("");
		    lbl_Programacion_Citas.setHorizontalAlignment(SwingConstants.RIGHT);
		    lbl_Programacion_Citas.setForeground(new Color(255, 128, 0));
		    lbl_Programacion_Citas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lbl_Programacion_Citas.setBounds(265, -23, 113, 134);
		    panelRececipnista.add(lbl_Programacion_Citas);
		    
		    lblEmision_de_Facturas = new JLabel("");
		    lblEmision_de_Facturas.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblEmision_de_Facturas.setForeground(new Color(255, 128, 0));
		    lblEmision_de_Facturas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblEmision_de_Facturas.setBounds(388, -23, 113, 134);
		    panelRececipnista.add(lblEmision_de_Facturas);
		    
		    lblNewLabelCaraRecepcionista = new JLabel("");
		    lblNewLabelCaraRecepcionista.setBounds(1213, 11, 106, 68);
		    panelRececipnista.add(lblNewLabelCaraRecepcionista);
		    
		    lblNewLabelNombreUsuarioMostrarRecepcionista = new JLabel("");
		    lblNewLabelNombreUsuarioMostrarRecepcionista.setHorizontalAlignment(SwingConstants.RIGHT);
		    lblNewLabelNombreUsuarioMostrarRecepcionista.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombreUsuarioMostrarRecepcionista.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombreUsuarioMostrarRecepcionista.setBounds(1014, 11, 189, 68);
		    panelRececipnista.add(lblNewLabelNombreUsuarioMostrarRecepcionista);
		    
		    lblNewLabelLogoRecepcionista = new JLabel("");
		    lblNewLabelLogoRecepcionista.setBounds(516, 0, 108, 79);
		    panelRececipnista.add(lblNewLabelLogoRecepcionista);
		    
		    lblNewLabelNombre_8 = new JLabel("VitalMed");
		    lblNewLabelNombre_8.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombre_8.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombre_8.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		    lblNewLabelNombre_8.setBounds(478, 11, 424, 68);
		    panelRececipnista.add(lblNewLabelNombre_8);
		    
		    lblNewLabelFondoRecepcionista = new JLabel("");
		    lblNewLabelFondoRecepcionista.setBounds(0, 0, 1329, 734);
		    panelRececipnista.add(lblNewLabelFondoRecepcionista);
		    
		    lblNewLabel_3 = new JLabel("New label");
		    lblNewLabel_3.setBounds(0, 0, 46, 14);
		    panelRececipnista.add(lblNewLabel_3);
		   
		panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 1329, 742);
		
		contentPane.add(panelInicio);
		panelInicio.setLayout(null);
		
		 GeoPosition clinica = new GeoPosition(38.97627620849862, -3.9133207171836717);
		
		lblEncontrarnos = new JLabel("Ubicacion ");
		lblEncontrarnos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEncontrarnos.setForeground(new Color(255, 128, 0));
		lblEncontrarnos.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 33));
		lblEncontrarnos.setBackground(new Color(255, 128, 64));
		lblEncontrarnos.setBounds(943, 441, 376, 83);
		panelInicio.add(lblEncontrarnos);
		
		lblNewLabelMarcoMapa = new JLabel("");
		lblNewLabelMarcoMapa.setBounds(1071, 505, 287, 273);
		panelInicio.add(lblNewLabelMarcoMapa);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(new Color(255, 128, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(452, -38, 18, 780);
		panelInicio.add(separator_2);
		
		
		labelHora = new JLabel("");
		labelHora.setHorizontalAlignment(SwingConstants.CENTER);
		labelHora.setForeground(new Color(255, 128, 0));
		labelHora.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		labelHora.setBackground(new Color(255, 128, 64));
		labelHora.setBounds(943, 11, 376, 83);
		panelInicio.add(labelHora);
		
		 lblNewLabelError = new JLabel("");
		 lblNewLabelError.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabelError.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		 lblNewLabelError.setBackground(new Color(255, 0, 0));
		 lblNewLabelError.setBounds(34, 621, 376, 83);
		 panelInicio.add(lblNewLabelError);
		 
		  lblNewLabelContraseña = new JLabel("Contraseña");
		  lblNewLabelContraseña.setForeground(new Color(255, 128, 0));
		  lblNewLabelContraseña.setBackground(new Color(255, 128, 0));
		  lblNewLabelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelContraseña.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 33));
		  lblNewLabelContraseña.setBounds(34, 400, 376, 83);
		  panelInicio.add(lblNewLabelContraseña);
		  
		   btnNewButtonInicioSesion = new JButton("");
		   btnNewButtonInicioSesion.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		   btnNewButtonInicioSesion.setBounds(138, 549, 173, 155);
		   btnNewButtonInicioSesion.setContentAreaFilled(false); 
		   btnNewButtonInicioSesion.setBorderPainted(false);
		   panelInicio.add(btnNewButtonInicioSesion);
		   
		    lblNewLabelNombreUsuario = new JLabel("Nombre Usuario");
		    lblNewLabelNombreUsuario.setForeground(new Color(255, 128, 0));
		    lblNewLabelNombreUsuario.setBackground(new Color(255, 128, 64));
		    lblNewLabelNombreUsuario.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 33));
		    lblNewLabelNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabelNombreUsuario.setBounds(34, 236, 376, 83);
		    
		    panelInicio.add(lblNewLabelNombreUsuario);
		    
		    textFieldContraseña = new JTextField();
		    textFieldContraseña.setColumns(10);	
		    textFieldContraseña.setBounds(44, 479, 366, 57);
		    panelInicio.add(textFieldContraseña);
		    
		    textFieldNombreUsuario = new JTextField();
		    textFieldNombreUsuario.setBounds(44, 330, 366, 57);
		    panelInicio.add(textFieldNombreUsuario);
		    textFieldNombreUsuario.setColumns(10);
		    
		lblLogo = new JLabel("");
		lblLogo.setBounds(80, -38, 287, 263);
		panelInicio.add(lblLogo);
		
		lblFotoMedicoInicio = new JLabel("");
		lblFotoMedicoInicio.setBackground(new Color(255, 255, 255));
		lblFotoMedicoInicio.setBounds(452, 0, 642, 742);
		panelInicio.add(lblFotoMedicoInicio);
		
		lblFondoEfecto = new JLabel("");
		lblFondoEfecto.setBackground(new Color(0, 255, 255));
		lblFondoEfecto.setBounds(0, 0, 453, 742);
		panelInicio.add(lblFondoEfecto);
		
		mapKit = new JXMapKit();
		mapKit.setBounds(1114, 524, 215, 218);
		mapKit.setAddressLocation(clinica);
		mapKit.setZoom(100);
		panelInicio.add(mapKit);
		
		
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1329, 825);
		panelInicio.add(lblFondo);
		  contentPane.add(panelMedico);
		  panelMedico.setLayout(null);
		  
		  panelFiltar = new JPanel();
		  panelFiltar.setBounds(938, 112, 290, 566);
		  panelFiltar.setVisible(false);
		  
		  scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBounds(56, 112, 840, 566);
		  scrollPane_1.setVisible(false);
		  
		  scrollPane_2 = new JScrollPane();
		  scrollPane_2.setBounds(66, 90, 862, 633);
		  scrollPane_2.setVisible(false);
		  
		  panelCrearHistorialMedico = new JPanel();
		  panelCrearHistorialMedico.setBounds(66, 90, 862, 633);
		  panelCrearHistorialMedico.setVisible(false);
		  panelMedico.add(panelCrearHistorialMedico);
		  
		  panelCrearHistorialMedico.setLayout(null);
		  
		  lblErrorRegistroMedico = new JLabel("");
		  lblErrorRegistroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		  lblErrorRegistroMedico.setForeground(new Color(255, 128, 0));
		  lblErrorRegistroMedico.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblErrorRegistroMedico.setBounds(346, 552, 506, 68);
		  panelCrearHistorialMedico.add(lblErrorRegistroMedico);
		  
		  lblNewLabelNombre_2 = new JLabel("Nombre paciente");
		  lblNewLabelNombre_2.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombre_2.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombre_2.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombre_2.setBounds(38, 35, 248, 68);
		  panelCrearHistorialMedico.add(lblNewLabelNombre_2);
		  
		  textFieldNombrePaciente = new JTextField();
		  textFieldNombrePaciente.setBounds(38, 114, 248, 36);
		  panelCrearHistorialMedico.add(textFieldNombrePaciente);
		  textFieldNombrePaciente.setColumns(10);
		  
		  lblNewLabelNombre_3 = new JLabel("Nombre medico");
		  lblNewLabelNombre_3.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombre_3.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombre_3.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombre_3.setBounds(509, 35, 248, 68);
		  panelCrearHistorialMedico.add(lblNewLabelNombre_3);
		  
		  textFieldNombreMedico = new JTextField();
		  textFieldNombreMedico.setColumns(10);
		  textFieldNombreMedico.setBounds(509, 114, 248, 36);
		  panelCrearHistorialMedico.add(textFieldNombreMedico);
		  
		  lblNewLabelNombre_4 = new JLabel("Diagnostico");
		  lblNewLabelNombre_4.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombre_4.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombre_4.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombre_4.setBounds(38, 168, 248, 68);
		  panelCrearHistorialMedico.add(lblNewLabelNombre_4);
		  
		  textFieldDiagnostico = new JTextField();
		  textFieldDiagnostico.setColumns(10);
		  textFieldDiagnostico.setBounds(38, 230, 248, 105);
		  panelCrearHistorialMedico.add(textFieldDiagnostico);
		  
		  lblNewLabelNombre_5 = new JLabel("Tratamiento");
		  lblNewLabelNombre_5.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombre_5.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombre_5.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombre_5.setBounds(509, 161, 248, 68);
		  panelCrearHistorialMedico.add(lblNewLabelNombre_5);
		  
		  textFieldTratamiento = new JTextField();
		  textFieldTratamiento.setColumns(10);
		  textFieldTratamiento.setBounds(509, 230, 248, 105);
		  panelCrearHistorialMedico.add(textFieldTratamiento);
		  
		  lblNewLabelNombre_6 = new JLabel("Receta");
		  lblNewLabelNombre_6.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombre_6.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombre_6.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombre_6.setBounds(38, 357, 248, 68);
		  panelCrearHistorialMedico.add(lblNewLabelNombre_6);
		  
		  textFieldReceta = new JTextField();
		  textFieldReceta.setColumns(10);
		  textFieldReceta.setBounds(38, 436, 248, 105);
		  panelCrearHistorialMedico.add(textFieldReceta);
		  
		  lblNewLabelNombre_7 = new JLabel("Fecha");
		  lblNewLabelNombre_7.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombre_7.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombre_7.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombre_7.setBounds(495, 357, 248, 68);
		  panelCrearHistorialMedico.add(lblNewLabelNombre_7);
		  
		  calendarioMedico = new JCalendar();
		  calendarioMedico.setBounds(509, 425, 238, 135);
		  panelCrearHistorialMedico.add(calendarioMedico);
		  
		  btnGuardarHistorialMedico = new JButton("");
		  btnGuardarHistorialMedico.setOpaque(false);
		  btnGuardarHistorialMedico.setContentAreaFilled(false);
		  btnGuardarHistorialMedico.setBorderPainted(false);
		  btnGuardarHistorialMedico.setBounds(10, 491, 310, 191);
		  panelCrearHistorialMedico.add(btnGuardarHistorialMedico);
		  
		  lblNewLabelFondoHistorialMedico = new JLabel("");
		  lblNewLabelFondoHistorialMedico.setBounds(0, 0, 874, 633);
		  panelCrearHistorialMedico.add(lblNewLabelFondoHistorialMedico);
		  panelMedico.add(scrollPane_2);
		  
		  tableMostrarResultadoCitas = new JTable();
		  scrollPane_2.setViewportView(tableMostrarResultadoCitas);
		  
		  panelFiltrarCitas = new JPanel();
		  panelFiltrarCitas.setBounds(938, 112, 290, 566);
		  panelMedico.add(panelFiltrarCitas);
		  panelFiltrarCitas.setVisible(false);
		  panelFiltrarCitas.setLayout(null);
		  
		  calendarioCitas = new JCalendar();
		  calendarioCitas.setBounds(42, 215, 238, 153);
		  panelFiltrarCitas.add(calendarioCitas);
		  
		  lblNewLabelErrorCitas = new JLabel("");
		  lblNewLabelErrorCitas.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelErrorCitas.setForeground(new Color(255, 0, 0));
		  lblNewLabelErrorCitas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		  lblNewLabelErrorCitas.setBounds(32, 487, 248, 68);
		  panelFiltrarCitas.add(lblNewLabelErrorCitas);
		  
		  btnFiltrarCitas = new JButton("");
		  btnFiltrarCitas.setBounds(42, 318, 238, 237);
		  btnFiltrarCitas.setOpaque(false);
		  btnFiltrarCitas.setContentAreaFilled(false);
		  btnFiltrarCitas.setBorderPainted(false);
		  panelFiltrarCitas.add(btnFiltrarCitas);
		  
		  textFieldNombreMedicoCita = new JTextField();
		  textFieldNombreMedicoCita.setBounds(42, 109, 238, 47);
		  panelFiltrarCitas.add(textFieldNombreMedicoCita);
		  textFieldNombreMedicoCita.setColumns(10);
		  
		  lblNewLabelFechaCita = new JLabel("Fecha de Cita");
		  lblNewLabelFechaCita.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelFechaCita.setForeground(new Color(255, 128, 0));
		  lblNewLabelFechaCita.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelFechaCita.setBounds(32, 167, 248, 68);
		  panelFiltrarCitas.add(lblNewLabelFechaCita);
		  
		  lblNewLabelNombreMecicoCita = new JLabel("Nombre medico");
		  lblNewLabelNombreMecicoCita.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombreMecicoCita.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombreMecicoCita.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombreMecicoCita.setBounds(32, 30, 248, 68);
		  panelFiltrarCitas.add(lblNewLabelNombreMecicoCita);
		  
		  lblNewLabelFondoFiltrarCita = new JLabel("");
		  lblNewLabelFondoFiltrarCita.setBounds(0, 0, 290, 566);
		  panelFiltrarCitas.add(lblNewLabelFondoFiltrarCita);
		  panelMedico.add(scrollPane_1);
		  tableHistorialMedico = new JTable();
		  scrollPane_1.setViewportView(tableHistorialMedico);
		  tableHistorialMedico.setVisible(false);
		  
		  panelMedico.add(panelFiltar);
		  panelFiltar.setLayout(null);
		  
		  textFieldDireccionPaciente = new JTextField();
		  textFieldDireccionPaciente.setColumns(10);
		  textFieldDireccionPaciente.setBounds(36, 187, 224, 46);
		  panelFiltar.add(textFieldDireccionPaciente);
		  
		  lblDireccion = new JLabel("Direccion");
		  lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		  lblDireccion.setForeground(new Color(255, 128, 0));
		  lblDireccion.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblDireccion.setBounds(0, 127, 290, 68);
		  panelFiltar.add(lblDireccion);
		  
		  lblErrorFiltro = new JLabel("");
		  lblErrorFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		  lblErrorFiltro.setForeground(new Color(255, 128, 0));
		  lblErrorFiltro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		  lblErrorFiltro.setBounds(0, 382, 290, 68);
		  panelFiltar.add(lblErrorFiltro);
		  
		  lblNombreDelCliente = new JLabel("Nombre Cliente");
		  lblNombreDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNombreDelCliente.setForeground(new Color(255, 128, 0));
		  lblNombreDelCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNombreDelCliente.setBounds(0, 11, 290, 68);
		  panelFiltar.add(lblNombreDelCliente);
		  
		  textFieldBuscarHistorialPaciente = new JTextField();
		  textFieldBuscarHistorialPaciente.setBounds(36, 79, 224, 46);
		  panelFiltar.add(textFieldBuscarHistorialPaciente);
		  textFieldBuscarHistorialPaciente.setColumns(10);
		  
		  btnBuscarHistorial = new JButton("");
		  btnBuscarHistorial.setOpaque(false);
		  btnBuscarHistorial.setContentAreaFilled(false);
		  btnBuscarHistorial.setBorderPainted(false);
		  btnBuscarHistorial.setBounds(36, 217, 224, 191);
		  panelFiltar.add(btnBuscarHistorial);
		  
		  lblFondoFiltrarHistorial = new JLabel("");
		  lblFondoFiltrarHistorial.setBounds(0, 0, 290, 566);
		  panelFiltar.add(lblFondoFiltrarHistorial);
		  
		  lblNewLabelNombre_1 = new JLabel("VitalMed");
		  lblNewLabelNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombre_1.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombre_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombre_1.setBounds(453, 11, 424, 68);
		  panelMedico.add(lblNewLabelNombre_1);
		  
		  lblNewLabelLogoMedico = new JLabel("");
		  lblNewLabelLogoMedico.setBounds(485, 0, 108, 79);
		  panelMedico.add(lblNewLabelLogoMedico);
		  
		  lblVerCitas = new JLabel("");
		  lblVerCitas.setHorizontalAlignment(SwingConstants.CENTER);
		  lblVerCitas.setForeground(new Color(255, 128, 0));
		  lblVerCitas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblVerCitas.setBounds(142, -23, 113, 134);
		  panelMedico.add(lblVerCitas);
		  
		  lblHistorialPaciente = new JLabel("");
		  lblHistorialPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		  lblHistorialPaciente.setForeground(new Color(255, 128, 0));
		  lblHistorialPaciente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblHistorialPaciente.setBounds(265, -23, 113, 134);
		  panelMedico.add(lblHistorialPaciente);
		  
		  lblRegistro = new JLabel("");
		  lblRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		  lblRegistro.setForeground(new Color(255, 128, 0));
		  lblRegistro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblRegistro.setBounds(377, -23, 113, 134);
		  panelMedico.add(lblRegistro);
		  
		  lblNewLabelCaraMedico = new JLabel("");
		  lblNewLabelCaraMedico.setBounds(1235, 11, 84, 68);
		  panelMedico.add(lblNewLabelCaraMedico);
		  
		  lblNewLabelNombreUsuarioMostrarMedico = new JLabel("");
		  lblNewLabelNombreUsuarioMostrarMedico.setHorizontalAlignment(SwingConstants.RIGHT);
		  lblNewLabelNombreUsuarioMostrarMedico.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombreUsuarioMostrarMedico.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		  lblNewLabelNombreUsuarioMostrarMedico.setBounds(1014, 11, 189, 68);
		  panelMedico.add(lblNewLabelNombreUsuarioMostrarMedico);
		  
		  separator_1 = new JSeparator();
		  separator_1.setForeground(new Color(255, 128, 0));
		  separator_1.setBounds(0, 77, 1319, 2);
		  panelMedico.add(separator_1);
		  
		  lblNewLabelSalidaMedico = new JLabel("");
		  lblNewLabelSalidaMedico.setBounds(0, 0, 84, 79);
		  panelMedico.add(lblNewLabelSalidaMedico);
		  
		  panelVerDatosMedicos = new JPanel();
		  panelVerDatosMedicos.setBounds(1014, 111, 272, 483);
		  panelMedico.add(panelVerDatosMedicos);
		  panelVerDatosMedicos.setVisible(false);
		  panelVerDatosMedicos.setLayout(null);
		  
		  lblNewLabel_2 = new JLabel("Nombre Usuario");
		  lblNewLabel_2.setBounds(60, 82, 168, 25);
		  lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabel_2.setForeground(new Color(255, 128, 0));
		  lblNewLabel_2.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		  panelVerDatosMedicos.add(lblNewLabel_2);
		  
		  lblNewLabelNombreMedico = new JLabel("");
		  lblNewLabelNombreMedico.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelNombreMedico.setForeground(new Color(255, 128, 0));
		  lblNewLabelNombreMedico.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		  lblNewLabelNombreMedico.setBounds(60, 138, 168, 25);
		  panelVerDatosMedicos.add(lblNewLabelNombreMedico);
		  
		  lblNewLabelEspecialidadMedica = new JLabel("Especialidad");
		  lblNewLabelEspecialidadMedica.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelEspecialidadMedica.setForeground(new Color(255, 128, 0));
		  lblNewLabelEspecialidadMedica.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		  lblNewLabelEspecialidadMedica.setBounds(60, 204, 168, 25);
		  panelVerDatosMedicos.add(lblNewLabelEspecialidadMedica);
		  
		  btnRellenarDatos = new JButton("");
		  btnRellenarDatos.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  btnRellenarDatos.setBounds(60, 344, 168, 113);
		  btnRellenarDatos.setOpaque(false);
		  btnRellenarDatos.setContentAreaFilled(false);
		  btnRellenarDatos.setBorderPainted(false);
		  panelVerDatosMedicos.add(btnRellenarDatos);
		  
		  lblNewLabel_5 = new JLabel("Horario");
		  lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabel_5.setForeground(new Color(255, 128, 0));
		  lblNewLabel_5.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		  lblNewLabel_5.setBounds(60, 289, 168, 25);
		  panelVerDatosMedicos.add(lblNewLabel_5);
		  
		  textFieldHorarioMedico = new JTextField();
		  textFieldHorarioMedico.setBounds(60, 325, 168, 45);
		  panelVerDatosMedicos.add(textFieldHorarioMedico);
		  textFieldHorarioMedico.setColumns(10);
		  
		  textFieldEspecialidadMedico = new JTextField();
		  textFieldEspecialidadMedico.setColumns(10);
		  textFieldEspecialidadMedico.setBounds(60, 233, 168, 45);
		  panelVerDatosMedicos.add(textFieldEspecialidadMedico);
		  
		  lblNewLabelErrorPefilMedico = new JLabel("");
		  lblNewLabelErrorPefilMedico.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelErrorPefilMedico.setForeground(new Color(255, 128, 0));
		  lblNewLabelErrorPefilMedico.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		  lblNewLabelErrorPefilMedico.setBounds(0, 447, 262, 25);
		  panelVerDatosMedicos.add(lblNewLabelErrorPefilMedico);
		  
		  lblNewLabelFondoPerfilMedico = new JLabel("");
		  lblNewLabelFondoPerfilMedico.setBounds(0, 0, 272, 483);
		  panelVerDatosMedicos.add(lblNewLabelFondoPerfilMedico);
		  
		  lblNewLabelFondoMedico = new JLabel("");
		  lblNewLabelFondoMedico.setBounds(0, 0, 1319, 734);
		  panelMedico.add(lblNewLabelFondoMedico);
		    contentPane.add(panelAdmin);
		    panelAdmin.setLayout(null);
		    
		     panelEditarUsuario = new JPanel();
		     panelEditarUsuario.setLayout(null);
		     panelEditarUsuario.setVisible(false);
		     
		      panelCrearAdmin = new JPanel();
		      panelCrearAdmin.setBounds(977, 160, 272, 432);
		      panelCrearAdmin.setVisible(false);
		      panelAdmin.add(panelCrearAdmin);
		      panelCrearAdmin.setLayout(null);
		      
		      lblNewLabel = new JLabel("Nombre Usuario");
		      lblNewLabel.setForeground(new Color(255, 128, 0));
		      lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		      lblNewLabel.setBounds(27, 58, 223, 35);
		      panelCrearAdmin.add(lblNewLabel);
		      
		      lblContraseña = new JLabel("Contraseña");
		      lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		      lblContraseña.setForeground(new Color(255, 128, 0));
		      lblContraseña.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		      lblContraseña.setBounds(27, 135, 223, 35);
		      panelCrearAdmin.add(lblContraseña);
		      
		      lblErrorCrear = new JLabel("");
		      lblErrorCrear.setHorizontalAlignment(SwingConstants.CENTER);
		      lblErrorCrear.setForeground(new Color(255, 0, 0));
		      lblErrorCrear.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		      lblErrorCrear.setBounds(27, 386, 223, 35);
		      panelCrearAdmin.add(lblErrorCrear);
		      
		      textFieldNombreUsuarioCrear = new JTextField();
		      textFieldNombreUsuarioCrear.setBounds(37, 104, 213, 35);
		      panelCrearAdmin.add(textFieldNombreUsuarioCrear);
		      textFieldNombreUsuarioCrear.setColumns(10);
		      
		      textFieldContraseñaCrear = new JTextField();
		      textFieldContraseñaCrear.setColumns(10);
		      textFieldContraseñaCrear.setBounds(37, 181, 213, 35);
		      panelCrearAdmin.add(textFieldContraseñaCrear);
		      
		       lblNewLabelVolverCrear = new JLabel("");
		       lblNewLabelVolverCrear.setBounds(0, 0, 75, 47);
		       panelCrearAdmin.add(lblNewLabelVolverCrear);
		       
		       btnCrearTotal = new JButton("");
		       btnCrearTotal.setBounds(75, 278, 136, 143);
		       btnCrearTotal.setOpaque(false);
		       btnCrearTotal.setContentAreaFilled(false);
		       btnCrearTotal.setBorderPainted(false);
		       panelCrearAdmin.add(btnCrearTotal);
		       
		       lblLabor = new JLabel("Labor");
		       lblLabor.setHorizontalAlignment(SwingConstants.CENTER);
		       lblLabor.setForeground(new Color(255, 128, 0));
		       lblLabor.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		       lblLabor.setBounds(27, 208, 223, 35);
		       panelCrearAdmin.add(lblLabor);
		       
		        comboBoxRoles = new JComboBox();
		        comboBoxRoles.setBounds(37, 254, 213, 22);
		        panelCrearAdmin.add(comboBoxRoles);
		        
		        lblNewLabelFondoCrear = new JLabel("");
		        lblNewLabelFondoCrear.setBounds(0, 0, 272, 432);
		        panelCrearAdmin.add(lblNewLabelFondoCrear);
		        panelEditarUsuario.setBounds(31, 160, 272, 432);
		        panelAdmin.add(panelEditarUsuario);
		        
		        JLabel lblNewLabel_1 = new JLabel("Nombre Usuario");
		        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		        lblNewLabel_1.setForeground(new Color(255, 128, 0));
		        lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		        lblNewLabel_1.setBounds(27, 58, 223, 35);
		        panelEditarUsuario.add(lblNewLabel_1);
		        
		        JLabel lblContraseña_1 = new JLabel("Contraseña");
		        lblContraseña_1.setHorizontalAlignment(SwingConstants.CENTER);
		        lblContraseña_1.setForeground(new Color(255, 128, 0));
		        lblContraseña_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		        lblContraseña_1.setBounds(27, 135, 223, 35);
		        panelEditarUsuario.add(lblContraseña_1);
		        
		         lblErrorEditar = new JLabel("");
		         lblErrorEditar.setHorizontalAlignment(SwingConstants.CENTER);
		         lblErrorEditar.setForeground(Color.RED);
		         lblErrorEditar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		         lblErrorEditar.setBounds(27, 386, 223, 35);
		         panelEditarUsuario.add(lblErrorEditar);
		         
		         textFieldNombreUsuarioEditar = new JTextField();
		         textFieldNombreUsuarioEditar.setColumns(10);
		         textFieldNombreUsuarioEditar.setBounds(37, 104, 213, 35);
		         panelEditarUsuario.add(textFieldNombreUsuarioEditar);
		         
		         textFieldContraseñaEditar = new JTextField();
		         textFieldContraseñaEditar.setColumns(10);
		         textFieldContraseñaEditar.setBounds(37, 181, 213, 35);
		         panelEditarUsuario.add(textFieldContraseñaEditar);
		         
		         lblNewLabelVolverEditar = new JLabel("");
		         lblNewLabelVolverEditar.setBounds(0, 0, 75, 47);
		         panelEditarUsuario.add(lblNewLabelVolverEditar);
		         
		          btnEditarTotal = new JButton("");
		          btnEditarTotal.setBounds(87, 278, 136, 143);
		          btnEditarTotal.setOpaque(false);
		          btnEditarTotal.setContentAreaFilled(false);
		          btnEditarTotal.setBorderPainted(false);
		          panelEditarUsuario.add(btnEditarTotal);
		          
		          JLabel lblLaborEditar = new JLabel("Labor");
		          lblLaborEditar.setHorizontalAlignment(SwingConstants.CENTER);
		          lblLaborEditar.setForeground(new Color(255, 128, 0));
		          lblLaborEditar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		          lblLaborEditar.setBounds(27, 210, 223, 35);
		          panelEditarUsuario.add(lblLaborEditar);
		          
		          lblLaborNombre = new JLabel("");
		          lblLaborNombre.setHorizontalAlignment(SwingConstants.CENTER);
		          lblLaborNombre.setForeground(new Color(255, 128, 0));
		          lblLaborNombre.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		          lblLaborNombre.setBounds(27, 256, 223, 35);
		          panelEditarUsuario.add(lblLaborNombre);
		          
		          lblNewLabelFondeEditar = new JLabel("");
		          lblNewLabelFondeEditar.setBounds(0, 0, 272, 432);
		          panelEditarUsuario.add(lblNewLabelFondeEditar);
		          
		          scrollPane = new JScrollPane();
		          scrollPane.setBounds(344, 184, 556, 388);
		          panelAdmin.add(scrollPane);
		          
		          tablaUsuarios = new JTable();
		          scrollPane.setViewportView(tablaUsuarios);
		          
		          lblNewLabelLogo = new JLabel("");
		          lblNewLabelLogo.setBounds(484, 0, 108, 79);
		          panelAdmin.add(lblNewLabelLogo);
		          
		          JSeparator separator = new JSeparator();
		          separator.setForeground(new Color(255, 128, 0));
		          separator.setBounds(0, 77, 1319, 2);
		          panelAdmin.add(separator);
		          
		           lblNewLabelNombre = new JLabel("VitalMed");
		           lblNewLabelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		           lblNewLabelNombre.setForeground(new Color(255, 128, 0));
		           lblNewLabelNombre.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		           lblNewLabelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		           lblNewLabelNombre.setBounds(453, 11, 424, 68);
		           panelAdmin.add(lblNewLabelNombre);
		           
		            lblNewLabelCara = new JLabel("");
		            lblNewLabelCara.setBounds(1235, 11, 84, 68);
		            panelAdmin.add(lblNewLabelCara);
		            
		             lblNewLabelNombreUsuarioMostrar = new JLabel("");
		             lblNewLabelNombreUsuarioMostrar.setHorizontalAlignment(SwingConstants.RIGHT);
		             lblNewLabelNombreUsuarioMostrar.setForeground(new Color(255, 128, 0));
		             lblNewLabelNombreUsuarioMostrar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		             lblNewLabelNombreUsuarioMostrar.setBounds(1012, 11, 189, 68);
		             panelAdmin.add(lblNewLabelNombreUsuarioMostrar);
		             
		              btnNewButtonCrear = new JButton("");
		              btnNewButtonCrear.setBounds(362, 583, 122, 140);
		              btnNewButtonCrear.setOpaque(false);
		              btnNewButtonCrear.setContentAreaFilled(false);
		              btnNewButtonCrear.setBorderPainted(false);
		              panelAdmin.add(btnNewButtonCrear);
		              
		               btnNewButtonEditar = new JButton("");
		               btnNewButtonEditar.setBounds(559, 583, 122, 140);
		               btnNewButtonEditar.setOpaque(false);
		               btnNewButtonEditar.setContentAreaFilled(false);
		               btnNewButtonEditar.setBorderPainted(false);
		               panelAdmin.add(btnNewButtonEditar);
		               
		                btnNewButtonEliminar = new JButton("");
		                btnNewButtonEliminar.setBounds(768, 583, 122, 140);
		                btnNewButtonEliminar.setOpaque(false);
		                btnNewButtonEliminar.setContentAreaFilled(false);
		                btnNewButtonEliminar.setBorderPainted(false);
		                panelAdmin.add(btnNewButtonEliminar);
		                
		                lblNewLabelSalida = new JLabel("");
		                lblNewLabelSalida.setBounds(0, 0, 84, 79);
		                panelAdmin.add(lblNewLabelSalida);
		                
		                lblNewLabelFondoAdmin = new JLabel("");
		                lblNewLabelFondoAdmin.setBounds(0, 0, 1321, 734);
		                panelAdmin.add(lblNewLabelFondoAdmin);


	}
	
	public static ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
    }//FIN AJUSTAR TAMAÑO IMG
}