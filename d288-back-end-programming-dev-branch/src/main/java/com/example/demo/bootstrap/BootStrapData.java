package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;


    }

    @Override
    public void run(String... args) throws Exception {

        Division Utahhh = new Division();
        Utahhh.setCountry_id(1l);
        Utahhh.setDivision_name("Utah Division");

        Division savedUtah = divisionRepository.save(Utahhh);

        Customer gene = new Customer("Gene", "McDonald", "223 Bealy St", "13456", "555-444-2355", Utahhh);
        Customer fred = new Customer("Fred", "McSampson", "523 Juniper Dr", "13458", "555-444-2321", Utahhh);
        Customer sam = new Customer("Sam", "McKight", "246 Lincdon Ct", "13457", "555-444-2455", Utahhh);
        Customer utah = new Customer("Utah", "McJackson", "823 Nockerton Ave", "13455", "555-884-2322", Utahhh);
        Customer sarah = new Customer("Sarah", "McAveralicka", "2778 Jumpme ln", "13454", "555-994-2992", Utahhh);


        savedUtah.add(gene);
        savedUtah.add(fred);
        savedUtah.add(sam);
        savedUtah.add(utah);
        savedUtah.add(sarah);

        customerRepository.save(gene);
        customerRepository.save(fred);
        customerRepository.save(sam);
        customerRepository.save(utah);
        customerRepository.save(sarah);

        System.out.println("Number of divisions: " + divisionRepository.count());
        System.out.println("Number of customers: " + customerRepository.count());

    }
}
