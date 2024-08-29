package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable long id) {
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger) {
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable int price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType) {
        return burgerDao.findByBreadType(BreadType.valueOf(breadType));
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent (@PathVariable String content) {
        return burgerDao.findByContent(content);
    }


}