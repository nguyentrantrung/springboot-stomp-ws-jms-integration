## Prerequisites

One must have ```docker``` installed. Otherwise, you can use ActiveMQ, download from website and start

If you're on Mac OS X, run:

```
boot2docker stop
VBoxManage modifyvm "boot2docker-vm" --natpf1 "stomp,tcp,,61613,,61613";
VBoxManage modifyvm "boot2docker-vm" --natpf1 "openwire,tcp,,61616,,61616";
boot2docker start
```

### Build amq-docker

```
git clone https://github.com/pires/amq-docker.git
cd amq-docker
docker build -t amq:5.10.0 .
```

### Run broker

```
docker run --name amq1 -p=61613:61613 -p=61616:61616 -d -t amq:5.10.0
```

## Build & run

```
git clone https://github.com/pires/springboot-stomp-ws-jms-integration.git
```

```
cd springboot-stomp-ws-jms-integration/master
mvn spring-boot:run
```

```
cd cd springboot-stomp-ws-jms-integration/minion
mvn spring-boot:run
```

## Test

1. Guest cannot SUBSCRIBE /user/** 
2. Score update for current session, other session cannot get message in /user/** topic
