package gui;

public class Ember implements Comparable<Ember>{
    private String nev, nem;
    private int kor, munkToltEv;

    public Ember(String nev, int kor,String nem, int munkToltEv) {
        this.nev = nev;
        this.nem = nem;
        this.kor = kor;
        this.munkToltEv = munkToltEv;
    }

    public Ember(String nev,int kor, String nem) {
       this(nev, kor, nem, 0);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getMunkToltEv() {
        return munkToltEv;
    }

    public void setMunkToltEv(int munkToltEv) {
        this.munkToltEv = munkToltEv;
    }

    @Override
    public int compareTo(Ember e) {
        return this.getKor() - e.getKor();
    }
    
    
    
}
