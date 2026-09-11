package org.example;

public class Version {

    private int major;
    private int minor;
    private  int revision;

    private static Version instancia;

    public Version() {
        this.major = 6;
        this.minor = 0;
        this.revision =2;
    }
    public static Version getInstance(){
        if(instancia==null){
           instancia = new Version();
        }
        return instancia;
    }

    @Override
    public String toString() {
        return "Version{" +
                "major=" + major +
                ", minor=" + minor +
                ", revision=" + revision +
                '}';
    }
}
