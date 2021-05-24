package Virus.envelope;


import Virus.acidNucleic;
import Virus.capsid;
import Virus.virus;

public class envelope{
    public String envelopeOfVirus;

    public envelope(String envelopeOfVirus) {
        this.envelopeOfVirus = envelopeOfVirus;
    }

    public String getEnvelopeOfVirus() {
        return envelopeOfVirus;
    }

    public void setEnvelopeOfVirus(String envelopeOfVirus) {
        this.envelopeOfVirus = envelopeOfVirus;
    }
}

