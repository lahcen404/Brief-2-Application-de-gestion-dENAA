import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Classe {
    private String nom;
    private Formateur formateur;

    Scanner scanner = new Scanner(System.in);
    private ArrayList <Apprenant> apprenants;

    ArrayList<Classe> classes = new ArrayList<>();
    public Classe(String nom, Formateur formateur, ArrayList<Apprenant> apprenants){
        this.nom=nom;
        this.formateur= formateur;
        this.apprenants=new ArrayList<>();


}
public Classe() {

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
        return "Classe :"+ nom + "Formateur :" + formateur + "Apprenants :" + apprenants;
    }



    }



