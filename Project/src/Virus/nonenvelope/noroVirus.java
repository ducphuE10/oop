package Virus.nonenvelope;
import Virus.acidNucleic;
import Virus.capsid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class noroVirus extends nonenvelopeVirus {
    public String ConstantDomain;
    public String VariableDomain;
    public String PDomain;
    public String SDomain;
    public String RNA;
    public String introVirus;

    public noroVirus(double size, acidNucleic typeOfAcidNucleic, capsid typeOfNucleocapsid, String constantDomain, String variableDomain, String PDomain, String SDomain, String RNA, String introVirus) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid);
        ConstantDomain = constantDomain;
        VariableDomain = variableDomain;
        this.PDomain = PDomain;
        this.SDomain = SDomain;
        this.RNA = RNA;
        this.introVirus = introVirus;
    }

    public noroVirus(double size, acidNucleic typeOfAcidNucleic, capsid typeOfNucleocapsid) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid);
    }

    public String getConstantDomain() {
        return ConstantDomain;
    }

    public void setConstantDomain(String constantDomain) {
        ConstantDomain = constantDomain;
    }

    public String getVariableDomain() {
        return VariableDomain;
    }

    public void setVariableDomain(String variableDomain) {
        VariableDomain = variableDomain;
    }

    public String getPDomain() {
        return PDomain;
    }

    public void setPDomain(String PDomain) {
        this.PDomain = PDomain;
    }

    public String getSDomain() {
        return SDomain;
    }

    public void setSDomain(String SDomain) {
        this.SDomain = SDomain;
    }

    public String getRNA() {
        return RNA;
    }

    public void setRNA(String RNA) {
        this.RNA = RNA;
    }

    public String getIntroVirus() {
        return introVirus;
    }

    public void setIntroVirus(String introVirus) {
        this.introVirus = introVirus;
    }

    @Override
    public void attackCell(){

    }
}
