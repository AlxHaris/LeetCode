import java.util.*;

public class FoodRatings {
    // food -> cuisine
    private Map<String, String> foodToCuisine;
    // food -> rating
    private Map<String, Integer> foodToRating;
    // cuisine -> sorted set of Food entries
    private Map<String, TreeSet<Food>> cuisineFoods;
    
    // Helper class to store food name + rating,
    // and to compare appropriately
    private static class Food implements Comparable<Food> {
        String name;
        int rating;
        
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
        
        @Override
        public int compareTo(Food other) {
            // First sort by rating descending
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating);
            }
            // If ratings are same, by name lexicographically
            return this.name.compareTo(other.name);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Food other = (Food) obj;
            return this.rating == other.rating && this.name.equals(other.name);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineFoods = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            
            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);
            
            cuisineFoods.putIfAbsent(cuisine, new TreeSet<>());
            cuisineFoods.get(cuisine).add(new Food(food, rating));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);
        
        TreeSet<Food> set = cuisineFoods.get(cuisine);
        // Remove old Food object
        set.remove(new Food(food, oldRating));
        // Insert new one
        set.add(new Food(food, newRating));
        
        // Update map
        foodToRating.put(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        TreeSet<Food> set = cuisineFoods.get(cuisine);
        // first() gives the highest per our compareTo logic
        return set.first().name;
    }
}
