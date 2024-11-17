# Proyecto fin de ciclo



## Descripción



Hoy en día, la gestión de contraseñas de manera adecuada es algo imprescindible. Cada día que pasa hay nuevas amenazas de ciberseguridad, y una de las debilidades más grandes que tenemos son las contraseñas débiles, por miedo a no recordarlas cuando son necesarias, o el emplear siempre y para todo la misma contraseña por miedo a olvidarla.

IrkoKey es una aplicación Android que permitirá a los usuarios guardar y gestionar sus contraseñas de manera segura.Contará con un mecanismo de backup y todo esto acompañado de una interfaz de usuario lo más sencilla, intuitiva y fácil de aprender posible para el usuario.

## Instalación / Puesta en marcha

 Se puede probar esta aplicación de tres maneras distintas, todas igual de sencillas. La primera sería directamente en un <u>emulador en Android Studio</u>. Podremos elegir entre distintos modelos de dispositivos, con diferentes API, tamaños de pantalla, RAM, etc. Una vez seleccionado solamente tendremos que pulsar el botón de reproducción (el triángulo verde), o pulsar Shift + F10.
 
 Otra manera simple de probar la app es <u>a través de un dispositivo físico</u>. Para ello tendremos que activar las opciones de desarrollador de nuestro dispositivo. Para activarlas, iremos al apartado de *Ajustes* -> *Sobre el teléfono* -> y sobre el *número de compilación*, pulsaremos rápidamente unas 5-7 veces, hasta que aparezca un mensaje informándonos de que se han activado las opciones de desarrollador.

 Hecho esto, tendremos que ir a *Ajustes* -> *Ajustes adicionales* -> *Opciones de desarrollador*, y activaremos la opción <u>Depuración USB</u>. Ahora, conectando nuestro dispositivo mediante un cable usb al ordenador, podremos instalar y probar la app en nuestro móvil.

 A partir de la versión 3.0 de Android Studio, y de Android 10, ya se puede utilizar la conexión inalámbrica para poder depurar la app en nuestro dispositivo android sin necesidad de utilizar un cable USB, aunque hay que tener en cuenta que si tenemos Android 10 (API level 29) o inferior, primero debemos sincronizarlos por USB y posteriormente podremos conectarnos de manera inalámbrica.

 Por último, también podemos <u>descargar la apk</u> que se encuetra en la carpeta con ese mismo nombre, e instalarla como cualquier aplicación en nuestro dispositivo móvil.

## Uso

Irko Key es una bóveda digital personal. Protege tus datos más sensibles con este gestor de contraseñas. Cifrado AES que garantiza la seguridad de tus credenciales. Generador de contraseñas aleatorias que crea contraseñas únicas y robustas. Copias de seguridad que te permiten recuperar tus datos en cualquier momento. ¡Organiza, protege y simplifica tu vida digital con Irko Key!

## Sobre el autor

Soy una apasionada del desarrollo móvil y la ciberseguridad. Para finalizar mis estudios, buscaba un proyecto que me permitiera poner en práctica los conocimientos adquiridos y, al mismo tiempo, contribuir a la seguridad de los usuarios. Irko Key se alinea perfectamente con mis objetivos, ya que me brinda la oportunidad de desarrollar una aplicación útil y segura. Mi experiencia en Kotlin y Android Studio, junto con mi interés por la criptografía, me han sido de gran ayuda en la realización de este proyecto.

Se puede contactar conmigo por las siguientes vías:

[Linkedin](https://www.linkedin.com/in/rocío-fortes-pérez)
[Email](mailto:rfortesperez@gmail.com)


## Licencia

Este software cuenta con una **licencia GPLv3** (GNU General Public License versión 3). Esto implica que cualquiera puede utilizar, modificar y distribuir este software, pero con ciertas implicaciones, que se detallan a continuación:

* **Copyleft**: cualquier modificación o combinación de este código fuente deberá también ser licenciado bajo GPLv3. Así se impedirá la creación de versiones propietarias basadas en este software.
* **Libertad de uso, estudio, modificación y distribución**: permite a cualquiera usar, copiar, distribuir, estudiar, modificar y mejorar el software.
* **Requisitos de licencia**: exige que cualquier trabajo derivado sea licenciado bajo los mismos términos.
* **Protección contra patentes**: se incluyen claúsulas para proteger contra la aplicación de patentes.

Puede verse el texto completo haciendo click [aquí](/LICENSE)

## Índice


1. Anteproyecto
     * 1.1. [Idea](#11-idea)
     * 1.2. [Objetivos](#12-objetivos)
     * 1.3. [Requisitos Funcionales](#13-requisitos-funcionales)
     * 1.4. [Requisitos No Funcionaes](#14-requisitos-no-funcionales)
     * 1.5. [Tecnologías](#15-tecnologías)
2. [Planificación](#2-planificación)
3. [Diseño](doc/templates/5_deseño.md)
4. [Implantación](doc/templates/6_implantacion.md)


## 1. Anteproyecto

Hoy en día, la gestión de contraseñas de manera adecuada es algo imprescindible. Cada día que pasa hay nuevas amenazas de ciberseguridad, y una de las mayores debilidades que tenemos son las contraseñas débiles o, emplear siempre y para todo la misma contraseña por miedo a olvidarla.

La idea es desarrollar una aplicación Android que permita a los usuarios guardar y gestionar sus contraseñas de manera segura. Todo esto con una interfaz que sea lo más simple e intuitiva posible para el usuario.

La aplicación incluirá funcionalidades básicas de gestión de contraseñas, tales como el almacenamiento seguro en local, mediante el cifrado de las contraseñas. En próximas versiones de la aplicación se podrían añadir funciones más avanzadas.

Esta primera versión también incluirá un mecanismo de exportación e importación de los datos. Previa a la exportación se pedirá al usuario que introduzca una contraseña, se cifrará el archivo, de manera que nadie salvo el usuario pueda acceder a la información del mismo, y después se guardarán en el dispositivo del usuario.

Llegados a ese punto, el usuario podrá enviarlo o guardarlo donde considere preciso (en un pendrive, enviarlo por correo electrónico, Whatsapp, guardarlo en Drive...), y posteriormente descargarlo en un nuevo dispositivo y recuperar las contraseñas. Para eso deberá introducir la contraseña empleada en el momento de la exportación, y que tan sólo el usuario conoce. A mayores esta funcionalidad permitirá que el usuario pueda tener copias de seguridad.

## 1.1 Idea

* El proyecto consiste en crear una aplicación instalable, es decir, un apk que será apto para cualquier dispositivo con un Android Nougat 7.0 ó superior. 
* El poryecto tal y como se ha indicado, será un gestor de contraseñas, y su propósito principal es dar al usuario la oportunidad de tener una contraseña distinta para cada aplicación o website que necesite, así como el hecho de poder tener una copia de seguridad de las mismas, y exportarlas/importarlas de forma segura a otros dispositivos.
* Esta aplicación está destinada a cualquier persona, ya que hoy en día todo el mundo tiene más de una aplicación o web en la que es necesario un usuario y contraseña para poder acceder, y de esta manera el usuario no necesita tener la misma para todo, ni el problema de poder llegar a olvidarla.
* Se pretende de esta manera que el usuario pueda emplear símbolos, mayúsculas, minúsculas, números, etc. sin necesidad de que signifique nada. De todos es sabidos que los ciberdelincuentes pueden saber nuestras fechas importantes, nombres de mascotas, familiares, equipos deportivos favoritos,... y es algo que mucha gente utiliza, cambiando apenas una o dos letras para crear sus contraseñas. Si contamos con una aplicación que la "recuerda por nosotros" tenemos la posibilidad de emplear contraseñas más largas y más complejas sin miedo a olvidarlas o perderlas. Sería posible subirla a tienda Play de Google, pero dado que hay muchas más en el mercado, al menos la versión inicial sería gratuita, y en un futuro se podría plantear el generar funcionalidades nuevas de pago.
* Actualmente hay aplicaciones con esta misma idea, tales como son LastPass, Proton Pass, Bitwarden, Keeper... que son aplicaciones muy eficientes y muy completas y que cubren las necesidades de los usuarios con respecto a la gestión de las contraseñas.
  
## 1.2 Objetivos
* Desarrollar una aplicación Android que permita ver, crear, guardar, actualizar, borrar y copiar contraseñas, así como guardar el nombre de usuario de cada sitio web.
* Implementar un almacenamiento seguro en local empleando cifrado.
* Emplear Room para la persistencia de datos.
* Diseñar una interfaz de usuario moderna, sencilla y fácil de usar.
* Incluír un mecanismo de exportación e importación de los datos guardados en la aplicación, para su posterior recuperación en el mismo o en otro dispositivo.
  
## 1.3 Requisitos Funcionales
* Gestión de contraseñas: Los usuarios podrán ver, crear, guardar, actualizar, borrar y copiar al portapapeles las contraseñas, así como los nombres de usuario empleados.
* Cifrado: Las contraseñas se van a almacenar cifradas en la base de datos local.
* Interfaz de usuario: Una interfaz moderna, y que sea muy amigable e intuitiva para el usuario.
* Persistencia de datos: Room será la encargada de la gestión de la base de datos local.
* Cifrado de datos: de la base de datos previa a su exportación.
  
## 1.4 Requisitos no funcionales
* Seguridad: se aportará mediante la implementación de técnicas seguras de autenticación para un acceso seguro.
* Usabilidad: la interfaz de usuario será intuitiva, simple y fácil de emplear.
* Rendimiento: la aplicación deberá ser rápida y eficiente manejando los datos, ya que los móviles no tienen tanta capacidad como un ordenador, y además para no malgastar batería.
  

## 1.5 Tecnologías
* Desarrollo de la app: Android Studio.
* Base de datos local: Room
* Lenguaje de programación: Kotlin
* Cifrado: Biblioteca de cifrado AES.

## 2. Planificación


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

* ##### Tarea 1: Conocer a la competencia

Descripción: Estudio detallado de otras aplicaciones similares ya existentes en el mercado.

Duración: 1 semana

* ##### Tarea 2: Investigación de tecnologías necesarias 

Descripción: Se trata de averiguar qué tecnologías son necesarias para poder crear una aplicación de las caracteríasticas que quiero crear.

Duración: 1 semana

* ##### Tarea 3: Documentación sobre dichas tecnologías

Descripción: Consulta de la documentación oficial de Android Studio y de las librerías necesarias, como Room, Moshi, Hilt, ect.

Duración: 1 semana


#### Fase 2: Planificacion

* ##### Tarea 1: Reparto de prioridades

Descripción: Estructuración de qué partes es nesario crear en primer lugar para poder avanzar en la creación de la app.

Duración: 2 días

* ##### Tarea 2: Diseño: elección de colores y navegación

Descripción: Hay que pensar las pantallas que tendrá la aplicación, y cómo queremos que se vean y cómo será la navegación entre ellas, es decir, cómo podrá moverse el usuario en nuestra aplicación.

Duración: 3 días

#### Fase 3: Creación de la Interfaz de Usuario.

* ##### Tarea 1: Creación de la splash

Descripción: En todas las aplicaciones android, se recomienda crear una splash screen, que será la pantalla que se muestre al usuario mientras carga, para que el usuario ya perciba que está pasando algo, y no de la sensación de que el equipo se ha quedado "colgado".

Duración: 1 día

* ##### Tarea 2: Creación Pantallas de Registro y Login

Descripción: Puesto que la seguridad será un punto clave en esta aplicación, es necesario crear una pantalla de registro para la primera visita del usuario, y otra para que pueda autenticarse en posteriores accesos a la aplicación.

Duración: 2 días

* ##### Tarea 3: Pantalla principal

Descripción: creación de los distintos fragmentos para las distintas tareas que podrá llevar a cabo el usuario dentro de la aplicación: creación de nuevas contraseñas, visualización de sus contraseñas, visualización de favoritas, y pantalla para crear/recuperar copias de seguridad de los datos. Se crean los botones y sus funcionalidades al menos de manera básica.

Duración: 3 días.


* ##### Tarea 4: Implementación de la navegación entre pantallas.

Descripción: Se implementan los grafos de navegación de la aplicación, y se crean los mecanismos para que funcione. Algunos botones ya adquieren su funcionalidad definitiva.

Duración: 2 días.


#### Fase 4: Desarrollo de la encriptación.

* ##### Tarea 1: Creación de la base de datos.

Descripción: Se crea la base de datos para poder guardar toda la información del usuario y de sus contraseñas. Los botones de la pantalla de creación de contraseñas y los de la de muestra de contraseñas ya adquieren sus funcionalidades definitvas.

Duración: 1 día.

* ##### Tarea 2: Encriptación.

Descripción: Todos las contraseñas se cifran antes de entrar en la base de datos, y se descifran al salir de la base de datos para ser mostradas al usuario. Además, también será necesario encriptar y desencriptar el archivo json que se empleará para la copia de seguridad.

Duración: 10 días

#### Fase 5: Creación funcionalidad de backup.

* ##### Tarea 1: Permisos de usuario y creación del archivo json.

Descripción: Se añaden los permisos pertinentes al Manifest de la aplicación, para que el usuario autorice a la aplicación a acceder a los archivos del dispositivo, para que el usuario pueda guardar/recuperar archivos de copia de seguridad. Se elige el formato json por su versatilidad. Se crea el mecanismo de exportación tras crear el archivo y cifrarlo. Se pide el pin del usuario para poder realizar esta operación.

Duración: 4 días.


* ##### Tarea 2: Importación del json.

Descripción: Una vez que el usuario tiene su json cifrado, y tras comprobar que el pin es el correcto, se importa el archivo, se descifra y se guardan los datos en la base de datos.

Duración: 3 días


#### Fase 6: Internacionalización.

* ##### Tarea 1: Creación de archivos strings.xml.

Descripción: Se crean diferentes archivos strings.xml para poder utilizar la aplicación en distintos idiomas. En este caso concreto, en esta primera versión estará disponible en español, gallego, catalán, euskera, inglés, francés, italiano y portugués.

Duración: 2 días.

#### Fase 7: Pruebas.

* ##### Tarea 1: Pruebas en distintos dispositivos.

Descripción: Se realizan pruebas de funcionamiento con distintos dispositivos virtuales (Pixel 5 y Pixel 8), y en dispositivo fisico (Poco X4 Pro 5G). Se retocan temas de visualización en modo oscuro, colores y situación de algunos botones para que se vea sin problema sea el dispositivo que sea.

Duración: 3 días

* ##### Tarea 2: Pruebas de importación y exportación.

Descripción: Se crea un json de la aplicación y se procede a guardarlo por ejemplo en google drive. Se instala la aplicación en otro dispositivo, y se comprueba que se puede importar, siempre y cuando se introduzcan las credenciales correctas.

Duración: 4 dias.


### Diagrama de Gantt

Aquí se puede ver el Diagrama de Gantt de este proyecto:

![Diagrama de Gantt de Irko Key](/doc/img/Diagrama_Gantt.png)

## Presupuesto

Este presupuesto incluye el trabajo realizado por mi, ya que no se ha comprado/alquilado ningún tipo de inmueble, ni equipos informáticos, ni se han contratado seguros o personal, ni comprado ningún tipo de licencia de Software. El proyecto se ha realizado empleando Android Studio que es gratuito, y las librerías empleadas tampoco tienen ningún tipo de coste por licencia.

La fase de investigación ha sido la más demandante en términos de tiempo dedicado. Al ser una desarrolladora junior, he considerado fundamental profundizar en los aspectos teóricos y prácticos del proyecto. Esta decisión me ha permitido adquirir un conocimiento más sólido de las tecnologías involucradas, lo que a su vez me ha facilitado la elección de las librerías y la arquitectura más apropiadas para Irko Key. Como resultado, he podido construir una base fuerte para el desarrollo de la aplicación, evitando errores comunes y adoptando las mejores prácticas recomendadas.

### Presupuesto por actividad

| ACTIVIDADE | DURACIÓN (horas) | CUSTO (EUROS) | CUSTO TOTAL ACTIVIDADE |
|--|:--:|:--:|:--:|
| Investigación| 90 h | 35 €/h | 3150 € |
| Planificación y diseño| 40 h| 35 €/h|1400 €|
|Desarrollo IU| 34 h| 35 €/h| 1190 €|
|Encriptación y otras funcionalidades|44 h|35 €/h| 1540 €|
|Import/Export Backup|28 h| 35 €/h| 980 €|
|Internacionalización|16 h| 35 €/h| 560 €|
|Pruebas|28 h| 35 €/h| 980 €|

| TOTAL HORAS| TOTAL PROYECTO | 
| :--: | :--: |
|**280 h**| **9800 €**|


## 3. Diseño


## Guía de contribución

> *TODO*: Tratándose de un proyecto de software libre, es muy importante que expongas cómo se puede contribuir con tu proyecto. Algunos ejemplos de esto son realizar nuevas funcionalidades, corrección y/u optimización del código, realización de tests automatizados, nuevas interfaces de integración, desarrollo de plugins, etc. etc. Sé lo más conciso que puedas.

## Links

> *TODO*: Enlaces externos y descipciones de estos enlaces que creas conveniente indicar aquí. Generalmente ya van a estar integrados con tu documentación, pero si requieres realizar un listado de ellos, este es el lugar.