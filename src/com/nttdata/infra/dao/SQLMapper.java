/*** SQLMapper.java
 * created by trgd101
 * created on Feb 14, 2014
 */
package com.nttdata.infra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nttdata.dbfw.ResultMapper;
import com.nttdata.infra.domain.RequestDetails;
import com.nttdata.infra.domain.RequestType;
import com.nttdata.infra.domain.Role;
import com.nttdata.infra.domain.Status;
import com.nttdata.infra.domain.User;

public class SQLMapper {
	public static final String VALIDATE_PASSWD = "select * from user_089961 where user_id = ? and passwd=?";

	public static final String REQUEST_BY_CREATOR = "Select * from sr_details_089961 where user_id = ? order by req_id";

	public static final String CREATE_SR = "insert into sr_details_089961 values(request_ID_SEQ_089961.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String VIEW_ALL_REQUEST = "select * from sr_details_089961 order by req_id";

	public static final String GET_REQUEST_DETIALS = "select * from sr_details_089961 where req_id = ? order by req_id";

	public static final String GET_REQUEST_TYPES = "Select * from request_type_089961";

	public static final String GET_STATUS_DETAILS = "Select * from status_089961 s inner join role_089961 r on s.role_id = r.role_id where s.role_id = ? and status_id = ?";

	public static final String UPDATE_ON_ASSIGN = "update sr_details_089961 set status_id=?, commited_date=?,ASSIGNED_DATE=? where req_id=?";

	public static final String UPDATE_ON_REJECT = "update sr_details_089961 set status_id=?, commited_date=?,ASSIGNED_DATE=?,COMPLETED_DATE=?,REJECTION_REASON=? where req_id=?";

	public static final String UPDATE_ON_CANCEL = "update sr_details_089961 set status_id=?, commited_date=?,ASSIGNED_DATE=?,COMPLETED_DATE=?,CANCELLATION_REASON=? where req_id=?";

	public static final String UPDATE_ON_COMPLETE = "update sr_details_089961 set status_id=?, COMPLETED_DATE=? where req_id=?";

	public static final String GET_STATUS_LIST = "Select * from status_089961 where role_id = ? and status_id=?";

	public final static String GET_NEW_REQ_ID = " select * from sr_details_089961 where req_id=(select max(req_id) from sr_details_089961)";

	public static final ResultMapper USER_RES_MAPPER = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws SQLException {
			User userDetails = new User();
			userDetails.setId(resSet.getInt("user_id"));
			userDetails.setName(resSet.getString("name"));
			userDetails.setPasswd(resSet.getString("passwd"));
			userDetails.setRollId(resSet.getInt("role_id"));
			return userDetails;
		}

	};
	public static final ResultMapper SR_DETAILS_RES_MAPPER = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws SQLException {
			RequestDetails srDetails = new RequestDetails();
			srDetails.setReqID(resSet.getInt("req_id"));
			srDetails.setUserID(resSet.getInt("user_id"));
			srDetails.setLocation(resSet.getString("location"));
			srDetails.setCubicalNo(resSet.getInt("cubicle_no"));
			srDetails.setDepartment(resSet.getString("department"));
			srDetails.setRequiredByDate(resSet.getString("required_by_date"));
			srDetails.setReqTypeID(resSet.getInt("req_typeid"));
			srDetails.setRejectionReason(resSet.getString("rejection_reason"));
			srDetails.setCancellationReason(resSet
					.getString("cancellation_reason"));
			srDetails.setRequestedDate(resSet.getDate("requested_date"));
			srDetails.setAssigndeDate(resSet.getDate("assigned_date"));
			srDetails.setCommittedDate(resSet.getDate("commited_date"));
			srDetails.setCompletedDate(resSet.getDate("completed_date"));
			srDetails.setJustification(resSet.getString("justification"));
			srDetails.setStatusID(resSet.getInt("status_id"));
			return srDetails;

		}
	};
	public static final ResultMapper STATUS_DETAILS_MAPPER = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws SQLException {
			Status stDetails = new Status();
			Role role = new Role();
			role.setId(resSet.getInt("role_id"));
			role.setName(resSet.getString("name"));
			stDetails.setStatusId(resSet.getInt("status_id"));
			stDetails.setStatusDesc(resSet.getString("stsDesc"));
			stDetails.setRole(role);
			return stDetails;
		}
	};
	public static final ResultMapper STATUS_LIST_MAPPER = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws SQLException {
			Status stDetails = new Status();
			stDetails.setStatusId(resSet.getInt("status_id"));
			stDetails.setStatusDesc(resSet.getString("stsDesc"));
			return stDetails;
		}
	};
	public static final ResultMapper ROLE_MAPPER = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws SQLException {
			Role roleDetails = new Role();
			roleDetails.setId(resSet.getInt("role_id"));
			roleDetails.setName(resSet.getString("name"));
			return roleDetails;
		}
	};
	public static final ResultMapper REQ_TYPE_RES_MAPPER = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws SQLException {
			RequestType reqType = new RequestType();
			reqType.setId(resSet.getInt("req_id"));
			reqType.setDesc(resSet.getString("typeDesc"));
			return reqType;
		}
	};
}
