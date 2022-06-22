package modele;

public class Livre {

    private int id;
    private String titre;
    private String auteur;
    private int annee;
    private String resume;
    private String commentaire;
    private String dateLecture;

    public Livre() {
    }

    public Livre(String titre, String auteur, int annee, String resume, String commentaire, String dateLecture) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.resume = resume;
        this.commentaire = commentaire;
        this.dateLecture = dateLecture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(String dateLecture) {
        this.dateLecture = dateLecture;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", annee=" + annee +
                ", resume='" + resume + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", dateLecture='" + dateLecture + '\'' +
                '}';
    }
}
