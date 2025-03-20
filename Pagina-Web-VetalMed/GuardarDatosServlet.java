import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controlador.ControladorHibernet;
import persistencias.Empleados;
import persistencias.Pacientes;

@WebServlet("/guardar-datos") 
public class GuardarDatosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String fechaNacimientoStr = request.getParameter("fecha_nacimiento"); // Corregir nombre del parámetro

        Date fechaNacimiento = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            fechaNacimiento = dateFormat.parse(fechaNacimientoStr);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.html"); 
            return;
        }

        ControladorHibernet controlador = new ControladorHibernet();

        try {

            int empleadoId = controlador.crearUsuario(nombre, password, "paciente");

            controlador.crearPacienteRecepcionista(nombre, password, direccion, telefono, fechaNacimiento);
o
            response.sendRedirect("exito.html");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}