import java.util.*;
import java.util.stream.Collectors;

public class RestaurantRecommendationEngine {
    
    public String[] getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {
        List<Restaurant> restaurants = Arrays.asList(availableRestaurants);

        // Step 1: Identify the user's primary and secondary cuisine and cost bracket based on their past orders.
        String primaryCuisine = user.getTopCuisine();
        String secondaryCuisine1 = user.getSecondaryCuisine1();
        String secondaryCuisine2 = user.getSecondaryCuisine2();

        int primaryCostBracket = user.getTopCostBracket();
        int secondaryCostBracket1 = user.getSecondaryCostBracket1();
        int secondaryCostBracket2 = user.getSecondaryCostBracket2();

        // Step 2: Sort the restaurants based on the criteria provided.
        Comparator<Restaurant> byFeaturedPrimary = Comparator
                .comparing(Restaurant::isRecommended).reversed()
                .thenComparing(r -> r.getCuisine().equals(primaryCuisine)).reversed()
                .thenComparingInt(Restaurant::getCostBracket);

		Comparator<Restaurant> byPrimaryRating = Comparator
                .comparingDouble(Restaurant::getRating).reversed();

		Comparator<Restaurant> bySecondaryRating = Comparator
		        .comparingDouble(r -> ((Restaurant) r).getSecondaryRating1().equals(secondaryCostBracket1) 
		                || (Restaurant) r.getSecondaryRating2().equals(secondaryCostBracket2))
		        .reversed();


        Comparator<Restaurant> byNewest = Comparator.comparing(Restaurant::isNew).reversed()
                .thenComparingDouble(Restaurant::getRating).reversed();

        Comparator<Restaurant> byPrimaryRatingLow = Comparator
                .comparing(r -> r.getCuisine().equals(primaryCuisine)).reversed()
                .thenComparingInt(Restaurant::getCostBracket)
                .thenComparingDouble(Restaurant::getRating);

        Comparator<Restaurant> bySecondaryRatingLow = Comparator
                .comparing(r -> r.getCuisine().equals(primaryCuisine) 
                        || r.getCuisine().equals(secondaryCuisine1))
                .reversed()
                .thenComparingInt(Restaurant::getCostBracket)
                .thenComparingDouble(Restaurant::getRating);

        Comparator<Restaurant> byAny = Comparator
                .comparingInt(Restaurant::getCostBracket)
                .thenComparingDouble(Restaurant::getRating).reversed();

        List<Restaurant> sortedRestaurants = restaurants.stream()
                .sorted(byFeaturedPrimary.thenComparing(byPrimaryRating)
                        .thenComparing(bySecondaryRating).thenComparing(byNewest)
                        .thenComparing(byPrimaryRatingLow).thenComparing(bySecondaryRatingLow)
                        .thenComparing(byAny))
                .limit(100)
                .collect(Collectors.toList());

        // Step 3: Return the top 100 unique restaurant IDs in the sorting order.
        return sortedRestaurants.stream()
                .map(Restaurant::getRestaurantId)
                .distinct()
                .toArray(String[]::new);
    }

}