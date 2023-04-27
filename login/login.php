<?php
// Obtenha as informações do formulário
$username = $_POST['username'];
$password = $_POST['password'];
$email = $_POST['email'];

// Crie uma conexão com o banco de dados PostgreSQL
$dbhost = 'localhost';
$dbname = 'login_db';
$dbuser = 'postgres';
$dbpass = '091974';
$conn = new PDO("pgsql:host=$dbhost;dbname=$dbname", $dbuser, $dbpass);

// Crie um hash da senha usando a função de hash 'password_hash()'
$password_hash = password_hash($password, PASSWORD_DEFAULT);

// Insira as informações do usuário na tabela 'users'
$stmt = $conn->prepare('INSERT INTO users (username, password, email) VALUES (:username, :password, :email)');
$stmt->execute(array(':username' => $username, ':password' => $password_hash, ':email' => $email));

echo "Usuário criado com sucesso!";
?>
