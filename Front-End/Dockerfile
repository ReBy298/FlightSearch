# Etapa 1: Construcción
FROM node:22-alpine AS build

WORKDIR /Front-End

# Copia los archivos de dependencias primero
COPY package.json package-lock.json ./

# Limpiar caché de npm e instalar dependencias
RUN npm cache clean --force && npm install

# Copia el resto de los archivos
COPY . .

# Construye la aplicación
RUN npm run build

# Etapa 2: Imagen final
FROM node:22-alpine

WORKDIR /Front-End

# Copia los archivos construidos desde la etapa anterior
COPY --from=build /Front-End .

EXPOSE 3000

CMD ["npm", "start"]
