package cc.vince.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cc.vince.model.PageModel;

public interface BaseDao<T> {
	/* =================== 保存 =================== */
	public void save(Object obj);

	public void saveOrUpdate(Object obj);

	public void update(Object obj);

	/* =================== 删除 =================== */
	public void delete(Serializable... ids);

	/* =================== 查询 =================== */
	public T get(Serializable entityId);

	public T load(Serializable entityId);

	public List<T> getAll(String where, Object[] queryParams);

	public long getCount();

	/* =================== 单一结果 =================== */
	public Object uniqueResult(String hql, Object[] queryParams);

	/* =================== 存在？ =================== */
	public boolean isExist(String where, Object[] queryParams);

	/* =================== 分页 =================== */
	public PageModel<T> find(int pageNo, int maxResult);

	public PageModel<T> find(int pageNo, int maxResult, String where,
			Object[] queryParams);

	public PageModel<T> find(int pageNo, int maxResult,
			Map<String, String> orderby);

	public PageModel<T> find(String where, Object[] queryParams,
			Map<String, String> orderby, int pageNo, int maxResult);
}