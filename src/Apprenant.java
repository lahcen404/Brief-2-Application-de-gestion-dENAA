import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Apprenant extends Personne {



    private Classe classe ;
   ArrayList<Double> notes ;
    public static ArrayList<Apprenant> allApprenants = new ArrayList<>();  // Global list of all students

    Scanner scanner = new Scanner(System.in);

  // public Apprenant(int id,String nom,String prenom,String email,Classe classe){
//        super(id,nom,prenom,email);
//        this.classe=classe;
//        this.notes= new ArrayList<>();
//
//   }


    public Apprenant(int id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);
        this.classe = null;
        this.notes = new ArrayList<>();
    }

    public Apprenant() {
        super();
    }

    public Classe getClasse() {
        return classe;
    }
    public ArrayList<Double> getNotes(){
       return notes;
    }

    public void setClasse(Classe classe){
       this.classe=classe;
   }
   public void setNotes(ArrayList<Double> notes){
       this.notes= notes;
   }

    public void ajouterNote(double note) {
        this.notes.add(note);
    }


     void ajouterApprenant() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (apprenantExiste(id)) {
                System.out.println("ID deja utiliser.");
                return;
            }
            System.out.print("Nom: ");
            String nom = scanner.nextLine();
            System.out.print("Prenom: ");
            String prenom = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            Apprenant newApprenant = new Apprenant(id, nom, prenom, email);

            System.out.println("Ajouter des notes pour cet apprenant (entrer 'fin' pour terminer) :");
            String inputNote;
            while (true) {
                System.out.print("Note : ");
                inputNote = scanner.nextLine();
                if (inputNote.equalsIgnoreCase("fin")) {
                    break;
                }
                try {
                    double note = Double.parseDouble(inputNote);
                    newApprenant.ajouterNote(note);
                } catch (NumberFormatException e) {
                    System.out.println("Erreur , entrer un nombre valide ou 'fin' our terminer.");
                }
            }

            allApprenants.add(newApprenant);
            System.out.println("Apprenant ajouter avec succees.");

        } catch (InputMismatchException e) {
            System.out.println("Erreur , entrer des donnees valides.");
            scanner.nextLine();
        }
    }

     boolean apprenantExiste(int id) {
        for (Apprenant apprenant : allApprenants) {
            if (apprenant.getId() == id) {
                return true;
            }
        }
        return false;
    }

    void supprimerApprenant() {
        try {
            System.out.print("Entrez ID du apprenant pour supprimer : ");
            int idSupprimer = scanner.nextInt();
            scanner.nextLine();
            Apprenant apprenantASupprimer = null;
            for (Apprenant apprenant : allApprenants) {
                if (apprenant.getId() == idSupprimer) {
                    apprenantASupprimer = apprenant;
                    break;
                }
            }
                if (apprenantASupprimer == null) {
                    System.out.println("Apprenant non trouver ");
                } else {
                    allApprenants.remove(apprenantASupprimer);
                    System.out.println("Apprenant supprimeeer avec succes.");



                }

        }catch (InputMismatchException e){
            System.out.println("Erreur , entrer un ID valide (un nombre entier).");
            scanner.nextLine();
        }
    }


    void afficherApprenants() {
        if (allApprenants.isEmpty()) {
            System.out.println("Aucun apprenant enregistreer.");
            return;
        }
        System.out.println("\n--- Liste des Apprenants ---");
        for (Apprenant apprenant : allApprenants) {
            System.out.println(apprenant);
        }
    }



    void modifierApprenant() {

        afficherApprenants();
        System.out.println("\n");
        try {

            System.out.print("Entrez ID du Apprenant pour modifier : ");
            int idAModifier = scanner.nextInt();
            scanner.nextLine();

            Apprenant apprenantModifier = null;
            for (Apprenant apprenant : allApprenants) {
                if (apprenant.getId() == idAModifier) {
                    apprenantModifier = apprenant;
                    break;
                }
            }

            if (apprenantModifier == null) {
                System.out.println("apprenant non trouver.");
                return;
            }

            System.out.println("Entrez les nouvelles informations :");

            System.out.print("Nom  : ");
            String nom = scanner.nextLine();

            apprenantModifier.setNom(nom);


            System.out.print("Prenom  : ");
            String prenom = scanner.nextLine();

            apprenantModifier.setPrenom(prenom);


            System.out.print("Email  : ");
            String email = scanner.nextLine();

            apprenantModifier.setEmail(email);



            System.out.println("Ajouter des notes pour cet apprenant (tapez 'fin' pour terminer) :");
            apprenantModifier.setNotes(new ArrayList<>());

            while (true) {
                String inputNote = scanner.nextLine();

                if (inputNote.equalsIgnoreCase("fin")) {
                    break;
                }

                try {
                    double note = Double.parseDouble(inputNote);
                    apprenantModifier.ajouterNote(note);
                } catch (NumberFormatException e) {
                    System.out.println("Entree , entrer un nombre ou 'fin' pour terminer");
                }
            }

            System.out.println("Notes ajoutees avec succees !");



            System.out.println("Apprenant modifier avec succes");

        } catch (InputMismatchException e) {
            System.out.println("Erreur  entrer un ID valide (un nombre )");
            scanner.nextLine();
        }


    }


    public void RechercheApprenant(){
        System.out.println("Entrer ID pour Recherche :");
        int IdRecherche = scanner.nextInt();

        for(Apprenant apprenant : allApprenants){
            if(apprenant.getId() == IdRecherche){
                System.out.println(apprenant);
                return;
            }
            else{
                System.out.println("Apprenant non trouver");
            }
        }
    }


    @Override
    public String toString() {

        String classeNom = (classe != null) ? classe.getNom() : "Aucune classe";
        return super.toString() + " | Classe: " + classeNom + " |Notes: " + notes;
    }

}
