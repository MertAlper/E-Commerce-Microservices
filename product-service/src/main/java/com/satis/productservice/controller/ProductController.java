package com.satis.productservice.controller;

import com.satis.productservice.Response.MessageResponse;
import com.satis.productservice.dto.CartDto;
import com.satis.productservice.dto.ProductDto;
import com.satis.productservice.dto.StockDto;
import com.satis.productservice.mapper.ProductMapper;
import com.satis.productservice.model.Product;
import com.satis.productservice.model.Stock;
import com.satis.productservice.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long productId) {
        Product product = productService.getById(productId);

        ProductDto productDto = productMapper.convertToProductDto(product);

        return ResponseEntity.ok().body(productDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<Product> products = productService.getAll();

        List<ProductDto> productDtoList = productMapper.convertToProductDtoList(products);

        return ResponseEntity.ok().body(productDtoList);
    }

//    @PostMapping("/cart")
//    public ResponseEntity<List<ProductDto>> getAllProductbyIds(@RequestBody CartDto cartDto) {
//
//        System.out.println(cartDto.getProductIds());
//        List<Product> products = productService.getAllProductsByIds(cartDto.getProductIds());
//
//        List<ProductDto> productDtoList = productMapper.convertToProductDtoList(products);
//
//        return ResponseEntity.ok().body(productDtoList);
//    }

    @PostMapping
    public ResponseEntity<MessageResponse> saveProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.convertToProduct(productDto);
        productService.save(product);

        MessageResponse response = new MessageResponse(String.format("Product %s created", product.getName()));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<MessageResponse> updateStock(@PathVariable long productId,
                                                       @RequestBody StockDto stockDto) {
        Product productInDb = productService.getById(productId);
        Stock stock = productInDb.getStock();
        stock.setQuantity(stock.getQuantity() - stockDto.getQuantity());

        productInDb.setStock(stock);

        productService.update(productInDb);

        MessageResponse response = new MessageResponse(String.format("Product quantity: %d", stock.getQuantity()));

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<MessageResponse> updateStock(@PathVariable long productId) {
        productService.delete(productId);

        MessageResponse response = new MessageResponse(String.format("Product id %d deleted", productId));

        return ResponseEntity.ok().body(response);
    }



}
