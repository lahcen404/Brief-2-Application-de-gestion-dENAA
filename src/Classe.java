import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
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



    void ajouterClasse() {

            System.out.print("Nom du Classe: ");
            String nom = scanner.nextLine();
            scanner.nextLine();
            if (NomClasseExiste(nom)) {
                System.out.println("Nom deja utiliser.");

            }
            Classe newClasse = new Classe(nom, null);
                classes.add(newClasse);
                System.out.println("Classe ajouter avec succes.");

        }

        boolean NomClasseExiste(String nom){
        for(Classe classe : classes){
            if (classe.getNom().equals(this.nom)){
                return true;
            }
        }return false;
        }

        void supprimerClasse() {
            try {
                System.out.print("Entrez Nom du Classe pour supprimer : ");
                String NomSupprimer = scanner.nextLine();

                Classe classeASupprimer = null;
                for (Classe classe : classes) {
                    if (Objects.equals(classe.getNom(), NomSupprimer)) {
                        classeASupprimer = classe;
                        break;
                    }
                }
                if (classeASupprimer == null) {
                    System.out.println("Apprenant non trouver ");
                } else {
                    classes.remove(classeASupprimer);
                    System.out.println("Apprenant supprimeeer avec succes.");

                }

            }catch (InputMismatchException e){
                System.out.println("Erreur , entrer un ID valide (un nombre entier).");
                scanner.nextLine();
            }
        }

        void afficherClasses() {
        if (classes.isEmpty()) {
            System.out.println("Aucun classe !!");
            return;
        }
        System.out.println("\n--- Liste des Classes ---");
        for (Classe classe : classes){
            System.out.println(classe);
        }
        }

    public void RechercheClasse(){
        System.out.println("Entrer Name Classe pour Recherche :");
        String NameRecherche = scanner.nextLine();

        for(Classe classe : classes){
            if(classe.getNom().equals(NameRecherche)){
                System.out.println(classe);

            }
            else{
                System.out.println("Classe non trouver");
            }
        }
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


    @Override
    public String toString() {
        return "Classe :"+ nom + " | Formateur :" + formateur + " | Apprenants :" + apprenants;
    }



    }



