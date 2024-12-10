# Proyecto fin de ciclo



## Descripción



Hoy en día, la gestión de contraseñas de manera adecuada es algo imprescindible. Cada día que pasa hay nuevas amenazas de ciberseguridad, y una de las debilidades más grandes que tenemos son las contraseñas débiles, por miedo a no recordarlas cuando son necesarias, o el emplear siempre y para todo la misma contraseña por miedo a olvidarla.

IrkoKey es una aplicación Android que permitirá a los usuarios guardar y gestionar sus contraseñas de manera segura.Contará con un mecanismo de backup y todo esto acompañado de una interfaz de usuario lo más sencilla, intuitiva y fácil de aprender posible para el usuario.

## Instalación / Puesta en marcha

 Se puede probar esta aplicación de tres maneras distintas, todas igual de sencillas. La primera sería directamente en un <u>emulador en Android Studio</u>. Podremos elegir entre distintos modelos de dispositivos, con diferentes API, tamaños de pantalla, RAM, etc. Una vez seleccionado solamente tendremos que pulsar el botón de reproducción (el triángulo verde), o pulsar Shift + F10.
 
 Otra manera simple de probar la app es <u>a través de un dispositivo físico</u>. Para ello tendremos que activar las opciones de desarrollador de nuestro dispositivo. Para activarlas, iremos al apartado de *Ajustes* -> *Sobre el teléfono* -> y sobre el *número de compilación*, pulsaremos rápidamente unas 5-7 veces, hasta que aparezca un mensaje informándonos de que se han activado las opciones de desarrollador.

 Hecho esto, tendremos que ir a *Ajustes* -> *Ajustes adicionales* -> *Opciones de desarrollador*, y activaremos la opción <u>Depuración USB</u>. Ahora, conectando nuestro dispositivo mediante un cable usb al ordenador, podremos instalar y probar la app en nuestro móvil.

 A partir de la versión 3.0 de Android Studio, y de Android 10, ya se puede utilizar la conexión inalámbrica para poder depurar la app en nuestro dispositivo android sin necesidad de utilizar un cable USB, aunque hay que tener en cuenta que si tenemos Android 10 (API level 29) o inferior, primero debemos sincronizarlos por USB y posteriormente podremos conectarnos de manera inalámbrica.

 Por último, también podemos <u>descargar la apk</u> que se encuetra en la raíz de este proyecto con ese mismo nombre (Irko_Key.apk), e instalarla como cualquier aplicación en nuestro dispositivo móvil.

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
3. [Diseño](#3-diseño)
4. [Implantación](#4-implantación)
5. [Manual de Usuario](#5-manual-de-usuario)
6. [Video Demostración](#6-video-demostración)
7. [Guía de Contribución](#7-guía-de-contribución)
8. [Referencias y Otros Enlaces](#8-referencias-y-otros-enlaces)


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

* ##### Tarea 2: Diseño Gráfico: elección de colores y navegación

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

| ACTIVIDAD | DURACIÓN (horas) | COSTE (EUROS) | COSTE TOTAL ACTIVIDAD |
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


Hay creado un Kdoc (documento similar al Javadoc) en el que puedes consultar todas las clases y métodos de este proyecto, haciendo click **[aquí](/app/build/dokka/index.html)**

##### Diagrama de Clases.

![Diagrama UML Irko Key](/doc/img/Diagrama_de_Clases.png)

##### Casos de uso.

![Diagrama de Casos de Uso Irko Key](/doc/img/Diagrama_Casos_de_Uso.png)

##### Diagrama de Flujo. 
![Diagrama de Flujo Irko Key](/doc/img/Diagrama_Flujo.png)

#### Diseño de interfaces de usuario.

<table>
<tr>
  <td><img src = "/doc/img/mockups/01_splash.png" alt = "pantalla splash"/></td>
  <td><img src = "/doc/img/mockups/registro.png" alt = "pantalla registro"/></td>  
</tr>
<tr>
  <td><img src = "/doc/img/mockups/login.png" alt = "pantalla login"/></td>
  <td><img src = "/doc/img/mockups/crear.png" alt = "pantalla crear"/></td>
</tr>
</table>

![Mockup Listado](/doc/img/mockups/listado.png)

<table>
<tr>
  <td><img src = "/doc/img/mockups/editar.png" alt = "dialogo editar"/></td>
  <td><img src = "/doc/img/mockups/backup2.png" alt = "pantalla backup"/></td>  
</tr>
</table>


##### Diagrama de Base de Datos.
![Diagrama ER](/doc/img/ERD_IrkoKey.png)

##### Diagrama de componentes y de secuencia.

![Diagrama de componentes](/doc/img/Diagrama_Componentes.png)

![Diagrama de secuencia](/doc/img/Diagrama_Secuencia.png) 


Y con este diagrama de secuencia, terminaríamos la parte de diseño y de los distintos diagramas.

## 4. Implantación

### Manual técnico:

#### Información relativa a la instalación: 

* **Requerimientos de hardware**: 
  * *Dispositivo móvil*: Cualquier móvil Android con versión 10 o superior.
  * *Almacenamiento*: se requiere un mínimo de 30 Mb de almacenamiento interno para la instalación de la aplicación y el almacenamiento de la base de datos local.
  
* **Software necesario**:
  * *Sistema Operativo*: Android 10 o superior.
* **Configuración inicial seguridad**: 
  * *Cifrado de datos*:  Todos los datos sensibles (contraseñas, etc.) se almacenan en la base de datos local cifrados utilizando el algoritmo AES/GCM/NoPadding 256.  
  * *Copia de seguridad*:Las copias de seguridad se generan en formato JSON cifrado. La restauración de una copia de seguridad requiere la contraseña maestra del usuario.
  * *Permisos*: la aplicación solicita los siguientes permisos:
    * Acceso a keystore: Permite a la aplicación acceder al almacén de claves de Android.
    * Acceso a ficheros: para poder leer y escribir datos en el almacenamiento externo del dispositivo.
* **Carga inicial de datos en la base de datos**: la base de datos no posee datos por defecto, pero se pueden cargar datos desde un archivo json previamente creado por la aplicación (por ejemplo en otro dispositivo), siempre que sea el mismo usuario.
* **Usuarios del sistema**: No aplica, ya que la aplicación es una aplicación móvil y no requiere usuarios del sistema.
* **Usuarios de la aplicación**: Cualquier usuario con un dispositivo Android compatible puede instalar y utilizar la aplicación.


### Información relativa a la administración del sistema:


Dado que Irko Key es una aplicación móvil diseñada para funcionar de forma autónoma en el dispositivo del usuario, la administración del sistema se centra principalmente en las acciones que el propio usuario debe realizar para garantizar la seguridad e integridad de sus datos.

* **Copias de seguridad**:
  * *Realizar copias de seguridad periódicas*: Es fundamental que el usuario cree copias de seguridad de sus datos de forma regular. La aplicación permite exportar los datos a un archivo JSON cifrado, el cual puede ser almacenado en un lugar seguro (por ejemplo, en un servicio de almacenamiento en la nube o en un dispositivo externo).
  * *Mantener la contraseña maestra a salvo*: La contraseña utilizada para cifrar los datos (el pin del usuario) no debe ser compartida con nadie.
  
* **Gestión de usuarios**: la aplicación está diseñada para ser utilizada por un único usuario (el propietario/a del dispositivo).
* **Gestión de seguridad**: cada vez que se accede a la aplicación es necesario que el usuario introduzca sus credenciales.
* **Gestión de incidencias**: será imprescindible que el usuario contacte conmigo en el siguiente email: rfortesperez@gmail.com, a ser posible con capturas de pantalla del incidente, para de esta manera tratar de solventarlo lo antes posible.

### Información relativa al matenimiento del sistema: 

* **Corrección de errores**: Si se reciben incidentes, se crearán actualizaciones para solventarlas.
* **Añadir nuevas funcionalidades**: en versiones posteriores se planteará la implantación de autenticación mediante biometría.
* **Adaptación por actualizaciones de software y/o hardware**: Se realizará constantemente un monitoreo de cambios para mantener la aplicación al día respecto a actualizaciones de Android, Kotlin, Room, y otras bibliotecas utilizadas en esta y en posteriores versiones de la aplicación.

## Protección de datos de carácter persoal.

Irko Key, como gestor de contraseñas, almacena información altamente sensible del usuario. Por ello, la protección de datos personales es una prioridad fundamental en el desarrollo y funcionamiento de la aplicación.

Irko Key se adhiere a los siguientes principios de protección de datos:

 * **Limitación de la finalidad**: Los datos recogidos se utilizan exclusivamente para el propósito de gestionar las contraseñas del usuario y no se comparten con terceros.
* **Minimización de datos**: Solo se recolectan los datos estrictamente necesarios para el funcionamiento de la aplicación.
* **Integridad y confidencialidad**: Los datos se protegen contra el procesamiento no autorizado o ilícito, mediante el cifrado con clave derivada del pin del usuario.

##### Medidas de Seguridad Implementadas

* **Cifrado**: Todos los datos se almacenan en el dispositivo de forma cifrada utilizando algoritmos de cifrado robustos.
* **Acceso local**: Irko Key no se conecta a internet, lo que minimiza el riesgo de ataques externos.
* **Contraseñas fuertes**: Se exige al usuario establecer contraseñas seguras para proteger el acceso a los diferentes websites.
* **Copia de seguridad cifrada**: Las copias de seguridad se generan en formato JSON cifrado, lo que garantiza la confidencialidad de los datos incluso fuera del dispositivo.
* **Actualizaciones de seguridad**: Se implementarán regularmente actualizaciones de seguridad para proteger la aplicación contra nuevas vulnerabilidades que se puedan detectar.

##### Derechos del Usuario

* **Acceso, rectificación y supresión de los datos del usuario**: dado que el almacenamiento de los datos se realiza al 100% en local, el usuario puede acceder, rectificar y eliminar sus datos cuando así lo desee sin tener que hacer solicitudes previas.

* **Limitación del tratamiento**: El usuario puede solicitar la limitación del tratamiento de sus datos en determinadas circunstancias, como por ejemplo no dando permiso a la aplicación para acceder al almacenamiento del dispositivo.
* **Portabilidad de los datos**: El usuario podrá realizar la portabilidad de sus datos mediante el archivo json creado en el proceso de exportación.

##### Información Adicional

* **Base legal del tratamiento**: El tratamiento de los datos personales se basa en el tratamiento explícito realizado por el usuario.
* **Conservación de datos**: Los datos se conservarán mientras el usuario mantenga una copia de seguridad de la aplicación.
* **Comunicación de incidencias de seguridad**: En caso de producirse una brecha de seguridad, se informará a los usuarios de forma inmediata.

Irko Key está diseñada para proteger la privacidad y seguridad de los datos de sus usuarios. Sin embargo, es importante recordar que la seguridad de los datos también depende de las acciones del usuario, como el uso de contraseñas seguras y la realización de copias de seguridad periódicas.


## 5. Manual de usuario

#### Puedes consultar el manual de usario haciendo click [aquí.](/doc/manual_usuario.md)


## 6. Video Demostración

Para que puedas aprender de manera mucho más sencilla cómo utilizar esta aplicación, haciendo click **[aquí](https://drive.google.com/file/d/1MhRhyukdJlCANCUdyVTxTx1akteVeMvU/view?usp=drive_link)** podrás ver un video demostración y así sacar el máximo partido a Irko Key.


## 7. Guía de contribución

¡Gracias por tu interés en contribuir a Irko Key! Tu aporte, por pequeño que sea, puede marcar una gran diferencia en el crecimiento y mejora continua de este proyecto de código abierto.
¿Cómo puedes contribuir?

* **Desarrollo de nuevas funcionalidades**: Implementa nuevas características solicitadas por los usuarios (por ejemplo, soporte para nuevos tipos de cuentas, integración con otros servicios, implementación de biometría, etc). Explora nuevas ideas para mejorar la experiencia del usuario.
* **Corrección de errores y optimización del código**: Identifica y corrige errores en el código existente. Mejora la eficiencia del código para un mejor rendimiento. Refactoriza el código para hacerlo más legible y mantenible.
* **Desarrollo de pruebas automatizadas**: Escribe pruebas unitarias y de integración para garantizar la calidad del código y prevenir futuros errores.
* **Desarrollo de plugins**: Crea plugins para ampliar las funcionalidades de Irko Key.
* **Documentación**: Mejora la documentación existente (código, manual de usuario, etc.).
* **Crea nuevos tutoriales y guías**.
* **Diseño de interfaz de usuario**: Mejora la apariencia y usabilidad de la interfaz de usuario.
* **Traducción**: Traduce la aplicación a nuevos idiomas.
  

##### Primeros pasos para contribuir

* Familiarízate con el proyecto: Lee el código fuente y la documentación existente.
* Explora los posibles issues y las pull requests en el repositorio.
* Participa en las discusiones en la comunidad.
* Elige una tarea: Busca una tarea que te interese y que se ajuste a tus habilidades.
* No dudes en preguntar si tienes alguna duda.
* Crea una rama: Crea una nueva rama en el repositorio para trabajar en tu cambio.
* Realiza los cambios: Realiza los cambios necesarios en el código. Asegúrate de que tus cambios cumplan con las guías de estilo del proyecto.
* Realiza las pruebas: Realiza pruebas exhaustivas para asegurarte de que tus cambios no introducen nuevos errores.
* Crea una pull request: Crea una pull request para que tus cambios sean revisados y fusionados con el código principal.

##### Cómo empezar a contribuir a Irko Key

*  Clona el repositorio:
  ```Bash

    git clone https://gitlab.iessanclemente.net/damd/a21rociofp.git
```


* Crea una nueva rama:
```Bash

git checkout -b mi-nueva-funcionalidad
```

* Realiza tus cambios y commitea tus cambios:

```Bash

git add .
git commit -m "Mi nuevo cambio"
```

* Realiza un push a tu rama:
```Bash

git push origin mi-nueva-funcionalidad

```

* Envía una merge request: Sigue las instrucciones en GitLab para crear una [merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html).



¡Gracias por tu contribución!

## 8. Referencias y otros enlaces


* [Creación logo](https://logo.com/)
* [Material Design](https://m3.material.io/)
* [Recycler View Android Developers](https://developer.android.com/develop/ui/views/layout/recyclerview?hl=es-419)
* [Recycler View AristiDevs](https://www.youtube.com/watch?v=k3zoVAMuW5w&list=PL8ie04dqq7_OmayyHRawwWkX3ZkrYlsTa)
* [Recycler View DevExpert](https://www.youtube.com/watch?v=IaYDkgwzil8&pp=ygUbcmVjeWNsZXJ2aWV3IGFuZHJvaWQgc3R1ZGlv)
* [TabLayout Android Developers](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout)
* [TabLayout Geeks For Geeks](https://www.geeksforgeeks.org/android-material-tabs-in-kotlin/)
* [TabLayout Philipp Lackner](https://www.youtube.com/watch?v=h41FnEH91D0&pp=ygUYdGFibGF5b3V0IGFuZHJvaWQgc3R1ZGlv)
* [Bottom Navigation View Android Developers](https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView)
* [Bottom Navigation View Medium.com](https://medium.com/@mohammadvahidsoudagar264/complete-bottom-navigation-view-in-android-studio-using-navigation-components-02a32fce1359)
* [Bottom Navigation View FoxAndroid](https://www.youtube.com/watch?v=YlIHxIAoHzU&pp=ygUgbmF2ZWdhY2lvbiBhbmRyb2lkIHN0dWRpbyBrb3RsaW4%3D)
* [Documentación Room](https://developer.android.com/training/data-storage/room?hl=es-419#kts)
* [Criptografía](https://developer.android.com/privacy-and-security/cryptography?hl=es-419)
* [Cypher Android Developers](https://developer.android.com/reference/kotlin/javax/crypto/Cipher)
* [Secretos criptográficos codificados Android Developers](https://developer.android.com/privacy-and-security/risks/hardcoded-cryptographic-secrets?hl=es-419)
* [Uso Javax Crypto Segu-Info](https://blog.segu-info.com.ar/2020/05/android-buenas-practicas-de-desarrollo.html)
* [Derivación de clave Wikipedia](https://es.wikipedia.org/wiki/Funci%C3%B3n_de_derivaci%C3%B3n_de_clave)
* [Derivación de clave vpnunlimited.com](https://www.vpnunlimited.com/es/help/cybersecurity/key-derivation-function?srsltid=AfmBOooLEn6Xx5eqBPSOVw7LTXcWwGMMe7zDXBpg0xIrHIkynlY72Ky_)
* [Uso Moshi para Json](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiNgPex7fWJAxXuR_EDHdxEG3cQFnoECBcQAQ&url=https%3A%2F%2Fwww.alten.es%2Fmoshi-modernizando-el-analisis-json-en-android%2F&usg=AOvVaw07iS49qohMMJgWZxISleC4&opi=89978449)
* [Moshi para Json Medium.com](https://medium.com/@prashantjadhav/choosing-the-right-json-library-for-your-android-app-moshi-vs-gson-351d2939e6a5)
* [Permisos Android Developers](https://developer.android.com/guide/topics/permissions/overview?hl=es-419)
* [Internacionalización Android Developers](https://developer.android.com/training/basics/supporting-devices/languages?hl=es-419)
* [Internacionalización DevExpert](https://www.youtube.com/watch?v=_ADu65MR1bU)