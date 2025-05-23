package persistencias;
// Generated 15 may 2025, 10:27:59 by Hibernate Tools 6.5.1.Final

import java.sql.Date;

/**
 * HistorialesMedicos generated by hbm2java
 */
public class HistorialesMedicos implements java.io.Serializable {

	private Integer id;
	private Pacientes pacientes;
	private Medicos medicos;
	private String diagnostico;
	private String tratamiento;
	private String receta;
	private Date fecha;

	public HistorialesMedicos() {
	}

	public HistorialesMedicos(Pacientes pacientes, Medicos medicos, String diagnostico, String tratamiento,
			String receta, Date fecha) {
		this.pacientes = pacientes;
		this.medicos = medicos;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.receta = receta;
		this.fecha = fecha;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pacientes getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
	}

	public Medicos getMedicos() {
		return this.medicos;
	}

	public void setMedicos(Medicos medicos) {
		this.medicos = medicos;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getReceta() {
		return this.receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
