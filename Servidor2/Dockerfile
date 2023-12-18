#Utiliza una imagen de pyrthon
FROM python:3.9
#Establecer el directorio de trabajo dentro del contenedor
WORKDIR /servidor
#Copiar todos los archivos desde la carpeta del host al contendor(Primero el host y luego del contendor)
COPY . . 
#Instalar las dependencias requeridas 
RUN pip install flask
#Exponer puerto del contenedr
EXPOSE 5001
#Comando para ejecutar mi aplicion
CMD ["python","app.py"]
