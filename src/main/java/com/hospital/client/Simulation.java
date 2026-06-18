package com.hospital.client;

import com.hospital.remote.AppointmentService;

import com.hospital.loadbalancer.LoadBalancer;

public class Simulation {

public static void main(
String[] args
)

throws Exception {

int requests=100;

int success=0;

int failed=0;

long start=

System.currentTimeMillis();

for(

int i=1;

i<=requests;

i++

){

try{

AppointmentService s=

LoadBalancer
.getServer();

s.book(

"USER-"+i,

"22-06"

);

success++;

}

catch(
Exception e
){

failed++;

}

}

long end=

System.currentTimeMillis();

System.out.println();

System.out.println(
"====== RESULT ======"
);

System.out.println(
"REQUESTS = "
+
requests
);

System.out.println(
"SUCCESS = "
+
success
);

System.out.println(
"FAILED = "
+
failed
);

System.out.println(
"TIME = "
+
(
end-start
)
+
" ms"
);

}
}
