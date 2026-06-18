package com.hospital.replication;

public class LeaderManager {

private static String leader=

"SERVER-1";

public static
String
getLeader(){

return leader;

}

public static
void elect(

String server

){

leader=
server;

System.out.println(

"NEW LEADER ? "

+

server

);

}

}
