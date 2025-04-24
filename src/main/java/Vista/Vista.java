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

import Api.EsqueletoInteractivoAPI;

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
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;


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
	public JLabel lblNewLabelEspecialidadMedica;
	public JButton btnRellenarDatos;
	public JLabel lblNewLabelFondoPerfilMedico;
	public JLabel lblNewLabel_5;
	public JTextField textFieldHorarioMedico;
	public JTextField textFieldEspecialidadMedico;
	public JLabel lblNewLabelErrorPefilMedico;
	public JPanel panelFiltar_Historial;
	public JTable tableHistorialMedico;
	public JLabel lblNombreDelCliente;
	public JTextField textFieldNumero_Telefono;
	public JLabel lblFondoFiltrarHistorial;
	public JLabel lblErrorFiltro;
	public JScrollPane scrollPane_1;
	public JPanel panelCrearHistorialMedico;
	public JLabel lblNewLabelNombre_2;
	public JLabel lblNewLabelNombre_3;
	public JLabel lblNewLabelNombre_4;
	public JLabel lblNewLabelNombre_5;
	public JLabel lblNewLabelNombre_6;
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
	public JLabel lblNewLabelFechaCita;
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
	public JLabel lblVerHistorialMedico;
	public JLabel lblVerCitasPaciente;
	public JLabel lblNewLabelLogoMedico_Paciente;
	public JLabel lblNewLabelNombre_24;
	public JLabel lblNewLabel_FondoInformacionPaciente;
	public JTable tableVerCitasPacientes;
	public JScrollPane scrollPane_3;
	public JTable tableVerHistorialMedico;
	public JScrollPane scrollPane_4;
	public JTable tableVerFacturas_Paciente;
	public JScrollPane scrollPane_5;
	public JLabel lblPagarFacturas;
	public JPanel panelDatos_Cliente_Factura;
	public JLabel lblNewLabelFondo_Datos_Cliente_Factura;
	public JLabel lblNewLabelNombre_25;
	public JLabel lblNewLabelNombre_26;
	public JLabel lblNewLabelNombre_27;
	public JLabel lblNewLabelNombre_28;
	public JTextField textField_Titular_Tarjeta;
	public JTextField textField_Numero_Tarjeta;
	public JTextField textField_CSV_Tarjeta;
	public JCalendar calendar_fecha_expiracion_tarjeta;
	public JLabel lblPagarFactura;
	public JLabel lblPagarFacturas_Definitiva;
	public JPanel panelEsqueleto;
	public JLabel lblNewLabelError_Tarjeta;
	public JLabel lblCrearFacturas;
	public JPanel panelCrearFacturasRecepcion;
	public JLabel lbFondo_Panel_Crear_Facturas;
	public JLabel lblNewLabelNombre_29;
	public JLabel lblNewLabelNombre_30;
	public JLabel lblNewLabelNombre_31;
	public JTextField textFieldImporte;
	public JCalendar calendarFecha_Creacion_Factura;
	public JLabel lblCCrearFacturasFinal;
	public JLabel lblErrorCrearFacturasPaciente;
	public JTextField textFieldlblNombreMedico;
	public JLabel lblNewLabel_CrearPacienteRecepcion;
	public JLabel lblConfirmarExportacion;
	public JLabel lblEnviarCorreo;
	public JPanel panelEnviarCorreo;
	public JLabel lblFondoCorreoElectronico;
	public JLabel lblNewLabelNombre_32;
	public JLabel lblNewLabelNombre_33;
	public JLabel lblNewLabelNombre_34;
	public JTextField textFieldAsuntoDeCorreoElectronico;
	public JLabel lblEnviarCorreElectronico;
	public JLabel lblConfirmarEnviar;
	public JTextArea textAreaCampodeTextoCorreo;
	public JTextArea textAreaDiagnostico;
	public JTextArea textAreaTratamiento;
	public JTextArea textAreaReceta;
	public JScrollPane scrollPane_6;
	public JScrollPane scrollPane_7;
	public JScrollPane scrollPane_8;
	public JScrollPane scrollPane_9;
	public JLabel lblNewLabelSalida_Paciente__Tarjeta;
	public JLabel lblNombre_Recepcion;
	public JLabel lblNewLabelNombre_Usuario_Medico;
	public JComboBox comboBoxNombre_Medicos;
	public JButton btnBuscarHistorial;
	public JLabel lblNewLabelNombre_Paciente;
	public JComboBox comboBoxNombre_Paciente;
	public JComboBox comboBox_Nombre_Paciente_Facturas;
	public JTextField textField_Corre_Electronico_Paciente;
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
		                                                      
		                                                       panelPacientes = new JPanel();
		                                                       panelPacientes.setBounds(0, 0, 1329, 734);
		                                                       panelPacientes.setVisible(false);
		                                                                   
		                                                                    panelRececipnista = new JPanel();
		                                                                    panelRececipnista.setBounds(0, 0, 1329, 734);
		                                                                    panelRececipnista.setVisible(false);
		                                                                    panelRececipnista.setVisible(false);
		                                                                       
		                                                                        panelMedico = new JPanel();
		                                                                        panelMedico.setBounds(0, 0, 1329, 734);
		                                                                        panelMedico.setVisible(false);
		                                                                        
		                                                                         panelAdmin = new JPanel();
		                                                                         panelAdmin.setBounds(0, 0, 1329, 734);
		                                                                         panelAdmin.setVisible(false);
		                                                                         contentPane.add(panelAdmin);
		                                                                         panelAdmin.setLayout(null);
		                                                                         
		                                                                          panelCrearAdmin = new JPanel();
		                                                                          panelCrearAdmin.setBounds(910, 101, 272, 471);
		                                                                          panelCrearAdmin.setVisible(false);
		                                                                          
		                                                                           panelEditarUsuario = new JPanel();
		                                                                           panelEditarUsuario.setLayout(null);
		                                                                           panelEditarUsuario.setVisible(false);
		                                                                           panelEditarUsuario.setBounds(31, 101, 272, 471);
		                                                                           panelAdmin.add(panelEditarUsuario);
		                                                                           
		                                                                           JLabel lblNewLabel_1 = new JLabel("Nombre Usuario");
		                                                                           lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                           lblNewLabel_1.setForeground(new Color(255, 128, 0));
		                                                                           lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                           lblNewLabel_1.setBounds(27, 69, 223, 35);
		                                                                           panelEditarUsuario.add(lblNewLabel_1);
		                                                                           
		                                                                           JLabel lblContraseña_1 = new JLabel("Contraseña");
		                                                                           lblContraseña_1.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                           lblContraseña_1.setForeground(new Color(255, 128, 0));
		                                                                           lblContraseña_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                           lblContraseña_1.setBounds(27, 150, 223, 35);
		                                                                           panelEditarUsuario.add(lblContraseña_1);
		                                                                           
		                                                                            lblErrorEditar = new JLabel("");
		                                                                            lblErrorEditar.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                            lblErrorEditar.setForeground(Color.RED);
		                                                                            lblErrorEditar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		                                                                            lblErrorEditar.setBounds(27, 386, 223, 74);
		                                                                            panelEditarUsuario.add(lblErrorEditar);
		                                                                            
		                                                                            textFieldNombreUsuarioEditar = new JTextField();
		                                                                            textFieldNombreUsuarioEditar.setColumns(10);
		                                                                            textFieldNombreUsuarioEditar.setBounds(37, 104, 213, 47);
		                                                                            panelEditarUsuario.add(textFieldNombreUsuarioEditar);
		                                                                            
		                                                                            textFieldContraseñaEditar = new JTextField();
		                                                                            textFieldContraseñaEditar.setColumns(10);
		                                                                            textFieldContraseñaEditar.setBounds(37, 181, 213, 47);
		                                                                            panelEditarUsuario.add(textFieldContraseñaEditar);
		                                                                            
		                                                                            lblNewLabelVolverEditar = new JLabel("");
		                                                                            lblNewLabelVolverEditar.setBounds(0, 0, 75, 58);
		                                                                            panelEditarUsuario.add(lblNewLabelVolverEditar);
		                                                                            
		                                                                             btnEditarTotal = new JButton("");
		                                                                             btnEditarTotal.setBounds(70, 290, 136, 143);
		                                                                             btnEditarTotal.setOpaque(false);
		                                                                             btnEditarTotal.setContentAreaFilled(false);
		                                                                             btnEditarTotal.setBorderPainted(false);
		                                                                             panelEditarUsuario.add(btnEditarTotal);
		                                                                             
		                                                                             JLabel lblLaborEditar = new JLabel("Labor");
		                                                                             lblLaborEditar.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                             lblLaborEditar.setForeground(new Color(255, 128, 0));
		                                                                             lblLaborEditar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                             lblLaborEditar.setBounds(27, 229, 223, 35);
		                                                                             panelEditarUsuario.add(lblLaborEditar);
		                                                                             
		                                                                             lblLaborNombre = new JLabel("");
		                                                                             lblLaborNombre.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                             lblLaborNombre.setForeground(new Color(255, 128, 0));
		                                                                             lblLaborNombre.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                             lblLaborNombre.setBounds(37, 264, 213, 47);
		                                                                             panelEditarUsuario.add(lblLaborNombre);
		                                                                             
		                                                                             lblNewLabelFondeEditar = new JLabel("");
		                                                                             lblNewLabelFondeEditar.setBounds(0, 0, 272, 472);
		                                                                             panelEditarUsuario.add(lblNewLabelFondeEditar);
		                                                                             panelAdmin.add(panelCrearAdmin);
		                                                                             panelCrearAdmin.setLayout(null);
		                                                                             
		                                                                             lblNewLabel = new JLabel("Nombre Usuario");
		                                                                             lblNewLabel.setForeground(new Color(255, 128, 0));
		                                                                             lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                             lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                             lblNewLabel.setBounds(27, 68, 223, 35);
		                                                                             panelCrearAdmin.add(lblNewLabel);
		                                                                             
		                                                                             lblContraseña = new JLabel("Contraseña");
		                                                                             lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                             lblContraseña.setForeground(new Color(255, 128, 0));
		                                                                             lblContraseña.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                             lblContraseña.setBounds(27, 150, 223, 35);
		                                                                             panelCrearAdmin.add(lblContraseña);
		                                                                             
		                                                                             lblErrorCrear = new JLabel("");
		                                                                             lblErrorCrear.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                             lblErrorCrear.setForeground(new Color(255, 0, 0));
		                                                                             lblErrorCrear.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		                                                                             lblErrorCrear.setBounds(27, 397, 223, 63);
		                                                                             panelCrearAdmin.add(lblErrorCrear);
		                                                                             
		                                                                             textFieldNombreUsuarioCrear = new JTextField();
		                                                                             textFieldNombreUsuarioCrear.setBounds(37, 104, 213, 47);
		                                                                             panelCrearAdmin.add(textFieldNombreUsuarioCrear);
		                                                                             textFieldNombreUsuarioCrear.setColumns(10);
		                                                                             
		                                                                             textFieldContraseñaCrear = new JTextField();
		                                                                             textFieldContraseñaCrear.setColumns(10);
		                                                                             textFieldContraseñaCrear.setBounds(37, 181, 213, 47);
		                                                                             panelCrearAdmin.add(textFieldContraseñaCrear);
		                                                                             
		                                                                              lblNewLabelVolverCrear = new JLabel("");
		                                                                              lblNewLabelVolverCrear.setBounds(0, 0, 75, 57);
		                                                                              panelCrearAdmin.add(lblNewLabelVolverCrear);
		                                                                              
		                                                                              btnCrearTotal = new JButton("");
		                                                                              btnCrearTotal.setBounds(75, 289, 136, 143);
		                                                                              btnCrearTotal.setOpaque(false);
		                                                                              btnCrearTotal.setContentAreaFilled(false);
		                                                                              btnCrearTotal.setBorderPainted(false);
		                                                                              panelCrearAdmin.add(btnCrearTotal);
		                                                                              
		                                                                              lblLabor = new JLabel("Labor");
		                                                                              lblLabor.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                              lblLabor.setForeground(new Color(255, 128, 0));
		                                                                              lblLabor.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                              lblLabor.setBounds(27, 221, 223, 35);
		                                                                              panelCrearAdmin.add(lblLabor);
		                                                                              
		                                                                               comboBoxRoles = new JComboBox();
		                                                                               comboBoxRoles.setBounds(37, 267, 213, 35);
		                                                                               panelCrearAdmin.add(comboBoxRoles);
		                                                                               
		                                                                               lblNewLabelFondoCrear = new JLabel("");
		                                                                               lblNewLabelFondoCrear.setBounds(0, 0, 272, 471);
		                                                                               panelCrearAdmin.add(lblNewLabelFondoCrear);
		                                                                               
		                                                                               scrollPane = new JScrollPane();
		                                                                               scrollPane.setBounds(313, 101, 587, 471);
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
		                                                                                   btnNewButtonCrear.setBounds(344, 528, 153, 237);
		                                                                                   btnNewButtonCrear.setOpaque(false);
		                                                                                   btnNewButtonCrear.setContentAreaFilled(false);
		                                                                                   btnNewButtonCrear.setBorderPainted(false);
		                                                                                   panelAdmin.add(btnNewButtonCrear);
		                                                                                   
		                                                                                    btnNewButtonEditar = new JButton("");
		                                                                                    btnNewButtonEditar.setBounds(545, 528, 153, 237);
		                                                                                    btnNewButtonEditar.setOpaque(false);
		                                                                                    btnNewButtonEditar.setContentAreaFilled(false);
		                                                                                    btnNewButtonEditar.setBorderPainted(false);
		                                                                                    panelAdmin.add(btnNewButtonEditar);
		                                                                                    
		                                                                                     btnNewButtonEliminar = new JButton("");
		                                                                                     btnNewButtonEliminar.setBounds(747, 528, 153, 237);
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
		                                                                        contentPane.add(panelMedico);
		                                                                        panelMedico.setLayout(null);
		                                                                        
		                                                                        scrollPane_1 = new JScrollPane();
		                                                                        scrollPane_1.setBounds(54, 90, 874, 633);
		                                                                        scrollPane_1.setVisible(false);
		                                                                        
		                                                                        scrollPane_2 = new JScrollPane();
		                                                                        scrollPane_2.setBounds(66, 90, 862, 633);
		                                                                        scrollPane_2.setVisible(false);
		                                                                        
		                                                                        panelCrearHistorialMedico = new JPanel();
		                                                                        panelCrearHistorialMedico.setBounds(66, 90, 862, 633);
		                                                                        panelCrearHistorialMedico.setVisible(false);
		                                                                        
		                                                                        panelFiltar_Historial = new JPanel();
		                                                                        panelFiltar_Historial.setBounds(938, 90, 290, 633);
		                                                                        panelFiltar_Historial.setVisible(false);
		                                                                        
		                                                                        panelEnviarCorreo = new JPanel();
		                                                                        panelEnviarCorreo.setBounds(42, 89, 886, 634);
		                                                                        panelMedico.add(panelEnviarCorreo);
		                                                                        panelEnviarCorreo.setVisible(false);
		                                                                        panelEnviarCorreo.setLayout(null);
		                                                                        
		                                                                        textField_Corre_Electronico_Paciente = new JTextField();
		                                                                        textField_Corre_Electronico_Paciente.setColumns(10);
		                                                                        textField_Corre_Electronico_Paciente.setBounds(36, 124, 414, 68);
		                                                                        panelEnviarCorreo.add(textField_Corre_Electronico_Paciente);
		                                                                        
		                                                                        scrollPane_9 = new JScrollPane();
		                                                                        scrollPane_9.setBounds(36, 258, 838, 215);
		                                                                        panelEnviarCorreo.add(scrollPane_9);
		                                                                        
		                                                                        textAreaCampodeTextoCorreo = new JTextArea();
		                                                                        scrollPane_9.setViewportView(textAreaCampodeTextoCorreo);
		                                                                        
		                                                                        lblConfirmarEnviar = new JLabel("");
		                                                                        lblConfirmarEnviar.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblConfirmarEnviar.setForeground(new Color(255, 128, 0));
		                                                                        lblConfirmarEnviar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblConfirmarEnviar.setBounds(383, 521, 511, 68);
		                                                                        panelEnviarCorreo.add(lblConfirmarEnviar);
		                                                                        
		                                                                        lblEnviarCorreElectronico = new JLabel("");
		                                                                        lblEnviarCorreElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		                                                                        lblEnviarCorreElectronico.setForeground(new Color(255, 128, 0));
		                                                                        lblEnviarCorreElectronico.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblEnviarCorreElectronico.setBounds(81, 440, 292, 215);
		                                                                        panelEnviarCorreo.add(lblEnviarCorreElectronico);
		                                                                        
		                                                                        textFieldAsuntoDeCorreoElectronico = new JTextField();
		                                                                        textFieldAsuntoDeCorreoElectronico.setColumns(10);
		                                                                        textFieldAsuntoDeCorreoElectronico.setBounds(460, 124, 414, 68);
		                                                                        panelEnviarCorreo.add(textFieldAsuntoDeCorreoElectronico);
		                                                                        
		                                                                        lblNewLabelNombre_34 = new JLabel("Campo de texto");
		                                                                        lblNewLabelNombre_34.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_34.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelNombre_34.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_34.setBounds(258, 203, 424, 68);
		                                                                        panelEnviarCorreo.add(lblNewLabelNombre_34);
		                                                                        
		                                                                        lblNewLabelNombre_33 = new JLabel("Asunto");
		                                                                        lblNewLabelNombre_33.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_33.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelNombre_33.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_33.setBounds(452, 45, 424, 68);
		                                                                        panelEnviarCorreo.add(lblNewLabelNombre_33);
		                                                                        
		                                                                        lblNewLabelNombre_32 = new JLabel("Correo Electronico");
		                                                                        lblNewLabelNombre_32.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_32.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelNombre_32.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_32.setBounds(36, 45, 424, 68);
		                                                                        panelEnviarCorreo.add(lblNewLabelNombre_32);
		                                                                        
		                                                                        lblFondoCorreoElectronico = new JLabel("");
		                                                                        lblFondoCorreoElectronico.setBounds(0, 0, 886, 634);
		                                                                        panelEnviarCorreo.add(lblFondoCorreoElectronico);
		                                                                        
		                                                                        panelMedico.add(panelFiltar_Historial);
		                                                                        panelFiltar_Historial.setLayout(null);
		                                                                        
		                                                                        panelEsqueleto = new JPanel();
		                                                                        panelEsqueleto.setBounds(26, 266, 244, 367);
		                                                                        panelEsqueleto.setVisible(false);
		                                                                        panelEsqueleto.setOpaque(true);
		                                                                        panelFiltar_Historial.add(panelEsqueleto);
		                                                                        panelEsqueleto.setLayout(null);
		                                                                        
		                                                                        lblErrorFiltro = new JLabel("");
		                                                                        lblErrorFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblErrorFiltro.setForeground(new Color(255, 128, 0));
		                                                                        lblErrorFiltro.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		                                                                        lblErrorFiltro.setBounds(0, 382, 290, 68);
		                                                                        panelFiltar_Historial.add(lblErrorFiltro);
		                                                                        
		                                                                        lblNombreDelCliente = new JLabel("Numero telefono");
		                                                                        lblNombreDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNombreDelCliente.setForeground(new Color(255, 128, 0));
		                                                                        lblNombreDelCliente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNombreDelCliente.setBounds(0, 11, 290, 68);
		                                                                        panelFiltar_Historial.add(lblNombreDelCliente);
		                                                                        
		                                                                        textFieldNumero_Telefono = new JTextField();
		                                                                        textFieldNumero_Telefono.setBounds(26, 90, 244, 46);
		                                                                        panelFiltar_Historial.add(textFieldNumero_Telefono);
		                                                                        textFieldNumero_Telefono.setColumns(10);
		                                                                        
		                                                                        btnBuscarHistorial = new JButton("");
		                                                                        btnBuscarHistorial.setOpaque(false);
		                                                                        btnBuscarHistorial.setContentAreaFilled(false);
		                                                                        btnBuscarHistorial.setBorderPainted(false);
		                                                                        btnBuscarHistorial.setBounds(26, 147, 244, 191);
		                                                                        panelFiltar_Historial.add(btnBuscarHistorial);
		                                                                        
		                                                                        lblFondoFiltrarHistorial = new JLabel("");
		                                                                        lblFondoFiltrarHistorial.setBounds(0, 0, 290, 633);
		                                                                        panelFiltar_Historial.add(lblFondoFiltrarHistorial);
		                                                                        
		                                                                        panelVerDatosMedicos = new JPanel();
		                                                                        panelVerDatosMedicos.setBounds(1014, 111, 272, 483);
		                                                                        panelMedico.add(panelVerDatosMedicos);
		                                                                        panelVerDatosMedicos.setVisible(false);
		                                                                        panelVerDatosMedicos.setLayout(null);
		                                                                        
		                                                                        textFieldlblNombreMedico = new JTextField();
		                                                                        textFieldlblNombreMedico.setBounds(60, 118, 168, 45);
		                                                                        panelVerDatosMedicos.add(textFieldlblNombreMedico);
		                                                                        textFieldlblNombreMedico.setColumns(10);
		                                                                        
		                                                                        lblNewLabel_2 = new JLabel("Nombre Usuario");
		                                                                        lblNewLabel_2.setBounds(60, 82, 168, 25);
		                                                                        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabel_2.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabel_2.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                        panelVerDatosMedicos.add(lblNewLabel_2);
		                                                                        
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
		                                                                        
		                                                                        panelFiltrarCitas = new JPanel();
		                                                                        panelFiltrarCitas.setBounds(938, 90, 290, 633);
		                                                                        panelMedico.add(panelFiltrarCitas);
		                                                                        panelFiltrarCitas.setVisible(false);
		                                                                        panelFiltrarCitas.setLayout(null);
		                                                                        
		                                                                        calendarioCitas = new JCalendar();
		                                                                        calendarioCitas.setBounds(44, 76, 204, 153);
		                                                                        panelFiltrarCitas.add(calendarioCitas);
		                                                                        
		                                                                        lblNewLabelErrorCitas = new JLabel("");
		                                                                        lblNewLabelErrorCitas.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelErrorCitas.setForeground(new Color(255, 0, 0));
		                                                                        lblNewLabelErrorCitas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                                        lblNewLabelErrorCitas.setBounds(32, 537, 248, 68);
		                                                                        panelFiltrarCitas.add(lblNewLabelErrorCitas);
		                                                                        
		                                                                        btnFiltrarCitas = new JButton("");
		                                                                        btnFiltrarCitas.setBounds(32, 240, 238, 237);
		                                                                        btnFiltrarCitas.setOpaque(false);
		                                                                        btnFiltrarCitas.setContentAreaFilled(false);
		                                                                        btnFiltrarCitas.setBorderPainted(false);
		                                                                        panelFiltrarCitas.add(btnFiltrarCitas);
		                                                                        
		                                                                        lblNewLabelFechaCita = new JLabel("Fecha de Cita");
		                                                                        lblNewLabelFechaCita.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelFechaCita.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelFechaCita.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelFechaCita.setBounds(21, 22, 248, 68);
		                                                                        panelFiltrarCitas.add(lblNewLabelFechaCita);
		                                                                        
		                                                                        lblNewLabelFondoFiltrarCita = new JLabel("");
		                                                                        lblNewLabelFondoFiltrarCita.setBounds(0, 0, 290, 633);
		                                                                        panelFiltrarCitas.add(lblNewLabelFondoFiltrarCita);
		                                                                        panelMedico.add(panelCrearHistorialMedico);
		                                                                        
		                                                                        panelCrearHistorialMedico.setLayout(null);
		                                                                        
		                                                                        lblNewLabelNombre_Paciente = new JLabel("");
		                                                                        lblNewLabelNombre_Paciente.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_Paciente.setForeground(Color.BLACK);
		                                                                        lblNewLabelNombre_Paciente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_Paciente.setBounds(38, 98, 248, 68);
		                                                                        panelCrearHistorialMedico.add(lblNewLabelNombre_Paciente);
		                                                                        
		                                                                        lblNewLabelNombre_Usuario_Medico = new JLabel("");
		                                                                        lblNewLabelNombre_Usuario_Medico.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_Usuario_Medico.setForeground(new Color(0, 0, 0));
		                                                                        lblNewLabelNombre_Usuario_Medico.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_Usuario_Medico.setBounds(509, 98, 248, 68);
		                                                                        panelCrearHistorialMedico.add(lblNewLabelNombre_Usuario_Medico);
		                                                                        
		                                                                        scrollPane_8 = new JScrollPane();
		                                                                        scrollPane_8.setBounds(38, 436, 248, 105);
		                                                                        panelCrearHistorialMedico.add(scrollPane_8);
		                                                                        
		                                                                        textAreaReceta = new JTextArea();
		                                                                        scrollPane_8.setViewportView(textAreaReceta);
		                                                                        
		                                                                        scrollPane_7 = new JScrollPane();
		                                                                        scrollPane_7.setBounds(509, 230, 248, 105);
		                                                                        panelCrearHistorialMedico.add(scrollPane_7);
		                                                                        
		                                                                        textAreaTratamiento = new JTextArea();
		                                                                        scrollPane_7.setViewportView(textAreaTratamiento);
		                                                                        
		                                                                        scrollPane_6 = new JScrollPane();
		                                                                        scrollPane_6.setBounds(38, 230, 248, 105);
		                                                                        panelCrearHistorialMedico.add(scrollPane_6);
		                                                                        
		                                                                        textAreaDiagnostico = new JTextArea();
		                                                                        scrollPane_6.setViewportView(textAreaDiagnostico);
		                                                                        
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
		                                                                        
		                                                                        lblNewLabelNombre_3 = new JLabel("Nombre medico");
		                                                                        lblNewLabelNombre_3.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_3.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelNombre_3.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_3.setBounds(509, 35, 248, 68);
		                                                                        panelCrearHistorialMedico.add(lblNewLabelNombre_3);
		                                                                        
		                                                                        lblNewLabelNombre_4 = new JLabel("Diagnostico");
		                                                                        lblNewLabelNombre_4.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_4.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelNombre_4.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_4.setBounds(38, 168, 248, 68);
		                                                                        panelCrearHistorialMedico.add(lblNewLabelNombre_4);
		                                                                        
		                                                                        lblNewLabelNombre_5 = new JLabel("Tratamiento");
		                                                                        lblNewLabelNombre_5.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_5.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelNombre_5.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_5.setBounds(509, 161, 248, 68);
		                                                                        panelCrearHistorialMedico.add(lblNewLabelNombre_5);
		                                                                        
		                                                                        lblNewLabelNombre_6 = new JLabel("Receta");
		                                                                        lblNewLabelNombre_6.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_6.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelNombre_6.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_6.setBounds(38, 357, 248, 68);
		                                                                        panelCrearHistorialMedico.add(lblNewLabelNombre_6);
		                                                                        
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
		                                                                        panelMedico.add(scrollPane_1);
		                                                                        tableHistorialMedico = new JTable();
		                                                                        scrollPane_1.setViewportView(tableHistorialMedico);
		                                                                        tableHistorialMedico.setVisible(false);
		                                                                        
		                                                                        lblNewLabelLogoMedico = new JLabel("");
		                                                                        lblNewLabelLogoMedico.setBounds(592, 0, 108, 79);
		                                                                        panelMedico.add(lblNewLabelLogoMedico);
		                                                                        
		                                                                        lblNewLabelNombre_1 = new JLabel("VitalMed");
		                                                                        lblNewLabelNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                        lblNewLabelNombre_1.setForeground(new Color(255, 128, 0));
		                                                                        lblNewLabelNombre_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblNewLabelNombre_1.setBounds(568, 11, 424, 68);
		                                                                        panelMedico.add(lblNewLabelNombre_1);
		                                                                        
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
		                                                                        
		                                                                        lblEnviarCorreo = new JLabel("");
		                                                                        lblEnviarCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		                                                                        lblEnviarCorreo.setForeground(new Color(255, 128, 0));
		                                                                        lblEnviarCorreo.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                        lblEnviarCorreo.setBounds(487, -23, 113, 134);
		                                                                        panelMedico.add(lblEnviarCorreo);
		                                                                        
		                                                                        lblNewLabelSalidaMedico = new JLabel("");
		                                                                        lblNewLabelSalidaMedico.setBounds(0, 0, 84, 79);
		                                                                        panelMedico.add(lblNewLabelSalidaMedico);
		                                                                        
		                                                                        lblNewLabelFondoMedico = new JLabel("");
		                                                                        lblNewLabelFondoMedico.setBounds(0, 0, 1319, 734);
		                                                                        panelMedico.add(lblNewLabelFondoMedico);
		                                                                    
		                                                                     
		                                                                    
		                                                                       contentPane.add(panelRececipnista);
		                                                                       panelRececipnista.setLayout(null);
		                                                                       
		                                                                       panelCrearPacienteRecepcion = new JPanel();
		                                                                       panelCrearPacienteRecepcion.setLayout(null);
		                                                                       panelCrearPacienteRecepcion.setBounds(50, 90, 878, 633);
		                                                                       panelCrearPacienteRecepcion.setVisible(false);
		                                                                       
		                                                                       panelProgramarCitasRecpecionosta = new JPanel();
		                                                                       panelProgramarCitasRecpecionosta.setBounds(50, 90, 878, 633);
		                                                                       panelProgramarCitasRecpecionosta.setVisible(false);
		                                                                       
		                                                                       panelInformacionPaciente = new JPanel();
		                                                                       panelInformacionPaciente.setBounds(1014, 104, 272, 197);
		                                                                       panelInformacionPaciente.setVisible(false);
		                                                                       
		                                                                       panelRececipnista.add(panelInformacionPaciente);
		                                                                       panelInformacionPaciente.setLayout(null);
		                                                                       
		                                                                       lblNombre_Recepcion = new JLabel("");
		                                                                       lblNombre_Recepcion.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblNombre_Recepcion.setForeground(new Color(0, 0, 0));
		                                                                       lblNombre_Recepcion.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblNombre_Recepcion.setBounds(-79, 90, 424, 68);
		                                                                       panelInformacionPaciente.add(lblNombre_Recepcion);
		                                                                       
		                                                                       lblNewLabelNombre_9 = new JLabel("Nombre");
		                                                                       lblNewLabelNombre_9.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblNewLabelNombre_9.setForeground(new Color(255, 128, 0));
		                                                                       lblNewLabelNombre_9.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblNewLabelNombre_9.setBounds(-79, 11, 424, 68);
		                                                                       panelInformacionPaciente.add(lblNewLabelNombre_9);
		                                                                       
		                                                                       lblNewLabelFondoPerfilRecepcionista = new JLabel("");
		                                                                       lblNewLabelFondoPerfilRecepcionista.setBounds(0, 0, 272, 483);
		                                                                       panelInformacionPaciente.add(lblNewLabelFondoPerfilRecepcionista);
		                                                                       
		                                                                       panelCrearFacturasRecepcion = new JPanel();
		                                                                       panelCrearFacturasRecepcion.setBounds(40, 90, 892, 633);
		                                                                       panelRececipnista.add(panelCrearFacturasRecepcion);
		                                                                       panelCrearFacturasRecepcion.setVisible(false);
		                                                                       panelCrearFacturasRecepcion.setLayout(null);
		                                                                       
		                                                                       comboBox_Nombre_Paciente_Facturas = new JComboBox();
		                                                                       comboBox_Nombre_Paciente_Facturas.setBounds(112, 120, 357, 68);
		                                                                       panelCrearFacturasRecepcion.add(comboBox_Nombre_Paciente_Facturas);
		                                                                       
		                                                                       lblErrorCrearFacturasPaciente = new JLabel("");
		                                                                       lblErrorCrearFacturasPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblErrorCrearFacturasPaciente.setForeground(new Color(255, 0, 0));
		                                                                       lblErrorCrearFacturasPaciente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblErrorCrearFacturasPaciente.setBounds(54, 521, 780, 68);
		                                                                       panelCrearFacturasRecepcion.add(lblErrorCrearFacturasPaciente);
		                                                                       
		                                                                       calendarFecha_Creacion_Factura = new JCalendar();
		                                                                       calendarFecha_Creacion_Factura.setBounds(86, 301, 363, 153);
		                                                                       panelCrearFacturasRecepcion.add(calendarFecha_Creacion_Factura);
		                                                                       
		                                                                       textFieldImporte = new JTextField();
		                                                                       textFieldImporte.setColumns(10);
		                                                                       textFieldImporte.setBounds(505, 120, 363, 68);
		                                                                       panelCrearFacturasRecepcion.add(textFieldImporte);
		                                                                       
		                                                                       lblCCrearFacturasFinal = new JLabel("");
		                                                                       lblCCrearFacturasFinal.setHorizontalAlignment(SwingConstants.RIGHT);
		                                                                       lblCCrearFacturasFinal.setForeground(new Color(255, 128, 0));
		                                                                       lblCCrearFacturasFinal.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblCCrearFacturasFinal.setBounds(505, 265, 329, 258);
		                                                                       panelCrearFacturasRecepcion.add(lblCCrearFacturasFinal);
		                                                                       
		                                                                       lblNewLabelNombre_31 = new JLabel("Fecha creacion factura");
		                                                                       lblNewLabelNombre_31.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblNewLabelNombre_31.setForeground(new Color(255, 128, 0));
		                                                                       lblNewLabelNombre_31.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblNewLabelNombre_31.setBounds(55, 235, 424, 68);
		                                                                       panelCrearFacturasRecepcion.add(lblNewLabelNombre_31);
		                                                                       
		                                                                       lblNewLabelNombre_30 = new JLabel("Importe");
		                                                                       lblNewLabelNombre_30.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblNewLabelNombre_30.setForeground(new Color(255, 128, 0));
		                                                                       lblNewLabelNombre_30.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblNewLabelNombre_30.setBounds(529, 41, 363, 68);
		                                                                       panelCrearFacturasRecepcion.add(lblNewLabelNombre_30);
		                                                                       
		                                                                       lblNewLabelNombre_29 = new JLabel("Nombre del Paciente");
		                                                                       lblNewLabelNombre_29.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblNewLabelNombre_29.setForeground(new Color(255, 128, 0));
		                                                                       lblNewLabelNombre_29.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblNewLabelNombre_29.setBounds(55, 41, 424, 68);
		                                                                       panelCrearFacturasRecepcion.add(lblNewLabelNombre_29);
		                                                                       
		                                                                       lbFondo_Panel_Crear_Facturas = new JLabel("");
		                                                                       lbFondo_Panel_Crear_Facturas.setBounds(0, 0, 892, 633);
		                                                                       panelCrearFacturasRecepcion.add(lbFondo_Panel_Crear_Facturas);
		                                                                       
		   
		                                                                       panelRececipnista.add(panelProgramarCitasRecpecionosta);
		                                                                       panelProgramarCitasRecpecionosta.setLayout(null);
		                                                                       
		                                                                       comboBoxNombre_Paciente = new JComboBox();
		                                                                       comboBoxNombre_Paciente.setBounds(84, 98, 231, 43);
		                                                                       panelProgramarCitasRecpecionosta.add(comboBoxNombre_Paciente);
		                                                                       
		                                                                       comboBoxNombre_Medicos = new JComboBox();
		                                                                       comboBoxNombre_Medicos.setBounds(548, 98, 231, 43);
		                                                                       panelProgramarCitasRecpecionosta.add(comboBoxNombre_Medicos);
		                                                                       
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
		                                                                       
		                                                                       lblNewLabel_CrearPacienteRecepcion = new JLabel("");
		                                                                       lblNewLabel_CrearPacienteRecepcion.setBounds(100, 428, 225, 194);
		                                                                       panelCrearPacienteRecepcion.add(lblNewLabel_CrearPacienteRecepcion);
		                                                                       
		                                                                       lblNewLabelErrorCrearPacienteRecepcion = new JLabel("");
		                                                                       lblNewLabelErrorCrearPacienteRecepcion.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblNewLabelErrorCrearPacienteRecepcion.setForeground(new Color(255, 128, 0));
		                                                                       lblNewLabelErrorCrearPacienteRecepcion.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblNewLabelErrorCrearPacienteRecepcion.setBounds(410, 487, 424, 68);
		                                                                       panelCrearPacienteRecepcion.add(lblNewLabelErrorCrearPacienteRecepcion);
		                                                                       
		                                                                       lblNewLabelFondoPanelCrearPaciente = new JLabel("");
		                                                                       lblNewLabelFondoPanelCrearPaciente.setBounds(0, 0, 878, 633);
		                                                                       panelCrearPacienteRecepcion.add(lblNewLabelFondoPanelCrearPaciente);
		                                                                       
		                                                                       panelExportacion = new JPanel();
		                                                                       panelExportacion.setBounds(40, 90, 892, 633);
		                                                                       panelRececipnista.add(panelExportacion);
		                                                                       panelExportacion.setVisible(false);
		                                                                       panelExportacion.setLayout(null);
		                                                                       
		                                                                       lblConfirmarExportacion = new JLabel("");
		                                                                       lblConfirmarExportacion.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblConfirmarExportacion.setForeground(new Color(255, 128, 0));
		                                                                       lblConfirmarExportacion.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblConfirmarExportacion.setBounds(211, 575, 424, 68);
		                                                                       panelExportacion.add(lblConfirmarExportacion);
		                                                                       
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
		                                                                       panelEmisiondeFacturasRecepcionista.setOpaque(false);  
		                                                                       panelExportacion.add(panelEmisiondeFacturasRecepcionista);
		                                                                       panelEmisiondeFacturasRecepcionista.setVisible(false);
		                                                                       panelEmisiondeFacturasRecepcionista.setLayout(null);
		                                                                       
		                                                                       lblNewLabelFondoEmisionFacturasRecepcion = new JLabel("New label");
		                                                                       lblNewLabelFondoEmisionFacturasRecepcion.setBounds(0, 0, 892, 633);
		                                                                       panelExportacion.add(lblNewLabelFondoEmisionFacturasRecepcion);
		                                                                       
		                                                                       lblCrearFacturas = new JLabel("");
		                                                                       lblCrearFacturas.setHorizontalAlignment(SwingConstants.RIGHT);
		                                                                       lblCrearFacturas.setForeground(new Color(255, 128, 0));
		                                                                       lblCrearFacturas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblCrearFacturas.setBounds(511, -23, 113, 134);
		                                                                       panelRececipnista.add(lblCrearFacturas);
		                                                                       
		                                                                       lblNewLabelSalidaRecepcionista = new JLabel("");
		                                                                       lblNewLabelSalidaRecepcionista.setBounds(0, 0, 84, 79);
		                                                                       panelRececipnista.add(lblNewLabelSalidaRecepcionista);
		                                                                       
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
		                                                                       lblNewLabelLogoRecepcionista.setBounds(639, 0, 108, 79);
		                                                                       panelRececipnista.add(lblNewLabelLogoRecepcionista);
		                                                                       
		                                                                       lblNewLabelNombre_8 = new JLabel("VitalMed");
		                                                                       lblNewLabelNombre_8.setHorizontalAlignment(SwingConstants.CENTER);
		                                                                       lblNewLabelNombre_8.setForeground(new Color(255, 128, 0));
		                                                                       lblNewLabelNombre_8.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                                       lblNewLabelNombre_8.setBounds(608, 11, 424, 68);
		                                                                       panelRececipnista.add(lblNewLabelNombre_8);
		                                                                       
		                                                                       lblNewLabelFondoRecepcionista = new JLabel("");
		                                                                       lblNewLabelFondoRecepcionista.setBounds(0, 0, 1329, 734);
		                                                                       panelRececipnista.add(lblNewLabelFondoRecepcionista);
		                                                       contentPane.add(panelPacientes);
		                                                       panelPacientes.setLayout(null);
		                                                       
		                                                       scrollPane_3 = new JScrollPane();
		                                                       scrollPane_3.setBounds(42, 90, 895, 633);
		                                                       scrollPane_3.setVisible(false);
		                                                       
		                                                       scrollPane_4 = new JScrollPane();
		                                                       scrollPane_4.setBounds(42, 90, 895, 633);
		                                                       scrollPane_4.setVisible(false);
		                                                       
		                                                       panelDatos_Cliente_Factura = new JPanel();
		                                                       panelDatos_Cliente_Factura.setBounds(204, 166, 611, 442);
		                                                       panelDatos_Cliente_Factura.setVisible(false);
		                                                       panelPacientes.add(panelDatos_Cliente_Factura);
		                                                       
		                                                       panelDatos_Cliente_Factura.setLayout(null);
		                                                       
		                                                       lblNewLabelSalida_Paciente__Tarjeta = new JLabel("");
		                                                       lblNewLabelSalida_Paciente__Tarjeta.setBounds(0, 0, 84, 79);
		                                                       panelDatos_Cliente_Factura.add(lblNewLabelSalida_Paciente__Tarjeta);
		                                                       
		                                                       lblNewLabelError_Tarjeta = new JLabel("");
		                                                       lblNewLabelError_Tarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		                                                       lblNewLabelError_Tarjeta.setForeground(new Color(255, 0, 0));
		                                                       lblNewLabelError_Tarjeta.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		                                                       lblNewLabelError_Tarjeta.setBounds(243, 374, 360, 68);
		                                                       panelDatos_Cliente_Factura.add(lblNewLabelError_Tarjeta);
		                                                       
		                                                       lblPagarFactura = new JLabel("");
		                                                       lblPagarFactura.setHorizontalAlignment(SwingConstants.CENTER);
		                                                       lblPagarFactura.setForeground(new Color(255, 128, 0));
		                                                       lblPagarFactura.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                       lblPagarFactura.setBounds(336, 236, 197, 189);
		                                                       panelDatos_Cliente_Factura.add(lblPagarFactura);
		                                                       
		                                                       calendar_fecha_expiracion_tarjeta = new JCalendar();
		                                                       calendar_fecha_expiracion_tarjeta.setBounds(49, 236, 184, 153);
		                                                       panelDatos_Cliente_Factura.add(calendar_fecha_expiracion_tarjeta);
		                                                       
		                                                       textField_CSV_Tarjeta = new JTextField();
		                                                       textField_CSV_Tarjeta.setColumns(10);
		                                                       textField_CSV_Tarjeta.setBounds(336, 236, 197, 44);
		                                                       panelDatos_Cliente_Factura.add(textField_CSV_Tarjeta);
		                                                       
		                                                       textField_Numero_Tarjeta = new JTextField();
		                                                       textField_Numero_Tarjeta.setColumns(10);
		                                                       textField_Numero_Tarjeta.setBounds(336, 113, 197, 44);
		                                                       panelDatos_Cliente_Factura.add(textField_Numero_Tarjeta);
		                                                       
		                                                       textField_Titular_Tarjeta = new JTextField();
		                                                       textField_Titular_Tarjeta.setBounds(49, 113, 197, 44);
		                                                       panelDatos_Cliente_Factura.add(textField_Titular_Tarjeta);
		                                                       textField_Titular_Tarjeta.setColumns(10);
		                                                       
		                                                       lblNewLabelNombre_26 = new JLabel("Numero Tarjeta");
		                                                       lblNewLabelNombre_26.setHorizontalAlignment(SwingConstants.CENTER);
		                                                       lblNewLabelNombre_26.setForeground(new Color(255, 128, 0));
		                                                       lblNewLabelNombre_26.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                       lblNewLabelNombre_26.setBounds(251, 58, 360, 68);
		                                                       panelDatos_Cliente_Factura.add(lblNewLabelNombre_26);
		                                                       
		                                                       lblNewLabelNombre_25 = new JLabel("Titular");
		                                                       lblNewLabelNombre_25.setHorizontalAlignment(SwingConstants.CENTER);
		                                                       lblNewLabelNombre_25.setForeground(new Color(255, 128, 0));
		                                                       lblNewLabelNombre_25.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                       lblNewLabelNombre_25.setBounds(0, 58, 300, 68);
		                                                       panelDatos_Cliente_Factura.add(lblNewLabelNombre_25);
		                                                       
		                                                       lblNewLabelNombre_27 = new JLabel("Expiracion");
		                                                       lblNewLabelNombre_27.setHorizontalAlignment(SwingConstants.CENTER);
		                                                       lblNewLabelNombre_27.setForeground(new Color(255, 128, 0));
		                                                       lblNewLabelNombre_27.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                       lblNewLabelNombre_27.setBounds(0, 178, 300, 68);
		                                                       panelDatos_Cliente_Factura.add(lblNewLabelNombre_27);
		                                                       
		                                                       lblNewLabelNombre_28 = new JLabel("CVC");
		                                                       lblNewLabelNombre_28.setHorizontalAlignment(SwingConstants.CENTER);
		                                                       lblNewLabelNombre_28.setForeground(new Color(255, 128, 0));
		                                                       lblNewLabelNombre_28.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                       lblNewLabelNombre_28.setBounds(251, 178, 360, 68);
		                                                       panelDatos_Cliente_Factura.add(lblNewLabelNombre_28);
		                                                       
		                                                       lblNewLabelFondo_Datos_Cliente_Factura = new JLabel("");
		                                                       lblNewLabelFondo_Datos_Cliente_Factura.setBounds(0, 0, 611, 442);
		                                                       panelDatos_Cliente_Factura.add(lblNewLabelFondo_Datos_Cliente_Factura);
		                                                       
		                                                       lblPagarFacturas_Definitiva = new JLabel("");
		                                                       lblPagarFacturas_Definitiva.setBounds(947, 261, 332, 301);
		                                                       panelPacientes.add(lblPagarFacturas_Definitiva);
		                                                       lblPagarFacturas_Definitiva.setHorizontalAlignment(SwingConstants.CENTER);
		                                                       lblPagarFacturas_Definitiva.setForeground(new Color(255, 128, 0));
		                                                       lblPagarFacturas_Definitiva.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                       lblPagarFacturas_Definitiva.setVisible(false);
		                                                       
		                                                       lblPagarFacturas = new JLabel("");
		                                                       lblPagarFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		                                                       lblPagarFacturas.setForeground(new Color(255, 128, 0));
		                                                       lblPagarFacturas.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		                                                       lblPagarFacturas.setBounds(387, -23, 113, 134);
		                                                       panelPacientes.add(lblPagarFacturas);
		                                                       
		                                                       scrollPane_5 = new JScrollPane();
		                                                       scrollPane_5.setBounds(42, 90, 895, 633);
		                                                       scrollPane_5.setVisible(false);
		                                                       panelPacientes.add(scrollPane_5);
		                                                       
		                                                       tableVerFacturas_Paciente = new JTable();
		                                                       scrollPane_5.setViewportView(tableVerFacturas_Paciente);
		                                                       tableVerFacturas_Paciente.setVisible(false);
		                                                       panelPacientes.add(scrollPane_4);
		                                                       
		                                                       tableVerHistorialMedico = new JTable();
		                                                       scrollPane_4.setViewportView(tableVerHistorialMedico);
		                                                       tableVerHistorialMedico.setVisible(false);
		                                                       panelPacientes.add(scrollPane_3);
		                                                       
		                                                       tableVerCitasPacientes = new JTable();
		                                                       scrollPane_3.setViewportView(tableVerCitasPacientes);
		                                                       tableVerCitasPacientes.setVisible(false);
		                                                       
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
		                                                       lblNewLabelNombrePaciente_1.setForeground(new Color(0, 0, 0));
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


	}
	
	public static ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
    }//FIN AJUSTAR TAMAÑO IMG
}