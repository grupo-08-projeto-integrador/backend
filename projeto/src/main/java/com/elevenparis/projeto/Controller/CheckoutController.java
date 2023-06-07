package com.elevenparis.projeto.Controller;

import com.elevenparis.projeto.Entity.Checkout;
import com.elevenparis.projeto.Repository.CheckoutRepository;
import com.elevenparis.projeto.Services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/checkouts")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping
    public ResponseEntity<List<Checkout>> findAll() {
        List<Checkout> checkouts = checkoutService.getAllCheckouts();
        if (checkouts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(checkouts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checkout> getCheckoutById(@PathVariable Long id) {
        Checkout checkout = checkoutService.getCheckoutById(id);
        if (checkout != null) {
            return ResponseEntity.ok(checkout);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Checkout> createCheckout(@RequestBody Checkout checkout) {
        Checkout createdCheckout = checkoutService.createCheckout(checkout);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCheckout);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checkout> updateCheckout(@PathVariable Long id, @RequestBody Checkout checkout) {
        Checkout updatedCheckout = checkoutService.updateCheckout(id, checkout);
        if (updatedCheckout != null) {
            return ResponseEntity.ok(updatedCheckout);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckout(@PathVariable Long id) {
        Checkout existingCheckout = checkoutService.getCheckoutById(id);
        if (existingCheckout != null) {
            checkoutService.deleteCheckout(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
