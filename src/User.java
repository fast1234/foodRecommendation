public class User {
	private CuisineTracking[]  cuisines;
	private CostTracking[] costBracket;
	
	public String getTopCuisine() {
		return cuisines[0].getCuisineType().toString();
	}
	
	public String getSecondaryCuisine1() {
		return cuisines[1].getCuisineType().toString();
	}
	
	public String getSecondaryCuisine2() {
		return cuisines[2].getCuisineType().toString();
	}
	
	public int getTopCostBracket() {
		return costBracket[0].getType();
	}
	
	public int getSecondaryCostBracket1() {
		return costBracket[1].getType();
	}
	
	public int getSecondaryCostBracket2() {
		return costBracket[2].getType();
	}
}