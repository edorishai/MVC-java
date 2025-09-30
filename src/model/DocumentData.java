package model;

public class DocumentData {
    private String titre; // ou lien
    private String texte;

    public DocumentData(String titre, String texte) {
        this.titre = titre;
        this.texte = texte;
    }

    public String getTitre() {
        return titre;
    }

    public String getTexte() {
        return texte;
    }
}
