const form = document.querySelector('form');
const loginBtn = document.querySelector('#login-btn');

form.addEventListener('submit', e => {
  e.preventDefault();
  
  const username = document.querySelector('#username').value;
  const password = document.querySelector('#password').value;


  if (username === 'lucas' && password === '123') {
    window.location.href = 'produtos.html';
  } else {
    alert('Usuário ou senha incorretos');
  }
});
