package cf.dinhthanhphu.sort;

public class Sorter {
	private String sortName;
	private String sortBy;
	
	public Sorter(String sortName, String sortBy) {
		this.setSortName(sortName);
		this.setSortBy(sortBy);
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
