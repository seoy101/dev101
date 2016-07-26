#!/bin/bash
set -e
echo "/mnt *(rw,insecure,fsid=0,no_subtree_check)" >> /etc/exports
rm /etc/services
mv /minjae/conf/services /etc/
rm /etc/default/nfs-kernel-server
mv /minaje/conf/nfs-kernel-server /etc/default/nfs-kernel-server

service rpcbind start
service nfs-kernel-server start
