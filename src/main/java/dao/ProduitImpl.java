package dao;

import java.util.ArrayList;
import java.util.List;

public class ProduitImpl implements ProduitDAO {

    private List<Produit> produits = new ArrayList<>();

    public void init() {
        System.out.println("Spring IOC est bien fonctionnee !");
        addProduit(new Produit("PC 1", "Sony vaio 1", 7000.0));
        addProduit(new Produit("PC 2", "Sony vaio 2", 6000.0));
        addProduit(new Produit("PC 3", "Sony vaio 3", 4000.0));
        addProduit(new Produit("PC 4", "Sony vaio 4", 9000.0));
        addProduit(new Produit("PC 5", "Sony vaio 5", 8000.0));
        addProduit(new Produit("PC 6", "Sony vaio 6", 5000.0));
        addProduit(new Produit("PC 7", "Sony vaio 7", 3000.0));
    }

    public void addProduit(Produit p) {
        p.setIdProduit((long) (produits.size() + 1));
        produits.add(p);
    }

    public void deleteProduit(Long id) {
        produits.remove(getProduitById(id));
    }

    public Produit getProduitById(Long id) {
        for (Produit p : produits) {
            if (p.getIdProduit().equals(id)) return p;
        }
        return null;
    }

    public List<Produit> getAllProduits() {
        return produits;
    }

    public void updateProduit(Produit p) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getIdProduit().equals(p.getIdProduit())) {
                produits.get(i).setNom(p.getNom());
                produits.get(i).setDescription(p.getDescription());
                produits.get(i).setPrix(p.getPrix());
                break;
            }
        }
    }
}