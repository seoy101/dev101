FROM ubuntu:14.04
RUN apt-get update
RUN apt-get install -y nfs-kernel-server
RUN apt-get install -y nfs-common
RUN apt-get install -y vim
RUN chmod 777 /mnt
RUN mkdir -p /minjae/conf/
ADD services /minjae/conf/
ADD nfs-kernel-server /minjae/conf/
ADD run.sh /usr/local/bin/run.sh
ENTRYPOINT ["run.sh"]
