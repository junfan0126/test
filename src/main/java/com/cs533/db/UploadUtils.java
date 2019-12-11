package com.cs533.db;

import java.util.UUID;

public class UploadUtils {
    public static String getUUIDFileName(String fileName){
        int idx = fileName.lastIndexOf(".");
        String extention = fileName.substring(idx);
        String uuidFileName = UUID.randomUUID().toString().replace("-", "")+extention;
        return uuidFileName;
    }


}
