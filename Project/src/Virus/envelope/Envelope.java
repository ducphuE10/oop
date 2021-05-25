package Virus.envelope;


import Virus.AcidNucleic;
import Virus.Capsid;
import Virus.Virus;

public class Envelope{
    public String envelopeOfVirus;

    public Envelope(String envelopeOfVirus) {
        this.envelopeOfVirus = envelopeOfVirus;
    }

    public String getEnvelopeOfVirus() {
        return envelopeOfVirus;
    }

    public void setEnvelopeOfVirus(String envelopeOfVirus) {
        this.envelopeOfVirus = envelopeOfVirus;
    }
}

