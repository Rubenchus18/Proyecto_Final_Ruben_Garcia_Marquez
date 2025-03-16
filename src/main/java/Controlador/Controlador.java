package Controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import Vista.Vista;
import net.bytebuddy.asm.Advice.This;
import persistencias.Citas;
import persistencias.Empleados;
import persistencias.HistorialesMedicos;
import persistencias.Medicos;

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
		   this.vista.lblNewLabelCerrarPerfilMedico.addMouseListener(this);
		   this.vista.btnRellenarDatos.addActionListener(this);
		   this.vista.btnBuscarHistorial.addActionListener(this);
		   this.vista.lblHistorialPaciente.addMouseListener(this);
		   this.vista.lblRegistro.addMouseListener(this);
		   this.vista.btnGuardarHistorialMedico.addActionListener(this);
		   this.vista.lblVerCitas.addMouseListener(this);
		   this.vista.btnFiltrarCitas.addActionListener(this);
		   this.hibernate=new ControladorHibernet();
		   imagenes();
		   iniciarReloj(this.vista.labelHora);
		    añadidoRolesComboBox();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==this.vista.lblNewLabelSalida) {
			this.vista.panelInicio.setVisible(true);
			this.vista.panelAdmin.setVisible(false);
		}
		if(e.getSource()==this.vista.lblNewLabelSalidaMedico) {
			this.vista.panelInicio.setVisible(true);
			this.vista.panelMedico.setVisible(false);
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelFiltar.setVisible(false);
			this.vista.panelVerDatosMedicos.setVisible(false);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
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
		if(e.getSource()==this.vista.lblNewLabelCaraMedico) {
			Medicos medicos=new Medicos();
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.panelFiltar.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelVerDatosMedicos.setVisible(true);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
			medicos=hibernate.verDatosMedicos(this.vista.lblNewLabelNombreUsuarioMostrarMedico.getText());
			
				this.vista.lblNewLabelNombreMedico.setText(medicos.getNombre());
				this.vista.textFieldEspecialidadMedico.setText(medicos.getEspecialidad());
				this.vista.textFieldHorarioMedico.setText(medicos.getHorario());
			
		}
		if(e.getSource()==this.vista.lblNewLabelCerrarPerfilMedico) {
			this.vista.panelVerDatosMedicos.setVisible(false);
		}
		if(e.getSource()==this.vista.lblHistorialPaciente) {
			this.vista.tableHistorialMedico.setVisible(true);
			this.vista.scrollPane_1.setVisible(true);
			this.vista.panelFiltar.setVisible(true);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
			}
		if(e.getSource()==this.vista.lblRegistro) {
			this.vista.panelCrearHistorialMedico.setVisible(true);
			this.vista.panelVerDatosMedicos.setVisible(false);
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelFiltar.setVisible(false);
			this.vista.scrollPane_2.setVisible(false);
			this.vista.panelFiltrarCitas.setVisible(false);
		}
		if(e.getSource()==this.vista.lblVerCitas) {
			
			this.vista.tableHistorialMedico.setVisible(false);
			this.vista.scrollPane_1.setVisible(false);
			this.vista.panelFiltar.setVisible(false);
			this.vista.panelVerDatosMedicos.setVisible(false);
			this.vista.panelCrearHistorialMedico.setVisible(false);
			this.vista.scrollPane_2.setVisible(true);
			this.vista.panelFiltrarCitas.setVisible(true);
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
				}else if(rol.equalsIgnoreCase("recepcionista")) {
					this.vista.panelInicio.setVisible(false);
					this.vista.panelRececipnista.setVisible(true);
				}else if(rol.equalsIgnoreCase("paciente")) {
					this.vista.panelInicio.setVisible(false);
					this.vista.panelPacientes.setVisible(true);
				}
			}else {
				this.vista.lblNewLabelError.setText("Usuario o Contraseña no existe");
				this.vista.lblNewLabelError.setForeground(new Color(139, 0, 0));
			}
			
		}
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
			
		    String nombre = this.vista.textFieldNombreUsuarioCrear.getText().trim();
		    String contraseña = this.vista.textFieldContraseñaCrear.getText().trim();
		    String rol = (String) this.vista.comboBoxRoles.getSelectedItem(); 

		    if (nombre.isEmpty() || contraseña.isEmpty() || rol.isEmpty()) {
		        this.vista.lblErrorCrear.setText("Campos obligatorios");
		    } else {
		    	Integer id=null;
		    	System.out.println(rol);
		    	if(rol.equalsIgnoreCase("admin")) {
		    		hibernate.crearUsuario(nombre, contraseña, rol);
		    	}else if(rol.equalsIgnoreCase("medico")) {
		    		id=hibernate.crearUsuario(nombre, contraseña, rol);
		    		hibernate.crearMedico(nombre,id);
			        mostrarUsuariosEnJTable(); 
		    	}else if(rol.equalsIgnoreCase("recepcionista")) {
		    		id=hibernate.crearUsuario(nombre, contraseña, rol);
		    		hibernate.crearRecepcionista(nombre);
			        mostrarUsuariosEnJTable(); 
		    	}else if(rol.equalsIgnoreCase("paciente")){
		    		id=hibernate.crearUsuario(nombre, contraseña, rol);
		    		hibernate.crearPaciente(nombre,id);
			        mostrarUsuariosEnJTable(); 
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
					  this.vista.lblErrorEditar.setText("Campos obligatorios");
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
			String nombre=this.vista.lblNewLabelNombreMedico.getText();
			String especialidad=this.vista.textFieldEspecialidadMedico.getText();
			String horaria=this.vista.textFieldHorarioMedico.getText();
			
			if(especialidad.isEmpty()||horaria.isEmpty()) {
				this.vista.lblNewLabelErrorPefilMedico.setText("Campos Obligatorios");
			}else {
				hibernate.actualizarMedico(nombre,especialidad,horaria);
				this.vista.panelVerDatosMedicos.setVisible(false);
			}
		}
	
		if(e.getSource()==this.vista.btnBuscarHistorial) {
			String nombre=this.vista.textFieldBuscarHistorialPaciente.getText();
			String direccion=this.vista.textFieldDireccionPaciente.getText();
			if(nombre.isEmpty()|| direccion.isEmpty()) {
				this.vista.lblErrorFiltro.setText("Campos obligatorios");
			}else {
				mostrarHistorialMedico(nombre,direccion);
			}
		}
		if(e.getSource() == this.vista.btnGuardarHistorialMedico) {
		    String nombrepaciente = this.vista.textFieldNombrePaciente.getText();
		    String nombre=this.vista.lblNewLabelNombreUsuarioMostrarMedico.getText();
		    this.vista.textFieldNombreMedico.setText(nombre);
		    String nombremedico= this.vista.textFieldNombreMedico.getText();
		    String diagnostico = this.vista.textFieldDiagnostico.getText();
		    String tratamiento = this.vista.textFieldTratamiento.getText();
		    String receta = this.vista.textFieldReceta.getText();
		    Calendar calendario = this.vista.calendarioMedico.getCalendar(); 
		    int day = calendario.get(Calendar.DAY_OF_MONTH);
		    int month = calendario.get(Calendar.MONTH) + 1; 
		    int year = calendario.get(Calendar.YEAR);
		    java.util.Date utilDate = calendario.getTime();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    if(nombrepaciente.isEmpty()||nombremedico.isEmpty()||diagnostico.isEmpty()||tratamiento.isEmpty()||receta.isEmpty()) {
		    	this.vista.lblErrorRegistroMedico.setText("Rellena todos los campos");
		    }else {
		    	hibernate.crearHistorialMedico(nombrepaciente, nombremedico, diagnostico, tratamiento, receta, sqlDate);
		    	this.vista.lblErrorRegistroMedico.setText(receta);
		    }
		    
		}
		if (e.getSource() == this.vista.btnFiltrarCitas) {
		  
		    String nombre = this.vista.textFieldNombreMedicoCita.getText();
		    Calendar calendario = this.vista.calendarioCitas.getCalendar();
		    java.util.Date utilDate = calendario.getTime();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		    if (nombre.isEmpty()) {
		        this.vista.lblNewLabelErrorCitas.setText("Campos obligatorios");
		    } else {

		        this.vista.lblNewLabelErrorCitas.setText("");
		        List<Citas> citas = hibernate.obtenerCitasPorMedicoYFecha(nombre, sqlDate);
		      
		            mostrarCitasEnTabla(this.vista.tableMostrarResultadoCitas, citas);
		        
		    }
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
		 this.vista.lblNewLabelCerrarPerfilMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelCerrarPerfilMedico, "imagenes/botonVolver.png"));
		 this.vista.lblNewLabelFondoPerfilMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoPerfilMedico, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblFondoFiltrarHistorial.setIcon(fotoEscalarLabel(this.vista.lblFondoFiltrarHistorial, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.btnBuscarHistorial.setIcon(fotoEscalarButton(this.vista.btnBuscarHistorial, "imagenes/botonBuscar.png"));
		 this.vista.btnGuardarHistorialMedico.setIcon(fotoEscalarButton(this.vista.btnGuardarHistorialMedico, "imagenes/botonGuardar.png"));
		 this.vista.lblNewLabelFondoHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoHistorialMedico, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblFotoMedicoInicio.setIcon(fotoEscalarLabel(this.vista.lblFotoMedicoInicio, "imagenes/fotosMedicos.png"));
		 this.vista.lblFondoEfecto.setIcon(fotoEscalarLabel(this.vista.lblFondoEfecto, "imagenes/fondo_inicio.jpg"));
		 this.vista.btnFiltrarCitas.setIcon(fotoEscalarButton(this.vista.btnFiltrarCitas, "imagenes/botonBuscar.png"));
		 this.vista.lblNewLabelFondoFiltrarCita.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoFiltrarCita, "imagenes/fondo_admin_panel.jpg"));
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
	 
	 public void mostrarHistorialMedico(String username, String direccion) {
		    List<HistorialesMedicos> historial = hibernate.obtenerHistorialMedicoPorUsuario(username, direccion);
		    if (historial.isEmpty()) {
		        this.vista.lblErrorFiltro.setText("No se encontró historial médico");
		        return; 
		    }

		    DefaultTableModel model = new DefaultTableModel();
		    model.addColumn("Diagnóstico");
		    model.addColumn("Tratamiento");
		    model.addColumn("Receta");
		    model.addColumn("Fecha");

		    for (HistorialesMedicos hm : historial) {
		         Object[]datos={
		            hm.getDiagnostico(),
		            hm.getTratamiento(),
		            hm.getReceta(),
		            hm.getFecha()
		        };
		        model.addRow(datos);
		    }
		    this.vista.tableHistorialMedico.setModel(model);
		}
	 public void mostrarCitasEnTabla(JTable tableMostrarResultadoCitas, List<Citas> citas) {
		  
		    DefaultTableModel model = new DefaultTableModel();

		    model.addColumn("Nombre del Médico");
		    model.addColumn("Motivo de la Cita");
		    model.addColumn("Hora de la Cita");
		    model.addColumn("Fecha de la Cita");

		    for (Citas cita : citas) {
		        Object[] fila = new Object[4];
		        fila[0] = cita.getMedicos().getNombre(); 
		        fila[1] = cita.getMotivo();             
		        fila[2] = cita.getHora();               
		        fila[3] = cita.getFecha().toString();   
		        model.addRow(fila);
		    }
		    tableMostrarResultadoCitas.setModel(model);
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
	 
}
