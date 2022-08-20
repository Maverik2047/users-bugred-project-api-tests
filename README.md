# Проект по автоматизации тестирования API
<a target="_blank" href="http://users.bugred.ru/">Веб сайт users.bugred.ru</a>

## ⤵️ Содержание:

> ➠[Реализованные проверки](#boom-Реализованные-проверки)
>
> ➠[Технологии](#classical_building-Технологии)
> 
> ➠[Сборка в Jenkins](#man_cook-Jenkins-job)
> 
> ➠[Allure отчет](#bar_chart-Allure-отчет)

## ⚜️ Реализованные проверки с исползованием моделей lombok и спецификаций

- ✓ Регистрация нового пользователя 
- ✓ Авторизация с существующим емейлом и паролем 
- ✓ Авторизация с несуществующим емейлом и паролем
- ✓ Проверка добавления аватарки пользователя
- ✓ Проверка удаления аватарки пользователя
- ✓ Проверка данных существующего пользователя

## 🤖 Технологии
<p align="center">
<img width="6%" title="Idea" src="images/logo/GitHub.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Java" src="images/logo/Gradle.svg">
<img width="6%" title="Java" src="images/logo/Idea.svg">
<img width="6%" title="Java" src="images/logo/Junit5.svg">
<img width="6%" title="Java" src="images/logo/logo.png">
<img width="6%" title="Java" src="images/logo/Jenkins.svg">
<img width="6%" title="Java" src="images/logo/Allure.svg">


</p>

## 🎆 Jenkins job
<img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a>  <a target="_blank" href="https://jenkins.autotests.cloud/job/users.bugred_Project_API/">Jenkins job</a>
<p align="center">
<img title="Jenkins Overview Dashboard" src="images/screens/job.PNG">
</p>


###  Локальный запуск:
```
gradle clean test
```

## 📎 Allure-отчет
<img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/users.bugred_Project_API/allure/#">Allure report</a>
<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/allure_report.PNG">
<img title="Allure Overview Dashboard" src="images/screens/allure2.PNG">
</p>
