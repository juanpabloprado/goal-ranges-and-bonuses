# goal-ranges-and-bonuses

El sueldo de los jugadores del Resuelve FC se compone de dos partes un sueldo fijo y un bono variable, la suma de estas dos partes es el sueldo de un jugador. El bono variable se compone de dos partes meta de goles individual y meta de goles por equipo cada una tiene un peso de 50%.

La meta individual de goles por jugador depende del nivel que tenga asignado:

| Nivel |Goles/mes|
| ------------- |:-------------:| 
|A |5|
|B |10|
|C |15|
|Cuauh |20|

Ejemplo:
Los jugadores Juan, Pedro, Martín y Luis anotaron así durante el mes:

| Jugador | Nivel |Goles anotados en el mes/mínimo requerido|
| ------------- |:-------------:| :-----------: |
|Juan | A |6/5|
|Pedro | B |7/10|
|Martín |C |16/15|
|Luis | Cuauh |19/20|
|  | | |
| total |  |48/50|

En el bono por equipo tendrían un alcance de 96%
Luis tendría un alcance individual de 95% para un alcance total de 95.5%
El suelo fijo de Luis es de 50,000.00 y su bono es de 10,000.00 por lo que su sueldo final será $59,550.00

Para correr el proyecto, primero hay que compilar y despues ejecutar el jar, esto se puede hacer en una sola linea de comandos:
```bash
./mvnw clean package && java -jar target/goal-ranges-and-bonuses-0.0.1-SNAPSHOT.jar
```
Espere a que el servidor comienze, una vez iniciada la aplicación. Con tu cliente REST favorito, ejecuta lo siguiente: 
```http
POST http://localhost:8080/players/salaries
Content-Type: application/json

[   {     "nombre":"Juan Perez",     "nivel":"C",     "goles":10,     "sueldo":50000,     "bono":25000,     "sueldo_completo":null,     "equipo":"rojo"   },   {     "nombre":"EL Cuauh",     "nivel":"Cuauh",     "goles":30,     "sueldo":100000,     "bono":30000,     "sueldo_completo":null,     "equipo":"azul"   },   {     "nombre":"Cosme Fulanito",     "nivel":"A",     "goles":7,     "sueldo":20000,     "bono":10000,     "sueldo_completo":null,     "equipo":"azul"    },   {     "nombre":"El Rulo",     "nivel":"B",     "goles":9,     "sueldo":30000,     "bono":15000,     "sueldo_completo":null,     "equipo":"rojo"    } ]
```
