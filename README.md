# Calculator Project

Консольный калькулятор на Java с историей вычислений

## Возможности

- Базовые операции: +,-,*,/,%
- Поддержка дробных чисел
- История последних 10 операций
- Команды: help,exit,history,clear,last
- Архитектура: каждое поведение - отдельный класс

## Технологии

- Java 17
- Maven
- JUnit 5

## Запуск

```
git clone https://github.com/yan-endback/calculator-project.git
cd calculator-project
mvn compile
mvn exec:java -Dexec.mainClass="com.yan.calculator.Main"
```

## Тесты

```
mvn test
```