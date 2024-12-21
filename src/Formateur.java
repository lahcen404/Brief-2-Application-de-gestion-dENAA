import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Formateur extends Personne{
    private String specialite;
    private double salaire;
    private Classe classe;

    Scanner scanner=new Scanner(System.in);
    private ArrayList<Formateur> formateurs = new ArrayList<>();

    public Formateur(int id, String nom, String prenom, String email,String specialite,double salaire,Classe classe) {
        super(id, nom, prenom, email);
        this.specialite=specialite;
        this.salaire=salaire;
        this.classe=classe;
    }

    public Formateur() {

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


    void ajouterFormateur() {
        try {
            System.out.println("Ajout d'un formateur:");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (formateurExiste(id)) {
                System.out.println("ID deja utiliser.");
                return;
            }

            System.out.print("Nom: ");
            String nom = scanner.nextLine();
            System.out.print("Prénom: ");
            String prenom = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Spécialité: ");
            String specialite = scanner.nextLine();
            try {
                System.out.print("Salaire: ");
                double salaire = scanner.nextDouble();
                scanner.nextLine();
            }catch (NumberFormatException e){
                System.out.println("Erreur , entrer un salaire valide (un nombre)");
            }
            Formateur newFormateur = new Formateur(id, nom, prenom, email, specialite, salaire, null);
            formateurs.add(newFormateur);
            System.out.println("Formateur ajouter avec succes.");

        } catch (InputMismatchException e) {
            System.out.println("Erreur  entrer des donnees valides");
            scanner.nextLine();
        }
    }

    private boolean formateurExiste(int id) {
        for (   Formateur formateur : formateurs) {
            if (formateur.getId() == id) {
                return true;
            }
        }
        return false;
    }


    void afficherFormateurs() {
        if (formateurs.isEmpty()) {
            System.out.println("Aucun formateur enregistreer.");
            return;
        }

        System.out.println("\n--- Liste des Formateurs ---");
        for (Formateur formateur : formateurs) {
            System.out.println(formateur);
        }
    }

    void supprimerFormateur() {
        try {
            System.out.print("Entrez ID du formateur pour supprimer : ");
            int idSupprimer = scanner.nextInt();
            scanner.nextLine();

            Formateur formateurASupprimer = null;
            for (Formateur formateur : formateurs) {
                if (formateur.getId() == idSupprimer) {
                    formateurASupprimer = formateur;
                    break;
                }
            }

            if (formateurASupprimer == null) {
                System.out.println("Formateur non trouver ");
            } else {
                formateurs.remove(formateurASupprimer);
                System.out.println("Formateur supprimeeer avec succes.");



            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur , entrer un ID valide (un nombre entier).");
            scanner.nextLine();
        }
    }

    void modifierFormateur() {
        try {
            System.out.print("Entrez ID du formateur pour modifier : ");
            int idModifier = scanner.nextInt();
            scanner.nextLine();

            Formateur formateurModifier = null;
            for (Formateur formateur : formateurs) {
                if (formateur.getId() == idModifier) {
                    formateurModifier = formateur;
                    break;
                }
            }

            if (formateurModifier == null) {
                System.out.println("Formateur non trouver.");
                return;
            }

            System.out.println("Entrez les nouvelles informations :");

            System.out.print("Nom  : ");
            String nom = scanner.nextLine();

            formateurModifier.setNom(nom);


            System.out.print("Prenom  : ");
            String prenom = scanner.nextLine();

            formateurModifier.setPrenom(prenom);


            System.out.print("Email  : ");
            String email = scanner.nextLine();

            formateurModifier.setEmail(email);


            System.out.print("Specialiter  : ");
            String specialite = scanner.nextLine();

            formateurModifier.setSpecialite(specialite);



            System.out.print("Salaire  : ");
            String salaireStr = scanner.nextLine();


                try {
                    double salaire = Double.parseDouble(salaireStr);
                    formateurModifier.setSalaire(salaire);
                } catch (NumberFormatException e) {
                    System.out.println("Erreur, entrer un salaire valide (un nombre)");
                }


            System.out.println("Formateur modifier avec succes");

        } catch (InputMismatchException e) {
            System.out.println("Erreur  entrer un ID valide (un nombre )");
            scanner.nextLine();
        }
    }

    public void RechercheFormateurs(){
        System.out.println("Entrer ID pour Recherche :");
        int IdRecherche = scanner.nextInt();

        for(Formateur formateur : formateurs){
            if(formateur.getId() == IdRecherche){
                System.out.println(formateur);
                return;
            }
            else{
                System.out.println("Apprenant non trouver");
            }
        }
    }


@Override
    public String toString(){
        return super.toString() + " | specialite :" + specialite + " | salaire :" + salaire + " | classe :" + classe;
}


}
