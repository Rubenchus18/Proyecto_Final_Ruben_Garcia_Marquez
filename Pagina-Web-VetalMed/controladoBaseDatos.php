<?php

$conexion = mysqli_connect("donoso005node.mooo.com:25570", "rubenchus18", "Unlx%bjXVnwt9H4bA", "ClinicaMedica");
if (!$conexion) {
    die("Conexión fallida: " . mysqli_connect_error());
}

$nombre = $_POST["nombre"];
$contraseña = $_POST["contraseña"];
$direccion = $_POST["direccion"];
$telefono = $_POST["telefono"];
$nacimiento = $_POST["nacimiento"]; 
$rol = 'paciente';

if (empty($nombre) || empty($contraseña) || empty($direccion) || empty($telefono) || empty($nacimiento)) {
      header("Location: MalRegistrado.html");
      exit();
}

$query_empleado = "INSERT INTO Empleados (username, password, rol) VALUES ('$nombre', '$contraseña', '$rol')";
if (mysqli_query($conexion, $query_empleado)) {
    $empleado_id = mysqli_insert_id($conexion);

    $query_paciente = "INSERT INTO Pacientes (nombre, direccion, telefono, fecha_nacimiento, empleado_id) 
                       VALUES ('$nombre', '$direccion', '$telefono', '$nacimiento', '$empleado_id')";
    if (mysqli_query($conexion, $query_paciente)) {
        header("Location: RegistradoCorrectamente.html");
        exit();
    } else {
        echo "Error al crear el paciente: " . mysqli_error($conexion) . "<br>";
        echo "Consulta: " . $query_paciente;
    }
} else {
    echo "Error al crear el empleado: " . mysqli_error($conexion) . "<br>";
    echo "Consulta: " . $query_empleado;
}

mysqli_close($conexion);
?>