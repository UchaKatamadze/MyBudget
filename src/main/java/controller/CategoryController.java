package controller;

import expense.model.CategoryImpl;
import expense.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CategoryController {
    /**
     * @Author: Ucha Katamadze
     * This class is used to handle all the requests related to categories
     */
    private Category category;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    public CategoryController(Category category) {
        super();
        this.category = category;
    }

    /**
     * @Author: Ucha Katamadze
     * This method is used to get all categories
     * @return
     */
    @GetMapping("categories")
    Collection<CategoryImpl>categories(){
        logger.info("GET request for all categories");
        Collection<CategoryImpl> categories= category.findAll();
        logger.info("Returning all categories");
        return categories();
    }

    //2nd way to do it

    @GetMapping("/category/{id}")
    ResponseEntity<?>getCategory(@PathVariable Long id){
        logger.info("GET request for category with id: "+id);
        Optional<CategoryImpl> category= this.category.findById(id);
        return category.map(response->{
            logger.info("Returning category with id: "+id);
            return ResponseEntity.ok().body(response);
        })
                    .orElseThrow(()->{
                        logger.error("Category with id: "+id+" not found");
                        return new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with id: "+id+" not found");
                    });
        }

    /**
     * @Author: Ucha Katamadze
     * @param categoryImpl
     * @return
     * @throws URISyntaxException
     * This method is used to create a new category
     */
    @PostMapping("/category")
    ResponseEntity<CategoryImpl>createCategory(@RequestBody CategoryImpl categoryImpl)throws URISyntaxException{
        logger.info("POST request for creating a new category");
        try{
            CategoryImpl result= category.save(categoryImpl);
            URI uri = new URI("/api/category/"+result.getId());
            logger.info("Returning a new category");
            return ResponseEntity.created(uri).body(result);
    } catch (Exception e) {
            logger.error("Error creating a new category", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * @Author: Ucha Katamadze
     * @param categoryImpl
     * @return
     * This method is used to update an existing category
     */
    @PutMapping("/category/{id}")
    ResponseEntity<CategoryImpl>updateCategory(@RequestBody CategoryImpl categoryImpl){
        logger.info("PUT request for updating category with id: "+categoryImpl.getId());
        try{
            CategoryImpl result= category.save(categoryImpl);
            logger.info("Returning updated category with id: "+categoryImpl.getId());
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            logger.error("An error occurred while updating category with id {}", categoryImpl.getId(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while updating category with id " + categoryImpl.getId() + " " + e.getMessage());
}
    }

    /**
     * @Author: Ucha Katamadze
     * @param id
     * @return
     * This method is used to delete an existing category
     */
    @DeleteMapping("/category/{id}")
    ResponseEntity<?>deleteCategory(@PathVariable Long id){
        logger.info("Received a DELETE request for deleting category with id {}", id);
        try {
            category.deleteById(id);
            logger.info("Deleted category with id {}", id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("An error occurred while deleting category with id {}", id, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete category");
        }
    }
}
