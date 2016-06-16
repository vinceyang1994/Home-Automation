package cc.vince.dao;

import java.util.List;

import cc.vince.model.ReservationModel;

public interface ReservationDao extends BaseDao<ReservationModel> {

	public List<ReservationModel> getAll(String where, Object[] queryParams);
}
