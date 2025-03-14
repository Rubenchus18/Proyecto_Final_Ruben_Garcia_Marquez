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
	public JLabel lblPaciente;
	public JLabel lblRecepcionista;
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
	public JLabel lblNewLabelCerrarPerfilMedico;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		  contentPane.add(panelMedico);
		  panelMedico.setLayout(null);
		  
		  panelFiltar = new JPanel();
		  panelFiltar.setBounds(938, 112, 290, 566);
		  panelFiltar.setVisible(false);
		  
		  scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBounds(56, 112, 840, 566);
		  scrollPane_1.setVisible(false);
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
		  
		  lblNewLabelCerrarPerfilMedico = new JLabel("");
		  lblNewLabelCerrarPerfilMedico.setBounds(0, 0, 75, 47);
		  panelVerDatosMedicos.add(lblNewLabelCerrarPerfilMedico);
		  
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
		      textFieldNombreUsuarioCrear.setBounds(37, 104, 213, 20);
		      panelCrearAdmin.add(textFieldNombreUsuarioCrear);
		      textFieldNombreUsuarioCrear.setColumns(10);
		      
		      textFieldContraseñaCrear = new JTextField();
		      textFieldContraseñaCrear.setColumns(10);
		      textFieldContraseñaCrear.setBounds(37, 181, 213, 20);
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
		      textFieldNombreUsuarioEditar.setBounds(37, 104, 213, 20);
		      panelEditarUsuario.add(textFieldNombreUsuarioEditar);
		      
		      textFieldContraseñaEditar = new JTextField();
		      textFieldContraseñaEditar.setColumns(10);
		      textFieldContraseñaEditar.setBounds(37, 181, 213, 20);
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
		 
		panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 1329, 742);
		
		contentPane.add(panelInicio);
		panelInicio.setLayout(null);
		 
		 
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
		 lblNewLabelError.setBounds(437, 648, 376, 83);
		 panelInicio.add(lblNewLabelError);
		 
		  lblNewLabelContraseña = new JLabel("Contraseña");
		  lblNewLabelContraseña.setForeground(new Color(255, 128, 0));
		  lblNewLabelContraseña.setBackground(new Color(255, 128, 0));
		  lblNewLabelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabelContraseña.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 33));
		  lblNewLabelContraseña.setBounds(437, 396, 376, 83);
		  panelInicio.add(lblNewLabelContraseña);
		   
		    btnNewButtonInicioSesion = new JButton("");
		    btnNewButtonInicioSesion.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 11));
		    btnNewButtonInicioSesion.setBounds(538, 547, 173, 155);
		    btnNewButtonInicioSesion.setContentAreaFilled(false); 
		    btnNewButtonInicioSesion.setBorderPainted(false);
		    panelInicio.add(btnNewButtonInicioSesion);
		    
		     lblNewLabelNombreUsuario = new JLabel("Nombre Usuario");
		     lblNewLabelNombreUsuario.setForeground(new Color(255, 128, 0));
		     lblNewLabelNombreUsuario.setBackground(new Color(255, 128, 64));
		     lblNewLabelNombreUsuario.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 33));
		     lblNewLabelNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		     lblNewLabelNombreUsuario.setBounds(437, 236, 376, 83);
		     
		     panelInicio.add(lblNewLabelNombreUsuario);
		     
		     textFieldContraseña = new JTextField();
		     textFieldContraseña.setColumns(10);
		     textFieldContraseña.setBounds(437, 479, 376, 57);
		     panelInicio.add(textFieldContraseña);
		     
		     textFieldNombreUsuario = new JTextField();
		     textFieldNombreUsuario.setBounds(437, 330, 376, 57);
		     panelInicio.add(textFieldNombreUsuario);
		     textFieldNombreUsuario.setColumns(10);
		     
		lblLogo = new JLabel("");
		lblLogo.setBounds(478, 0, 287, 263);
		panelInicio.add(lblLogo);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 1329, 825);
		panelInicio.add(lblFondo);
		
		 panelPacientes = new JPanel();
		panelPacientes.setBounds(0, 0, 1329, 734);
		panelPacientes.setVisible(false);
		contentPane.add(panelPacientes);
		panelPacientes.setLayout(null);
		
		lblPaciente = new JLabel("Paciente");
		lblPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaciente.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 33));
		lblPaciente.setBackground(new Color(255, 128, 0));
		lblPaciente.setBounds(0, 0, 376, 83);
		panelPacientes.add(lblPaciente);
		
		 panelRececipnista = new JPanel();
		panelRececipnista.setBounds(0, 0, 1329, 734);
		panelRececipnista.setVisible(false);
		contentPane.add(panelRececipnista);
		panelRececipnista.setLayout(null);
		
		lblRecepcionista = new JLabel("Recepcionista");
		lblRecepcionista.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecepcionista.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 33));
		lblRecepcionista.setBackground(new Color(255, 128, 0));
		lblRecepcionista.setBounds(0, 0, 376, 83);
		panelRececipnista.add(lblRecepcionista);


	}
	
	public static ImageIcon ajustarTamañoImg(String ruta, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon((ruta));
        Image imagenOriginal = imagen.getImage();
        Image imagenAjustada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenAjustada);
    }//FIN AJUSTAR TAMAÑO IMG
}