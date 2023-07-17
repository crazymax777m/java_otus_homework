"use strict";


// Получаем ссылки на элементы формы и таблицы
const form = document.getElementById('studentForm');
const tableBody = document.querySelector('#studentTable tbody');
const averageAgeCell = document.getElementById('averageAge');

// Обработчик события отправки формы
form.addEventListener('submit', function(e) {
    e.preventDefault();

    // Получаем значения из полей формы
    const name = document.getElementById('name').value;
    const dob = document.getElementById('dob').value;
    const gender = document.getElementById('gender').value;

    // Рассчитываем возраст студента
    const age = calculateAge(dob);

    // Создаем новую строку для таблицы
    const newRow = document.createElement('tr');
    const nameCell = document.createElement('td');
    const genderCell = document.createElement('td');
    const dobCell = document.createElement('td');
    const ageCell = document.createElement('td');

    // Заполняем ячейки данными
    nameCell.textContent = name;
    genderCell.textContent = gender;
    dobCell.textContent = dob;
    ageCell.textContent = age;

    // Добавляем ячейки в строку
    newRow.appendChild(nameCell);
    newRow.appendChild(genderCell);
    newRow.appendChild(dobCell);
    newRow.appendChild(ageCell);

    // Добавляем строку в таблицу
    tableBody.appendChild(newRow);

    // Пересчитываем и выводим средний возраст студентов
    calculateAverageAge();

    // Очищаем поля формы
    form.reset();
});

// Функция для расчета возраста на основе даты рождения
function calculateAge(dob) {
    const birthDate = new Date(dob);
    const today = new Date();
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDiff = today.getMonth() - birthDate.getMonth();

    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }

    return age;
}

// Функция для пересчета и вывода среднего возраста студентов
function calculateAverageAge() {
    const ageCells = tableBody.querySelectorAll('td:nth-child(4)');
    let totalAge = 0;

    for (let i = 0; i < ageCells.length; i++) {
        totalAge += parseInt(ageCells[i].textContent);
    }

    const averageAge = totalAge / ageCells.length;
    averageAgeCell.textContent = averageAge.toFixed(1);
}
