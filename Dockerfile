FROM java
COPY . /usr/src/client-app
WORKDIR /usr/src/client-app
RUN javac src/MyClient.java
CMD [ "java", "Myclient" ]
