package com.eea.v2.service.general;

public class FileSizeImp {
    public static Double getSizeInMB(long size){
        return size*0.00000095367432;
    }
}
