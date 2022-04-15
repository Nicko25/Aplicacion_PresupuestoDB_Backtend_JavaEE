# Aplicacion_PresupuestoDB_Backtend_JavaEE

# AplicacionPresupuestoDatabase

This project was generated with [Apache NetBeans IDE] version 12.2, **it is only the Backend of a Fullstack Project**.

![Example](https://github.com/Nicko25/Aplicacion_PresupuestoDB_Frontend_Angular/blob/master/src/assets/example.png?raw=true "Title")


## Backend Info
The intetion of this project is to bring a secure connection beetween the **Frontend APP** with the **DataBase**. To get more details of the Frontend go to [this GitHub link](https://github.com/Nicko25/Aplicacion_PresupuestoDB_Frontend_Angular)

<p align="center">
  <img src="https://github.com/Nicko25/Aplicacion_PresupuestoDB_Frontend_Angular/blob/master/src/assets/angular-icon-mini.png" />
</p>

## Server

This project use Glassfish 5.0. Navigate to `http://localhost:8080/`. Glassfish Server Setting `http://localhost:4848/common/index.jsf`

## Build versions

- Maven Compiler v1.8
- JavaEE v8.0
- Glassfish v2.29

To see more details about dependencies check out [the POM file](https://github.com/Nicko25/Aplicacion_PresupuestoDB_Backtend_JavaEE/blob/master/pom.xml)

## Database Structure

The Database was created using MySQL.

![MySQLIcon](https://github.com/Nicko25/Aplicacion_PresupuestoDB_Frontend_Angular/blob/master/src/assets/mysql-icon-mini.png)

### Info
- Schema name: presupuesto
- Table count: 2
- Table names: **egreso, ingreso**

#### ingreso / egreso Tables

![ExampleTable](https://github.com/Nicko25/Aplicacion_PresupuestoDB_Backtend_JavaEE/blob/master/src/main/resources/META-INF/table-example.png)

**NOTE**: Both table have the same attributes with the same primary key name. Following Oriented Object rules this is not optimal, i recomend to create a parent/abstract class and then two child classes to inherit the attributes.



