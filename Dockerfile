FROM openjdk:8-jre-alpine

# Copy app to new directory
RUN mkdir -p /usr/pippo-starter
COPY build/libs/pippo-starter-0.1.0.jar /usr/pippo-starter

# Work out of the directory
WORKDIR /usr/pippo-starter

# Expose http ports
EXPOSE 8080 8443

# Start java application
CMD ["java","-jar","pippo-starter-0.1.0.jar"]
