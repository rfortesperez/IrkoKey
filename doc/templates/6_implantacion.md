
# FASE DE IMPLANTACIÓN

## Manual técnico:

### Información relativa a la instalación: 

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



## Manual de usuario

* **Formación usuario**: Irko Key es una aplicación muy simple e intuitiva que no necesitará formación previa de los usuarios para utilizarla.
##### Manual de Usuario de Irko Key
 
Irko Key es un gestor de contraseñas diseñado para ayudarte a almacenar de forma segura todas tus credenciales en un solo lugar. Gracias a su interfaz intuitiva y a las robustas medidas de seguridad implementadas, podrás acceder a tus contraseñas de forma rápida y sencilla, sin comprometer tu privacidad.

##### Instalación y Configuración Inicial

* **Descarga e instalación**: Descarga la aplicación Irko Key descargando el archivo Irko_Key.apk de este repositorio, y procede a instalarla como cualquier otra aplicación móvil. Es posible que tu dispositivo te pida que autorices el instalar aplicacaciones de terceros, puesto que esta aplicación todavía no está disponible en la Google PlayStore.
* **Creación de cuenta**: Al iniciar la aplicación por primera vez, se te pedirá que crees una cuenta. Elige un pin único, que sea fuerte y que puedas recordar para proteger tus datos, y no lo compartas con nadie.
  ![Mockup Registro](/doc/img/mockups/registro.png)

##### Uso de la Aplicación

* **Agregar una nueva contraseña**: En la pantalla de crear puedes añadir una nueva entrada. Introduce el nombre de la web o app, el nombre de usuario y la contraseña (que debe cumplir una serie de características para que sea una contraseña fuerte).
* ![Mockup Crear](/doc/img/mockups/crear.png)
  
* **Buscar una contraseña**: Utiliza la barra de búsqueda para encontrar rápidamente la contraseña que necesitas, tanto en el apartado de contraseñas como en el apartado de favoritos. Puedes filtrar los resultados por nombre de la web o aplicación.
  ![Mockup Listado](/doc/img/mockups/listado.png)
* **Generar contraseñas seguras**: Irko Key incluye un generador de contraseñas aleatorias y seguras para ayudarte a crear contraseñas difíciles de adivinar.
* **Copiar contraseña**: Pulsa sobre el botón con el icono de copiar para copiar automáticamente la contraseña al portapapeles, tanto en el listado de contraseñas como en favoritos.
  ![Mockup copiar](/doc/img/mockups/copiar.png)
* **Editar o eliminar una entrada**: Pulsa sobre la entrada que deseas modificar y utiliza el botón correspondiente para editarla (icono de lápiz) o eliminarla (icono de bote de basura).
  ![Mockup Editar](/doc/img/mockups/editar.png)
* **Copias de seguridad**: La aplicación dispone de un apartado de exportación e importación. Puedes realizar una copia de seguridad manual en cualquier momento exportando tus datos a un archivo JSON cifrado, de nombre irkokey.json, o recuperar tu información de ese mismo archivo, que siempre se debe de guardar a buen recaudo.
  ![Mockup Backup](/doc/img/mockups/backup2.png)


##### Seguridad y Privacidad

* **Cifrado**: Todos los datos se almacenan en tu dispositivo de forma cifrada, lo que garantiza la máxima seguridad.
* **Acceso local**: Irko Key no se conecta a internet, lo que reduce el riesgo de ataques externos.
* **Contraseñas fuertes**: La aplicación te ayudará a crear y almacenar contraseñas seguras y únicas.
* **Copias de seguridad cifradas**: Las copias de seguridad se generan en formato JSON cifrado, lo que protege tus datos incluso fuera del dispositivo.

##### Solución de Problemas

Si encuentras algún problema o tienes alguna duda, puedes ponerte en contacto conmigo en rfortesperez@gmail.com

Irko Key es la herramienta perfecta para proteger tus contraseñas y mantener tu información segura. Gracias a su interfaz intuitiva y a las robustas medidas de seguridad, podrás disfrutar de una gestión de contraseñas sencilla y eficaz.


