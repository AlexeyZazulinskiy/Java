package seminar6;

public class Notebook {
    private int id;
    private int ramSize;
    private int hddSize;
    private int os;
    private int diag;

public Notebook (int id, int ramsize, int hddsize, int os, int diag){
    this.id = id;
    this.ramSize =ramsize;
    this.hddSize = hddsize;
    this.os= os;
    this.diag = diag;
}
public int getRamSize() {
    return ramSize;
}
public int getHddSize() {
    return hddSize;
}
public String getOsVer() {
    String osver = "Windows";
    if (os == 2){osver = "Linux  ";}
    return osver;
}
public int getDiag() {
    return diag;
}
public int getNum() {
    return id;
}
public int getOsIndex() {
    return os;
}
}
