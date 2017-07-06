package cn.scholarprofile.util;

/**
 * 
 * @author 超 分页工具类
 */
public class PageUtil {

	private int curPage = 1; // 当前是第几页，默认是第一页
	private long maxPage; // 一共有多少页
	private long maxRowCount; // 一共有多少行
	public int rowsPerPage = 10; // 每页多少行

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public long getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(long maxPage) {
		this.maxPage = maxPage;
	}

	public long getMaxRowCount() {
		return maxRowCount;
	}

	public void setMaxRowCount(long maxRowCount) {
		this.maxRowCount = maxRowCount;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

}
