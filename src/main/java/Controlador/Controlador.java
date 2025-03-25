package Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import java.util.List;

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
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import com.stripe.model.Event.Data;

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
		   this.vista.btnNewButtonCrearPacienteRecepcion.addActionListener(this);
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
		   this.hibernate=new ControladorHibernet();
		   imagenes();
		   iniciarReloj(this.vista.labelHora);
		    añadidoRolesComboBox();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//Administrador
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
		//Medico
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
		//Recepcionista
		if(e.getSource()== this.vista.lblNewLabelCaraRecepcionista) {
			this.vista.panelInformacionPaciente.setVisible(true);
			Recepcionistas recepecionista=new Recepcionistas();
			String nombre=this.vista.lblNewLabelNombreUsuarioMostrarRecepcionista.getText();
			recepecionista=hibernate.cogerDatosRecpecionista(nombre);
			this.vista.lblNewLabelNombrePaciente.setText(recepecionista.getNombre());
			this.vista.panelProgramarCitasRecpecionosta.setVisible(false);
			this.vista.panelCrearPacienteRecepcion.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			   this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
		}
		if(e.getSource()==this.vista.lblNewLabelSalidaRecepcionista) {
			this.vista.panelInicio.setVisible(true);
			this.vista.panelRececipnista.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			   this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
		}
		if(e.getSource()==this.vista.lblRegistro_Nuevo_Pacientes) {
			this.vista.panelCrearPacienteRecepcion.setVisible(true);
			this.vista.panelProgramarCitasRecpecionosta.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			   this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
		}
		if(e.getSource()==this.vista.lbl_Programacion_Citas) {
			this.vista.panelProgramarCitasRecpecionosta.setVisible(true);
			this.vista.panelCrearPacienteRecepcion.setVisible(false);
			this.vista.panelExportacion.setVisible(false);
			   this.vista.panelEmisiondeFacturasRecepcionista.setVisible(false);
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

		    chart.getStyler().setSeriesColors(new Color[]{Color.green}); 
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
		    
		}
		//Paciente
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
			}
			if(e.getSource()==this.vista.lblVerCitasPaciente) {
				String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();	
			
				this.vista.tableVerCitasPacientes.setVisible(true);
				this.vista.scrollPane_3.setVisible(true);
				this.vista.tableVerHistorialMedico.setVisible(false);
				this.vista.scrollPane_4.setVisible(false);
				this.vista.tableVerFacturas_Paciente.setVisible(false);
				this.vista.scrollPane_5.setVisible(false);
				List<Object[]> detallesCitas = hibernate.obtenerDetallesCitasPorPaciente(nombre);
				mostrarCitasEnTabla(detallesCitas,this.vista.tableVerCitasPacientes);
				
			}
			if(e.getSource()==this.vista.lblVerHistorialMedico) {
				String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();
				this.vista.tableVerHistorialMedico.setVisible(true);
				this.vista.scrollPane_4.setVisible(true);
				this.vista.tableVerFacturas_Paciente.setVisible(false);
				this.vista.scrollPane_5.setVisible(false);
				this.vista.tableVerCitasPacientes.setVisible(false);
				this.vista.scrollPane_3.setVisible(false);
				List<Object[]> detallesCitas = hibernate.obtenerHistorialMedicoPaciente(nombre);
				mostrarHistorialClienteEnTabla(detallesCitas,this.vista.tableVerHistorialMedico);
			}
			if(e.getSource()==this.vista.lblPagarFacturas) {
				String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();
				this.vista.tableVerFacturas_Paciente.setVisible(true);
				this.vista.scrollPane_5.setVisible(true);
				this.vista.tableVerCitasPacientes.setVisible(false);
				this.vista.scrollPane_3.setVisible(false);
				this.vista.tableVerHistorialMedico.setVisible(false);
				this.vista.scrollPane_4.setVisible(false);
				this.vista.lblPagarFacturas_Definitiva.setVisible(true);
				this.vista.lblPagarFacturas_Definitiva.setEnabled(false);
				List<Object[]> detallesCitas=hibernate.obtenerFacturaCliente(nombre);
				mostrarFacturasCliente(detallesCitas,this.vista.tableVerFacturas_Paciente);
			}
			if(e.getSource() == this.vista.tableVerFacturas_Paciente) {
			    int seleccionfactura = this.vista.tableVerFacturas_Paciente.getSelectedRow();
			    if (seleccionfactura >= 0) {
			        this.vista.lblPagarFacturas_Definitiva.setEnabled(true);

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
			        String estado = (String) this.vista.tableVerFacturas_Paciente.getValueAt(seleccionfactura, 4); 
			        
			        this.vista.tableVerFacturas_Paciente.putClientProperty("selectedRow", seleccionfactura);
			    }
			}
				if(e.getSource()==this.vista.lblPagarFacturas_Definitiva) {
					this.vista.panelDatos_Cliente_Factura.setVisible(true);
				}
			  
				if(e.getSource()== this.vista.lblPagarFactura) {
				  String nombre=this.vista.lblNewLabelNombreUsuarioMostrarPaciente.getText();
				  int seleccionfactura = (Integer) this.vista.tableVerFacturas_Paciente.getClientProperty("selectedRow");
				  String titular=this.vista.textField_Titular_Tarjeta.getText();
				  String numero=this.vista.textField_Numero_Tarjeta.getText();
				  String csv=this.vista.textField_CSV_Tarjeta.getText();
				  Date fecha_tarjete=this.vista.calendar_fecha_expiracion_tarjeta.getDate();
				  if(titular.isEmpty()||numero.isEmpty()||csv.isEmpty()) {
					  
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
							mostrarFacturasCliente(detallesCitas,this.vista.tableVerFacturas_Paciente);
							this.vista.panelDatos_Cliente_Factura.setVisible(false);
					    }
				  }
				 
			  }
			
		//DobleClick
		if(e.getClickCount()==2) {
			if(e.getSource()== this.vista.lblNewLabelCaraRecepcionista) {
				this.vista.panelInformacionPaciente.setVisible(false);
			}
			if(e.getSource()==this.vista.lblNewLabelCaraMedico) {
				this.vista.panelVerDatosMedicos.setVisible(false);
			}
			if(e.getSource()==this.vista.panelInformacionPaciente_1) {
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
					this.vista.tableMostrarResultadoCitas.setVisible(true);
				}else if(rol.equalsIgnoreCase("recepcionista")) {
					this.vista.panelInicio.setVisible(false);
					this.vista.panelRececipnista.setVisible(true);
					this.vista.lblNewLabelNombreUsuarioMostrarRecepcionista.setText(nombre);
					this.vista.panelCrearPacienteRecepcion.setVisible(true);
				}else if(rol.equalsIgnoreCase("paciente")) {
					this.vista.panelInicio.setVisible(false);
					this.vista.panelPacientes.setVisible(true);
					this.vista.lblNewLabelNombreUsuarioMostrarPaciente.setText(nombre);
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
		    	this.vista.lblErrorRegistroMedico.setText("Creada perfectamente");
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
		//Recepcionista
		if(e.getSource()==this.vista.btnNewButtonCrearPacienteRecepcion) {
			String nombre=this.vista.textField_NombrePaciente.getText();
			String contraseña=this.vista.passwordFieldContraseñaPacienteRecepcion.getText();
			String direccion=this.vista.textFieldDireccionPacienteRecepcion.getText();
			String telefono=this.vista.textFieldTelefonoPacienteRecepcion.getText();
			Calendar calendario = this.vista.calendarFechaNacimientoPacienteRecepcion.getCalendar();
		    java.util.Date utilDate = calendario.getTime();
		    java.sql.Date fechaNacimientoPaciente = new java.sql.Date(utilDate.getTime());
		    if(nombre.isEmpty()||contraseña.isEmpty()|| direccion.isEmpty()|| telefono.isEmpty()) {
		    	this.vista.lblNewLabelErrorCrearPacienteRecepcion.setText("Campos obligatorios");
		    	this.vista.lblNewLabelErrorCrearPacienteRecepcion.setForeground(Color.RED);
		    }else{
		    	hibernate.crearPacienteRecepcionista(nombre, contraseña, direccion, telefono, fechaNacimientoPaciente);
		    	this.vista.lblNewLabelErrorCrearPacienteRecepcion.setText("Se ha creado en todo momento");
		    }
		}
		if(e.getSource()==this.vista.btnNewButtonCrearCitaRecepcion) {
			String nombreCliente = this.vista.textFieldNombrePacienteCitaRecepcion.getText();
			String nombreMedico = this.vista.textFieldNombreMedicoCitaRecepcion.getText();
			Calendar calendario = this.vista.calendarCitaPaciente.getCalendar();
			java.util.Date utilDate = calendario.getTime();
			java.sql.Date fechaCitaPaciente = new java.sql.Date(utilDate.getTime());
			String horaTexto = this.vista.textFieldHoraCitaPaciente.getText(); 
			String motivo = this.vista.textFieldMotivoCitaRecepcion.getText();
			if (nombreCliente.isEmpty() || nombreMedico.isEmpty() || motivo.isEmpty() || horaTexto.isEmpty()) {
			    this.vista.lblNewLabelErrorCrearCitaRecpecion.setText("Campos obligatorios");
			    this.vista.lblNewLabelErrorCrearCitaRecpecion.setForeground(Color.RED);
			} else if (!horaTexto.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {	   
			    this.vista.lblNewLabelErrorCrearCitaRecpecion.setText("Formato de hora inválido (HH:mm)");
			    this.vista.lblNewLabelErrorCrearCitaRecpecion.setForeground(Color.RED);
			} else {
			    try {
			        Time hora = Time.valueOf(horaTexto + ":00"); 
			        hibernate.crearCitaRecepcion(nombreCliente, nombreMedico, fechaCitaPaciente, hora, motivo);
			    } catch (Exception g) {
			        
			        this.vista.lblNewLabelErrorCrearCitaRecpecion.setText("Error al procesar la hora");
			        this.vista.lblNewLabelErrorCrearCitaRecpecion.setForeground(Color.RED);
			    }
			}
		}
		if(e.getSource()==this.vista.btnNewButtonExprotarCSV) {
			hibernate.exportarFacturasACSV("documentos/FacturasConsulta.csv");
		}
		if(e.getSource()==this.vista.btnNewButtonExportarPDF) {
			hibernate.exportarFacturasAPDF("documentos/FacturasConsulta.pdf");
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
		 this.vista.btnNewButtonCrearPacienteRecepcion.setIcon(fotoEscalarButton(this.vista.btnNewButtonCrearPacienteRecepcion, "imagenes/botonGuardar.png"));
		 this.vista.lblNewLabelMarcoMapa.setIcon(fotoEscalarLabel(this.vista.lblNewLabelMarcoMapa, "imagenes/marcomapa.png"));
		 this.vista.btnNewButtonCrearCitaRecepcion.setIcon(fotoEscalarButton(this.vista.btnNewButtonCrearCitaRecepcion, "imagenes/botonGuardar.png"));
		 this.vista.lblNewLabelFondoPanelCrearCitaRecepcion.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoPanelCrearCitaRecepcion, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabelFondoEmisionFacturasRecepcion.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoEmisionFacturasRecepcion, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.btnNewButtonExportarPDF.setIcon(fotoEscalarButton(this.vista.btnNewButtonExportarPDF, "imagenes/exportarPDF.png"));
		 this.vista.btnNewButtonExprotarCSV.setIcon(fotoEscalarButton(this.vista.btnNewButtonExprotarCSV, "imagenes/botonExportarCSV.png"));
		 this.vista.lblNewLabelSalida_Paciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelSalida_Paciente, "imagenes/botonVolver.png"));
		 this.vista.lblVerCitasPaciente.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/vercitas.png"));
		 this.vista.lblVerHistorialMedico.setIcon(fotoEscalarLabel(this.vista.lblVerCitasPaciente, "imagenes/Historial.png"));
		 this.vista.lblPagarFacturas.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas, "imagenes/btnPagarFacturas.png"));
		 this.vista.lblNewLabelFondoPaciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondoPaciente, "imagenes/fondo_aplicacion.jpg"));
		 this.vista.lblNewLabelCaraPaciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelCaraPaciente, "imagenes/foto_perfil.png"));
		 this.vista.lblNewLabelLogoMedico_Paciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabelCaraPaciente, "imagenes/logo.png"));
		 this.vista.lblNewLabel_FondoInformacionPaciente.setIcon(fotoEscalarLabel(this.vista.lblNewLabel_FondoInformacionPaciente, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblNewLabelFondo_Datos_Cliente_Factura.setIcon(fotoEscalarLabel(this.vista.lblNewLabelFondo_Datos_Cliente_Factura, "imagenes/fondo_admin_panel.jpg"));
		 this.vista.lblPagarFactura.setIcon(fotoEscalarLabel(this.vista.lblPagarFactura, "imagenes/btn_pagar.png"));
		this.vista.lblPagarFacturas_Definitiva.setIcon(fotoEscalarLabel(this.vista.lblPagarFacturas_Definitiva, "imagenes/btn_pagar.png"));
		 
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
		    model.addColumn("Nombre del Paciente");
		    model.addColumn("Motivo de la Cita");
		    model.addColumn("Hora de la Cita");
		    model.addColumn("Fecha de la Cita");

		    for (Citas cita : citas) {
		        Object[] fila = new Object[5];
		        fila[0] = cita.getMedicos().getNombre();
		        fila[1] = cita.getPacientes().getNombre();   
		        fila[2] = cita.getMotivo();             
		        fila[3] = cita.getHora();               
		        fila[4] = cita.getFecha().toString();   
		        model.addRow(fila);
		    }
		    tableMostrarResultadoCitas.setModel(model);
		}
	  public static void mostrarCitasEnTabla(List<Object[]> detallesCitas,JTable citas) {

	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Paciente");
	        model.addColumn("Médico");
	        model.addColumn("Especialidad");
	        model.addColumn("Fecha");
	        model.addColumn("Hora");
	        model.addColumn("Motivo");

	       
	        for (Object[] detalle : detallesCitas) {
	            model.addRow(detalle);
	        }
	        citas.setModel(model);
	        
	    }
	  public static void mostrarHistorialClienteEnTabla(List<Object[]> detallesCitas, JTable historial) {
		    DefaultTableModel model = new DefaultTableModel();
		    model.addColumn("Paciente");
		    model.addColumn("Médico");
		    model.addColumn("Especialidad");
		    model.addColumn("Fecha");
		    model.addColumn("Hora");
		    model.addColumn("Motivo");

	
		    for (Object[] detalle : detallesCitas) {
		        model.addRow(detalle);
		    }

		    historial.setModel(model);
		}
	  public static void mostrarFacturasCliente(List<Object[]> detallesFacturas, JTable facturas) {
		    DefaultTableModel model = new DefaultTableModel();
		  
		    model.addColumn("Paciente");
		    model.addColumn("Dirección");
		    model.addColumn("Dinero");
		    model.addColumn("Fecha");
		    model.addColumn("Estado");
		    
		  
		    model.setRowCount(0);
		    
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
		            
		            model.addRow(rowData);
		        }
		    }
		    
		    facturas.setModel(model);
		
		    facturas.getColumnModel().getColumn(0).setPreferredWidth(150);
		    facturas.getColumnModel().getColumn(1).setPreferredWidth(200);
		    facturas.getColumnModel().getColumn(2).setPreferredWidth(80);  
		    facturas.getColumnModel().getColumn(3).setPreferredWidth(100);
		    facturas.getColumnModel().getColumn(4).setPreferredWidth(80); 
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
