package Virus.envelope;
import Virus.acidNucleic;
import Virus.capsid;
import Virus.virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ebolaVirus extends envelopeVirus {
    public envelope envelopeOfVirus;
    public String GlyProtein;
    public String Nucleprotein;
    public String RNA;
    public String VP;

    public ebolaVirus(double size, acidNucleic typeOfAcidNucleic, capsid typeOfNucleocapsid, envelope envelopeOfVirus,  String glyProtein, String nucleprotein, String RNA, String VP) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid, envelopeOfVirus);
        this.envelopeOfVirus = envelopeOfVirus;
        GlyProtein = glyProtein;
        Nucleprotein = nucleprotein;
        this.RNA = RNA;
        this.VP = VP;
    }

    public envelope getEnvelopeOfVirus() {
        return envelopeOfVirus;
    }

    public void setEnvelopeOfVirus(envelope envelopeOfVirus) {
        this.envelopeOfVirus = envelopeOfVirus;
    }

    public String getGlyProtein() {
        return GlyProtein;
    }

    public void setGlyProtein(String glyProtein) {
        GlyProtein = glyProtein;
    }

    public String getNucleprotein() {
        return Nucleprotein;
    }

    public void setNucleprotein(String nucleprotein) {
        Nucleprotein = nucleprotein;
    }

    public String getRNA() {
        return RNA;
    }

    public void setRNA(String RNA) {
        this.RNA = RNA;
    }

    public String getVP() {
        return VP;
    }

    public void setVP(String VP) {
        this.VP = VP;
    }
    @Override
    public void attackCell(){

    }
}
