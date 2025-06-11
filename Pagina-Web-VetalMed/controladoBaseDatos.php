<?php
session_start();
function handleError() {
    header("Location: MalRegistrado.html");
    exit();
}


if (!isset($_POST["nombre"]) || !isset($_POST["contraseña"]) || !isset($_POST["direccion"]) || 
    !isset($_POST["telefono"]) || !isset($_POST["nacimiento"]) || !isset($_POST["correo"]) || 
    !isset($_POST["dni"])) {
    handleError();
}


$nombre = trim($_POST["nombre"]);
$contraseña = trim($_POST["contraseña"]);
$direccion = trim($_POST["direccion"]);
$telefono = trim($_POST["telefono"]);
$nacimiento = trim($_POST["nacimiento"]); 
$correo = trim($_POST["correo"]);
$dni = trim($_POST["dni"]);
$rol = 'paciente';

if (empty($nombre) || empty($contraseña) || empty($direccion) || empty($telefono) || 
    empty($nacimiento) || empty($correo) || empty($dni)) {
    handleError();
}


if(!preg_match('/^[0-9]{8}[A-Za-z]$/', $dni)) {
    handleError();
}


$conexion = @mysqli_connect("donoso005node.duckdns.org:25570", "rubenchus18", "Unlx%bjXVnwt9H4bA", "ClinicaMedica");
if (!$conexion) {
    handleError();
}

$nombre = mysqli_real_escape_string($conexion, $nombre);
$contraseña = mysqli_real_escape_string($conexion, $contraseña);
$direccion = mysqli_real_escape_string($conexion, $direccion);
$telefono = mysqli_real_escape_string($conexion, $telefono);
$nacimiento = mysqli_real_escape_string($conexion, $nacimiento);
$correo = mysqli_real_escape_string($conexion, $correo);
$dni = mysqli_real_escape_string($conexion, $dni);

mysqli_begin_transaction($conexion);

try {
    $query_empleado = "INSERT INTO Empleados (username, password, rol) VALUES ('$nombre', '$contraseña', '$rol')";
    if (!mysqli_query($conexion, $query_empleado)) {
        throw new Exception("Error al crear el empleado");
    }
    
    $empleado_id = mysqli_insert_id($conexion);
    $query_paciente = "INSERT INTO Pacientes (nombre, direccion, telefono, fecha_nacimiento, empleado_id, correo_electronico, dni) 
                       VALUES ('$nombre', '$direccion', '$telefono', '$nacimiento', '$empleado_id', '$correo', '$dni')";
    
    if (!mysqli_query($conexion, $query_paciente)) {
        throw new Exception("Error al crear el paciente");
    }
    mysqli_commit($conexion);
    header("Location: RegistradoCorrectamente.html");
    exit();
    
} catch (Exception $e) {
    mysqli_rollback($conexion);
    handleError();
} finally {
    mysqli_close($conexion);
}
?>