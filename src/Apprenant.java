import java.util.ArrayList;
import java.util.Scanner;

public class Apprenant extends Personne {
   private Classe classe ;
   ArrayList<Double> notes ;

   public Apprenant(int id,String nom,String prenom,String email,Classe classe){
        super(id,nom,prenom,email);
        this.classe=classe;
        this.notes= new ArrayList<>();

   }

    public Apprenant(int id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);
        this.classe = null;
        this.notes = new ArrayList<>();
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
        this.notes.add(note); // Now this will work!
    }




//    @Override
//    public String toString() {
//       return super.toString() + "Classe :" + classe.getNom() + "Notes :"+notes;
//    }

    @Override
    public String toString() {
        // Fix applied for null Classe handling
        String classeNom = (classe != null) ? classe.getNom() : "Aucune classe";
        return super.toString() + " | Classe: " + classeNom + " |Notes: " + notes;
    }

}
