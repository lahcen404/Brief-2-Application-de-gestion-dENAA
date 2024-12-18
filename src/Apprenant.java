import java.util.ArrayList;
import java.util.Scanner;

public class Apprenant extends Personne {
   private Classe classe ;
   ArrayList<Double> notes ;

   public Apprenant(int id,String nom,String prenom,String email,Classe classe,ArrayList<Double> notes){
        super(id,nom,prenom,email);
        this.classe=classe;
        this.notes= new ArrayList<>(notes);

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

   @Override
   public void displayInfoApprenants(){

       System.out.println("Id : "+getId());
       System.out.println("Name : "+getNom());
       System.out.println("Prenom : "+getPrenom());
       System.out.println("Email : "+getEmail());
       System.out.println("Classe : "+getClasse());
       System.out.println("Note : "+getNotes());

   }

//    public static void addApprenant(){
//        Scanner sc=new Scanner(System.in);
//        ArrayList<Personne> personnes = new ArrayList<>();
//
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




    @Override
    public void displayInfoFormateurs() {

    }
}
