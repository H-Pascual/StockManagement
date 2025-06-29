============================================================
                 PROYECTO: GESTIÓN DE ACCIONES
                     Autor: Héctor Pascual Marín
                     Versión: 1.0
============================================================

📌 DESCRIPCIÓN DEL PROYECTO
------------------------------------------------------------
Este proyecto es una aplicación de escritorio desarrollada 
en Java con JavaFX para gestionar un portafolio de acciones 
(financieras). Permite al usuario añadir, visualizar y 
gestionar acciones individuales, calculando métricas clave 
como el valor total, rendimiento, y dividendos promedio del 
portafolio.

📦 ESTRUCTURA DEL PROYECTO
------------------------------------------------------------
- `MainApplication.java`: Clase principal que inicia la app.
- `Portfolio.java`: Clase para gestionar la lista de acciones.
- `Stock.java`: Representa una acción individual.
- `Addstock.java`: Controlador para la ventana de agregar.
- `MainController.java`: Controlador general de la interfaz.
- `StockTest.java`: Tests unitarios para la clase Stock.
- `stocks.txt`: Archivo de entrada con acciones precargadas.
- `home.fxml`: Interfaz gráfica principal de la aplicación.
- `pom.xml`: Archivo de configuración Maven.

🛠 TECNOLOGÍAS UTILIZADAS
------------------------------------------------------------
- Java 18
- JavaFX 18.0.1 (Controles + FXML)
- Maven
- JUnit 5.8.2

🔧 FUNCIONALIDADES PRINCIPALES
------------------------------------------------------------
✔ Cargar automáticamente las acciones desde `stocks.txt`
✔ Añadir una nueva acción mediante formulario JavaFX
✔ Validación de entrada para evitar errores de usuario
✔ Cálculo de:
   - Valor total del portafolio
   - Rentabilidad (% de cambio)
   - Dividendos medios por acción
✔ Interfaz gráfica simple y funcional

🧪 TESTEO
------------------------------------------------------------
La clase `StockTest.java` realiza pruebas unitarias básicas 
sobre los métodos de acceso (getters) de la clase Stock.

⚙️ INSTRUCCIONES DE USO
------------------------------------------------------------
1. Requisitos previos:
   - Java 18 instalado
   - Maven instalado

2. Compilar el proyecto:
   > mvn clean install

3. Ejecutar la aplicación:
   > mvn javafx:run

4. Formato del archivo `stocks.txt`:
   nombre;ticker;precioCompra;cantidad;precioActual;país;sector;divisa;dividendo

📁 EJEMPLO DE `stocks.txt`:
------------------------------------------------------------
Intel;INTC;26.4;3.0;30.0;EEUU;Communication Services;Dollar;2.2
Apple;APPL;120.0;50.0;160.0;EEUU;Technology;Dollar;1.18

🚨 ERRORES CONOCIDOS
------------------------------------------------------------
- En el test `getSector()` el valor esperado está mal escrito 
  ("Comunication Services" en lugar de "Communication Services").

✍️ AUTOR
------------------------------------------------------------
Héctor Pascual Marín
Proyecto para la asignatura Entornos de Desarrollo