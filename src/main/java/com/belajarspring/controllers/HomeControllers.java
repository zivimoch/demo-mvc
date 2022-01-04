package com.belajarspring.controllers;

import com.belajarspring.dto.SearchFormData;
import com.belajarspring.entity.Product;
import com.belajarspring.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeControllers {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String welcome(Model model){
        String message = "Hallo madafaka!";
        model.addAttribute("msg", message);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("products", productService.findAll());
        return "index";
    }
    
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/save")
    public String save(Product product, Model model){
        productService.addProduct(product);

        String message = "Hallo madafaka!";
        model.addAttribute("msg", message);
        model.addAttribute("products", productService.findAll());

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, Model model){
        productService.updateProduct(product);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(SearchFormData searchFormData, Model model){
        String message = "Hallo madafaka!";
        model.addAttribute("msg", message);
        model.addAttribute("searchForm", searchFormData);
        model.addAttribute("products", productService.findByName(searchFormData.getKeyword()));
        return "index";
    }
}
