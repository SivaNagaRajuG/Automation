package com.selenium.infrastructure.datahandler;

public interface DataReader {

    public void generateDataRecord() throws Exception;
    public String getData(String name);

}
