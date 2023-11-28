package codam.test.tomtom;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class RecipeController {
    private final RecipeRepository repository;

    RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    // tag::get-aggregate-root[]
    @GetMapping("/recipes")
    List<Recipe> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/recipes")
    Recipe newRecipe(@RequestBody Recipe recipe) {
        return repository.save(recipe);
    }

    // Single item
    @GetMapping("/recipes/{id}")
    Recipe one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @PutMapping("/recipes/{id}")
    Recipe replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {
        return repository.findById(id)
                .map(recipe -> {
                    recipe.setName(newRecipe.getName());
                    recipe.setType(newRecipe.getType());
                    recipe.setNumberOfServings(newRecipe.getNumberOfServings());
                    recipe.setIngredients(newRecipe.getIngredients());
                    recipe.setDescription(newRecipe.getDescription());
                    return repository.save(recipe);
                })
                .orElseGet(() -> {
                    newRecipe.setId(id);
                    return repository.save(newRecipe);
                });
    }

    @DeleteMapping("/recipes/{id}")
    void deleteRecipe(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
