# Proyecto fin de ciclo



## Descripción



Hoy en día, la gestión de contraseñas de manera adecuada es algo imprescindible. Cada día que pasa hay nuevas amenazas de ciberseguridad, y una de las debilidades más grandes que tenemos son las contraseñas débiles, por miedo a no recordarlas cuando son necesarias, o el emplear siempre y para todo la misma contraseña por miedo a olvidarla.

IrkoKey es una aplicación Android que permitirá a los usuarios guardar y gestionar sus contraseñas de manera segura.Contará con un mecanismo de backup y todo esto acompañado de una interfaz de usuario lo más sencilla, intuitiva y fácil de aprender posible para el usuario.

## Instalación / Puesta en marcha

 Se puede probar esta aplicación de tres maneras distintas, todas igual de sencillas. La primera sería directamente en un <u>emulador en Android Studio</u>. Podremos elegir entre distintos modelos de dispositivos, con diferentes API, tamaños de pantalla, RAM, etc. Una vez seleccionado solamente tendremos que pulsar el botón de reproducción (el triángulo verde), o pulsar Shift + F10.
 
 Otra manera simple de probar la app es <u>a través de un dispositivo físico</u>. Para ello tendremos que activar las opciones de desarrollador de nuestro dispositivo. Para activarlas, iremos al apartado de *Ajustes* -> *Sobre el teléfono* -> y sobre el *número de compilación*, pulsaremos rápidamente unas 5-7 veces, hasta que aparezca un mensaje informándonos de que se han activado las opciones de desarrollador.

 Hecho esto, tendremos que ir a *Ajustes* -> *Ajustes adicionales* -> *Opciones de desarrollador*, y activaremos la opción <u>Depuración USB</u>. Ahora, conectando nuestro dispositivo mediante un cable usb al ordenador, podremos instalar y probar la app en nuestro móvil.

 A partir de la versión 3.0 de Android Studio, y de Android 10, ya se puede utilizar la <u>conexión inalámbrica</u> para poder depurar la app en nuestro dispositivo android sin necesidad de utilizar un cable USB, aunque hay que tener en cuenta que si tenemos Android 10 (API level 29) o inferior, primero debemos sincronizarlos por USB y posteriormente podremos conectarnos de manera inalámbrica.

## Uso

Irko Key es una bóveda digital personal. Protege tus datos más sensibles con este gestor de contraseñas. Cifrado AES que garantiza la seguridad de tus credenciales. Generador de contraseñas aleatorias que crea contraseñas únicas y robustas. Copias de seguridad que te permiten recuperar tus datos en cualquier momento. ¡Organiza, protege y simplifica tu vida digital con Irko Key!

## Sobre el autor

Soy una apasionada del desarrollo móvil y la ciberseguridad. Para finalizar mis estudios, buscaba un proyecto que me permitiera poner en práctica los conocimientos adquiridos y, al mismo tiempo, contribuir a la seguridad de los usuarios. Irko Key se alinea perfectamente con mis objetivos, ya que me brinda la oportunidad de desarrollar una aplicación útil y segura. Mi experiencia en Kotlin y Android Studio, junto con mi interés por la criptografía, me han sido de gran ayuda en la realización de este proyecto.

Se puede contactar conmigo por las siguientes vías:

[Linkedin](https://www.linkedin.com/in/rocío-fortes-pérez)
[Email](mailto:rfortesperez@gmail.com)


## Licencia

> *TODO*: Es requisito INDISPENSABLE el licenciar explícitamente el proyecto software. Se recomienda licenciar con *GNU Free Documentation License Version 1.3*. Crear un fichero `LICENSE` en la raiz del repo, con tu fichero de licencia. Recuerda que si empleas una licencia de software libre estás autorizando la derivación de tu obra bajo la misma licencia que elijas, pudiendo dar continuidad, p. e. otro alumno, para continuar tu proyecto en otro curso.
> Si tu proyecto es documental, recomendamos los términos de *GNU Free Documentation License Version 1.3*, crea igualmente el fichero `LICENSE`. Será especialmente valorado en este caso, la claridad de la especificación para que el proyecto pueda ser ejecutado partiendo de lo proyectado.


## Índice

> *TODO*: Simplemente indexa ordenadamente todo tu proyecto.

1. Anteproyecto
     * 1.1. [Idea](#11-idea)
     * 1.2. [Objetivos](#12-objetivos)
     * 1.3. [Requisitos Funcionales](#13-requisitos-funcionales)
     * 1.4. [Requisitos No Funcionaes](#14-requisitos-no-funcionales)
     * 1.5. [Tecnologías](#15-tecnologías)
2. [Planificación](doc/templates/4_planificacion.md)
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

## Guía de contribución

> *TODO*: Tratándose de un proyecto de software libre, es muy importante que expongas cómo se puede contribuir con tu proyecto. Algunos ejemplos de esto son realizar nuevas funcionalidades, corrección y/u optimización del código, realización de tests automatizados, nuevas interfaces de integración, desarrollo de plugins, etc. etc. Sé lo más conciso que puedas.

## Links

> *TODO*: Enlaces externos y descipciones de estos enlaces que creas conveniente indicar aquí. Generalmente ya van a estar integrados con tu documentación, pero si requieres realizar un listado de ellos, este es el lugar.