package com.example.demo.Controllers;


import com.example.demo.Repository.*;
import com.example.demo.models.*;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class MainController {




    private final PersonRepository personRepository;
    private final EmployeeRepository employeeRepository;
    private final InventoryRepository inventoryRepository;
    private final PromotionRepository promotionRepository;
    private final ReviewsRepository reviewsRepository;





    @GetMapping("/")
    public String mainPage(){
        return "MainPAge";
    }
    @Autowired
    public MainController(PersonRepository personRepository, EmployeeRepository employeeRepository, InventoryRepository inventoryRepository, PromotionRepository promotionRepository, ReviewsRepository reviewsRepository){
        this.personRepository = personRepository;
        this.employeeRepository = employeeRepository;
        this.inventoryRepository = inventoryRepository;
        this.promotionRepository = promotionRepository;
        this.reviewsRepository = reviewsRepository;
    }




    @GetMapping("/Persons")
    public String Persons(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "Persons";
    }

    @PostMapping("/addPerson")
    public String addOrder(@RequestParam("username") String username,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password) {
        int id = 0;
        Person person = new Person(id, username, email, password);
        personRepository.save(person);
        return "redirect:/Persons";
    }

    @GetMapping("/editPerson/{id}")
    public String editPersonForm(@PathVariable int id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("person", person);
        return "editPerson";
    }

    @PostMapping("/editPerson/{id}")
    public String editPerson(@PathVariable("id") int id, @Valid Person person, BindingResult result, Model model) {
        person.setId(id);
        personRepository.save(person);
        return "redirect:/Persons";
    }

    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable int id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        personRepository.delete(person);
        return "redirect:/Persons";
    }

    @GetMapping("/inventoryPage")
    public String Inventory(Model model) {
        model.addAttribute("inventory", inventoryRepository.findAll());
        return "InventoryPage";
    }

    @PostMapping("/addInventory")
    public String addInventory(@RequestParam("name") String name,
                               @RequestParam("type") String type,
                               @RequestParam("bladelength") String bladelength,
                               @RequestParam("price") String price) {
        int id = 0;
        Inventory inventory = new Inventory(id, name, type, bladelength, price);
        inventoryRepository.save(inventory);
        return "redirect:/inventoryPage";
    }

    @GetMapping("/editInventory/{id}")
    public String editInventoryForm(@PathVariable int id, Model model) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid inventory Id:" + id));
        model.addAttribute("inventory", inventory);
        return "editInventory";
    }

    @PostMapping("/editInventory/{id}")
    public String editInventory(@PathVariable("id") int id, @Valid Inventory inventory, BindingResult result, Model model) {
        inventory.setId(id);
        inventoryRepository.save(inventory);
        return "redirect:/inventoryPage";
    }

    @GetMapping("/deleteInventory/{id}")
    public String deleteInventory(@PathVariable int id) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid inv Id:" + id));
        inventoryRepository.delete(inventory);
        return "redirect:/inventoryPage";
    }

    @GetMapping("/employee")
    public String Employee(Model model) {
        model.addAttribute("employee", employeeRepository.findAll());
        return "employee";
    }

    @PostMapping("/addpemployee")
    public String addemp(@RequestParam("name") String name,
                         @RequestParam("dolznost") String dolznost,
                         @RequestParam("zp") String zp,
                         @RequestParam("premiya") String premiya) {
        int id = 0;
        Employee employee = new Employee(id, name, dolznost, zp, premiya);
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/editemployee/{id}")
    public String editemployee(@PathVariable int id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid emp Id:" + id));
        model.addAttribute("employee", employee);
        return "editemployee";
    }

    @PostMapping("/editemployee/{id}")
    public String editemployee(@PathVariable("id") int id, @Valid Employee employee, BindingResult result, Model model) {
        employee.setId(id);
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/deleteemployee/{id}")
    public String deleteemployee(@PathVariable int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid emp Id:" + id));
        employeeRepository.delete(employee);
        return "redirect:/employee";
    }

    @PostMapping("/Search")
    public ModelAndView PersonSearch(@RequestParam String username, Model model){
        ModelAndView modelview = new ModelAndView("/Search");
        modelview.addObject("username", personRepository.findUserBySurname(username));
        return  modelview;
    }

    @GetMapping("/reviews")
    public String Reviews(Model model) {
        model.addAttribute("reviews", reviewsRepository.findAll());
        return "reviews";
    }

    @PostMapping("/addreviews")
    public String addOrder(@RequestParam("namecut") String namecut,
                           @RequestParam("clientname") String clientname,
                           @RequestParam("raiting") String raiting,
                           @RequestParam("comment") String comment) {
        int id = 0;
        Reviews reviews = new Reviews(id, namecut, clientname, raiting, comment);
        reviewsRepository.save(reviews);
        return "redirect:/reviews";
    }

    @GetMapping("/editreviews/{id}")
    public String editreviews(@PathVariable int id, Model model) {
        Reviews reviews = reviewsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("reviews", reviews);
        return "editreviews";
    }

    @PostMapping("/editreviews/{id}")
    public String editreviews(@PathVariable("id") int id, @Valid Reviews reviews, BindingResult result, Model model) {
        reviews.setId(id);
        reviewsRepository.save(reviews);
        return "redirect:/reviews";
    }

    @GetMapping("/deletereviews/{id}")
    public String deletereviews(@PathVariable int id) {
        Reviews reviews = reviewsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        reviewsRepository.delete(reviews);
        return "redirect:/reviews";
    }

    @GetMapping("/promotion")
    public String Promotion(Model model) {
        model.addAttribute("promotion", promotionRepository.findAll());
        return "promotion";
    }

    @PostMapping("/addpromotion")
    public String addpromotion(@RequestParam("promotionname") String promotionname,
                           @RequestParam("promotiontime") String promotiontime,
                           @RequestParam("conditions") String conditions,
                           @RequestParam("pronocode") String pronocode) {
        int id = 0;
        Promotion promotion = new Promotion(id, promotionname, promotiontime, conditions, pronocode);
        promotionRepository.save(promotion);
        return "redirect:/promotion";
    }

    @GetMapping("/editpromotion/{id}")
    public String editpromotion(@PathVariable int id, Model model) {
        Promotion promotion = promotionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("promotion", promotion);
        return "editpromotion";
    }

    @PostMapping("/editpromotion/{id}")
    public String editreviews(@PathVariable("id") int id, @Valid Promotion promotion, BindingResult result, Model model) {
        promotion.setId(id);
        promotionRepository.save(promotion);
        return "redirect:/promotion";
    }

    @GetMapping("/deletepromotion/{id}")
    public String deletepromotion(@PathVariable int id) {
        Promotion promotion = promotionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        promotionRepository.delete(promotion);
        return "redirect:/promotion";
    }
}
