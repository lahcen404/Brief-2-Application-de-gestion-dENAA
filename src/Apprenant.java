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


   public void displayInfoApprenants(){

       System.out.println("Id : "+getId());
       System.out.println("Name : "+getNom());
       System.out.println("Prenom : "+getPrenom());
       System.out.println("Email : "+getEmail());
       System.out.println("Classe : "+getClasse());
       System.out.println("Note : "+getNotes());

   }



    @Override
    public String toString() {
       return super.toString() + "Classe :" + classe.getNom() + "Notes :"+notes;
    }


}
