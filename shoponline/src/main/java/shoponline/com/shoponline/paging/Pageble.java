package shoponline.com.shoponline.paging;

import shoponline.com.shoponline.sort.Sorter;

public interface Pageble {
	Integer getPage();

	Integer getOffset();

	Integer getLimit();

	Sorter getSorter();
}
