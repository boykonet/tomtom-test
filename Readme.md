# Dish recipes API in Java

------------------------------------------------
## Fetching all recipes and one by `id`
### `GET /recipes`
Returns all recipes from database.

Example: `curl -v localhost:8080/recipes`

### `GET /recipes/{id}`
Returns the recipe from database by `id`.
If recipe is not exist, returns error.

Example: `curl -v localhost:8080/recipes/2`

------------------------------------------------
## Adding new recipe
### `POST /recipes`
Adds new recipe to database and sets unique `id` for it.
Returns new created `id` if the recipe didn't exist.
If recipe is already exist, returns error.

Example: `curl -X POST localhost:8080/recipes -H "Content-type: application/json" -d '{"name":"some another dish name","type":"meat","number_of_serving,"ingredients":"carrot,potato,cucumber,sausages","description":"sausage soup with vegetables"}'`

------------------------------------------------

## Deleting recipe from database
### `DELETE /recipes/{id}`
Removes recipe from database by `id`.
If the recipe didn't exist, returns nothing.

Example: `curl -X DELETE localhost:8080/recipes/3`

------------------------------------------------

## Updating already existing recipe
### `PUT /recipes/{id}`
Updates already created recipe in database by id.
If the recipe didn't exist, returns error.

Example: `curl -X PUT localhost:8080/recipes/3 -H "Content-type: application/json" -d '{"name":"some name","type":"meat","number_of_servings":4,"ingredients":"carrot,potato","description":"some another description"}'`