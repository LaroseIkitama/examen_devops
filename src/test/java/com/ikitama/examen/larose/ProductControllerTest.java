package com.ikitama.examen.larose;

import com.ikitama.examen.larose.controller.ProductController;
import com.ikitama.examen.larose.domain.Product;
import com.ikitama.examen.larose.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateProduct() {
        System.out.println("Début du test testCreateProduct");

        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setPrice(10500.99);

        // Affichage des données créées
        System.out.println("Données créées : " + product);

        when(productService.createProduct(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = productController.createProduct(product);

        // Vérification des résultats attendus et réels
        System.out.println("Résultat attendu : " + HttpStatus.OK);
        System.out.println("Résultat réel : " + response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());

        verify(productService, times(1)).createProduct(any(Product.class));

        System.out.println("Fin du test testCreateProduct");
    }

    @Test
    public void testGetProducts() {
        System.out.println("Début du test testGetProducts");

        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Product 1");
        product1.setPrice(250.75);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Product 2");
        product2.setPrice(520.35);

        List<Product> productList = Arrays.asList(product1, product2);

        // Affichage des données créées
        System.out.println("Données créées : " + productList);

        when(productService.getProducts()).thenReturn(productList);

        ResponseEntity<List<Product>> response = productController.getProducts();

        // Vérification des résultats attendus et réels
        System.out.println("Résultat attendu : " + HttpStatus.OK);
        System.out.println("Résultat réel : " + response.getStatusCode());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productList, response.getBody());

        verify(productService, times(1)).getProducts();

        System.out.println("Fin du test testGetProducts");
    }
}
