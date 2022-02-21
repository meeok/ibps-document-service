package com.kelmorgan.ibpsdocumentservice.utils;

public class Query {

    public static String getFolderIndex(String wiName){
        return  "select FolderIndex from PDBFolder where Name='" + wiName + "'";
    }
}
