package controller;

import expense.model.CategoryImpl;
import expense.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CategoryController {
    private Category category;

    public CategoryController(Category category) {
        super();
        this.category = category;
    }

    @GetMapping("categories")
    Collection<CategoryImpl>categories(){
        return category.findAll();
    }

    //2nd way to do it

    @GetMapping("/category/{id}")
    ResponseEntity<?>getCategory(@PathVariable Long id){
        Optional<CategoryImpl> category= this.category.findById(id);
        return category.map(response->ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    ResponseEntity<CategoryImpl>createCategory(@RequestBody CategoryImpl categoryImpl)throws URISyntaxException{
        CategoryImpl result= category.save(categoryImpl);
        return ResponseEntity.created(new URI("/api/category"+result.getId())).body(result);
    }

    @PutMapping("/category/{id}")
    ResponseEntity<CategoryImpl>updateCategory(@RequestBody CategoryImpl categoryImpl){
        CategoryImpl result= category.save(categoryImpl);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?>deleteCategory(@PathVariable Long id){
        category.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
