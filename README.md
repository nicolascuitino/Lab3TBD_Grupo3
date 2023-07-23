# Lab3TBD_Grupo3

- Para la creacion de la base de datos se debe abrir un terminal dentro del directorio donde se encuentre la carpeta tbdlab3grupo3 y ejecutar la siguiente linea en la consola:

mongorestore --db tbdlab3grupo3 tbdlab3grupo3

- Para cargar los datos de prueba se deben ejecutar los siguientes comandos abriendo un terminal donde se encuentros estos archivos:

mongoimport --db tbdlab3grupo3 --collection emergencia --jsonArray --file ejemplos_emergencias.json 

mongoimport --db tbdlab3grupo3 --collection tarea --jsonArray --file ejemplos_tareas.json
