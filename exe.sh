#! /bin/bash
mkdir test
chmod 777 test
cp -r data test/data
cp exe1.sh test
cd test
echo FROM ubuntu:14.04 > Dockerfile
echo ADD data /home/test/ >>Dockerfile
echo ADD exe1.sh /home/ >>Dockerfile
echo RUN sudo apt-get update >>Dockerfile
echo RUN sudo apt-get install -y ftp >> Dockerfile
echo WORKDIR /home/	>>Dockerfile
echo CMD /home/exe1.sh >> Dockerfile
sudo docker build --tag yhim/example .
sudo docker login -u "yhim" -p "k9460180"
sudo docker tag yhim/example 192.168.0.136:5000/yhim 
sudo docker push 192.168.0.136:5000/yhim
sudo docker rmi 192.168.0.136:5000/yhim
sudo rm -rf test








