package com.elevenparis.projeto.Services;

import com.elevenparis.projeto.Entity.Checkout;
import com.elevenparis.projeto.Repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {
    private final CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutService(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    public List<Checkout> getAllCheckouts() {
        return checkoutRepository.findAll();
    }

    public Checkout getCheckoutById(Long id) {
        return checkoutRepository.findById(id).orElse(null);
    }

    public Checkout createCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    public Checkout updateCheckout(Long id, Checkout newCheckout) {
        Checkout existingCheckout = checkoutRepository.findById(id).orElse(null);
        if (existingCheckout != null) {
            return checkoutRepository.save(existingCheckout);
        }
        return null;
    }

    public void deleteCheckout(Long id) {
        checkoutRepository.deleteById(id);
    }
}
