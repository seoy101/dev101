FROM ubuntu:14.04
RUN apt-get update
RUN apt-get install -y nfs-kernel-server
RUN apt-get install -y nfs-common
RUN apt-get install -y vim
VOLUME /nfsdir
RUN chmod 777 /nfsdir
RUN mkdir /nfsconf
ADD services /nfsconf/
ADD nfs-kernel-server /nfsconf/
ADD run.sh /usr/local/bin/run.sh
ADD MT.fa /nfsdir
ADD bwa /nfsdir
ENTRYPOINT ["run.sh"]
