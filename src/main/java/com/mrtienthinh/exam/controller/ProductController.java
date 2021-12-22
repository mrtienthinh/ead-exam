package com.mrtienthinh.exam.controller;

import com.mrtienthinh.exam.dto.ProductDto;
import com.mrtienthinh.exam.entity.ProductEntity;
import com.mrtienthinh.exam.service.SaleService;
import com.mrtienthinh.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    SaleService categoryService;

    @Autowired
    ProductService productService;


    @GetMapping("")
    public String viewIndexPage(Model model,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<ProductEntity> categoryPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", categoryPage);
        int totalPages = categoryPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "product";
    }

    @GetMapping("/new")
    public String viewCreatePage(Model model) {
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "create_or_edit_product";
    }

    @GetMapping("/edit/{id}")
    public String viewEditPage(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.getProductByID(id));
        model.addAttribute("categories", categoryService.getAllCategory());
        return "create_or_edit_product";
    }

    @PostMapping("/save")
    public String save(ProductEntity product, Model model) {
        if (product.getId() > 0) {
            productService.updateProduct(product);
        } else {
            productService.createProduct(product);
        }
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
}

