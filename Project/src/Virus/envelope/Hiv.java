package Virus.envelope;

import Virus.AcidNucleic;
import Virus.Capsid;

public class Hiv extends EnvelopeVirus{
    public String Gp120;
    public String Gp41;
    public String HumanClass1;
    public String HumanClass2;
    public String Integrase;
    public Envelope envelopeOfVirus;
    public String Nucleocapsid;
    public String Protease;
    public String RNA;
    public String Reverse;
    public String MatrixProtein;
    public String ProteinP79;


    public Hiv(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid, Envelope envelopeOfVirus, String gp120, String gp41, String humanClass1, String humanClass2, String integrase, String nucleocapsid, String protease, String RNA, String reverse,String MatrixProtein,String P79) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid, envelopeOfVirus);
        this.envelopeOfVirus = envelopeOfVirus;
        Gp120 = gp120;
        Gp41 = gp41;
        HumanClass1 = humanClass1;
        HumanClass2 = humanClass2;
        Integrase = integrase;
        Nucleocapsid = nucleocapsid;
        Protease = protease;
        this.RNA = RNA;
        Reverse = reverse;
        this.MatrixProtein = MatrixProtein;
        this.ProteinP79 = P79;
    }

    public String getGp120() {
        return Gp120;
    }

    public void setGp120(String gp120) {
        Gp120 = gp120;
    }

    public String getGp41() {
        return Gp41;
    }

    public void setGp41(String gp41) {
        Gp41 = gp41;
    }

    public String getHumanClass1() {
        return HumanClass1;
    }

    public void setHumanClass1(String humanClass1) {
        HumanClass1 = humanClass1;
    }

    public String getHumanClass2() {
        return HumanClass2;
    }

    public void setHumanClass2(String humanClass2) {
        HumanClass2 = humanClass2;
    }

    public String getIntegrase() {
        return Integrase;
    }

    public void setIntegrase(String integrase) {
        Integrase = integrase;
    }

    public Envelope getEnvelopeOfVirus() {
        return envelopeOfVirus;
    }

    public void setEnvelopeOfVirus(Envelope envelopeOfVirus) {
        this.envelopeOfVirus = envelopeOfVirus;
    }

    public String getNucleocapsid() {
        return Nucleocapsid;
    }

    public void setNucleocapsid(String nucleocapsid) {
        Nucleocapsid = nucleocapsid;
    }

    public String getProtease() {
        return Protease;
    }

    public void setProtease(String protease) {
        Protease = protease;
    }

    public String getRNA() {
        return RNA;
    }

    public void setRNA(String RNA) {
        this.RNA = RNA;
    }

    public String getReverse() {
        return Reverse;
    }

    public void setReverse(String reverse) {
        Reverse = reverse;
    }
    @Override
    public void attackCell(){

    }
}



