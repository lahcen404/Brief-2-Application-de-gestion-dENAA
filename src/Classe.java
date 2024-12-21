import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Classe {
    private int id;
    private String nom;
    private Formateur formateur;
    private ArrayList<Apprenant> apprenants = new ArrayList<>();


    ArrayList<Classe> classes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Constructors
    public Classe() {

    }

    public Classe(int id, String nom, Formateur formateur, Apprenant apprenant) {
        this.id = id;
        this.nom = nom;
        this.formateur = formateur;
    }

    public Classe(int id, String nom, Formateur formateur, ArrayList<Apprenant> apprenants) {
        this.id = id;
        this.nom = nom;
        this.formateur = formateur;
        this.apprenants = new ArrayList<>();
    }


    public void ajouterClasse() {
        System.out.print("Enter Class ID: ");
        int id = lireChoix();
        if (idClasseExiste(id)) {
            System.out.println("ID deja utilise.");
            return;
        }
        scanner.nextLine();
        System.out.print("Nom du Classe: ");
        String nom = scanner.nextLine();
        if (NomClasseExiste(nom)) {
            System.out.println("Nom deja utiliser.");

        }
        Classe newClasse = new Classe(id, nom, null , new ArrayList<>());
        classes.add(newClasse);
        System.out.println("Classe ajouter avec succes.");

    }

    boolean NomClasseExiste(String nom){
        for(Classe classe : classes){
            if (classe.getNom().equals(nom)){
                return true;
            }
        }return false;
    }


    public boolean idClasseExiste(int id) {
        for (Classe classe : classes) {
            if (classe.getId() == id) {
                return true;
            }
        }
        return false;
    }





    private Classe trouverClasseParId(int id) {
        for (Classe classe : classes) {
            if (classe.getId() == id) {
                return classe;
            }
        }
        return null;
    }

    private int lireChoix() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erreur, entrer un nombre entier");
                scanner.nextLine();
            }
        }
    }


    public void supprimerClasse() {
        System.out.print("Entrez ID de la classe à supprimer : ");
        int idSupprimer = lireChoix();
        Classe classeASupprimer = trouverClasseParId(idSupprimer);
        if (classeASupprimer == null) {
            System.out.println("Classe non trouvee");
        } else {
            classes.remove(classeASupprimer);
            System.out.println("Classe supprimee avec succees");
        }
    }


    public void modifierClasse() {
        if (classes.isEmpty()) {
            System.out.println("Aucune classe enregistree.");
            return;
        }

        afficherClasses();
        System.out.print("Entrez ID de la classe a modifier : ");
        int idAModifier = lireChoix();
        Classe classeAModifier = trouverClasseParId(idAModifier);

        if (classeAModifier == null) {
            System.out.println("Classe non trouvee");
            return;
        }

        System.out.print("Nouveau nom de la classe : ");
        scanner.nextLine();
        String nouveauNom = scanner.nextLine();

        classeAModifier.setNom(nouveauNom);
        System.out.println("Classe modifiee avec succes");
    }


    public void afficherClasses() {
        if (classes.isEmpty()) {
            System.out.println("Aucune classe enregistree");
            return;
        }
        System.out.println("\n--- Liste des Classes ---");
        for (Classe classe : classes) {
            System.out.println(classe);
        }
    }


//    public void associerApprenant() {
//        System.out.print("Entrez l'ID de l'apprenant à associer à la classe: ");
//        int apprenantId = lireChoix();
//        scanner.nextLine();
//
//
//        Apprenant apprenant = findApprenantById(apprenantId);
//        if (apprenant != null) {
//            ajouterApprenant(apprenant);
//            System.out.println("Apprenant associé à la classe avec succès !");
//        } else {
//            System.out.println("Apprenant non trouvé.");
//        }
//    }


//    private Apprenant findApprenantById(int id) {
//        for (Apprenant apprenant : Apprenant.allApprenants) { // Global search
//            if (apprenant.getId() == id) {
//                return apprenant;
//            }
//        }
//        return null;
//    }

    public void RechercheClasse() {
        System.out.println("Entrer ID pour Recherche :");
        int IdRecherche = scanner.nextInt();

        for (Classe classe : classes) {
            if (classe.getId() == IdRecherche) {
                System.out.println(classe);
                return;
            } else {
                System.out.println("Classe non trouver");
            }
        }
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public ArrayList<Apprenant> getApprenants() {
        return apprenants;
    }

    public void setApprenants(ArrayList<Apprenant> apprenants) {
        this.apprenants =  new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Classe ID: " + id +
                " | Nom: " + nom +
                " | Formateur: " + (formateur != null ? formateur.getNom() : "Aucun") +
                " | Nombre d'Apprenants: " + apprenants.size();
    }
}