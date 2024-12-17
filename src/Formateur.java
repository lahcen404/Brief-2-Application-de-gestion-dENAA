public class Formateur extends Personne{
    private String specialite;
    private double salaire;
    private Classe classe;

    public Formateur(int id, String nom, String prenom, String email,String specialite,double salaire,Classe classe) {
        super(id, nom, prenom, email);
        this.specialite=specialite;
        this.salaire=salaire;
        this.classe=classe;
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

    @Override
    public void displayInfoApprenants() {

    }
    @Override
    public void displayInfoFormateurs(){

        System.out.println("Id : "+getId());
        System.out.println("Name : "+getNom());
        System.out.println("Prenom : "+getPrenom());
        System.out.println("Email : "+getEmail());
        System.out.println("Classe : "+getClasse());
        System.out.println("Specialite : "+getSpecialite());
        System.out.println("Salaire : "+getSalaire());

    }
}
