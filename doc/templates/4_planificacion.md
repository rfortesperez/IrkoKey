# FASE DE PLANIFICACIÓN DO PROXECTO

## Objetivos del proyecto

Crear una aplicación para la gestión de contraseñas de cualquier usuario. Esta aplicación debe ser intuitiva y sencilla de utilizar, a la par que segura. Ayudará al usuario a generar y guardar contraseñas seguras y lo suficientemente fuertes, para mejorar la seguridad de los sitios web que precise.


## Guía de planificación del proyecto

### Metodología


### Fases planificadas

Este proyecto se ha desarrollado en las siguientes fases:

* [Fase 1](#fase-1-investigación): Investigación.
* [Fase 2](#fase-2-planificacion): Planificacion y diseño.
* [Fase 3](#fase-3-creación-de-la-interfaz-de-usuario): Creación y desarrollo de la IU (Interfaz de Usuario).
* [Fase 4](#fase-4-desarrollo-de-la-encriptación): Desarrollo de la encriptación.
* [Fase 5](#fase-5-creación-funcionalidad-de-backup): Creación funcionalidad de backup.
* [Fase 6](#fase-6-internacionalización): Internacionalización.
* [Fase 7](#fase-7-pruebas): Pruebas.

#### Fase 1: Investigación

##### Tarea 1: Conocer a la competencia

Descripción: Estudio detallado de otras aplicaciones similares ya existentes en el mercado.

Duración: 1 semana

##### Tarea 2: Investigación de tecnologías necesarias 

Descripción: Se trata de averiguar qué tecnologías son necesarias para poder crear una aplicación de las caracteríasticas que quiero crear.

Duración: 1 semana

##### Tarea 3: Documentación sobre dichas tecnologías

Descripción: Consulta de la documentación oficial de Android Studio y de las librerías necesarias, como Room, Moshi, Hilt, ect.

Duración: 1 semana


#### Fase 2: Planificacion

##### Tarea 1: Reparto de prioridades

Descripción: Estructuración de qué partes es nesario crear en primer lugar para poder avanzar en la creación de la app.

Duración: 2 días

##### Tarea 2: Diseño: elección de colores y navegación

Descripción: Hay que pensar las pantallas que tendrá la aplicación, y cómo queremos que se vean y cómo será la navegación entre ellas, es decir, cómo podrá moverse el usuario en nuestra aplicación.

Duración: 3 días

#### Fase 3: Creación de la Interfaz de Usuario.

##### Tarea 1: Creación de la splash

Descripción: En todas las aplicaciones android, se recomienda crear una splash screen, que será la pantalla que se muestre al usuario mientras carga, para que el usuario ya perciba que está pasando algo, y no de la sensación de que el equipo se ha quedado "colgado".

Duración: 1 día

##### Tarea 2: Creación Pantallas de Registro y Login

Descripción: Puesto que la seguridad será un punto clave en esta aplicación, es necesario crear una pantalla de registro para la primera visita del usuario, y otra para que pueda autenticarse en posteriores accesos a la aplicación.

Duración: 2 días

##### Tarea 3: Pantalla principal

Descripción: creación de los distintos fragmentos para las distintas tareas que podrá llevar a cabo el usuario dentro de la aplicación: creación de nuevas contraseñas, visualización de sus contraseñas, visualización de favoritas, y pantalla para crear/recuperar copias de seguridad de los datos. Se crean los botones y sus funcionalidades al menos de manera básica.

Duración: 3 días.


##### Tarea 4: Implementación de la navegación entre pantallas.

Descripción: Se implementan los grafos de navegación de la aplicación, y se crean los mecanismos para que funcione. Algunos botones ya adquieren su funcionalidad definitiva.

Duración: 2 días.


#### Fase 4: Desarrollo de la encriptación.

##### Tarea 1: Creación de la base de datos.

Descripción: Se crea la base de datos para poder guardar toda la información del usuario y de sus contraseñas. Los botones de la pantalla de creación de contraseñas y los de la de muestra de contraseñas ya adquieren sus funcionalidades definitvas.

Duración: 1 día.

##### Tarea 2: Encriptación.

Descripción: Todos las contraseñas se cifran antes de entrar en la base de datos, y se descifran al salir de la base de datos para ser mostradas al usuario. Además, también será necesario encriptar y desencriptar el archivo json que se empleará para la copia de seguridad.

Duración: 10 días

#### Fase 5: Creación funcionalidad de backup.

##### Tarea 1: Permisos de usuario y creación del archivo json.

Descripción: Se añaden los permisos pertinentes al Manifest de la aplicación, para que el usuario autorice a la aplicación a acceder a los archivos del dispositivo, para que el usuario pueda guardar/recuperar archivos de copia de seguridad. Se elige el formato json por su versatilidad. Se crea el mecanismo de exportación tras crear el archivo y cifrarlo. Se pide el pin del usuario para poder realizar esta operación.

Duración: 4 días.


##### Tarea 2: Importación del json.

Descripción: Una vez que el usuario tiene su json cifrado, y tras comprobar que el pin es el correcto, se importa el archivo, se descifra y se guardan los datos en la base de datos.

Duración: 3 días


#### Fase 6: Internacionalización.

##### Tarea 1: Creación de archivos strings.xml.

Descripción: Se crean diferentes archivos strings.xml para poder utilizar la aplicación en distintos idiomas. En este caso concreto, en esta primera versión estará disponible en español, gallego, catalán, euskera, inglés, francés, italiano y portugués.

Duración: 2 días.

#### Fase 7: Pruebas.

##### Tarea 1: Pruebas en distintos dispositivos.

Descripción: Se realizan pruebas de funcionamiento con distintos dispositivos virtuales (Pixel 5 y Pixel 8), y en dispositivo fisico (Poco X4 Pro 5G). Se retocan temas de visualización en modo oscuro, colores y situación de algunos botones para que se vea sin problema sea el dispositivo que sea.

Duración: 3 días

##### Tarea 2: Pruebas de importación y exportación.

Descripción: Se crea un json de la aplicación y se procede a guardarlo por ejemplo en google drive. Se instala la aplicación en otro dispositivo, y se comprueba que se puede importar, siempre y cuando se introduzcan las credenciales correctas.

Duración: 4 dias.






### Diagrama de Gantt

Aquí se puede ver el Diagrama de Gantt de este proyecto:

![Diagrama de Gantt de Irko Key](/doc/img/Diagrama_Gantt.png)

## Presupuesto
O orzamento do proxecto será a suma do importe dos materiais que necesites para realizar o proxecto máis o importe que corresponde ao traballo realizado. 
O importe relacionado co traballo no proxecto é relativamente fácil de obter se se elaboraron ben as etapas anteriores: definir as actividades necesarias e os recursos propios de cada actividade. Neste caso disporase dun custo por cada actividade e a suma do custo de todas as actividades será o custo total do traballo do proxecto. 
Para establecer os custos do proxecto debes ter en conta diferentes conceptos: 
- Materiais que se utilizan: material funxible, materias primas, materiais didácticos, roupa de traballo… 
- Custo horario das persoas que participan directamente na actividade. 
- Aluguer/compra de ferramentas, maquinaria, equipos informáticos e/ou audiovisuais… 
- Aluguer/compra de locais 
- Contratos de subministracións: auga, luz, electricidade, gas… Subcontrataciones 
- Gastos de publicidade… 
- Seguros ... 

O maior custo no proxecto case sempre corresponde ás persoas, polo que é importante controlar o número de horas que se invisten en cada actividade para que non se nos desequilibre o orzamento. Tamén hai que coidar as subcontratacións; convén que traballen cun orzamento establecido.
 A continuación preséntanse dúas opción de táboa para facilitar a creación do orzamento do proxecto:

### Orzamento por actividade

| ACTIVIDADE | DURACIÓN | CUSTO (EUROS) | | CUSTO TOTAL ACTIVIDADE |
|--|--|--|--|--|
|            |          | PERSOAS|RECURSOS MATERIAIS|
|||||
|||||
|||||
|||||

| TOTAL | PROXECTO | 
| -- | -- |

### Orzamento por partidas de inversión / gasto:

| CONCEPTO | IMPORTE|
|--|--|
|**A) INVERSIONS**
|Gastos de establecemento e gastos de constitución
|Total inmobilizacións inmateriais
|Terreos
|Construcións
|Instalacións técnicas
|Maquinaria
|Ferramentas
|Mobiliario e instalacións
|Equipos informáticos
|Elementos de transporte
|Outro inmobilizado material
|Total inmobilizacións materiais
|Outros gastos a distribuír en varios exercicios
|**TOTAL INVERSIÓNS:**
|**B) GASTOS**
|Compras de materiais
|Arrendamentos
|Publicidade, propaganda e relacións públicas
|Persoal
|Reparacións e conservación
|Servizos de profesionais independentes
|Outros gastos xerais
|Gastos financeiros
|Amortizacións
|Gastos de xestión e administración
|**TOTAL GASTOS:**

|TOTAL ORZAMENTO:
|--|

### WEBGRAFÍA
Guía para a elaboración de proyectos. Gobierno Vasco.
https://www.pluralismoyconvivencia.es/upload/19/71/guia_elaboracion_proyectos_c.pdf  (páxina 49 e seguintes)



