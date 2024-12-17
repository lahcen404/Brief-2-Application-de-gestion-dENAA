import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         ArrayList<Personne> personnes = new ArrayList<>();
         ArrayList<Formateur> formateurs = new ArrayList<>();
         ArrayList<Classe> classes = new ArrayList<>();

        Classe classe1 = new Classe();
        ArrayList<Double> notes1 = new ArrayList<>();
        notes1.add(12.0);


        Apprenant student1 = new Apprenant(1, "Lahcen", "Maskour", "Lahcen.maskour@gmail.com",classe1,notes1);
        Apprenant student2 = new Apprenant(2, "saaaaaad", "mansooor", "sasad.mansssor@gmail.com", classe1,notes1 );

        Formateur formateur1 = new Formateur(1, "Ahmed", "Mamo", "Email@email.com", "Java EE", 20000, classe1);


//        System.out.println(student1.getId());
//        System.out.println(student1.getNom());
//        System.out.println(student1.getPrenom());
//        System.out.println(student1.getEmail());
//        System.out.println(student1.getClasse());
//        System.out.println(student1.getNotes());

        Apprenant.addApprenant(personnes);

        personnes.add(student1);
        personnes.add(student2);
        formateurs.add(formateur1);
//        personnes.remove(student1);

//                System.out.println("----------77");
//                student1.displayInfoApprenants();
//                student2.displayInfoApprenants();

            for(Personne personne:personnes){
                personne.displayInfoApprenants();
                System.out.println("----------");
            }

//


   }


//    public static void addApprenant(Scanner sc){
//        System.out.println("Add an Apprenant : \n");
//        System.out.println("-------------------------- \n");
//        System.out.println("Add ID : \n");
//        int id = sc.nextInt();
//        sc.nextLine();
//        System.out.println("Add First Name : \n");
//        String nom=sc.nextLine();
//        System.out.println("Add Second Name : \n");
//        String prenom=sc.nextLine();
//        System.out.println("Add Email : \n");
//        String email=sc.nextLine();
//        System.out.println("Add Classe : \n");
//        String classe=sc.nextLine();
//        System.out.println("Add Note  : \n");
//        double note=sc.nextDouble();
//        Apprenant apprenant = new Apprenant(id,nom,prenom,email,classe,note);
//        personnes.add(apprenant);
//        System.out.println("Apprenant created Succesfully \n");
//
//    }

    }