package com.born.fcs.face.web.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.born.fcs.pm.page.Page;
import com.born.fcs.pm.ws.result.base.QueryBaseBatchResult;

public class PageUtil {
	public static <T> Page<T> getCovertPage(QueryBaseBatchResult<T> batchResult) {
		long start = (batchResult.getPageNumber() - 1) * batchResult.getPageSize();
		Page<T> newPage = new Page<T>(batchResult.getSortCol(), batchResult.getSortOrder(), start,
			batchResult.getTotalCount(), (int) batchResult.getPageSize(), batchResult.getPageList());
		return newPage;
	}
	
	public static <T> Page<T> getCovertPageAndResult(QueryBaseBatchResult<T> batchResult) {
		List<T> listOld = batchResult.getPageList();
		long pageNum = batchResult.getPageNumber();
		long pageSize = batchResult.getPageSize();
		long totalCount = batchResult.getTotalCount();
		List<T> listNew = new ArrayList<T>();
		long start = (pageNum - 1) * pageSize;
		if (pageNum == 1) {
			if (pageSize >= totalCount) {
				listNew = listOld;
			} else {
				for (int i = 0; i < pageSize; i++) {
					listNew.add(listOld.get(i));
				}
			}
		} else {
			if (pageSize < totalCount) {
				if (start < totalCount) {
					int end = (int) ((start + pageSize) > totalCount ? totalCount
						: (start + pageSize));
					for (int i = (int) start; i < end; i++) {
						listNew.add(listOld.get(i));
					}
				}
			}
		}
		Page<T> newPage = new Page<T>(batchResult.getSortCol(), batchResult.getSortOrder(), start,
			totalCount, (int) pageSize, listNew);
		return newPage;
	}
	
	/**
	 * 计算页数
	 * @param list
	 * @param pageSize
	 * @return
	 */
	public static long getPageCount(List<T> list, long pageSize) {
		long rowCount = list == null ? 0 : list.size();
		if (rowCount == 0)
			return 0;
		return rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
	}
}
