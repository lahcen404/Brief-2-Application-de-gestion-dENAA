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

        afficherMenuFormateur();
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

    private void gererClasses() {


            afficherMenuClasse();


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