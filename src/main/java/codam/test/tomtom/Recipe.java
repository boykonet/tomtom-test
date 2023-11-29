package codam.test.tomtom;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Value;


@Entity
@Table(name="Recipes")
class Recipe {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Value("${some.key:meat,fish,seafood,vegetarian,vegan,raw}")
    private String type;
    @Column(name="number_of_servings")
    private Long numberOfServings;
    private String ingredients;
    @Lob
    @Column(name="DESCRIPTION", length=512)
    private String description;

    public Recipe() {}

    Recipe(String name, String type, Long numberOfServings, String ingredients, String description) {

        this.name = name;
        this.type = type;
        this.numberOfServings = numberOfServings;
        this.ingredients = ingredients;
        this.description = description;
    }

    // getters
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public Long getNumberOfServings() {
        return this.numberOfServings;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public String getDescription() {
        return this.description;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumberOfServings(Long numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Recipe)) {
            return false;
        }
        Recipe recipe = (Recipe) o;
        return Objects.equals(this.id, recipe.id)
                && Objects.equals(this.name, recipe.name)
                && Objects.equals(this.type, recipe.type)
                && Objects.equals(this.numberOfServings, recipe.numberOfServings)
                && Objects.equals(this.ingredients, recipe.ingredients)
                && Objects.equals(this.description, recipe.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.type, this.numberOfServings, this.ingredients, this.description);
    }

    @Override
    public String toString() {
        return "DishRecipe{"
                + "id=" + this.id
                + ", name=" + '\'' + this.name + '\''
                + ", type=" + '\'' + this.type + '\''
                + ", number_of_servings=" + this.numberOfServings
                + ", ingredients=" + '\'' + this.ingredients + '\''
                + ", description=" + '\'' + this.description + '\''
                + "}";
    }
}
