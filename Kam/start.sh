#!/bin/bash

sudo docker run -d --name nfsimage --privileged -p 111:111 -p 2049:2049 -p 4002:4002 nfsimage
