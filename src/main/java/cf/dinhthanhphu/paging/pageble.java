package cf.dinhthanhphu.paging;

import cf.dinhthanhphu.sort.Sorter;

public interface pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
