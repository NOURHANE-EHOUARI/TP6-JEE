package controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import dao.Produit;
import services.ProduitMetier;

@Controller
public class ProduitController {

    @Autowired
    private ProduitMetier services;

    // ─── Page d'accueil ────────────────────────────────────────────────────────
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String pageIndex(Model model) {
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    // ─── Recherche par ID ──────────────────────────────────────────────────────
    @RequestMapping(value = "/searchProduct", method = RequestMethod.POST)
    public String searchProduct(Model model,
            @RequestParam(value = "idProduit") Long id) {
        List<Produit> liste = new ArrayList<>();
        Produit p = services.getProduitById(id);
        if (p != null) liste.add(p);
        model.addAttribute("listeProduit", liste);
        model.addAttribute("idProduit", id);
        return "produits";
    }

    // ─── Ajout d'un produit ────────────────────────────────────────────────────
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Model model, Produit p) {
        services.addProduit(p);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    // ─── Suppression d'un produit ──────────────────────────────────────────────
    @RequestMapping(value = "/deleteProduit", method = RequestMethod.GET)
    public String supprimerProduit(Model model, @RequestParam Long id) {
        services.deleteProduit(id);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    // ─── Chargement du formulaire de modification ──────────────────────────────
    @RequestMapping(value = "/editProduit", method = RequestMethod.GET)
    public String editProduit(Model model, @RequestParam Long id) {
        Produit p = services.getProduitById(id);
        model.addAttribute("produitEdit", p);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    // ─── Mise à jour d'un produit ──────────────────────────────────────────────
    @RequestMapping(value = "/updateProduit", method = RequestMethod.POST)
    public String updateProduit(Model model,
            @RequestParam Long idProduit,
            @RequestParam String nom,
            @RequestParam String description,
            @RequestParam Double prix) {
        Produit p = new Produit();
        p.setIdProduit(idProduit);
        p.setNom(nom);
        p.setDescription(description);
        p.setPrix(prix);
        services.updateProduit(p);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }
}