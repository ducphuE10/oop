package Virus;

public class Virus implements Attack {
    public double size;
    public AcidNucleic typeOfAcidNucleic;
    public Capsid typeOfNucleocapsid;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public void attackCell() {

    }

    public Virus(double size, AcidNucleic typeOfAcidNucleic, Capsid typeOfNucleocapsid) {
        this.size = size;
        this.typeOfAcidNucleic = typeOfAcidNucleic;
        this.typeOfNucleocapsid = typeOfNucleocapsid;
    }

    public AcidNucleic getTypeOfAcidNucleic() {
        return typeOfAcidNucleic;
    }

    public void setTypeOfAcidNucleic(AcidNucleic typeOfAcidNucleic) {
        this.typeOfAcidNucleic = typeOfAcidNucleic;
    }

    public Capsid getTypeOfNucleocapsid() {
        return typeOfNucleocapsid;
    }

    public void setTypeOfNucleocapsid(Capsid typeOfNucleocapsid) {
        this.typeOfNucleocapsid = typeOfNucleocapsid;
    }
}
