package Virus.envelope;
import Virus.virus;
import Virus.capsid;
import Virus.acidNucleic;
public class envelopeVirus extends virus{
    public envelope envelopeOfVirus;

    public envelopeVirus(double size, acidNucleic typeOfAcidNucleic, capsid typeOfNucleocapsid, envelope envelopeOfVirus) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid);
        this.envelopeOfVirus = envelopeOfVirus;
    }

    public envelope getEnvelopeOfVirus() {
        return envelopeOfVirus;
    }

    public void setEnvelopeOfVirus(envelope envelopeOfVirus) {
        this.envelopeOfVirus = envelopeOfVirus;
    }
}
