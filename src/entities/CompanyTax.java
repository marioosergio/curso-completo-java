package entities;

public class CompanyTax extends TaxPayer {

	private int numberOfEmployees;

	public CompanyTax() {
		super();
	}

	public CompanyTax(String name, Double anualIncome, int numberOfEmployes) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployes;
	}

	public int getNumberOfEmployess() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployess(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		if (numberOfEmployees > 10.0) {
			return getAnualIncome() * 0.14;
		} else {
			return getAnualIncome() * 0.16;
		}
	}
}
