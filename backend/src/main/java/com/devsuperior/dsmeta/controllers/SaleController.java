package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;

import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //
@RequestMapping(value = "/sales") // Mapeando o Controller
public class SaleController {
    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;

    @GetMapping("/findSales")
    public List<Sale> findSales() {
        return service.findSales();
    }

    @GetMapping("/findSalesPage") //Exemplo Pageable
    public Page<Sale> findSalesPage(Pageable pageable) {
        return service.findSalesPage(pageable);
        // Retornando com Exemplo com Page
    }

    @GetMapping("/findSalesDate")
    public Page<Sale> findSalesDate(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                    @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                    Pageable pageable) {
        return service.findSalesDate(minDate, maxDate, pageable);
    }
    @GetMapping("/notification")
    public void notifySms() {
        smsService.sendSms();
    }

    @GetMapping("/{id}/notificationID")
    public  void notifySmsID(@PathVariable Long id){
        smsService.sendSmsID(id);
    }

    @GetMapping("/{id}/notificationInfo")
    public  void notifySmsInfo(@PathVariable Long id){
        smsService.sendSmsInfo(id);
    }

}
