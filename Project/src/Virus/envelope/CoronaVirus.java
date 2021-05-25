package Virus.envelope;

import Virus.AcidNucleic;
import Virus.Capsid;
import Virus.Virus;

public class CoronaVirus extends EnvelopeVirus {
    //TODO add more attribute
	public String evenlopeProtein;
	public String mprotein;
	public String spike;

	
    public CoronaVirus(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid,Envelope envelopeOfVirus,String evenlopeProtein,String mprotein,String spike) {
        super(size, typeOfAcidNucleic, typeOfNucleocapsid, envelopeOfVirus);
        this.evenlopeProtein = evenlopeProtein;
        this.mprotein = mprotein;
        this.spike = spike;
    }

	public String getEvenlopeProtein() {
		return evenlopeProtein;
	}

	public void setEvenlopeProtein(String evenlopeProtein) {
		this.evenlopeProtein = evenlopeProtein;
	}

	public String getMprotein() {
		return mprotein;
	}

	public void setMprotein(String mprotein) {
		this.mprotein = mprotein;
	}

	public String getSpike() {
		return spike;
	}

	public void setSpike(String spike) {
		this.spike = spike;
	}


    
}
