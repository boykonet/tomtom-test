package codam.test.tomtom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByType(String type);
    List<Recipe> findByTypeNot(String type);
    List<Recipe> findByNumberOfServings(Long numberOfServings);
}
