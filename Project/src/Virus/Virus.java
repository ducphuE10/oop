package Virus;

public class virus implements attack {
    public double size;
    public acidNucleic typeOfAcidNucleic;
    public capsid typeOfNucleocapsid;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public void attackCell() {

    }

    public virus(double size, acidNucleic typeOfAcidNucleic, capsid typeOfNucleocapsid) {
        this.size = size;
        this.typeOfAcidNucleic = typeOfAcidNucleic;
        this.typeOfNucleocapsid = typeOfNucleocapsid;
    }

    public acidNucleic getTypeOfAcidNucleic() {
        return typeOfAcidNucleic;
    }

    public void setTypeOfAcidNucleic(acidNucleic typeOfAcidNucleic) {
        this.typeOfAcidNucleic = typeOfAcidNucleic;
    }

    public capsid getTypeOfNucleocapsid() {
        return typeOfNucleocapsid;
    }

    public void setTypeOfNucleocapsid(capsid typeOfNucleocapsid) {
        this.typeOfNucleocapsid = typeOfNucleocapsid;
    }
}
