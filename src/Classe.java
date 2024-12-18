import java.util.ArrayList;

public class Classe {
String nom;
Formateur formateur;
ArrayList <Apprenant> apprenants;
    public Classe(String nom, Formateur formateur, ArrayList<Apprenant> apprenants){
        this.nom=nom;
        this.formateur= formateur;
        this.apprenants=new ArrayList<>();
}
    public Classe(String nom, Formateur formateur){
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

    public void displayInfoClasses(){


        System.out.println("Name : "+getNom());
        System.out.println("Apprenants : "+getApprenants());
        System.out.println("Formateur : "+getFormateur());


    }
    @Override
    public String toString() {
        return  nom;
    }


    public void ajouterApprenant(Apprenant newApprenant) {
    }
}
