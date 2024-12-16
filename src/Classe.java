import java.util.ArrayList;

public class Classe {
String nom;
Formateur formateur;
ArrayList <Apprenant> apprenants;
    public Classe(){
        this.nom=nom;
        this.formateur= formateur;
        this.apprenants=new ArrayList<>();
}


    public String getNom() {
        return nom;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public ArrayList<Apprenant> getApprenants() {
        return apprenants;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public void setApprenants(ArrayList<Apprenant> apprenants) {
        this.apprenants = apprenants;
    }
}
