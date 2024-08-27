FROM node:20-alpine

LABEL authors="Aby"

WORKDIR /app

# Copia los archivos de dependencias primero
COPY package.json package-lock.json ./  
COPY src ./
COPY public ./

# Instala las dependencias
RUN npm install

# Expone el puerto que usará la aplicación
EXPOSE 3000

# Comando para iniciar la aplicación
CMD ["npm" ,"start"]