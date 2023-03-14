package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Budget {

	private int numOfDays;
	private int groupSize;
	private int budgetTotal;
	
	public Budget() {
	
	}
	public int calculateTotal(Traveler b) {
		budgetTotal=0;
		for(int i=0;i<b.itinerary.itineraryCost.size();i++) {
			budgetTotal+=b.itinerary.itineraryCost.get(i);
		}
		budgetTotal*=b.budget.groupSize;
			return budgetTotal;
	}
	public int getNumOfDays() {
		return numOfDays;
	}
	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	public int getBudgetTotal() {
		return budgetTotal;
	}
	public void setBudgetTotal(int budgetTotal) {
		this.budgetTotal = budgetTotal;
	}
	
}