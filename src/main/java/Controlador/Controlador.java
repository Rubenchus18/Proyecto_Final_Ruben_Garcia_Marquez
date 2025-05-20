package Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import Api.EmailSender;
import Api.EsqueletoInteractivoAPI;
import Api.EsqueletoInteractivoAPI.ZonaEsqueleto;
import Vista.Vista;
import net.bytebuddy.asm.Advice.This;
import persistencias.Citas;
import persistencias.Empleados;
import persistencias.HistorialesMedicos;
import persistencias.Medicos;
import persistencias.Pacientes;
import persistencias.Recepcionistas;

public class Controlador implements ActionListener,MouseListener{
	private Vista vista;
	public ControladorHibernet hibernate;
	String rol=null;
	public Controlador(Vista vista) throws Exception {
		   this.vista = vista;
		   this.vista.btnNewButtonInicioSesion.addActionListener(this);
		   this.vista.lblNewLabelSalida.addMouseListener(this);
		   this.vista.btnNewButtonCrear.addActionListener(this);
		   this.vista.lblNewLabelVolverEditar.addMouseListener(this);
		   this.vista.lblNewLabelVolverCrear.addMouseListener(this);
		   this.vista.btnNewButtonEditar.addActionListener(this);
		   this.vista.comboBoxRoles.addActionListener(this);
		   this.vista.btnCrearTotal.addActionListener(this);
		   this.vista.btnNewButtonEliminar.addActionListener(this);
		   this.vista.btnEditarTotal.addActionListener(this);
		   this.vista.lblNewLabelSalidaMedico.addMouseListener(this);
		   this.vista.lblNewLabelCaraMedico.addMouseListener(this);
		   this.vista.btnRellenarDatos.addActionListener(this);
		   this.vista.btnBuscarHistorial.addActionListener(this);
		   this.vista.lblHistorialPaciente.addMouseListener(this);
		   this.vista.lblRegistro.addMouseListener(this);
		   this.vista.btnGuardarHistorialMedico.addActionListener(this);
		   this.vista.lblVerCitas.addMouseListener(this);
		   this.vista.btnFiltrarCitas.addActionListener(this);
		   this.vista.lblNewLabelCaraRecepcionista.addMouseListener(this);
		   this.vista.lblNewLabelSalidaRecepcionista.addMouseListener(this);
		   this.vista.lblRegistro_Nuevo_Pacientes.addMouseListener(this);
		   this.vista.lblNewLabel_CrearPacienteRecepcion.addMouseListener(this);
		   this.vista.lbl_Programacion_Citas.addMouseListener(this);
		   this.vista.btnNewButtonCrearCitaRecepcion.addActionListener(this);
		   this.vista.lblEmision_de_Facturas.addMouseListener(this);
		   this.vista.btnNewButtonExprotarCSV.addActionListener(this);
		   this.vista.btnNewButtonExportarPDF.addActionListener(this);
		   this.vista.lblNewLabelCaraPaciente.addMouseListener(this);
		   this.vista.lblVerCitasPaciente.addMouseListener(this);
		   this.vista.lblVerHistorialMedico.addMouseListener(this);
		   this.vista.lblPagarFacturas.addMouseListener(this);
		   this.vista.tableVerFacturas_Paciente.addMouseListener(this);
		   this.vista.lblPagarFacturas_Definitiva.addMouseListener(this);
		   this.vista.lblPagarFactura.addMouseListener(this);
		   this.vista.tableHistorialMedico.addMouseListener(this);
		   this.vista.lblNewLabelSalida_Paciente.addMouseListener(this);
		   this.vista.lblCrearFacturas.addMouseListener(this);
		   this.vista.lblCCrearFacturasFinal.addMouseListener(this);
		   this.vista.lblEnviarCorreo.addMouseListener(this);
		   this.vista.lblEnviarCorreElectronico.addMouseListener(this);
		   this.vista.lblNewLabelSalida_Paciente__Tarjeta.addMouseListener(this);
		   this.vista.tableMostrarResultadoCitas.addMouseListener(this);
		   this.vista.comboBox_Nombre_Paciente_Facturas.addMouseListener(this);
		   this.vista.comboBoxNombre_Paciente.addMouseListener(this);
		   this.vista.comboBoxNombre_Medicos.addMouseListener(this);
		   this.hibernate=new ControladorHibernet();
		   imagenes();
		   iniciarReloj(this.vista.labelHora);
		    añadidoRolesComboBox();		    
		   //Saltos de texArea
		    saltosTextArea( this.vista.textAreaCampodeTextoCorreo);
		    saltosTextArea( this.vista.textAreaDiagnostico);
		    saltosTextArea( this.vista.textAreaTratamiento);
		    saltosTextArea( this.vista.textAreaReceta);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//Administrador
		if(e.getSource()==this.vista.lblNewLabelSalida) {
			this.vista.panelInicio.setVisible(true);
			this.vista.panelAdmin.setVisible(false);
			this.vista.textFieldNombreUsuario.setText("");
			this.vista.textFieldContraseña.setText("");
		}
		
		if(e.getSource()==this.vista.lblNewLabelVolverCrear) {
			this.vista.panelCrearAdmin.setVisible(false);
			this.vista.btnNewButtonEditar.setEnabled(true);
			this.vista.btnNewButtonEliminar.setEnabled(true);
			this.vista.lblNewLabelSalida.setEnabled(true);
			this.vista.btnNewButtonCrear.setEnabled(true);
			this.vista.tablaUsuarios.setEnabled(true);
			
		}
		if(e.getSource()==this.vista.lblNewLabelVolverEditar) {
			this.vista.panelEditarUsuario.setVisible(false);
			this.vista.btnNewButtonEditar.setEnabled(true);
			this.vista.btnNewButtonEliminar.setEnabled(true);
			this.vista.lblNewLabelSalida.setEnabled(true);
			this.vista.btnNewButtonCrear.setEnabled(true);
			this.vista.tablaUsuarios.setEnabled(true);
		}
		//Medico
		if(e.getSource()==this.vista.lblNewLabelSalidaMedico) {
			 DefaultTableModel modelHistorila = (DefaultTableModel) this.vista.tableHistorialMedico.getModel();
			 modelHistorila.setRowCount(0);			 
			 DefaultTableModel modelCitas = (DefaultTableModel) this.vista.tableMostrarResultadoCitas.getModel();
			 modelCitas.setRowCount(0);
			 this.vista.lblVerCitas.setIcon(fotoEscalarLabel(this.vista.lblVerCitas, "imagenes/vercitas.png"));
			 this.vista.lblHistorialPaciente.setIcon(fotoEscalarLabel(this.vista.lblHistorialPaciente, "imagenes/Historial.png"));
			 this.vista.lblRegistro.setIcon(fotoEscalarLabel(this.vista.lblRegistro, "imagenes/Registro.png"));
			 this.vista.lblEnviarCorreo.setIcon(fotoEscalarLabel(this.vista.lblEnviarCorreo, "imagenes/btnEnviarCorreo.png"));
			this.vista.panelInicio.setVisible(true);
			this.vista.panelMedico.setVisible(false);
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelFiltar_Historial.setVisible(false);
			this.vista.panelVerDatosMedicos.setVisible(false);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
			this.vista.textFieldNombreUsuario.setText("");
			this.vista.textFieldContraseña.setText("");
			this.vista.panelEnviarCorreo.setVisible(false);
		}
		if(e.getSource()==this.vista.lblNewLabelCaraMedico) {
			Medicos medicos=new Medicos();
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.panelFiltar_Historial.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelVerDatosMedicos.setVisible(true);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
			this.vista.panelEnviarCorreo.setVisible(false);
			medicos=hibernate.verDatosMedicos(this.vista.lblNewLabelNombreUsuarioMostrarMedico.getText());
				this.vista.textFieldlblNombreMedico.setText(medicos.getNombre());
				this.vista.textFieldEspecialidadMedico.setText(medicos.getEspecialidad());
				this.vista.textFieldHorarioMedico.setText(medicos.getHorario());
				this.vista.lblVerCitas.setIcon(fotoEscalarLabel(this.vista.lblVerCitas, "imagenes/vercitas.png"));
				this.vista.lblHistorialPaciente.setIcon(fotoEscalarLabel(this.vista.lblHistorialPaciente, "imagenes/Historial.png"));
				this.vista.lblRegistro.setIcon(fotoEscalarLabel(this.vista.lblRegistro, "imagenes/Registro.png"));
				this.vista.lblEnviarCorreo.setIcon(fotoEscalarLabel(this.vista.lblEnviarCorreo, "imagenes/btnEnviarCorreo.png"));
		}
		
		if(e.getSource()==this.vista.lblHistorialPaciente) {
			this.vista.tableHistorialMedico.setVisible(true);
			this.vista.scrollPane_1.setVisible(true);
			this.vista.panelFiltar_Historial.setVisible(true);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
			this.vista.panelEsqueleto.setVisible(false);
			this.vista.panelEnviarCorreo.setVisible(false);
			this.vista.lblVerCitas.setIcon(fotoEscalarLabel(this.vista.lblVerCitas, "imagenes/vercitas.png"));
			this.vista.lblHistorialPaciente.setIcon(fotoEscalarLabel(this.vista.lblHistorialPaciente, "imagenes/Historial_seleccionado.png"));
			this.vista.lblRegistro.setIcon(fotoEscalarLabel(this.vista.lblRegistro, "imagenes/Registro.png"));
			this.vista.lblEnviarCorreo.setIcon(fotoEscalarLabel(this.vista.lblEnviarCorreo, "imagenes/btnEnviarCorreo.png"));
			}
		if(e.getSource()==this.vista.lblRegistro) {
			this.vista.panelCrearHistorialMedico.setVisible(true);
			this.vista.panelVerDatosMedicos.setVisible(false);
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelFiltar_Historial.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
			this.vista.panelEsqueleto.setVisible(false);
			this.vista.panelEnviarCorreo.setVisible(false);
			this.vista.lblVerCitas.setIcon(fotoEscalarLabel(this.vista.lblVerCitas, "imagenes/vercitas.png"));
			this.vista.lblHistorialPaciente.setIcon(fotoEscalarLabel(this.vista.lblHistorialPaciente, "imagenes/Historial.png"));
			this.vista.lblRegistro.setIcon(fotoEscalarLabel(this.vista.lblRegistro, "imagenes/Registro_seleccionado.png"));
			this.vista.lblEnviarCorreo.setIcon(fotoEscalarLabel(this.vista.lblEnviarCorreo, "imagenes/btnEnviarCorreo.png"));
			this.vista.lblNewLabelNombre_Usuario_Medico.setText(this.vista.lblNewLabelNombreUsuarioMostrarMedico.getText());
		}
		if(e.getSource()==this.vista.lblVerCitas) {
			
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelFiltar_Historial.setVisible(false);
			this.vista.panelVerDatosMedicos.setVisible(false);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.panelEnviarCorreo.setVisible(false);
			this.vista.scrollPane_2.setVisible(true);
			this.vista.panelFiltrarCitas.setVisible(true);
			this.vista.panelEsqueleto.setVisible(false);
			this.vista.lblVerCitas.setIcon(fotoEscalarLabel(this.vista.lblVerCitas, "imagenes/vercitas_seleccionado.png"));
			this.vista.lblHistorialPaciente.setIcon(fotoEscalarLabel(this.vista.lblHistorialPaciente, "imagenes/Historial.png"));
			this.vista.lblRegistro.setIcon(fotoEscalarLabel(this.vista.lblRegistro, "imagenes/Registro.png"));
			this.vista.lblEnviarCorreo.setIcon(fotoEscalarLabel(this.vista.lblEnviarCorreo, "imagenes/btnEnviarCorreo.png"));
		}
		if(e.getSource() == this.vista.tableHistorialMedico) {
		    int seleccion_historial = this.vista.tableHistorialMedico.getSelectedRow();
		    if (seleccion_historial >= 0) {  		      
		        this.vista.panelEsqueleto.removeAll(); 
		        EsqueletoInteractivoAPI panelEsqueleto = new EsqueletoInteractivoAPI();
		        panelEsqueleto.setOpaque(true);
		        panelEsqueleto.setPreferredSize(new Dimension(100, 100)); 
		        this.vista.panelEsqueleto.setLayout(new BorderLayout());
		        this.vista.panelEsqueleto.add(panelEsqueleto, BorderLayout.CENTER);
		        String diagnostico = (String) this.vista.tableHistorialMedico.getValueAt(seleccion_historial, 0); 
		        configurarEsqueletoPorDiagnostico(panelEsqueleto, diagnostico);
		        this.vista.panelEsqueleto.setVisible(true);
		        this.vista.panelEsqueleto.revalidate();
		        this.vista.panelEsqueleto.repaint();
		        SwingUtilities.updateComponentTreeUI(this.vista.panelEsqueleto.getTopLevelAncestor());
		    }
		}
		if(e.getSource()==this.vista.lblEnviarCorreo) {
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.panelFiltar_Historial.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelVerDatosMedicos.setVisible(true);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
			this.vista.panelVerDatosMedicos.setVisible(false);
			this.vista.panelEnviarCorreo.setVisible(true);
			this.vista.lblEnviarCorreo.setIcon(fotoEscalarLabel(this.vista.lblEnviarCorreo, "imagenes/btnEnviarCorreoSeleccionado.png"));
			this.vista.lblVerCitas.setIcon(fotoEscalarLabel(this.vista.lblVerCitas, "imagenes/vercitas.png"));
			this.vista.lblHistorialPaciente.setIcon(fotoEscalarLabel(this.vista.lblHistorialPaciente, "imagenes/Historial.png"));
			this.vista.lblRegistro.setIcon(fotoEscalarLabel(this.vista.lblRegistro, "imagenes/Registro.png"));
		}
		if(e.getSource() == this.vista.lblEnviarCorreElectronico) {
		    String correoelectronico = this.vista.textField_Corre_Electronico_Paciente.getText();
		    String asunto = this.vista.textFieldAsuntoDeCorreoElectronico.getText();
		    String campo = this.vista.textAreaCampodeTextoCorreo.getText();
		    
		    if(correoelectronico == null || correoelectronico.isEmpty() || asunto.isEmpty() || campo.isEmpty()) {
		        mostrarLabelTemporalmente(this.vista.lblConfirmarEnviar, "Rellena todos los campos");
		        this.vista.lblConfirmarEnviar.setForeground(Color.red);
		    } else {
		        try {
		            EmailSender.sendEmail(correoelectronico, asunto, campo);
		            mostrarLabelTemporalmente(this.vista.lblConfirmarEnviar, "Enviado correctamente");
		            this.vista.lblConfirmarEnviar.setForeground(new Color(47, 113, 9));
		            
		            this.vista.textFieldAsuntoDeCorreoElectronico.setText("");
		            this.vista.textAreaCampodeTextoCorreo.setText("");
		        } catch (Exception i) {
		            System.err.println("Error en Main: " + i.getMessage());
		            mostrarLabelTemporalmente(this.vista.lblConfirmarEnviar, "Correo electrónico no existente o mal escrito");
		            this.vista.lblConfirmarEnviar.setForeground(Color.red);
		        }
		    }	
		}
		if(e.getSource() == this.vista.tableMostrarResultadoCitas) {
			Pacientes paciente=new Pacientes();
			int seleccionfila = this.vista.tableMostrarResultadoCitas.getSelectedRow();
		    if (seleccionfila >= 0 && this.vista.tableMostrarResultadoCitas.getColumnCount() > 0) { 
		        String nombrepaciente = (String) this.vista.tableMostrarResultadoCitas.getValueAt(seleccionfila, 1); 
		        this.vista.lblNewLabelNombre_Paciente.setText(nombrepaciente);
		        paciente=hibernate.cogerDatosPaciente(nombrepaciente);		      
		        this.vista.textFieldDNI_paciente.setText(paciente.getDni());
		        this.vista.textField_Corre_Electronico_Paciente.setText(paciente.getCorreoElectronico()); 
		    }  
		}
		//Recepcionista
		if(e.getSource()==this.vista.lblNewLabel_CrearPacienteRecepcion) {
			String nombre=this.vista.textField_NombrePaciente.getText();
			String contraseña=this.vista.passwordFieldContraseñaPacienteRecepcion.getText();
			String direccion=this.vista.textFieldDireccionPacienteRecepcion.getText();
			String telefono=this.vista.textFieldTelefonoPacienteRecepcion.getText();
			String dni=this.vista.textField_DNI_Paciente.getText();
			String correoelectronico=this.vista.textFieldCorreo_Electronico_paciente.getText();
			Calendar calendario = this.vista.calendarFechaNacimientoPacienteRecepcion.getCalendar();
		    java.util.Date utilDate = calendario.getTime();
		    java.sql.Date fechaNacimientoPaciente = new java.sql.Date(utilDate.getTime());
		    if(nombre.isEmpty()||contraseña.isEmpty()|| direccion.isEmpty()|| telefono.isEmpty()||correoelectronico.isEmpty()||dni.isEmpty()) {
		    	mostrarLabelTemporalmente(this.vista.lblNewLabelErrorCrearPacienteRecepcion,"Campos obligatorios");
		    	this.vista.lblNewLabelErrorCrearPacienteRecepcion.setForeground(Color.RED);
		    }else{
		    	hibernate.crearPacienteRecepcionista(nombre, contraseña, direccion, telefono, fechaNacimientoPaciente,correoelectronico,dni);
		    	mostrarLabelTemporalmente(this.vista.lblNewLabelErrorCrearPacienteRecepcion,"Se ha creado correctamente");
		    	this.vista.lblNewLabelErrorCrearPacienteRecepcion.setForeground(new Color(47, 113, 9));
		    	this.vista.textField_NombrePaciente.setText("");
		    	this.vista.passwordFieldContraseñaPacienteRecepcion.setText("");
		    	this.vista.textFieldDireccionPacienteRecepcion.setText("");
		    	this.vista.textField_DNI_Paciente.setText("");
		    	this.vista.textFieldTelefonoPacienteRecepcion.setText("");
		    	this.vista.textFieldCorreo_Electronico_paciente.setText("");
		    }
		}
		if(e.getSource()== this.vista.lblNewLabelCaraRecepcionista) {
			this.vista.panelInformacionPaciente.setVisible(true);
			Recepcionistas recepecionista=new Recepcionistas();
			String nombre=this.vista.lblNewLabelNombreUsuarioMostrarRecepcionista.getText();
			recepecionista=hibernate.cogerDatosRecpecionista(nombre);
			this.vista.lblNombre_Recepcion.setText(recepecionista.getNombre());
			this.vista.panelProgramarCitasRecpecionosta.setVisible(false);
			this.vista.panelCrearPacienteRecepcion.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
			this.vista.panelCrearFacturasRecepcion.setVisible(false);
			 this.vista.lblRegistro_Nuevo_Pacientes.setIcon(fotoEscalarLabel(this.vista.lblRegistro_Nuevo_Pacientes, "imagenes/NuevoPaciente.png")); 
			 this.vista.lbl_Programacion_Citas.setIcon(fotoEscalarLabel(this.vista.lbl_Programacion_Citas, "imagenes/NuevaCita.png"));
			 this.vista.lblEmision_de_Facturas.setIcon(fotoEscalarLabel(this.vista.lblEmision_de_Facturas, "imagenes/emisionFacturas.png"));
			 this.vista.lblCrearFacturas.setIcon(fotoEscalarLabel(this.vista.lblCrearFacturas, "imagenes/btnCrearFacturas.png"));
		}
		if(e.getSource()==this.vista.lblNewLabelSalidaRecepcionista) {
			this.vista.panelInicio.setVisible(true);
			this.vista.panelRececipnista.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			   this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
			   this.vista.panelCrearFacturasRecepcion.setVisible(false);
			   this.vista.lblRegistro_Nuevo_Pacientes.setIcon(fotoEscalarLabel(this.vista.lblRegistro_Nuevo_Pacientes, "imagenes/NuevoPaciente_seleccionado.png"));
			   this.vista.lbl_Programacion_Citas.setIcon(fotoEscalarLabel(this.vista.lbl_Programacion_Citas, "imagenes/NuevaCita.png"));
			   this.vista.lblEmision_de_Facturas.setIcon(fotoEscalarLabel(this.vista.lblEmision_de_Facturas, "imagenes/emisionFacturas.png"));
			   this.vista.lblCrearFacturas.setIcon(fotoEscalarLabel(this.vista.lblCrearFacturas, "imagenes/btnCrearFacturas.png"));
			   this.vista.textFieldNombreUsuario.setText("");
			   this.vista.textFieldContraseña.setText("");
			   this.vista.panelExportacion.setVisible(true);
			   this.vista.panelInformacionPaciente.setVisible(false);
				this.vista.panelProgramarCitasRecpecionosta.setVisible(false);
				this.vista.panelCrearPacienteRecepcion.setVisible(false);
				this.vista.panelExportacion.setVisible(false);
				this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
				this.vista.panelCrearFacturasRecepcion.setVisible(false);
		}
		if(e.getSource()==this.vista.lblRegistro_Nuevo_Pacientes) {
			this.vista.panelCrearPacienteRecepcion.setVisible(true);
			this.vista.panelProgramarCitasRecpecionosta.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			   this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
			   this.vista.panelCrearFacturasRecepcion.setVisible(false);
			   this.vista.lblRegistro_Nuevo_Pacientes.setIcon(fotoEscalarLabel(this.vista.lblRegistro_Nuevo_Pacientes, "imagenes/NuevoPaciente_seleccionado.png"));
			   this.vista.lbl_Programacion_Citas.setIcon(fotoEscalarLabel(this.vista.lbl_Programacion_Citas, "imagenes/NuevaCita.png"));
			   this.vista.lblEmision_de_Facturas.setIcon(fotoEscalarLabel(this.vista.lblEmision_de_Facturas, "imagenes/emisionFacturas.png"));
			   this.vista.lblCrearFacturas.setIcon(fotoEscalarLabel(this.vista.lblCrearFacturas, "imagenes/btnCrearFacturas.png"));
		}
		if(e.getSource()==this.vista.lbl_Programacion_Citas) {
			this.vista.panelProgramarCitasRecpecionosta.setVisible(true);
			this.vista.panelCrearPacienteRecepcion.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			   this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
			   this.vista.panelCrearFacturasRecepcion.setVisible(false);
			   this.vista.lblRegistro_Nuevo_Pacientes.setIcon(fotoEscalarLabel(this.vista.lblRegistro_Nuevo_Pacientes, "imagenes/NuevoPaciente.png"));
			   this.vista.lbl_Programacion_Citas.setIcon(fotoEscalarLabel(this.vista.lbl_Programacion_Citas, "imagenes/NuevaCita_seleccionado.png"));
			   this.vista.lblEmision_de_Facturas.setIcon(fotoEscalarLabel(this.vista.lblEmision_de_Facturas, "imagenes/emisionFacturas.png"));
			   this.vista.lblCrearFacturas.setIcon(fotoEscalarLabel(this.vista.lblCrearFacturas, "imagenes/btnCrearFacturas.png"));
		}
		if (e.getSource() == this.vista.lblEmision_de_Facturas) {
		    double[] totales = hibernate.obtenerTotalesFacturas(); 
		    double totalPagadas = totales[0];
		    double totalNoPagadas = totales[1];

		    CategoryChart chart = new CategoryChartBuilder()
		            .width(934)  
		            .height(469) 
		            .title("Ganancias") 
		            .xAxisTitle("Estado de Facturas") 
		            .yAxisTitle("Dinero (€)") 
		            .build();

		    chart.addSeries("Facturas", 
		                    Arrays.asList("Facturas Pagadas", "Facturas Sin Pagar"), 
		                    Arrays.asList(totalPagadas, totalNoPagadas)); 

		    chart.getStyler().setSeriesColors(new Color[]{Color.orange}); 
		    chart.getStyler().setChartBackgroundColor(Color.white);
		    chart.getStyler().setChartFontColor(Color.BLACK);
		    XChartPanel<CategoryChart> chartPanel_3 = new XChartPanel<>(chart);
		    chartPanel_3.setBounds(10, 11, 934, 469); 

		    
		    this.vista.panelEmisiondeFacturasRecepcionista.removeAll();
		    this.vista.panelEmisiondeFacturasRecepcionista.add(chartPanel_3);
		    this.vista.panelEmisiondeFacturasRecepcionista.revalidate();
		    this.vista.panelEmisiondeFacturasRecepcionista.repaint();
		    this.vista.panelEmisiondeFacturasRecepcionista.setVisible(true);
		    this.vista.panelExportacion.setVisible(true);
		    this.vista.panelProgramarCitasRecpecionosta.setVisible(false);
			this.vista.panelCrearPacienteRecepcion.setVisible(false);
			this.vista.panelInformacionPaciente.setVisible(false);
			this.vista.panelCrearFacturasRecepcion.setVisible(false);
			 this.vista.lblRegistro_Nuevo_Pacientes.setIcon(fotoEscalarLabel(this.vista.lblRegistro_Nuevo_Pacientes, "imagenes/NuevoPaciente.png"));
			 this.vista.lbl_Programacion_Citas.setIcon(fotoEscalarLabel(this.vista.lbl_Programacion_Citas, "imagenes/NuevaCita.png"));
			 this.vista.lblEmision_de_Facturas.setIcon(fotoEscalarLabel(this.vista.lblEmision_de_Facturas, "imagenes/emisionFacturas_seleccionado.png"));
			 this.vista.lblCrearFacturas.setIcon(fotoEscalarLabel(this.vista.lblCrearFacturas, "imagenes/btnCrearFacturas.png"));
		    
		}
		if(e.getSource()== this.vista.lblCrearFacturas) {
			this.vista.panelInformacionPaciente.setVisible(false);
			this.vista.panelProgramarCitasRecpecionosta.setVisible(false);
			this.vista.panelCrearPacienteRecepcion.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
			this.vista.panelCrearFacturasRecepcion.setVisible(true);
			 this.vista.lblRegistro_Nuevo_Pacientes.setIcon(fotoEscalarLabel(this.vista.lblRegistro_Nuevo_Pacientes, "imagenes/NuevoPaciente.png"));
			 this.vista.lbl_Programacion_Citas.setIcon(fotoEscalarLabel(this.vista.lbl_Programacion_Citas, "imagenes/NuevaCita.png"));
			 this.vista.lblEmision_de_Facturas.setIcon(fotoEscalarLabel(this.vista.lblEmision_de_Facturas, "imagenes/emisionFacturas.png"));
			 this.vista.lblCrearFacturas.setIcon(fotoEscalarLabel(this.vista.lblCrearFacturas, "imagenes/btnCrearFacturas_seleccionada.png"));
			
			
			}
		if(e.getSource() == this.vista.lblCCrearFacturasFinal) {
		    this.vista.panelCrearFacturasRecepcion.setVisible(true);
		    String nombrePaciente = (String)this.vista.comboBox_Nombre_Paciente_Facturas.getSelectedItem();
		    String importe = this.vista.textFieldImporte.getText().trim();
		    if(nombrePaciente == null || nombrePaciente.isEmpty() || importe.isEmpty()) {
		        mostrarLabelTemporalmente(this.vista.lblErrorCrearFacturasPaciente, "Todos los campos son obligatorios");
		        return;
		    }else {
		    	try {
			        importe = importe.replace(',', '.');
			        BigDecimal importetext = new BigDecimal(importe);
			        if(importetext.compareTo(BigDecimal.ZERO) <= 0) {
			            mostrarLabelTemporalmente(this.vista.lblErrorCrearFacturasPaciente, "El importe debe ser positivo");
			            return;
			        }
			        
			        Calendar calendario = this.vista.calendarFecha_Creacion_Factura.getCalendar(); 
			        int day = calendario.get(Calendar.DAY_OF_MONTH);
			        int month = calendario.get(Calendar.MONTH) + 1; 
			        int year = calendario.get(Calendar.YEAR);
			        java.util.Date utilDate = calendario.getTime();
			        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			        
			        hibernate.crearFacturaPorNombrePaciente(nombrePaciente, importetext, sqlDate);
			        mostrarLabelTemporalmente(this.vista.lblErrorCrearFacturasPaciente, "Creado perfectamente");
			        this.vista.lblErrorCrearFacturasPaciente.setForeground(new Color(47, 113, 9));
			        this.vista.textFieldImporte.setText("");
			    } catch (NumberFormatException ex) {
			        mostrarLabelTemporalmente(this.vista.lblErrorCrearFacturasPaciente, "Formato de importe inválido");
			        this.vista.lblErrorCrearFacturasPaciente.setForeground(Color.RED);
			    }
		  }  
		}
			if(e.getSource()==this.vista.comboBox_Nombre_Paciente_Facturas) {
				List<String> nombre_Paciente = hibernate.obtenerNombresDePacientes();
				this.vista.comboBox_Nombre_Paciente_Facturas.removeAllItems();
			    
			    for (String nombre_Paciente2 : nombre_Paciente) {
			    	this.vista.comboBox_Nombre_Paciente_Facturas.addItem(nombre_Paciente2);
			    }
			    
			    this.vista.comboBox_Nombre_Paciente_Facturas.setSelectedItem(null);
			}
			if(e.getSource()==this.vista.comboBoxNombre_Paciente) {
				List<String> nombre_Paciente = hibernate.obtenerNombresDePacientes();
				this.vista.comboBoxNombre_Paciente.removeAllItems();
			    
			    for (String nombre_Paciente2 : nombre_Paciente) {
			    	this.vista.comboBoxNombre_Paciente.addItem(nombre_Paciente2);
			    }
			    
			    this.vista.comboBoxNombre_Paciente.setSelectedItem(null);
			}
			if(e.getSource()==this.vista.comboBoxNombre_Medicos) {
				   List<String> nombre_med = hibernate.obtenerNombres_Medico();
				    this.vista.comboBoxNombre_Medicos.removeAllItems();
				    
				    for (String nombre_med2 : nombre_med) {
				        this.vista.comboBoxNombre_Medicos.addItem(nombre_med2);
				    }
				    this.vista.comboBoxNombre_Medicos.setSelectedItem(null);
			}
		//Paciente
			if(e.getSource()==this.vista.lblNewLabelSalida_Paciente) {
				DefaultTableModel modelverfactura = (DefaultTableModel) this.vista.tableVerFacturas_Paciente.getModel();
				modelverfactura.setRowCount(0);			 
				 DefaultTableModel verHistorialCitas = (DefaultTableModel) this.vista.tableVerHistorialMedico.getModel();
				 verHistorialCitas.setRowCount(0);
				 DefaultTableModel verCitasPaciente = (DefaultTableModel) this.vista.tableVerCitasPacientes.getModel();
				 verCitasPaciente.setRowCount(0);
				this.vista.panelPacientes.setVisible(false);
				this.vista.panelInicio.setVisible(true);
				this.vista.lblVerCitasPaciente.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/vercitas.png"));
				this.vista.lblVerHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblVerHistorialMedico, "imagenes/Historial.png"));
				this.vista.lblPagarFacturas.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas, "imagenes/btnPagarFacturas.png"));
				this.vista.textFieldNombreUsuario.setText("");
				this.vista.textFieldContraseña.setText("");
			}
			if(e.getSource()==this.vista.lblNewLabelCaraPaciente) {
				this.vista.panelInformacionPaciente_1.setVisible(true);
				String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();
				Pacientes paciente=hibernate.cogerDatosPaciente(nombre);
				this.vista.lblNewLabelNombrePaciente_1.setText(paciente.getNombre());
				this.vista.textFieldDireccion_PanelPaciente.setText(paciente.getDireccion());
				this.vista.textField_Telefono_PanelPaciente.setText(paciente.getTelefono());
				this.vista.calendarFechaNacimientoPaciente_1.setDate(paciente.getFechaNacimiento());
				this.vista.tableVerFacturas_Paciente.setVisible(false);
				this.vista.scrollPane_5.setVisible(false);
				this.vista.tableVerCitasPacientes.setVisible(false);
				this.vista.scrollPane_3.setVisible(false);
				this.vista.tableVerHistorialMedico.setVisible(false);
				this.vista.scrollPane_4.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setVisible(false);
				this.vista.scrollPane_5.setVisible(false);
				this.vista.lblPagarFacturas_Definitiva.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setEnabled(true);
				this.vista.panelDatos_Cliente_Factura.setVisible(false);
				this.vista.lblVerCitasPaciente.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/vercitas.png"));
				this.vista.lblVerHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblVerHistorialMedico, "imagenes/Historial.png"));
				this.vista.lblPagarFacturas.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas, "imagenes/btnPagarFacturas.png"));
			}
			if(e.getSource()==this.vista.lblVerCitasPaciente) {
				String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();	
				this.vista.panelInformacionPaciente_1.setVisible(false);
				this.vista.tableVerCitasPacientes.setVisible(true);
				this.vista.scrollPane_3.setVisible(true);
				this.vista.tableVerHistorialMedico.setVisible(false);
				this.vista.scrollPane_4.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setVisible(false);
				this.vista.scrollPane_5.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setVisible(false);
				this.vista.scrollPane_5.setVisible(false);
				this.vista.lblPagarFacturas_Definitiva.setVisible(false);
				this.vista.panelDatos_Cliente_Factura.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setEnabled(true);
				List<Object[]> detallesCitas = hibernate.obtenerDetallesCitasPorPaciente(nombre);
				mostrarCitasEnTabla(detallesCitas,this.vista.tableVerCitasPacientes);
				this.vista.lblVerCitasPaciente.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/vercitas_seleccionado.png"));
				this.vista.lblVerHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblVerHistorialMedico, "imagenes/Historial.png"));
				this.vista.lblPagarFacturas.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas, "imagenes/btnPagarFacturas.png"));
				
			}
			if(e.getSource()==this.vista.lblVerHistorialMedico) {
				String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();
				this.vista.panelInformacionPaciente_1.setVisible(false);
				this.vista.tableVerHistorialMedico.setVisible(true);
				this.vista.scrollPane_4.setVisible(true);
				this.vista.tableVerFacturas_Paciente.setVisible(false);
				this.vista.scrollPane_5.setVisible(false);
				this.vista.tableVerCitasPacientes.setVisible(false);
				this.vista.scrollPane_3.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setVisible(false);
				this.vista.scrollPane_5.setVisible(false);
				this.vista.lblPagarFacturas_Definitiva.setVisible(false);
				this.vista.panelDatos_Cliente_Factura.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setEnabled(true);
				List<Object[]> detallesCitas = hibernate.obtenerHistorialMedicoPaciente(nombre);
				mostrarHistorialClienteEnTabla(detallesCitas,this.vista.tableVerHistorialMedico);
				this.vista.lblVerCitasPaciente.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/vercitas.png"));
				this.vista.lblVerHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblVerHistorialMedico, "imagenes/Historial_seleccionado.png"));
				this.vista.lblPagarFacturas.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas, "imagenes/btnPagarFacturas.png"));
			}
			if(e.getSource()==this.vista.lblPagarFacturas) {
				String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();
				this.vista.panelInformacionPaciente_1.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setVisible(true);
				this.vista.scrollPane_5.setVisible(true);
				this.vista.tableVerCitasPacientes.setVisible(false);
				this.vista.scrollPane_3.setVisible(false);
				this.vista.tableVerHistorialMedico.setVisible(false);
				this.vista.scrollPane_4.setVisible(false);
				this.vista.lblPagarFacturas_Definitiva.setVisible(true);
				this.vista.lblPagarFacturas_Definitiva.setEnabled(false);
				this.vista.panelDatos_Cliente_Factura.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setEnabled(true);
				List<Object[]> detallesCitas=hibernate.obtenerFacturaCliente(nombre);
				mostrarFacturasCliente(detallesCitas,this.vista.tableVerFacturas_Paciente);
				this.vista.lblVerCitasPaciente.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/vercitas.png"));
				this.vista.lblVerHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblVerHistorialMedico, "imagenes/Historial.png"));
				this.vista.lblPagarFacturas.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas, "imagenes/btnPagarFacturas_seleccionado.png"));
			}
			if(e.getSource() == this.vista.tableVerFacturas_Paciente) {
			    int seleccionfactura = this.vista.tableVerFacturas_Paciente.getSelectedRow();
			    if (seleccionfactura >= 0) {
			    	String estado = (String) this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 4); 
			    	boolean estaPagada =  estado.equalsIgnoreCase("Pagado");
			    	this.vista.lblPagarFacturas_Definitiva.setEnabled(!estaPagada);

			        String paciente = (String) this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 0); 
			        String direccion = (String) this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 1);    
			        Object valorDinero = this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 2);
			        Double dinero = null;
			        
			        if (valorDinero instanceof BigDecimal) {
			            dinero = ((BigDecimal) valorDinero).doubleValue();
			        } else if (valorDinero instanceof Double) {
			            dinero = (Double) valorDinero;
			        } else if (valorDinero != null) {
			            dinero = Double.parseDouble(valorDinero.toString());
			        }
			        
			        Date fecha = (Date) this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 3); 
			        
			        
			        this.vista.tableVerFacturas_Paciente.putClientProperty("selectedRow", seleccionfactura);
			    }
			}
			if(e.getSource()==this.vista.lblPagarFacturas_Definitiva) {
				this.vista.panelDatos_Cliente_Factura.setVisible(true);
				this.vista.tableVerFacturas_Paciente.setEnabled(false);
				}
			if(e.getSource()== this.vista.lblPagarFactura) {
				String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();
				int seleccionfactura = (Integer) this.vista.tableVerFacturas_Paciente.getClientProperty("selectedRow");
				String titular=this.vista.textField_Titular_Tarjeta.getText();
				String numero=this.vista.textField_Numero_Tarjeta.getText();
				String csv=this.vista.textField_CSV_Tarjeta.getText();
				Date fecha_tarjete=this.vista.calendar_fecha_expiracion_tarjeta.getDate();
				 if(titular.isEmpty()||numero.isEmpty()||csv.isEmpty()) {
					 mostrarLabelTemporalmente(this.vista.lblNewLabelError_Tarjeta,"Todos los campos obligatorios");
				 }else {
					  if (seleccionfactura >= 0) {
					        String direccion = (String) this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 1);
					        Object valorMonto = this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 2);
			                BigDecimal monto;
			                if (valorMonto instanceof BigDecimal) {
			                    monto = (BigDecimal) valorMonto;
			                } else if (valorMonto instanceof Double) {
			                    monto = BigDecimal.valueOf((Double) valorMonto);
			                } else {
			                    monto = new BigDecimal(valorMonto.toString());
			                }
					        Date fecha = (Date) this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 3);
					        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
					      
					        hibernate.actualizarEstadoFactura(direccion, monto, fechaSQL);
					        this.vista.panelDatos_Cliente_Factura.setVisible(false);
					        List<Object[]> detallesCitas=hibernate.obtenerFacturaCliente(nombre);
					        this.vista.textField_Titular_Tarjeta.setText("");
					        this.vista.textField_Titular_Tarjeta.setText("");
					        this.vista.textField_Numero_Tarjeta.setText("");
					        this.vista.textField_CSV_Tarjeta.setText("");
							mostrarFacturasCliente(detallesCitas,this.vista.tableVerFacturas_Paciente);
							this.vista.panelDatos_Cliente_Factura.setVisible(false);
							this.vista.tableVerFacturas_Paciente.setEnabled(true);
					    }
				  }
				 
			  }
			if(e.getSource()==this.vista.lblNewLabelSalida_Paciente__Tarjeta) {
					this.vista.panelDatos_Cliente_Factura.setVisible(false);
					
				}
		//DobleClick
		if(e.getClickCount()==2) {
			if(e.getSource()== this.vista.lblNewLabelCaraRecepcionista) {
				this.vista.panelInformacionPaciente.setVisible(false);
			}
			if(e.getSource()==this.vista.lblNewLabelCaraMedico) {
				this.vista.panelVerDatosMedicos.setVisible(false);
			}
			if(e.getSource()==this.vista.lblNewLabelCaraPaciente) {
				this.vista.panelInformacionPaciente_1.setVisible(false);
			}
		}

	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	//Inicio
		if(e.getSource()==this.vista.btnNewButtonInicioSesion) {
			String nombre=this.vista.textFieldNombreUsuario.getText();
			String contraseña=this.vista.textFieldContraseña.getText();
			rol=hibernate.sacarRoles(nombre,contraseña);
			if(rol!=null) {
				if(rol.equalsIgnoreCase("admin")) {
					this.vista.panelInicio.setVisible(false);
					this.vista.panelAdmin.setVisible(true);
					this.vista.lblNewLabelNombreUsuarioMostrar.setText(nombre);
					mostrarUsuariosEnJTable();
				}else if(rol.equalsIgnoreCase("medico")) {
					this.vista.panelInicio.setVisible(false);
					this.vista.panelMedico.setVisible(true);
					this.vista.lblNewLabelNombreUsuarioMostrarMedico.setText(nombre);
					this.vista.panelFiltrarCitas.setVisible(true);
					this.vista.scrollPane_2.setVisible(true);
					this.vista.lblVerCitas.setIcon(fotoEscalarLabel(this.vista.lblVerCitas, "imagenes/vercitas_seleccionado.png"));
					this.vista.tableMostrarResultadoCitas.setVisible(true);
					//Cargar las citas cuando entre el medico 	
					Calendar calendario = this.vista.calendarioCitas.getCalendar();
					java.util.Date utilDate = calendario.getTime();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

					if (nombre.isEmpty()) {
					    mostrarLabelTemporalmente( this.vista.lblNewLabelErrorCitas,"Campos obligatorios");
					} else {
					  this.vista.lblNewLabelErrorCitas.setText("");
					  List<Citas> citas = hibernate.obtenerCitasPorMedicoYFecha(nombre, sqlDate);
					  mostrarCitasEnTabla(this.vista.tableMostrarResultadoCitas, citas);      
					    }
				}else if(rol.equalsIgnoreCase("recepcionista")) {
					this.vista.panelInicio.setVisible(false);
					this.vista.panelRececipnista.setVisible(true);
					this.vista.lblNewLabelNombreUsuarioMostrarRecepcionista.setText(nombre);
					this.vista.panelCrearPacienteRecepcion.setVisible(true);
					 this.vista.lblRegistro_Nuevo_Pacientes.setIcon(fotoEscalarLabel(this.vista.lblRegistro_Nuevo_Pacientes, "imagenes/NuevoPaciente_seleccionado.png"));
				}else if(rol.equalsIgnoreCase("paciente")) {
					this.vista.panelInicio.setVisible(false);
					this.vista.panelPacientes.setVisible(true);
					this.vista.lblNewLabelNombreUsuarioMostrarPaciente.setText(nombre);
					this.vista.tableVerCitasPacientes.setVisible(true);
					this.vista.scrollPane_3.setVisible(true);
					//Cargar citas al inicio paciente
					List<Object[]> detallesCitas = hibernate.obtenerDetallesCitasPorPaciente(nombre);
					mostrarCitasEnTabla(detallesCitas,this.vista.tableVerCitasPacientes);
					this.vista.lblVerCitasPaciente.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/vercitas_seleccionado.png"));
				    }
			}else {
					mostrarLabelTemporalmente(this.vista.lblNewLabelError,"Usuario o Contraseña no existe");
					this.vista.lblNewLabelError.setForeground(new Color(139, 0, 0));
			}
			
		}
		//Administrador
		if(e.getSource()==this.vista.btnNewButtonCrear) {
			this.vista.btnNewButtonEditar.setEnabled(false);
			this.vista.btnNewButtonCrear.setEnabled(false);
			this.vista.btnNewButtonEliminar.setEnabled(false);
			this.vista.lblNewLabelSalida.setEnabled(false);
			this.vista.tablaUsuarios.setEnabled(false);
			this.vista.panelCrearAdmin.setVisible(true);
		}
		if(e.getSource()==this.vista.btnNewButtonEditar) {
			this.vista.btnNewButtonEditar.setEnabled(false);
			this.vista.btnNewButtonCrear.setEnabled(false);
			this.vista.btnNewButtonEliminar.setEnabled(false);
			this.vista.lblNewLabelSalida.setEnabled(false);
			this.vista.tablaUsuarios.setEnabled(false);
			this.vista.panelEditarUsuario.setVisible(true);
		}
		if (e.getSource() == this.vista.btnCrearTotal) {
			
		    String nombre = this.vista.textFieldNombreUsuarioCrear.getText();
		    String contraseña = this.vista.textFieldContraseñaCrear.getText();
		    String rol = (String) this.vista.comboBoxRoles.getSelectedItem(); 

		    if (nombre.isEmpty() || contraseña.isEmpty() || rol.isEmpty()) {
		        mostrarLabelTemporalmente(this.vista.lblErrorCrear,"Campos obligatorios");
		    } else {
		    	Integer id=null;
		    	System.out.println(rol);
		    	if(rol.equalsIgnoreCase("admin")) {
		    		hibernate.crearUsuario(nombre, contraseña, rol);
		    		this.vista.textFieldNombreUsuarioCrear.setText("");
		    		this.vista.textFieldContraseñaCrear.setText("");
		    	}else if(rol.equalsIgnoreCase("medico")) {
		    		id=hibernate.crearUsuario(nombre, contraseña, rol);
		    		hibernate.crearMedico(nombre,id);
			        mostrarUsuariosEnJTable(); 
			        this.vista.textFieldNombreUsuarioCrear.setText("");
		    		this.vista.textFieldContraseñaCrear.setText("");
		    		
		    	}else if(rol.equalsIgnoreCase("recepcionista")) {
		    		id=hibernate.crearUsuario(nombre, contraseña, rol);
		    		hibernate.crearRecepcionista(nombre);
			        mostrarUsuariosEnJTable(); 
			        this.vista.textFieldNombreUsuarioCrear.setText("");
		    		this.vista.textFieldContraseñaCrear.setText("");
		    	}else if(rol.equalsIgnoreCase("paciente")){
		    		id=hibernate.crearUsuario(nombre, contraseña, rol);
		    		hibernate.crearPaciente(nombre,id);
			        mostrarUsuariosEnJTable(); 
			        this.vista.textFieldNombreUsuarioCrear.setText("");
		    		this.vista.textFieldContraseñaCrear.setText("");
		    	}
		      
		        this.vista.panelCrearAdmin.setVisible(false);
		        this.vista.btnNewButtonEditar.setEnabled(true);
		        this.vista.btnNewButtonEliminar.setEnabled(true);
		        this.vista.lblNewLabelSalida.setEnabled(true);
		        this.vista.btnNewButtonCrear.setEnabled(true);
		        this.vista.tablaUsuarios.setEnabled(true);

		       
		        this.vista.lblErrorCrear.setText("");
		        this.vista.textFieldNombreUsuarioCrear.setText("");
		        this.vista.textFieldContraseñaCrear.setText("");
		        this.vista.comboBoxRoles.setSelectedIndex(0); 
		    }
		}
		if(e.getSource()==this.vista.btnNewButtonEliminar) {
			int seleccionfila=this.vista.tablaUsuarios.getSelectedRow();
			if(seleccionfila>=0) {
				  String nombreUsuario = (String) this.vista.tablaUsuarios.getValueAt(seleccionfila, 0);
				  hibernate.eliminarUsuario(nombreUsuario);
				  mostrarUsuariosEnJTable();  
			}
		}
		if(e.getSource()==this.vista.btnEditarTotal) {
				  String nombreUsuario =this.vista.textFieldNombreUsuarioEditar.getText();
				  String contraseña=this.vista.textFieldContraseñaEditar.getText();
				  String rol =this.vista.lblLaborNombre.getText(); 
				  if(nombreUsuario.isEmpty()||contraseña.isEmpty()||rol.isEmpty()) {
					
					  mostrarLabelTemporalmente( this.vista.lblErrorEditar,"Campos obligatorios");
				  }else {
					  hibernate.EditarUsuario(nombreUsuario, contraseña, rol);
					  mostrarUsuariosEnJTable();
					  this.vista.panelEditarUsuario.setVisible(false);
					     this.vista.btnNewButtonEditar.setEnabled(true);
					        this.vista.btnNewButtonCrear.setEnabled(true);
					        this.vista.btnNewButtonEliminar.setEnabled(true);
					        this.vista.lblNewLabelSalida.setEnabled(true);
					        this.vista.tablaUsuarios.setEnabled(true);
				  }
				 ; 
			
		}
		if (e.getSource() == this.vista.btnNewButtonEditar) {

		    int seleccionfila = this.vista.tablaUsuarios.getSelectedRow();
		    if (seleccionfila >= 0) { 
		        String nombreUsuario = (String) this.vista.tablaUsuarios.getValueAt(seleccionfila, 0); 
		        String contraseña = (String) this.vista.tablaUsuarios.getValueAt(seleccionfila, 1);    
		        String rol = (String) this.vista.tablaUsuarios.getValueAt(seleccionfila, 2);    

		        this.vista.textFieldNombreUsuarioEditar.setText(nombreUsuario);
		        this.vista.textFieldContraseñaEditar.setText(contraseña);
		        this.vista.lblLaborNombre.setText(rol);
		        this.vista.panelEditarUsuario.setVisible(true);

		        this.vista.btnNewButtonEditar.setEnabled(false);
		        this.vista.btnNewButtonCrear.setEnabled(false);
		        this.vista.btnNewButtonEliminar.setEnabled(false);
		        this.vista.lblNewLabelSalida.setEnabled(false);
		        this.vista.tablaUsuarios.setEnabled(false);
		    } 
		}
		if(e.getSource()==this.vista.btnRellenarDatos) {
			String nombre=this.vista.textFieldlblNombreMedico.getText();
			String especialidad=this.vista.textFieldEspecialidadMedico.getText();
			String horaria=this.vista.textFieldHorarioMedico.getText();
			
			if(especialidad.isEmpty()||horaria.isEmpty()) {
				  mostrarLabelTemporalmente(this.vista.lblNewLabelErrorPefilMedico,"Campos Obligatorios");
			
			}else {
				hibernate.actualizarMedico(nombre,especialidad,horaria);
				this.vista.panelVerDatosMedicos.setVisible(false);
			}
		}
		//Medico
		if(e.getSource()==this.vista.btnBuscarHistorial) {
			String dni=this.vista.textFieldDNI_paciente.getText();
			if(dni.isEmpty()) {
				mostrarLabelTemporalmente(this.vista.lblErrorFiltro,"Campos obligatorios");
				this.vista.lblErrorFiltro.setForeground(Color.RED);
			}else {
				mostrarHistorialMedico(dni);
			}
		}
		if(e.getSource() == this.vista.btnGuardarHistorialMedico) {
		    String nombrepaciente = this.vista.lblNewLabelNombre_Paciente.getText();		     
		    String nombremedico= this.vista.lblNewLabelNombre_Usuario_Medico.getText();
		    String diagnostico = this.vista.textAreaDiagnostico.getText();
		    String tratamiento = this.vista.textAreaTratamiento.getText();
		    String receta = this.vista.textAreaReceta.getText();
		    Calendar calendario = this.vista.calendarioMedico.getCalendar(); 
		    int day = calendario.get(Calendar.DAY_OF_MONTH);
		    int month = calendario.get(Calendar.MONTH) + 1; 
		    int year = calendario.get(Calendar.YEAR);
		    java.util.Date utilDate = calendario.getTime();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    if(nombrepaciente.isEmpty()||nombremedico.isEmpty()||diagnostico.isEmpty()||tratamiento.isEmpty()||receta.isEmpty()) {
		    	mostrarLabelTemporalmente(this.vista.lblErrorRegistroMedico,"Rellena todos los campos");
		    	this.vista.lblErrorRegistroMedico.setForeground(Color.RED);
		    }else {
		    	hibernate.crearHistorialMedico(nombrepaciente, nombremedico, diagnostico, tratamiento, receta, sqlDate);
		    	mostrarLabelTemporalmente(this.vista.lblErrorRegistroMedico,"Creada perfectamente");
		    	this.vista.lblErrorRegistroMedico.setForeground(Color.GREEN);  	
		    }
		    
		}
		if (e.getSource() == this.vista.btnFiltrarCitas) {
		  
		    String nombre = this.vista.lblNewLabelNombreUsuarioMostrarMedico.getText();
		    Calendar calendario = this.vista.calendarioCitas.getCalendar();
		    java.util.Date utilDate = calendario.getTime();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		    if (nombre.isEmpty()) {
		        mostrarLabelTemporalmente( this.vista.lblNewLabelErrorCitas,"Campos obligatorios");
		        this.vista.lblNewLabelErrorCitas.setForeground(Color.RED);
		    } else {
		        this.vista.lblNewLabelErrorCitas.setText("");
		        List<Citas> citas = hibernate.obtenerCitasPorMedicoYFecha(nombre, sqlDate);
		            mostrarCitasEnTabla(this.vista.tableMostrarResultadoCitas, citas);
		            
		        
		    }
		}
		//Recepcionista
		
		if(e.getSource()==this.vista.btnNewButtonCrearCitaRecepcion) {
			String nombreCliente = (String)this.vista.comboBoxNombre_Paciente.getSelectedItem();
			String nombreMedico = (String)this.vista.comboBoxNombre_Medicos.getSelectedItem();
			Calendar calendario = this.vista.calendarCitaPaciente.getCalendar();
			java.util.Date utilDate = calendario.getTime();
			java.sql.Date fechaCitaPaciente = new java.sql.Date(utilDate.getTime());
			String horaTexto = this.vista.textFieldHoraCitaPaciente.getText(); 
			String motivo = this.vista.textFieldMotivoCitaRecepcion.getText();
			if (nombreCliente.isEmpty() || nombreMedico.isEmpty() || motivo.isEmpty() || horaTexto.isEmpty()) {
			    mostrarLabelTemporalmente(this.vista.lblNewLabelErrorCrearCitaRecpecion,"Campos obligatorios");
			    this.vista.lblNewLabelErrorCrearCitaRecpecion.setForeground(Color.RED);
			} else if (!horaTexto.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
				mostrarLabelTemporalmente(this.vista.lblNewLabelErrorCrearCitaRecpecion,"Formato de hora inválido (HH:mm)");
			    this.vista.lblNewLabelErrorCrearCitaRecpecion.setForeground(Color.RED);
			} else {
			    try {
			        Time hora = Time.valueOf(horaTexto + ":00"); 
			        hibernate.crearCitaRecepcion(nombreCliente, nombreMedico, fechaCitaPaciente, hora, motivo);
			    	mostrarLabelTemporalmente( this.vista.lblNewLabelErrorCrearCitaRecpecion,"Cita Creada");
			        this.vista.lblNewLabelErrorCrearCitaRecpecion.setForeground(new Color(47, 113, 9));
			        this.vista.textFieldHoraCitaPaciente.setText(""); 
			        this.vista.textFieldMotivoCitaRecepcion.setText("");
			    } catch (Exception g) {
			    	mostrarLabelTemporalmente( this.vista.lblNewLabelErrorCrearCitaRecpecion,"Error al procesar la hora");
			        this.vista.lblNewLabelErrorCrearCitaRecpecion.setForeground(Color.RED);
			    }
			}
		}
		if(e.getSource()==this.vista.btnNewButtonExprotarCSV) {
			hibernate.exportarFacturasACSV("documentos/FacturasConsulta.csv");
			mostrarLabelTemporalmente(this.vista.lblConfirmarExportacion,"Exportado exitosamente a csv");
			this.vista.lblConfirmarExportacion.setForeground(new Color(47, 113, 9));
		}
		if(e.getSource()==this.vista.btnNewButtonExportarPDF) {
			hibernate.exportarFacturasAPDF("documentos/FacturasConsulta.pdf");
			mostrarLabelTemporalmente(this.vista.lblConfirmarExportacion,"Exportado exitosamente a pdf");
			this.vista.lblConfirmarExportacion.setForeground(new Color(47, 113, 9));
		}
		
				
			
	}	
	//Metodo
	public ImageIcon fotoEscalarLabel(JLabel label, String url) {
        ImageIcon imagenDefecto = new ImageIcon(url);
        ImageIcon icono = new ImageIcon(imagenDefecto.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        return icono;
    }
	 public ImageIcon fotoEscalarButton(JButton label, String url) {
	        ImageIcon imagenDefecto = new ImageIcon(url);
	        ImageIcon icono = new ImageIcon(imagenDefecto.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
	        return icono;
	    }
	 public void imagenes() {
		 this.vista.lblFondo.setIcon(fotoEscalarLabel(this.vista.lblFondo, "imagenes/fondo_aplicacion.jpg"));
		 this.vista.lblLogo.setIcon(fotoEscalarLabel(this.vista.lblLogo, "imagenes/logo.png"));
		 this.vista.btnNewButtonInicioSesion.setIcon(fotoEscalarButton(this.vista.btnNewButtonInicioSesion, "imagenes/botonInicoSesion.png"));
		 this.vista.lblNewLabelSalida.setIcon(fotoEscalarLabel(this.vista.lblNewLabelSalida, "imagenes/botonVolver.png"));
		 this.vista.lblNewLabelLogo.setIcon(fotoEscalarLabel(this.vista.lblNewLabelLogo, "imagenes/logo.png"));
		 this.vista.lblNewLabelCara.setIcon(fotoEscalarLabel(this.vista.lblNewLabelCara, "imagenes/foto_perfil.png"));
		 this.vista.lblNewLabelFondoAdmin.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoAdmin, "imagenes/fondo_aplicacion.jpg"));
		 this.vista.btnNewButtonCrear.setIcon(fotoEscalarButton(this.vista.btnNewButtonCrear, "imagenes/boton_crear.png"));
		 this.vista.btnNewButtonEditar.setIcon(fotoEscalarButton(this.vista.btnNewButtonEditar, "imagenes/editar.png"));
		 this.vista.btnNewButtonEliminar.setIcon(fotoEscalarButton(this.vista.btnNewButtonEliminar, "imagenes/BtonEliminar.png"));
		 this.vista.btnCrearTotal.setIcon(fotoEscalarButton(this.vista.btnCrearTotal, "imagenes/boton_crear.png"));
		 this.vista.btnEditarTotal.setIcon(fotoEscalarButton(this.vista.btnEditarTotal, "imagenes/editar.png"));
		 this.vista.lblNewLabelVolverCrear.setIcon(fotoEscalarLabel(this.vista.lblNewLabelVolverCrear, "imagenes/botonVolver.png"));
		 this.vista.lblNewLabelVolverEditar.setIcon(fotoEscalarLabel(this.vista.lblNewLabelVolverEditar, "imagenes/botonVolver.png"));
		 this.vista.lblNewLabelFondoCrear.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoCrear, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabelFondeEditar.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondeEditar, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabelFondoMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoMedico, "imagenes/fondo_aplicacion.jpg"));
		 this.vista.lblNewLabelSalidaMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelSalidaMedico, "imagenes/botonVolver.png"));
		 this.vista.lblNewLabelCaraMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelCaraMedico,"imagenes/foto_perfil.png"));
		 this.vista.lblVerCitas.setIcon(fotoEscalarLabel(this.vista.lblVerCitas,"imagenes/vercitas.png"));
		 this.vista.lblHistorialPaciente.setIcon(fotoEscalarLabel(this.vista.lblHistorialPaciente,"imagenes/Historial.png"));
		 this.vista.lblRegistro.setIcon(fotoEscalarLabel(this.vista.lblRegistro,"imagenes/Registro.png"));		 
		 this.vista.lblNewLabelLogoMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelLogoMedico,"imagenes/logo.png"));
		 this.vista.btnRellenarDatos.setIcon(fotoEscalarButton(this.vista.btnRellenarDatos, "imagenes/botonmodificar.png"));
		 this.vista.lblNewLabelFondoPerfilMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoPerfilMedico, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblFondoFiltrarHistorial.setIcon(fotoEscalarLabel(this.vista.lblFondoFiltrarHistorial, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.btnBuscarHistorial.setIcon(fotoEscalarButton(this.vista.btnBuscarHistorial, "imagenes/botonBuscar.png"));
		 this.vista.btnGuardarHistorialMedico.setIcon(fotoEscalarButton(this.vista.btnGuardarHistorialMedico, "imagenes/botonGuardar.png"));
		 this.vista.lblNewLabelFondoHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoHistorialMedico, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblFotoMedicoInicio.setIcon(fotoEscalarLabel(this.vista.lblFotoMedicoInicio, "imagenes/fotosMedicos.png"));
		 this.vista.lblFondoEfecto.setIcon(fotoEscalarLabel(this.vista.lblFondoEfecto, "imagenes/fondo_inicio.jpg"));
		 this.vista.btnFiltrarCitas.setIcon(fotoEscalarButton(this.vista.btnFiltrarCitas, "imagenes/botonBuscar.png"));
		 this.vista.lblNewLabelFondoFiltrarCita.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoFiltrarCita, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabelSalidaRecepcionista.setIcon(fotoEscalarLabel(this.vista.lblNewLabelSalidaRecepcionista, "imagenes/botonVolver.png"));
		 this.vista.lblRegistro_Nuevo_Pacientes.setIcon(fotoEscalarLabel(this.vista.lblRegistro_Nuevo_Pacientes, "imagenes/NuevoPaciente.png"));
		 this.vista.lbl_Programacion_Citas.setIcon(fotoEscalarLabel(this.vista.lbl_Programacion_Citas, "imagenes/NuevaCita.png"));
		 this.vista.lblEmision_de_Facturas.setIcon(fotoEscalarLabel(this.vista.lblEmision_de_Facturas, "imagenes/emisionFacturas.png"));
		 this.vista.lblNewLabelLogoRecepcionista.setIcon(fotoEscalarLabel(this.vista.lblNewLabelLogoRecepcionista, "imagenes/logo.png"));
		 this.vista.lblNewLabelCaraRecepcionista.setIcon(fotoEscalarLabel(this.vista.lblNewLabelLogoRecepcionista, "imagenes/foto_perfil.png"));
		 this.vista.lblNewLabelFondoRecepcionista.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoRecepcionista, "imagenes/fondo_aplicacion.jpg"));
		 this.vista.lblNewLabelFondoPerfilRecepcionista.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoRecepcionista, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabelFondoPanelCrearPaciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoRecepcionista, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabel_CrearPacienteRecepcion.setIcon(fotoEscalarLabel(this.vista.lblNewLabel_CrearPacienteRecepcion, "imagenes/botonGuardar.png"));
		 this.vista.lblNewLabelMarcoMapa.setIcon(fotoEscalarLabel(this.vista.lblNewLabelMarcoMapa, "imagenes/marcomapa.png"));
		 this.vista.btnNewButtonCrearCitaRecepcion.setIcon(fotoEscalarButton(this.vista.btnNewButtonCrearCitaRecepcion, "imagenes/botonGuardar.png"));
		 this.vista.lblNewLabelFondoPanelCrearCitaRecepcion.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoPanelCrearCitaRecepcion, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabelFondoEmisionFacturasRecepcion.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoEmisionFacturasRecepcion, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.btnNewButtonExportarPDF.setIcon(fotoEscalarButton(this.vista.btnNewButtonExportarPDF, "imagenes/exportarPDF.png"));
		 this.vista.btnNewButtonExprotarCSV.setIcon(fotoEscalarButton(this.vista.btnNewButtonExprotarCSV, "imagenes/botonExportarCSV.png"));
		 this.vista.lblNewLabelSalida_Paciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelSalida_Paciente, "imagenes/botonVolver.png"));
		 this.vista.lblVerCitasPaciente.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/vercitas.png"));
		 this.vista.lblVerHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblVerHistorialMedico, "imagenes/Historial.png"));
		 this.vista.lblPagarFacturas.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas, "imagenes/btnPagarFacturas.png"));
		 this.vista.lblNewLabelFondoPaciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoPaciente, "imagenes/fondo_aplicacion.jpg"));
		 this.vista.lblNewLabelCaraPaciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelCaraPaciente, "imagenes/foto_perfil.png"));
		 this.vista.lblNewLabelLogoMedico_Paciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelCaraPaciente, "imagenes/logo.png"));
		 this.vista.lblNewLabel_FondoInformacionPaciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabel_FondoInformacionPaciente, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabelFondo_Datos_Cliente_Factura.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondo_Datos_Cliente_Factura, "imagenes/fondo_panel_cobro.jpg"));
		 this.vista.lblPagarFactura.setIcon(fotoEscalarLabel(this.vista.lblPagarFactura, "imagenes/btn_pagar.png"));
		this.vista.lblPagarFacturas_Definitiva.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas_Definitiva, "imagenes/btn_pagar.png"));
		this.vista.lblCrearFacturas.setIcon(fotoEscalarLabel(this.vista.lblCrearFacturas, "imagenes/btnCrearFacturas.png"));
		this.vista.lbFondo_Panel_Crear_Facturas.setIcon(fotoEscalarLabel(this.vista.lbFondo_Panel_Crear_Facturas, "imagenes/fondo_admin_panel.jpg"));
		this.vista.lblCCrearFacturasFinal.setIcon(fotoEscalarLabel(this.vista.lblCCrearFacturasFinal, "imagenes/boton_crear.png"));
		this.vista.lblEnviarCorreo.setIcon(fotoEscalarLabel(this.vista.lblEnviarCorreo, "imagenes/btnEnviarCorreo.png"));
		this.vista.lblFondoCorreoElectronico.setIcon(fotoEscalarLabel(this.vista.lblFondoCorreoElectronico, "imagenes/fondo_admin_panel.jpg"));
		this.vista.lblEnviarCorreElectronico.setIcon(fotoEscalarLabel(this.vista.lblEnviarCorreElectronico, "imagenes/btnEnviar.png"));
		this.vista.lblNewLabelSalida_Paciente__Tarjeta.setIcon(fotoEscalarLabel(this.vista.lblNewLabelSalida_Paciente__Tarjeta, "imagenes/botonVolver.png"));
	 }
	 public void añadidoRolesComboBox() {
		  this.vista.comboBoxRoles.addItem("admin");
		    this.vista.comboBoxRoles.addItem("medico");
		    this.vista.comboBoxRoles.addItem("recepcionista");
		    this.vista.comboBoxRoles.addItem("paciente");
		    
		    this.vista.comboBoxRoles.setSelectedItem(null);
		
		    
		    this.vista.comboBoxRoles.setSelectedItem(null);
	 }
	 public void mostrarUsuariosEnJTable() {
		 
		    List<Empleados> usuarios = hibernate.obtenerTodosLosUsuarios();

		  
		    DefaultTableModel modelo = new DefaultTableModel();

		    
		    modelo.addColumn("Usuario");
		    modelo.addColumn("Contraseña");
		    modelo.addColumn("Rol");

		    for (Empleados empleado : usuarios) {
		        Object[] fila = {
		            empleado.getUsername(), 
		            empleado.getPassword(), 
		            empleado.getRol()      
		        };
		        modelo.addRow(fila); 
		    }

		    this.vista.tablaUsuarios.setModel(modelo);
		}
	 
	 public void mostrarHistorialMedico(String numerotelefono) {
		    List<HistorialesMedicos> historial = hibernate.obtenerHistorialMedicoPorUsuario(numerotelefono);
		    if (historial.isEmpty()) {
		        this.vista.lblErrorFiltro.setText("No se encontró historial médico");
		        return; 
		    }

		    DefaultTableModel modelo = new DefaultTableModel();
		    modelo.addColumn("Diagnóstico");
		    modelo.addColumn("Tratamiento");
		    modelo.addColumn("Receta");
		    modelo.addColumn("Fecha");

		    for (HistorialesMedicos hm : historial) {
		         Object[]datos={
		            hm.getDiagnostico(),
		            hm.getTratamiento(),
		            hm.getReceta(),
		            hm.getFecha()
		        };
		         modelo.addRow(datos);
		    }
		    this.vista.tableHistorialMedico.setModel(modelo);
		}
	 public void mostrarCitasEnTabla(JTable tableMostrarResultadoCitas, List<Citas> citas) {
		    DefaultTableModel modelo = new DefaultTableModel();

		    modelo.addColumn("Nombre del Médico");
		    modelo.addColumn("Nombre del Paciente");
		    modelo.addColumn("Motivo de la Cita");
		    modelo.addColumn("Hora de la Cita");
		    modelo.addColumn("Fecha de la Cita");

		    for (Citas cita : citas) {
		        Object[] fila = new Object[5];
		        fila[0] = cita.getMedicos().getNombre();
		        fila[1] = cita.getPacientes().getNombre();   
		        fila[2] = cita.getMotivo();             
		        fila[3] = cita.getHora();               
		        fila[4] = cita.getFecha().toString();   
		        modelo.addRow(fila);
		    }
		    tableMostrarResultadoCitas.setModel(modelo);
		}
	  public static void mostrarCitasEnTabla(List<Object[]> detallesCitas,JTable citas) {

	        DefaultTableModel modelo = new DefaultTableModel();
	        modelo.addColumn("Paciente");
	        modelo.addColumn("Médico");
	        modelo.addColumn("Especialidad");
	        modelo.addColumn("Fecha");
	        modelo.addColumn("Hora");
	        modelo.addColumn("Motivo");

	       
	        for (Object[] detalle : detallesCitas) {
	        	modelo.addRow(detalle);
	        }
	        citas.setModel(modelo);
	        
	    }
	  public static void mostrarHistorialClienteEnTabla(List<Object[]> detallesCitas, JTable historial) {
		    DefaultTableModel modelo = new DefaultTableModel();
		    modelo.addColumn("Paciente");
		    modelo.addColumn("Médico");
		    modelo.addColumn("Diagnostico");
		    modelo.addColumn("Tratamiento");
		    modelo.addColumn("Receta");
		    modelo.addColumn("Fecha");

	
		    for (Object[] detalle : detallesCitas) {
		    	modelo.addRow(detalle);
		    }

		    historial.setModel(modelo);
		}
	  public static void mostrarFacturasCliente(List<Object[]> detallesFacturas, JTable facturas) {
		    DefaultTableModel modelo = new DefaultTableModel();
		  
		    modelo.addColumn("Paciente");
		    modelo.addColumn("Dirección");
		    modelo.addColumn("Dinero");
		    modelo.addColumn("Fecha");
		    modelo.addColumn("Estado");
		    
		  
		    modelo.setRowCount(0);
		    
		    if (detallesFacturas != null) {
		        for (Object[] fila : detallesFacturas) {
		      
		            Object[] rowData = new Object[5];
		            
		       
		            rowData[0] = fila.length > 0 ? fila[0] : ""; 
		            rowData[1] = fila.length > 1 ? fila[1] : "";
		            rowData[2] = fila.length > 2 ? fila[2] : 0.0; 
		            rowData[3] = fila.length > 3 ? fila[3] : "";  
		            
		           
		            if (fila.length > 4) {
		                rowData[4] = (fila[4] instanceof Boolean) ? 
		                             ((Boolean)fila[4] ? "Pagado" : "Pendiente") : 
		                             fila[4].toString();
		            } else {
		                rowData[4] = "Pendiente";
		            }
		            
		            modelo.addRow(rowData);
		        }
		    }
		    
		    facturas.setModel(modelo);
		
		    facturas.getColumnModel().getColumn(0).setPreferredWidth(150);
		    facturas.getColumnModel().getColumn(1).setPreferredWidth(200);
		    facturas.getColumnModel().getColumn(2).setPreferredWidth(80);  
		    facturas.getColumnModel().getColumn(3).setPreferredWidth(100);
		    facturas.getColumnModel().getColumn(4).setPreferredWidth(80); 
		}
	  	
	  public void configurarEsqueletoPorDiagnostico(EsqueletoInteractivoAPI esqueleto, String diagnostico) {
		   
		    esqueleto.limpiarSelecciones();
		   
		    Color colorDolor = new Color(255, 100, 100); 

		    if (diagnostico != null) {
		        String diagLower = diagnostico.toLowerCase();
		        
		        if (diagLower.contains("cabeza") || diagLower.contains("cefalea") || diagLower.contains("migraña")|| diagLower.contains("tumor cerebral")) {
		            esqueleto.setColorSeleccion(colorDolor);
		            esqueleto.colorearZona(EsqueletoInteractivoAPI.ZonaEsqueleto.CABEZA);
		        }
		        if (diagLower.contains("brazo izquierdo") || diagLower.contains("hombro izquierdo")) {
		            esqueleto.setColorSeleccion(colorDolor);
		            esqueleto.colorearZona(EsqueletoInteractivoAPI.ZonaEsqueleto.BRAZO_IZQUIERDO);
		        }
		        if (diagLower.contains("brazo derecho") || diagLower.contains("hombro derecho")) {
		            esqueleto.setColorSeleccion(colorDolor);
		            esqueleto.colorearZona(EsqueletoInteractivoAPI.ZonaEsqueleto.BRAZO_DERECHO);
		        }
		        if (diagLower.contains("espalda") || diagLower.contains("columna") || diagLower.contains("lumbar")) {
		            esqueleto.setColorSeleccion(colorDolor);
		            esqueleto.colorearZona(EsqueletoInteractivoAPI.ZonaEsqueleto.TORSO);
		        }
		        if (diagLower.contains("pierna izquierda") || diagLower.contains("rodilla izquierda")) {
		            esqueleto.setColorSeleccion(colorDolor);
		            esqueleto.colorearZona(EsqueletoInteractivoAPI.ZonaEsqueleto.PIERNA_IZQUIERDA);
		        }
		        if (diagLower.contains("pierna derecha") || diagLower.contains("rodilla derecha")) {
		            esqueleto.setColorSeleccion(colorDolor);
		            esqueleto.colorearZona(EsqueletoInteractivoAPI.ZonaEsqueleto.PIERNA_DERECHA);
		        }
		        
		    }
	  }
	  public void saltosTextArea(JTextArea textArea) {
		    textArea.setTabSize(4);             
		    textArea.setLineWrap(true);        
		    textArea.setWrapStyleWord(true);    
		}
	  //Hilo
	 public void iniciarReloj(JLabel label) {
		    Thread hiloReloj = new Thread(() -> {
		        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

		        while (!Thread.currentThread().isInterrupted()) {
		            try {
		                String horaActual = formato.format(new Date());

		                SwingUtilities.invokeLater(() -> {
		                    label.setText(horaActual);
		                });
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		              
		                Thread.currentThread().interrupt();
		                break;
		            }
		        }
		    });

		    hiloReloj.start();
		}
	 public void mostrarLabelTemporalmente(JLabel label, String mensaje) {
		    label.setText(mensaje);
		    label.setVisible(true);

		    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	
		    executor.schedule(() -> {
		        SwingUtilities.invokeLater(() -> {
		            label.setText("");
		            label.setVisible(false);
		        });
		        executor.shutdown(); 
		    }, 3, TimeUnit.SECONDS); 
		}
	 
}
