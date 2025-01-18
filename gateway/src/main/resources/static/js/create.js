  document.addEventListener('DOMContentLoaded', function() {
  document.querySelector('form').addEventListener('submit', function(e) {
   e.preventDefault(); // Остановить стандартное поведение формы


   // Получить данные из формы
   const email = document.querySelector('#email').value
   const realPassword = document.querySelector('#realPassword').value;
   const confirmPassword = document.querySelector('#confirmPassword').value;

   if (realPassword !== confirmPassword) {
   alert('Пароли не совпадают. Попробуйте ещё раз.');
   return;
   }

   // Преобразовать данные в JSON
   const data = {
   realPassword,
   email,
   };


   // Отправить JSON запрос
   createUser(data).then(() => {
   // Очистить поля формы при успешной отправке
   document.querySelector('#realPassword').value = '';
   document.querySelector('#email').value = '';
   document.querySelector('#confirmPassword').value = '';
   // Также логировать сообщение в консоль
   console.log('Поля формы очищены после успешной отправки');
   });
   });


  function createUser(data) {
    return fetch(`/users`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Ошибка при отправке данных');
      }
      return response.json();
    })
    .then(data => {
      console.log('Данные успешно обновлены');
    })
    .catch(error => {
      console.error('Произошла ошибка:', error);
    });
  }
});