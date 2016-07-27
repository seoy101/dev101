#!/bin/bash
set -e
echo "/nfsdir *(rw,insecure,fsid=0,no_subtree_check)" >> /etc/exports
rm /etc/services
mv /nfsconf/services /etc/
rm /etc/default/nfs-kernel-server
mv /nfsconf/nfs-kernel-server /etc/default/nfs-kernel-server

service rpcbind start
service nfs-kernel-server start

while :
do
	sleep 1
done
