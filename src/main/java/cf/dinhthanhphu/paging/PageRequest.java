package cf.dinhthanhphu.paging;

import java.awt.print.Pageable;

import cf.dinhthanhphu.sort.Sorter;

public class PageRequest implements pageble{

	private Integer page;
	private Integer maxPageItem;
	private Sorter sort;
	
	public  PageRequest(Integer page, Integer maxPageItem, Sorter sort) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sort = sort;
	}
	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if(this.page != null && this.maxPageItem != null ) {
		return (page -1) * maxPageItem;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItem;
	}
	
	public void setSort(Sorter sort) {
		this.sort = sort;
	}
	@Override
	public Sorter getSorter() {
		if(sort.getSortName() != null) {
			return sort;
		}
	return null;
	}

}
