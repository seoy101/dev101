FROM java:8
RUN apt-get update
RUN apt-get install nfs-common -y
RUN apt-get install nfs-kernel-server -y
RUN apt-get install portmap -y
RUN chmod 777 /mnt
RUN chmod 777 /etc/exports
RUN echo "/mnt 192.168.10.101(rw,async,no_root_squash,all_squash)" > /etc/exports
RUN /etc/init.d/nfs-kernel-server restart
EXPOSE 111 2049
