import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private static ArrayList<Apprenant> apprenants = new ArrayList<>();
    private ArrayList<Formateur> formateurs = new ArrayList<>();
    private ArrayList<Classe> classes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Application application = new Application();
        application.run();

    }

    public void run() {
        int choix;
        do {
            afficherMenu();
            try {
                choix = scanner.nextInt();
                scanner.nextLine();
                traiterChoix(choix);
            } catch (InputMismatchException e) {
                System.out.println("Erreur !!! entrer un nombre");
                scanner.nextLine();
                choix = -1;
            }
        } while (choix != 0);
        System.out.println("Good Bye!!!");
        scanner.close();
    }

    private void afficherMenu() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gerer les apprenants");
        System.out.println("2. Gerer les formateurs");
        System.out.println("3. Gerer les classes");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    private void traiterChoix(int choix) {
        switch (choix) {
            case 1:
                gererApprenants();
                break;
            case 2:
                gererFormateurs();
                break;
            case 3:
                gererClasses();
                break;
            case 0:
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }


    private void gererApprenants() {

        int choix;
        do {
            afficherMenuApprenant();
            try {
                choix = scanner.nextInt();
                scanner.nextLine();
                traiterChoixApprenant(choix);
            } catch (InputMismatchException e) {
                System.out.println("Erreur !!! entrer un nombre");
                scanner.nextLine();
                choix = -1;
            }
        } while (choix != 0);

    }

    private void afficherMenuApprenant() {
        System.out.println("\n--- Gestion des Apprenants ---");
        System.out.println("1. Ajouter un apprenant");
        System.out.println("2. Modifier un apprenant");
        System.out.println("3. Supprimer un apprenant");
        System.out.println("4. Afficher les apprenants");
        System.out.println("5. Associer un apprenant a une classe");
        System.out.println("0. Retour menu principal");
        System.out.print("Votre choix : ");
    }




    private void traiterChoixApprenant(int choix) {
        switch (choix) {
            case 1:
                ajouterApprenant();
                break;
            case 2:
                modifierApprenant();
                break;
            case 3:
                supprimerApprenant();
                break;
            case 4:
                afficherApprenants();
                break;
            case 5:
                break;
            case 0:
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }


    private void ajouterApprenant() {
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

            apprenants.add(newApprenant);
            System.out.println("Apprenant ajouter avec succees.");

        } catch (InputMismatchException e) {
            System.out.println("Erreur , entrer des donnees valides.");
            scanner.nextLine();
        }
    }

    private boolean apprenantExiste(int id) {
        for (Apprenant apprenant : apprenants) {
            if (apprenant.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void supprimerApprenant() {
        try {
            System.out.print("Entrez ID du apprenant pour supprimer : ");
            int idSupprimer = scanner.nextInt();
            scanner.nextLine();
            Apprenant apprenantASupprimer = null;
            for (Apprenant apprenant : apprenants) {
                if (apprenant.getId() == idSupprimer) {
                    apprenantASupprimer = apprenant;
                    break;
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Erreur , entrer un ID valide (un nombre entier).");
            scanner.nextLine();
        }
    }

    private void modifierApprenant() {

            afficherApprenants();
            System.out.println("\n");
        try {

            System.out.print("Entrez ID du Apprenant pour modifier : ");
            int idAModifier = scanner.nextInt();
            scanner.nextLine();

            Apprenant apprenantModifier = null;
            for (Apprenant apprenant : apprenants) {
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


            System.out.print("Classe  : ");
            String classeNom = scanner.nextLine();
            Classe classe = new Classe(classeNom, null);

            if (classe == null) {

                System.out.println("Classe Null");
            } else {
                System.out.println("Classe selectionnee : " + classe.getNom());
            }
            apprenantModifier.setClasse(classe);

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

    private void traiterChoixFormateur(int choix) {
        switch (choix) {
            case 1:
                ajouterFormateur();
                break;
            case 2:
                modifierFormateur();
                break;
            case 3:
                supprimerFormateur();
                break;
            case 4:
                afficherFormateurs();
                break;
            case 5:
                break;
            case 0:
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }


    private void traiterChoixClasse(int choix) {
        switch (choix) {
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:

                break;
            case 5:
                break;
            case 0:
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }



    private void gererFormateurs() {

        int choix;
        do {
            afficherMenuFormateur();
            try {
                choix = scanner.nextInt();
                scanner.nextLine();
                traiterChoixFormateur(choix);
            } catch (InputMismatchException e) {
                System.out.println("Erreur !!! entrer un nombre");
                scanner.nextLine();
                choix = -1;
            }
        } while (choix != 0);

    }






    private void afficherMenuFormateur() {
        System.out.println("\n--- Gestion des Formateurs ---");
        System.out.println("1. Ajouter un formateur");
        System.out.println("2. Modifier un formateur");
        System.out.println("3. Supprimer un formateur");
        System.out.println("4. Afficher les formateurs");
        System.out.println("5. Associer un formateur à une classe");
        System.out.println("0. Retour au menu principal");
        System.out.print("Votre choix : ");
    }


    private void ajouterFormateur() {
        try {
            System.out.println("Ajout d'un formateur:");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nom: ");
            String nom = scanner.nextLine();
            System.out.print("Prénom: ");
            String prenom = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Spécialité: ");
            String specialite = scanner.nextLine();
            System.out.print("Salaire: ");
            double salaire = scanner.nextDouble();
            scanner.nextLine();

            Formateur newFormateur = new Formateur(id, nom, prenom, email, specialite, salaire, null);
            formateurs.add(newFormateur);
            System.out.println("Formateur ajouter avec succes.");

        } catch (InputMismatchException e) {
            System.out.println("Erreur  entrer des donnees valides");
            scanner.nextLine();
        }
    }

    private void afficherApprenants() {
        if (apprenants.isEmpty()) {
            System.out.println("Aucun apprenant enregistreer.");
            return;
        }
        System.out.println("\n--- Liste des Apprenants ---");
        for (Apprenant apprenant : apprenants) {
            System.out.println(apprenant);
        }
    }

    private void afficherFormateurs() {
        if (formateurs.isEmpty()) {
            System.out.println("Aucun formateur enregistreer.");
            return;
        }

        System.out.println("\n--- Liste des Formateurs ---");
        for (Formateur formateur : formateurs) {
            System.out.println(formateur);
        }
    }

    private void supprimerFormateur() {
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

    private void modifierFormateur() {
        try {
            System.out.print("Entrez ID du formateur pour modifier : ");
            int idAModifier = scanner.nextInt();
            scanner.nextLine();

            Formateur formateurAModifier = null;
            for (Formateur formateur : formateurs) {
                if (formateur.getId() == idAModifier) {
                    formateurAModifier = formateur;
                    break;
                }
            }

            if (formateurAModifier == null) {
                System.out.println("Formateur non trouver.");
                return;
            }

            System.out.println("Entrez les nouvelles informations :");

            System.out.print("Nom  : ");
            String nom = scanner.nextLine();

                formateurAModifier.setNom(nom);


            System.out.print("Prenom  : ");
            String prenom = scanner.nextLine();

                formateurAModifier.setPrenom(prenom);


            System.out.print("Email  : ");
            String email = scanner.nextLine();

                formateurAModifier.setEmail(email);


            System.out.print("Specialiter  : ");
            String specialite = scanner.nextLine();

                formateurAModifier.setSpecialite(specialite);


            System.out.print("Salaire  : ");
            String salaireStr = scanner.nextLine();

                try {
                    double salaire = Double.parseDouble(salaireStr);
                    formateurAModifier.setSalaire(salaire);
                } catch (NumberFormatException e) {
                    System.out.println("Erreur, entrer un salaire valide (un nombre)");
                }


            System.out.println("Formateur modifier avec succes");

        } catch (InputMismatchException e) {
            System.out.println("Erreur  entrer un ID valide (un nombre )");
            scanner.nextLine();
        }
    }



    private void gererClasses() {

        int choix;
        do {
            afficherMenuClasse();
            try {
                choix = scanner.nextInt();
                scanner.nextLine();
                traiterChoixClasse(choix);
            } catch (InputMismatchException e) {
                System.out.println("Erreur !!! entrer un nombre");
                scanner.nextLine();
                choix = -1;
            }
        } while (choix != 0);

    }

    private void afficherMenuClasse() {
        System.out.println("\n--- Gestion des Classes ---");
        System.out.println("1. Créer une classe");
        System.out.println("2. Modifier une classe");
        System.out.println("3. Supprimer une classe");
        System.out.println("4. Afficher les détails d'une classe");
        System.out.println("5. Afficher toutes les classes");
        System.out.println("6. Ajouter un apprenant à une classe");
        System.out.println("7. Supprimer un apprenant d'une classe");
        System.out.println("0. Retour au menu principal");
        System.out.print("Votre choix : ");
    }




}