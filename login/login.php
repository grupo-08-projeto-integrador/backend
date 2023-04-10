<?php
// Conecte-se ao banco de dados
$db = new PDO('pgsql:host=localhost;dbname=login_db', 'username', 'password');

// Pegue as informações de login do formulário
$username = $_POST['username'];
$password = $_POST['password'];

// Crie um hash da senha usando a função de hash 'crypt()'
$password_hash = crypt($password, gen_salt('bf', 8));

// Insira o nome de usuário e hash da senha no banco de dados
$stmt = $db->prepare('INSERT INTO users (username, password_hash) VALUES (:username, :password_hash)');
$stmt->execute(array(':username' => $username, ':password_hash' => $password_hash));

echo "Usuário criado com sucesso!";
?>