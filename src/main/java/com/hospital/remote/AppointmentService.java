package com.hospital.remote;

import java.rmi.Remote;

import java.rmi.RemoteException;

public interface AppointmentService
extends Remote {

String book(
String patient,
String date
)

throws RemoteException;

String cancel(
String patient
)

throws RemoteException;

String health()

throws RemoteException;

long heartbeat()

throws RemoteException;

}
