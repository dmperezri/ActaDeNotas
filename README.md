# Acta de Notas - Aplicación de Consola

Este proyecto consiste en el desarrollo de una aplicación de consola en Java diseñada para la gestión académica de actas de notas, permitiendo el registro de datos generales de un curso, la entrada de calificaciones de estudiantes y la generación de reportes estadísticos detallados.

---

## 📋 Descripción del Ejercicio

El programa permite administrar la información de una asignatura bajo los parámetros del Programa de Ingeniería de Sistemas de la Facultad de Tecnología de la Información y Comunicación.

### Datos Generales del Curso

La aplicación solicita o precarga la siguiente información inicial:

* **Nombre del curso**.
* **Período lectivo**.
* **Carrera y Modalidad**.
* **Códigos**: Código de asignatura, de programa y de curso.
* **Grupo** y **Cantidad de estudiantes**.

---

## ⚙️ Funcionalidades Principales

### 1. Registro de Estudiantes y Notas

Para cada estudiante, el sistema solicita:

* **Identificación**: Número de carnet y nombres/apellidos.
* **Evaluación estándar**: Primer parcial (máximo 35.00) y Sistemáticos (máximo 30.00).
* **Lógica de Proyecto**:
  1. Si la asignatura incluye proyecto, se pide nota de Proyecto (máximo 35.00) en lugar del segundo parcial.
  2. De lo contrario, se solicita el Segundo parcial (máximo 35.00).


### 2. Lógica de Aprobación y Convocatorias

* **Nota Final**: Calculada mediante la suma de las notas ingresadas (máximo 100.00).
* **Primera Convocatoria**: Si la nota final es inferior a 60.00, se solicita un examen de primera convocatoria (máximo 70.00). La nueva nota se calcula sumando los sistemáticos y este examen.
* **Segunda Convocatoria**: Si tras la primera convocatoria la nota sigue siendo inferior a 60.00, se solicita un examen de segunda convocatoria (máximo 100.00).
* **Deserción**: El usuario puede marcar si un estudiante desertó el curso.

### 3. Reportes y Estadísticas

Al finalizar el ingreso, el sistema genera:

* **Acta de Notas**: Un listado organizado en orden alfabético por apellidos que incluye todas las notas y estados (¿Aprobado?, ¿Deserción?).
* **Estadísticas del Curso**:
* Matrícula inicial y matrícula efectiva.
* Cantidad y porcentaje de aprobados/reprobados.
* Número de deserciones.
* Nota mínima, máxima y promedio del curso.


---

## 🛠️ Requisitos Técnicos

La implementación hace uso de los siguientes componentes de programación:

* **Tipos de datos**: Uso de primitivos y manejo de hasta dos dígitos decimales para precisión numérica.
**Estructuras de Control**: Lógica condicional y bucles para el procesamiento de datos y repetición de la aplicación.
**Arreglos**: Para el almacenamiento de la lista de estudiantes y sus notas.
**Algoritmos**: Implementación de búsqueda y ordenamiento (alfabético por apellido).
**Modularidad**: Uso de métodos definidos por el programador y manejo de excepciones.


---

**Docente**: M.Sc. Danilo H. Noguera Rivera **Año**: 2
