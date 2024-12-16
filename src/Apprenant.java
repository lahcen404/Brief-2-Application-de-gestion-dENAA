import java.util.ArrayList;

public class Apprenant extends Personne {
   Classe classe ;
   ArrayList<Double> notes ;

   public Apprenant(int id,String nom,String prenom,String email,Classe classe){
        super(id,nom,prenom,email);
        this.classe=classe;
        this.notes= new ArrayList<Double>();

   }

    public Classe getClasse() {
        return classe;
    }
    public ArrayList<Double> getNotes(){
       return notes;
    }

    public void setClasse(){
       this.classe=classe;
   }
   public void setNotes(){
       this.notes= new ArrayList<Double>();
   }
}
