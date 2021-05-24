package Virus.envelope;

import Virus.acidNucleic;
import Virus.capsid;
import Virus.virus;

public class coronaVirus extends envelopeVirus {
    //TODO add more attribute

    public coronaVirus(double size, acidNucleic typeOfAcidNucleic, capsid typeOfNucleocapsid, envelope envelopeOfVirus) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid, envelopeOfVirus);
    }
}
