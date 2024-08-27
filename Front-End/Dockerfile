FROM node:20-alpine

LABEL authors="Aby"

WORKDIR /Front-End
# Copia los archivos de dependencias primero
COPY package.json package-lock.json ./

# Instala las dependencias
RUN npm install

# Copia el resto de los archivos
COPY src ./src

COPY public ./public

# Construye la aplicación
RUN npm run build

# Expone el puerto que usará la aplicación
EXPOSE 3000

# Comando para iniciar la aplicación
CMD ["npm", "start"]
