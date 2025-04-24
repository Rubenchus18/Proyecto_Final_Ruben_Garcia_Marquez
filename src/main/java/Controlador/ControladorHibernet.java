package Controlador;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import persistencias.Citas;
import persistencias.Empleados;
import persistencias.Facturas;
import persistencias.HistorialesMedicos;
import persistencias.Pacientes;
import persistencias.Medicos;
import persistencias.Recepcionistas;

public class ControladorHibernet {

    private SessionFactory sessionFactory;

    public ControladorHibernet() throws Exception {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Método para obtener el rol de un usuario
    public String sacarRoles(String nombreusuario, String contraseña) {
        Session session = null;
        String rol = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Query<Empleados> q = session.createQuery("FROM Empleados WHERE username = :nombre AND password = :contraseña", Empleados.class);
            q.setParameter("nombre", nombreusuario);
            q.setParameter("contraseña", contraseña);

            List<Empleados> empleados = q.getResultList();

            if (!empleados.isEmpty()) {
                rol = empleados.get(0).getRol();
            } else {
                rol = null;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return rol;
    }

    // Método para obtener todos los usuarios (Empleados)
    public List<Empleados> obtenerTodosLosUsuarios() {
        Session session = null;
        List<Empleados> usuarios = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Query<Empleados> q = session.createQuery("FROM Empleados", Empleados.class);
            usuarios = q.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return usuarios;
    }

    // Método para crear un nuevo usuario (Empleado)
    public int crearUsuario(String nombreusuario, String contraseña, String rol) {
        Session sesion = null;
        Integer id = null;
        try {
            sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();

            Empleados empleado = new Empleados();
            empleado.setUsername(nombreusuario);
            empleado.setPassword(contraseña);
            empleado.setRol(rol);

            sesion.save(empleado);
            sesion.getTransaction().commit();
            id = empleado.getId(); 
        } catch (Exception e) {
            if (sesion != null && sesion.getTransaction() != null) {
                sesion.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return id;
    }

    // Método para eliminar un usuario (Empleado)
    public void eliminarUsuario(String nombreUsuario) {
        Session sesion = null;
        try {
            sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();

            Query<Empleados> query = sesion.createQuery("FROM Empleados WHERE username = :nombre", Empleados.class);
            query.setParameter("nombre", nombreUsuario);
            Empleados empleado = query.uniqueResult();

            if (empleado != null) {
                sesion.delete(empleado);
                System.out.println("Usuario eliminado: " + nombreUsuario);
            } else {
                System.out.println("Usuario no encontrado: " + nombreUsuario);
            }

            sesion.getTransaction().commit();
        } catch (Exception e) {
            if (sesion != null && sesion.getTransaction() != null) {
                sesion.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    // Método para editar un usuario (Empleado)
    public void EditarUsuario(String nuevoNombreUsuario, String nuevaContraseña, String nuevoRol) {
        Session sesion = null;
        try {
            sesion = sessionFactory.getCurrentSession();
            sesion.beginTransaction();

            Query<Empleados> query = sesion.createQuery("FROM Empleados WHERE username = :nombreUsuario", Empleados.class);
            query.setParameter("nombreUsuario", nuevoNombreUsuario);
            Empleados empleado = query.uniqueResult();

            if (empleado != null) {
                empleado.setUsername(nuevoNombreUsuario);
                empleado.setPassword(nuevaContraseña);
                empleado.setRol(nuevoRol);
                
                sesion.saveOrUpdate(empleado);
                sesion.getTransaction().commit();
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("Usuario no encontrado: " + nuevoNombreUsuario);
            }
        } catch (Exception e) {
            if (sesion != null && sesion.getTransaction() != null) {
                sesion.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    
    public void crearPaciente(String nombre, int empleadoId) {
        Session session = null;
        Empleados emple=new Empleados();
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query q=session.createQuery("FROM Empleados WHERE username=: nombrea");
            q.setParameter("nombrea", nombre);
            emple=(Empleados) q.getSingleResult();
            
            Pacientes paciente = new Pacientes();
            paciente.setNombre(nombre);
            paciente.setEmpleados(emple);

            session.save(paciente);
            session.getTransaction().commit();
            System.out.println("Paciente creado correctamente.");
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void crearMedico(String nombre, int empleadoId) {
        Session session = null;
        Empleados emple=new Empleados();
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            
            Query q=session.createQuery("FROM Empleados WHERE username=: nombrea");
            q.setParameter("nombrea", nombre);
            emple=(Empleados) q.getSingleResult();
            
            Medicos medico = new Medicos();
            medico.setNombre(nombre);
            medico.setEmpleados(emple); 

            session.save(medico);
            session.getTransaction().commit();
            System.out.println("Médico creado correctamente.");
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void crearRecepcionista(String nombre) {
        Session session = null;
        Empleados emple=new Empleados();
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

         
            Query q=session.createQuery("FROM Empleados WHERE username=: nombrea");
            q.setParameter("nombrea", nombre);
            emple=(Empleados) q.getSingleResult();
            
            Recepcionistas recepcionista = new Recepcionistas();
            recepcionista.setNombre(nombre);
            recepcionista.setEmpleados(emple);;  

            session.save(recepcionista);
            session.getTransaction().commit();
            System.out.println("Recepcionista creado correctamente.");
        } catch (Exception e) {
            if (session != null && session.isOpen()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public Medicos verDatosMedicos(String nombre) {
    	Session session=null;
    	Medicos medicos=new Medicos();
    	Empleados empleado=new Empleados();
    	try {
    		session=sessionFactory.getCurrentSession();
    		session.beginTransaction();
    		
    		Query q2=session.createQuery("FROM Empleados WHERE username= :nombreuser");
    		q2.setParameter("nombreuser", nombre);
    		empleado=(Empleados)q2.getSingleResult();
    		Query q=session.createQuery("FROM Medicos WHERE empleados= :empleado ");
    		q.setParameter("empleado", empleado);
    		medicos=(Medicos) q.getSingleResult();
    		
    		session.getTransaction().commit();;
    		
    	}catch(Exception e) {
    		if(session!=null) {
    			  session.getTransaction().rollback();
    		}
    		e.printStackTrace();
    	}finally{
    		if(session!=null) {
    			 session.close();
    		}
    	}
		return medicos;
    }
    public void actualizarMedico(String nombre, String nuevaEspecialidad, String nuevoHorario) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Query<Medicos> query = session.createQuery("FROM Medicos WHERE nombre = :nombre", Medicos.class);
            query.setParameter("nombre", nombre);
            Medicos medico = query.uniqueResult();

            if (medico != null) {
                medico.setEspecialidad(nuevaEspecialidad);
                medico.setHorario(nuevoHorario);
                session.saveOrUpdate(medico);
                session.getTransaction().commit();
                System.out.println("Médico actualizado correctamente.");
            } else {
                System.out.println("Médico no encontrado: " + nombre);
            }
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
            	 session.close();
            }
        }
    }
    public List<HistorialesMedicos> obtenerHistorialMedicoPorUsuario(String numero_telefono) {
        Session session = null;
        List<HistorialesMedicos> historial = null;
        Pacientes paciente=new Pacientes();
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

         
            Query queryPaciente = session.createQuery("FROM Pacientes WHERE telefono=: telefonos", Pacientes.class);
            queryPaciente.setParameter("telefonos", numero_telefono);
             paciente = (Pacientes) queryPaciente.uniqueResult();

            if (paciente != null) {
                Query<HistorialesMedicos> queryHistorial = session.createQuery("FROM HistorialesMedicos WHERE pacientes.id = :pacienteId", HistorialesMedicos.class);
                queryHistorial.setParameter("pacienteId", paciente.getId());
                historial = queryHistorial.getResultList();
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return historial;
    }
    public void crearHistorialMedico(String nombrePaciente, String nombreMedico, String diagnostico, String tratamiento, String receta, Date fecha) {
       Session session=null;
       Pacientes paciente=new Pacientes();
       Medicos medicos=new Medicos();
        try {
        	 session =sessionFactory.getCurrentSession();
        	 session.beginTransaction();
        	 String hqlEmpleado = "FROM Empleados e WHERE e.username = :username";
             Query<Empleados> queryEmpleado = session.createQuery(hqlEmpleado, Empleados.class);
             queryEmpleado.setParameter("username", nombreMedico);
             Empleados empleado = queryEmpleado.uniqueResult();

             String hqlMedico = "FROM Medicos m WHERE m.empleados.id = :empleadoId";
             Query<Medicos> queryMedico = session.createQuery(hqlMedico, Medicos.class);
             queryMedico.setParameter("empleadoId", empleado.getId());
             Medicos medico = queryMedico.uniqueResult();
             
            Query querypaciente=session.createQuery("FROM Pacientes WHERE nombre=:nombrep");
            		querypaciente.setParameter("nombrep", nombrePaciente);
            		paciente=(Pacientes) querypaciente.uniqueResult();

                    
            Query medicosquery =session.createQuery("FROM Medicos WHERE nombre=:nombrem");
            medicosquery.setParameter("nombrem", medico.getNombre());
            medicos=(Medicos) medicosquery.uniqueResult();
            
            System.out.println("Paciente encontrado: " + (paciente != null));
            System.out.println("Médico encontrado: " + (medicos != null));
            if (paciente != null && medicos != null) {
               
                HistorialesMedicos historial = new HistorialesMedicos();
                historial.setPacientes(paciente);
                historial.setMedicos(medicos);
                historial.setDiagnostico(diagnostico);
                historial.setTratamiento(tratamiento);
                historial.setReceta(receta);
                historial.setFecha(fecha);

                
                session.save(historial);
                session.getTransaction().commit();
                System.out.println("Historial médico creado exitosamente.");
            } else {
                System.out.println("No se encontró el paciente o el médico.");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
        	if (session != null) {
                session.close();
            }
        }
    }
    public List<Citas> obtenerCitasPorMedicoYFecha(String usernameEmpleado, java.sql.Date fecha) {
        Session session = null;
        List<Citas> citas = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

    
            String hqlEmpleado = "FROM Empleados e WHERE e.username = :username";
            Query<Empleados> queryEmpleado = session.createQuery(hqlEmpleado, Empleados.class);
            queryEmpleado.setParameter("username", usernameEmpleado);
            Empleados empleado = queryEmpleado.uniqueResult();

            String hqlMedico = "FROM Medicos m WHERE m.empleados.id = :empleadoId";
            Query<Medicos> queryMedico = session.createQuery(hqlMedico, Medicos.class);
            queryMedico.setParameter("empleadoId", empleado.getId());
            Medicos medico = queryMedico.uniqueResult();

            String hqlCitas = "SELECT c FROM Citas c JOIN FETCH c.medicos m JOIN FETCH c.pacientes p " +
                             "WHERE m.id = :medicoId AND c.fecha = :fecha";
            Query<Citas> queryCitas = session.createQuery(hqlCitas, Citas.class);
            queryCitas.setParameter("medicoId", medico.getId());
            queryCitas.setParameter("fecha", fecha);

            citas = queryCitas.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al obtener citas por médico y fecha", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return citas; 
    }
	public Pacientes cogerDatosPaciente(String nombreCliente) {
		Session session=null;
		Pacientes paciente=new Pacientes();
		try{
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query q=session.createQuery("FROM Pacientes WHERE nombre=:nombrep");
			q.setParameter("nombrep", nombreCliente);
			paciente=(Pacientes) q.getSingleResult();
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(session!=null) {
				session.getTransaction().rollback();
			}
		}finally {
			if(session!=null) {
				 session.close();
			}
		}
		return paciente;
	}
	public Recepcionistas cogerDatosRecpecionista(String nombreRecepcionista) {
		Session session=null;
		Recepcionistas recpecionista=new Recepcionistas();
		try{
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query q=session.createQuery("FROM Recepcionistas WHERE nombre=:nombrep");
			q.setParameter("nombrep", nombreRecepcionista);
			recpecionista=(Recepcionistas) q.getSingleResult();
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(session!=null) {
				session.getTransaction().rollback();
			}
		}finally {
			if(session!=null) {
				 session.close();
			}
		}
		return recpecionista;
	}
	public void crearPacienteRecepcionista(String username, String password, String direccion, String telefono, Date fechaNacimiento) {
	    Session session = null;
	    try {
	        session = sessionFactory.getCurrentSession();
	   
	        session.beginTransaction();
	     
	        Empleados empleado = new Empleados();
	        empleado.setUsername(username);      
	        empleado.setPassword(password);      
	        empleado.setRol("paciente");         
	      
	        session.save(empleado);             
	   
	        Pacientes paciente = new Pacientes();
	        paciente.setNombre(username);         
	        paciente.setDireccion(direccion);    
	        paciente.setTelefono(telefono);      
	        paciente.setFechaNacimiento(fechaNacimiento); 
	        paciente.setEmpleados(empleado);  
	        
	      
	        session.save(paciente);             
	
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	   
	        if (session != null && session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}
	  public void crearCitaRecepcion(String nombrePaciente, String nombreMedico, Date fecha, Time hora, String motivo) {
	        Session session = sessionFactory.openSession();
	        try {
	        	  session = sessionFactory.getCurrentSession();
	       	   
	  	        session.beginTransaction();

	            Pacientes paciente = (Pacientes) session.createQuery("FROM Pacientes WHERE nombre = :nombre")
	                                                  .setParameter("nombre", nombrePaciente)
	                                                  .uniqueResult();

	            Medicos medico = (Medicos) session.createQuery("FROM Medicos WHERE nombre = :nombre")
	                                           .setParameter("nombre", nombreMedico)
	                                           .uniqueResult();

	            if (paciente != null && medico != null) {
	                Citas nuevaCita = new Citas();
	                nuevaCita.setFecha(fecha);
	                nuevaCita.setHora(hora);
	                nuevaCita.setPacientes(paciente);
	                nuevaCita.setMedicos(medico);
	                nuevaCita.setMotivo(motivo);
	                session.save(nuevaCita);
	            } else {
	                System.out.println("Paciente o Médico no encontrado.");
	            }

	            session.getTransaction().commit();
	        } catch (Exception e) {
	            if (session != null) {
	            	session.getTransaction().rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	  public double[] obtenerTotalesFacturas() {
		    double[] totales = new double[2];
		    Session session = sessionFactory.getCurrentSession();
		    try {
		        session.beginTransaction();

		        Query<BigDecimal> queryPagadas = session.createQuery(
		            "SELECT SUM(monto) FROM Facturas WHERE pagado = true", BigDecimal.class);
		        BigDecimal totalPagadas = queryPagadas.uniqueResult();
		        totales[0] = (totalPagadas != null) ? totalPagadas.doubleValue() : 0.0;

		        
		        Query<BigDecimal> queryNoPagadas = session.createQuery(
		            "SELECT SUM(monto) FROM Facturas WHERE pagado = false", BigDecimal.class);
		        BigDecimal totalNoPagadas = queryNoPagadas.uniqueResult();
		        totales[1] = (totalNoPagadas != null) ? totalNoPagadas.doubleValue() : 0.0;

		        session.getTransaction().commit();
		    } catch (Exception e) {
		        if (session != null && session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }
		    return totales;
		}
	  public void exportarFacturasACSV(String archivoCSV) {
		    Session session = null;
		    try {
		        session = sessionFactory.getCurrentSession();
		        session.beginTransaction();

		        String hql = "SELECT f.id, p.nombre, f.monto, f.fecha, f.pagado, h.tratamiento " +
		                     "FROM Facturas f " +
		                     "JOIN f.pacientes p " +
		                     "LEFT JOIN HistorialesMedicos h ON h.pacientes.id = p.id " +
		                     "ORDER BY f.id";

		        Query<Object[]> query = session.createQuery(hql, Object[].class);
		        List<Object[]> resultados = query.getResultList();

		        try (FileWriter writer = new FileWriter(archivoCSV)) {
		            writer.write("ID,Nombre del Cliente,Importe,Fecha,Tratamiento,¿Pagado?\n");
		            for (Object[] fila : resultados) {
		                int id = (int) fila[0];
		                String nombreCliente = (String) fila[1];
		                BigDecimal importeBD = (BigDecimal) fila[2]; 
		                double importe = importeBD.doubleValue();
		                Date fecha = (Date) fila[3];
		                boolean pagado = (boolean) fila[4];
		                String tratamiento = (fila[5] != null) ? (String) fila[5] : "Sin tratamiento";

		                writer.write(String.format("%d,%s,%.2f,%s,%s,%s\n",
		                    id, nombreCliente, importe, fecha.toString(), tratamiento, pagado ? "Sí" : "No"));
		            }

		            System.out.println("Datos exportados correctamente a " + archivoCSV);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        session.getTransaction().commit();
		    } catch (Exception e) {
		        if (session != null && session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }
		}
	  public void exportarFacturasAPDF(String archivoPDF) {
		    Session session = null;
		    Document document = new Document();
		   
		    try {
		        PdfWriter.getInstance(document, new FileOutputStream(archivoPDF));
		        document.open();

		        session = sessionFactory.getCurrentSession();
		        session.beginTransaction();

		        String hql = "SELECT f.id, p.nombre, f.monto, f.fecha, f.pagado, h.tratamiento " +
		                     "FROM Facturas f " +
		                     "JOIN f.pacientes p " +
		                     "LEFT JOIN HistorialesMedicos h ON h.pacientes.id = p.id " +
		                     "ORDER BY f.id";

		        Query<Object[]> query = session.createQuery(hql, Object[].class);
		        List<Object[]> resultados = query.getResultList();

		        PdfPTable table = new PdfPTable(6); 
		        table.setWidthPercentage(100); 

		        table.addCell("ID");
		        table.addCell("Nombre del Cliente");
		        table.addCell("Importe");
		        table.addCell("Fecha");
		        table.addCell("Tratamiento");
		        table.addCell("¿Pagado?");

		        for (Object[] fila : resultados) {
		            int id = (int) fila[0];
		            String nombreCliente = (String) fila[1];
		            BigDecimal montoBigDecimal = (BigDecimal) fila[2];
		            double importe = montoBigDecimal.doubleValue();
		            Date fecha = (Date) fila[3];
		            boolean pagado = (boolean) fila[4];
		            String tratamiento = (fila[5] != null) ? (String) fila[5] : "Sin tratamiento";

		            table.addCell(String.valueOf(id));
		            table.addCell(nombreCliente);
		            table.addCell(String.format("%.2f", importe));
		            table.addCell(fecha.toString());
		            table.addCell(tratamiento);
		            table.addCell(pagado ? "Sí" : "No");
		        }
		        Image imagen = Image.getInstance("imagenes/logo.png"); 
	            imagen.scaleToFit(200, 200); 
	            imagen.setAlignment(Image.ALIGN_CENTER);
	            document.add(imagen);
		        document.add(new Paragraph("Reporte de Facturas"));
		        document.add(new Paragraph(" "));
		        document.add(table);


		        session.getTransaction().commit();
		    } catch (Exception e) {
		        if (session != null && session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (document != null && document.isOpen()) {
		            document.close(); 
		        }
		        if (session != null) {
		            session.close();
		        }
		    }
		}
	  public List<Object[]> obtenerDetallesCitasPorPaciente(String nombrePaciente) {
		    Session session=null;
		    List<Object[]> resultados=null;
		    try {
		    		session=sessionFactory.getCurrentSession();
		    		session.beginTransaction();
		    		  String consulta = "SELECT p.nombre, m.nombre, m.especialidad, c.fecha, c.hora, c.motivo " +
				                 "FROM Citas c " +
				                 "INNER JOIN c.pacientes p " +
				                 "INNER JOIN c.medicos m " +
				                 "WHERE p.nombre = :nombrePaciente";
				    Query<Object[]> query = session.createQuery(consulta, Object[].class);
				    query.setParameter("nombrePaciente", nombrePaciente);
				    resultados = query.getResultList();
				    
				    session.getTransaction().commit();
		    }catch(Exception e) {
		    	 if (session != null) {
			            session.getTransaction().rollback();
			        }
		    	 e.printStackTrace();

		    }finally {
		    	 if (session != null) {
			            session.close();
			        }
		    }
		  
		    return resultados;
		}
	  public List<Object[]> obtenerHistorialMedicoPaciente(String nombre) {
		    Session session = null;
		    List<Object[]> resultados = null;
		    try {
		        session = sessionFactory.getCurrentSession();
		        session.beginTransaction();
		        
		        String consulta = "SELECT P.nombre, M.nombre, HM.diagnostico, HM.tratamiento, HM.receta, HM.fecha " +
		                          "FROM HistorialesMedicos HM " +
		                          "INNER JOIN HM.pacientes P " +
		                          "INNER JOIN HM.medicos M " +
		                          "WHERE P.nombre = :nombrePaciente";
		        
		        Query<Object[]> query = session.createQuery(consulta, Object[].class);
		        query.setParameter("nombrePaciente", nombre);
		        
		        resultados = query.getResultList();
		        
		        session.getTransaction().commit();
		    } catch (Exception e) {
		        if (session != null) {
		            session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		    	if (session != null) {
		            session.close();
		        }
		    }
		    return resultados;
		}
	  
	  public List<Object[]> obtenerFacturaCliente(String nombre) {
		    Session session = null;
		    List<Object[]> resultados = null;
		    try {
		        session = sessionFactory.getCurrentSession();
		        session.beginTransaction();
		        
		        String consulta = "SELECT "
		                + "p.nombre AS nombre_paciente, "
		                + "p.direccion AS direccion_paciente, "
		                + "f.monto AS monto_factura, "
		                + "f.fecha AS fecha_factura, "
		                + "CASE WHEN f.pagado = true THEN 'Pagado' ELSE 'Pendiente' END AS estado_pago "
		                + "FROM Facturas f "
		                + "INNER JOIN Pacientes p ON f.pacientes = p.id "
		                + "WHERE p.nombre = :nombre";
		        
		        Query<Object[]> query = session.createQuery(consulta, Object[].class);
		        query.setParameter("nombre",nombre);
		        
		        resultados = query.getResultList();
		        
		        session.getTransaction().commit();
		    } catch(Exception e) {
		        e.printStackTrace();
		        if (session != null) {
		            session.getTransaction().rollback();
		        }
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }
		    return resultados;
		}
	  public void actualizarEstadoFactura(String direccion, BigDecimal monto, java.sql.Date fecha) {
		    Session session = null;
		    Transaction transaction = null;
		    Pacientes p=new Pacientes();
		    try {
		        session = sessionFactory.getCurrentSession();
		         session.beginTransaction();
		        
		        Query q=session.createQuery("FROM Pacientes WHERE direccion=: direcciones");
		        q.setParameter("direcciones", direccion);
		        p=(Pacientes) q.getSingleResult();
		        
		        String sql = "UPDATE Facturas f " +
		                "SET f.pagado = 1 " +
		                "WHERE f.paciente_id = :id_paciente " +
		                "AND f.monto = :dinero " +
		                "AND f.fecha = :fecha";

		   Query q2 = session.createNativeQuery(sql);
		   q2.setParameter("id_paciente", p.getId());
		   q2.setParameter("dinero", monto);
		   q2.setParameter("fecha", fecha);
		   int updated = q2.executeUpdate(); 
		        
		        
		        session.getTransaction().commit();
		    } catch (Exception e) {
		        if (session != null) {
		        	session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		      
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }
		}
	  public void crearFacturaPorNombrePaciente(String nombrePaciente, BigDecimal monto, Date fechaCreacion) {
		  Session session = null;

	        try {
	        	 session = sessionFactory.getCurrentSession();
		         session.beginTransaction();

	            Pacientes paciente = (Pacientes) session.createQuery(
	                    "FROM Pacientes p WHERE p.nombre = :nombre")
	                    .setParameter("nombre", nombrePaciente)
	                    .getSingleResult();

	            if (paciente != null) {
	                Facturas nuevaFactura = new Facturas();
	                nuevaFactura.setPacientes(paciente);
	                nuevaFactura.setMonto(monto);
	                nuevaFactura.setFecha(fechaCreacion);
	                nuevaFactura.setPagado(false);
	                session.save(nuevaFactura);    
	            }
	            session.getTransaction().commit();
	        } catch (Exception e) {
	            if (session != null) {
	                session.getTransaction().rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	  public List<String> obtenerCorreosElectronicos() {
		    Session session = null;
		    List<String> correos = new ArrayList<>();
		    try {
		        session = sessionFactory.openSession();
		        session.beginTransaction();
		        
		        String hql = "SELECT p.correoElectronico FROM Pacientes p WHERE p.correoElectronico IS NOT NULL";
		        Query<String> query = session.createQuery(hql, String.class);
		        correos = query.getResultList();
		        
		        session.getTransaction().commit();
		    } catch (Exception e) {
		        if (session != null && session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }
		    return correos;
		}
	  public List<String> obtenerNombres_Medico() {
		    Session session = null;
		    List<String> medico = new ArrayList<>();
		    try {
		        session = sessionFactory.openSession();
		        session.beginTransaction();
		        
		        String hql = "SELECT m.nombre FROM Medicos m";
		        Query<String> query = session.createQuery(hql, String.class);
		        medico = query.getResultList();
		        
		        session.getTransaction().commit();
		    } catch (Exception e) {
		        if (session != null && session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }
		    return medico;
		}
}