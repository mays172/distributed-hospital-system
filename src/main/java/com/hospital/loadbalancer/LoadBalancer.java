package com.hospital.loadbalancer;

import java.rmi.registry.*;

import java.util.HashSet;

import java.util.Set;

import com.hospital.remote.AppointmentService;

public class LoadBalancer {

private static int next=0;

private static final int[] ports={

2001,
2002,
2003

};

private static Set<Integer>
reported=

new HashSet<>();

public static
AppointmentService
getServer()

throws Exception {

for(

int i=0;

i<ports.length;

i++

){

int port=

ports[
next
];

next=

(
next+1
)

%

ports.length;

try{

Registry registry=

LocateRegistry
.getRegistry(

"localhost",

port

);

AppointmentService server=

(

AppointmentService

)

registry.lookup(
"hospital"
);

server.health();

return server;

}

catch(
Exception e
){

if(

!reported.contains(
port
)

){

System.out.println(

"SERVER "

+

port

+

" OFFLINE"

);

reported.add(
port
);

}

}

}

throw new RuntimeException(

"ALL SERVERS DOWN"

);

}

}
