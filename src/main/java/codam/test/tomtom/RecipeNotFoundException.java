package codam.test.tomtom;

class RecipeNotFoundException extends RuntimeException {
    RecipeNotFoundException(Long id) {
        super("Couldn't find the recipe by id=" + id);
    }
}
