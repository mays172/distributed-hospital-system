package com.hospital.client;

import com.hospital.remote.AppointmentService;

import com.hospital.loadbalancer.LoadBalancer;

public class Client {

public static void main(
String[] args
)

throws Exception {

for(

int i=1;

i<=6;

i++

){

AppointmentService server=

LoadBalancer
.getServer();

String result=

server.book(

"PATIENT-"+i,

"22-06"

);

System.out.println(
result
);

}

}

}
