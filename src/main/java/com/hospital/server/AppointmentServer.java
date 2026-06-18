package com.hospital.server;

import java.rmi.RemoteException;

import java.util.ArrayList;

import java.util.List;

import com.hospital.remote.AppointmentService;

public class AppointmentServer
implements AppointmentService {

private String serverName;

private List<String>
appointments=

new ArrayList<>();

public AppointmentServer(
String serverName
){

this.serverName=
serverName;

}

@Override
public String book(
String patient,
String date
)

throws RemoteException {

appointments.add(
patient
);

new Thread(

()->{

try{

Thread.sleep(
3000
);

System.out.println(

serverName+

" REPLICATED "

+

patient

);

}

catch(
Exception e
){

}

}

).start();

return

"[LEADER="

+

serverName

+

"] booked "

+

patient;

}

@Override
public String cancel(
String patient
){

return
"OK";

}

@Override
public String health(){

return "UP";

}

@Override
public long heartbeat(){

return

System
.currentTimeMillis();

}

}
