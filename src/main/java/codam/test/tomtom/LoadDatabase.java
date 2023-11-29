package codam.test.tomtom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RecipeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Recipe(
                    "Incredible Vegan Thai Green Curry",
                    "vegetarian",
                    4L,
                    "1 middle eggplant,250ml coconut milk,750ml vegetable broth,100ml soy sauce,1 teaspoon coconut sugar,1 teaspoon salt,300g extra-firm tofu,200g green curry paste,15g thai basil,1 red pepper,5g lime leaves",
                    "Boil the tofu. Slice the tofu into cubes (2 cm). Add 1 tablespoon of salt to the water. Boil for 2 minutes, then drain.\n"
                            + "Start the curry. Add a few spoons of the coconut milk to a large sauté pan over medium-high heat. Let it bubble for a few minutes before stirring in your green curry paste. Keep stirring until the paste starts to dry out.\nNow pour in the rest of the coconut milk.\nAdd the lime leaves, sugar, and soy sauce. Let the sauce simmer until it starts to thicken.\n"
                            + "Add the veggies. Add your vegetables of choice and broth.\nSimmer until the vegetables are crisp-tender (eggplant takes the longest).\nTurn off the heat and add a squeeze of lime juice if desired. Taste and adjust the seasonings as needed. Remove the lime leaves, then stir in the Thai basil.\n"
            )));
            log.info("Preloading " + repository.save(
                    new Recipe("Polish patties (kotlety)",
                    "meat",
                    8L,
                    "1 crusty white bread roll,120ml milk,1 onion,vegetable oil,500g beef mince,1 egg,1 garlic clove,pinch of marjoram,75g dried breadcrumbs",
                    "STEP 1\nSoak the bread roll in the milk so it softens completely. Meanwhile, fry the onion in the oil for around 8 mins or until soft and golden. Add the fried onion to the beef mince along with the egg, garlic, marjoram and some seasoning. Squeeze the excess milk from the bread roll and add it to the mince mixture. Mix everything together and season well.\n"
                               + "STEP 2\nDivide the meat into 8 patties. Tip the dried breadcrumbs into a shallow bowl and coat the patties in it, all over. Heat some oil in a deep frying pan and fry the patties in batches on both sides until browned and cooked through, about 6-7 mins on each side.\n")));
            log.info("Preloading " + repository.save(new Recipe(
                    "Some dish name",
                    "vegetarian",
                    4L,
                    "carrot,potato,love",
                    "How to cook food with love"
            )));
        };
    }
}
