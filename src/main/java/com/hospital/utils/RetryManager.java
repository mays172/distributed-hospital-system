package com.hospital.utils;

public class RetryManager {

public static void waitRetry(

int attempt

){

try{

Thread.sleep(

1000L*

attempt

);

}

catch(
Exception e
){

}

}

}
