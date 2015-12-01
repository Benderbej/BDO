package ServletPack;

import java.util.HashSet;

public class RecipeList {

    private HashSet<Recipe> recipes_list;

    public HashSet<Recipe> getRecipes_list() {
        return recipes_list;
    }

    /**
     *
     * @param recipe
     * @return
     */
    public boolean addRecipe(Recipe recipe) {
        if (!recipes_list.contains(recipe)) {
            return recipes_list.add(recipe);
        }
        return false;
    }

    /**
     *
     * @param recipe_id
     * @return
     */
    public Recipe getRecipe(int recipe_id) {
        for (Recipe recipe : recipes_list) {//рецептов и того меньше
            if (recipe.getRecipe_id() == recipe_id) {
                return recipe;
            }
        }
        return null;
    }

    /**
     *
     * @param recipe
     */
    public void updateRecipeData(Recipe recipe) {

    }

}
