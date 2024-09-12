package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CommandeModel;
import com.example.demo.Model.ContenueModel;
import com.example.demo.Model.Dashboard.MonthTotalEntry;
import com.example.demo.Model.Dashboard.Topplat;
import com.example.demo.Repository.ContenueRepository;

@Service
public class DashboardService {

  @Autowired
  private ContenueRepository contenueRepository;

  public List<MonthTotalEntry> Contenue6mois() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, -5);
    Date startDate = calendar.getTime();

    return calculerTotalParMois(contenueRepository.findByQte(startDate));
  }

  public List<Topplat> findTop10Plats() {
    Pageable topTen = PageRequest.of(0, 10);
    return contenueRepository.findTop10Plats(topTen);
  }

  public int SommeTotal() {
    List<ContenueModel> contenues = contenueRepository.findAll();
    int total = 0;
    for (ContenueModel contenu : contenues) {
      total += contenu.getQte() * contenu.getMenu().getPu();
    }
    return total;
  }

  public static List<MonthTotalEntry> calculerTotalParMois(List<CommandeModel> commandes) {
    List<MonthTotalEntry> totalParMois = new ArrayList<>();

    // Initialiser les six derniers mois avec 0
    Calendar calendar = Calendar.getInstance();
    for (int i = 5; i >= 0; i--) {
      calendar.add(Calendar.MONTH, -i);
      String mois = getMonthName(calendar.get(Calendar.MONTH));
      totalParMois.add(new MonthTotalEntry(mois, 0));
      calendar.add(Calendar.MONTH, i); // Revenir au mois actuel
    }

    // Parcourir les commandes et ajouter les totaux
    for (CommandeModel commande : commandes) {
      calendar.setTime(commande.getDatecom());
      String mois = getMonthName(calendar.get(Calendar.MONTH));
      int total = 0;

      for (ContenueModel entry : commande.getContenue()) {
        total += entry.getQte() * entry.getMenu().getPu();
      }
      // Mettre à jour le total correspondant au mois
      for (MonthTotalEntry entry : totalParMois) {
        if (entry.getMois().equals(mois)) {
          entry.setRecette(entry.getRecette() + total);
          break;
        }
      }
    }

    return totalParMois;
  }

  private static String getMonthName(int month) {
    String[] months = {
        "Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
        "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"
    };
    return months[month];
  }
}
