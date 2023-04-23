import java.sql.Date;

public class Restaurant {
	private String restaurantId;
	private Cuisine cuisine;
	private int costBracket;
	private float rating;
	private boolean isRecommended;
	private Date onboardedTime;
	
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getCuisine() {
		return cuisine.toString();
	}
	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}
	public int getCostBracket() {
		return costBracket;
	}
	public void setCostBracket(int costBracket) {
		this.costBracket = costBracket;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public boolean isRecommended() {
		return isRecommended;
	}
	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}
	public Date getOnboardedTime() {
		return onboardedTime;
	}
	public void setOnboardedTime(Date onboardedTime) {
		this.onboardedTime = onboardedTime;
	}
}
