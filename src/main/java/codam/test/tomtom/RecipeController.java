package codam.test.tomtom;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
class RecipeController {
    private final RecipeRepository repository;

    RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    // All items
    // tag::get-aggregate-root[]
    @GetMapping
    List<Recipe> all(
            @RequestParam(required = false, name = "is_vegetarian") Boolean isVegetarian,
            @RequestParam(required = false, name = "servings") Long servings) {

        if (isVegetarian != null) {
            if (isVegetarian) {
                return repository.findByType("vegetarian");
            }
            return repository.findByTypeNot("vegetarian");
        }
        if (servings != null) {
            return repository.findByNumberOfServings(servings);
        }
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    // Single item
    @GetMapping("/{id}")
    Recipe one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @PostMapping
    Recipe newRecipe(@RequestBody Recipe recipe) {
        return repository.save(recipe);
    }

    @PutMapping("/{id}")
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
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteRecipe(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
