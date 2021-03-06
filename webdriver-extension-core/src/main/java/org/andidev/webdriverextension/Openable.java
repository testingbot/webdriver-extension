package org.andidev.webdriverextension;

public interface Openable {

    public void open();

    public boolean isOpen();

    public boolean isNotOpen();

    public void assertIsOpen() throws Error;

    public void assertIsNotOpen() throws Error;

    public String getUrl();
}