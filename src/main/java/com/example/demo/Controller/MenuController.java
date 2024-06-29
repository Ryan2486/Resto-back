package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.MenuModel;
import com.example.demo.Service.MenuService;

import jakarta.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<MenuModel> getAllMenus() {
        return menuService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuModel> getMenuById(@PathVariable String id) {
        Optional<MenuModel> menuModel = menuService.findById(id);
        return menuModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MenuModel createMenu(@RequestBody MenuModel menuModel) {
        if (menuService.findById(menuModel.getIdplat()) == null) {
            throw new EntityExistsException("Le menu N°" + menuModel.getIdplat() + " existe déjà ");
        }
        return menuService.save(menuModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuModel> updateMenu(@PathVariable String id, @RequestBody MenuModel menuModel) {
        Optional<MenuModel> existingMenu = menuService.findById(id);
        if (existingMenu.isPresent()) {
            MenuModel updatedMenu = existingMenu.get();
            updatedMenu.setNomplat(menuModel.getNomplat());
            updatedMenu.setPu(menuModel.getPu());
            return ResponseEntity.ok(menuService.save(updatedMenu));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable String id) {
        System.out.println(("hello"));
        if (menuService.findById(id).isPresent()) {
            menuService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
