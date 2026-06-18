package com.hospital.server;

import java.rmi.registry.*;

import java.rmi.server.UnicastRemoteObject;

public class StartServer {

public static void main(
String[] args
)

throws Exception {

String name=
args[0];

int port=

Integer.parseInt(
args[1]
);

AppointmentServer server=

new AppointmentServer(
name
);

var stub=

UnicastRemoteObject
.exportObject(

server,

port

);

Registry registry=

LocateRegistry
.createRegistry(
port
);

registry.rebind(

"hospital",

stub

);

System.out.println(

name+

" RUNNING ON "

+

port

);

while(true){

Thread.sleep(
1000
);

}

}

}
