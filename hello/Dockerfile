FROM java:8
RUN apt-get update
RUN apt-get install -y unzip
RUN apt-get install -y curl
RUN mkdir /app
RUN curl -O http://downloads.typesafe.com/typesafe-activator/1.3.10/typesafe-activator-1.3.10.zip
RUN unzip typesafe-activator-1.3.10.zip -d / && rm typesafe-activator-1.3.10.zip && chmod 777 /activator-dist-1.3.10/bin/activator && ln -sf /activator-dist-1.3.10/bin/activator /app
ENV PATH $PATH:/activator-dist-1.3.10/bin
ADD hello /app
EXPOSE 9000 8888
WORKDIR /app
CMD activator run



