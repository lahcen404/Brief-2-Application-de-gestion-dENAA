public class Formateur extends Personne{
    private String specialite;
    private double salaire;
    private Classe classe;

    public Formateur(int id, String nom, String prenom, String email,String specialite,double salaire,Classe classe) {
        super(id, nom, prenom, email);
        this.specialite=specialite;
        this.salaire=salaire;
        this.classe=classe;
    }



    public String getSpecialite() {
        return specialite;
    }

    public double getSalaire() {
        return salaire;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setSpecialite(String specialite) {
        this.specialite=specialite;
    }
    public void setSalaire(double salaire){
        this.salaire=salaire;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }


@Override
    public String toString(){
        return super.toString() + " | specialite :" + specialite + " | salaire :" + salaire + " | classe :" + classe;
}


}
