/*** RequestDetails.java
 * created by trgd101
 * created on Feb 14, 2014
 */
package com.nttdata.infra.domain;

import java.sql.Date;

public class RequestDetails {

	private int reqId;
	private int userId;
	private int cubicalNo;
	private String department;
	private String location;
	private String requiredByDate;
	private int reqTypeId;
	private String justification;
	private String rejectionReason;
	private String cancellationReason;
	private int statusId;
	private Date requestedDate;
	private Date assigndeDate;
	private Date committedDate;
	private Date completedDate;

	public RequestDetails(int reqId, int reqTypeId, Date requestedDate,
			Date assigndeDate, Date committedDate, Date completedDate,
			int statusId) { // To
		// list
		// out
		// the
		// requests
		super();
		this.reqId = reqId;
		this.reqTypeId = reqTypeId;
		this.requestedDate = requestedDate;
		this.assigndeDate = assigndeDate;
		this.committedDate = committedDate;
		this.completedDate = completedDate;
		this.statusId = statusId;
	}

	public RequestDetails(int reqId, String location, int cubicalNo,
			String department, String requiredByDate, int reqTypeId,
			String rejectionReason, String cancellationReason,
			Date committedDate, String justification, int statusId) { // For
																		// Details
																		// about
																		// the
																		// Specific
																		// Request
																		// & for
																		// Updating
																		// request.
		super();
		this.reqId = reqId;
		this.cubicalNo = cubicalNo;
		this.department = department;
		this.location = location;
		this.requiredByDate = requiredByDate;
		this.justification = justification;
		this.rejectionReason = rejectionReason;
		this.cancellationReason = cancellationReason;
		this.statusId = statusId;
		this.committedDate = committedDate;
	}

	public RequestDetails(int userId, String location, int cubicalNo,
			String department, Date requestedDate, String requiredByDate,
			int reqTypeId, String justification, int statusId) { // For create
																	// SR Set
																	// statusId
																	// =1
		super();
		this.userId = userId;
		this.cubicalNo = cubicalNo;
		this.department = department;
		this.location = location;
		this.requestedDate = requestedDate;
		this.requiredByDate = requiredByDate;
		this.reqTypeId = reqTypeId;
		this.justification = justification;
		this.statusId = statusId;
	}

	public RequestDetails() {
		// TODO Auto-generated constructor stub
	}

	public String cancelRequst(int statusId, String cancellationReason) {

		return cancellationReason;
	}

	public String rejectRequest(int statusid, String rejectionReason) {

		return rejectionReason;
	}

	public boolean completeRequest(int statusid, Date completedDate) {

		boolean complete = false;
		return complete;
	}

	public boolean assignRequest(int statusid, Date committedDate) {

		boolean assigned = false;
		return assigned;
	}

	public int getReqID() {
		return reqId;
	}

	public void setReqID(int reqID) {
		this.reqId = reqID;
	}

	public int getUserID() {
		return userId;
	}

	public void setUserID(int userID) {
		this.userId = userID;
	}

	public int getCubicalNo() {
		return cubicalNo;
	}

	public void setCubicalNo(int cubicalNo) {
		this.cubicalNo = cubicalNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRequiredByDate() {
		return requiredByDate;
	}

	public void setRequiredByDate(String requiredByDate) {
		this.requiredByDate = requiredByDate;
	}

	public int getReqTypeID() {
		return reqTypeId;
	}

	public void setReqTypeID(int reqTypeID) {
		this.reqTypeId = reqTypeID;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public String getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public int getStatusID() {
		return statusId;
	}

	public void setStatusID(int statusID) {
		this.statusId = statusID;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Date getAssigndeDate() {
		return assigndeDate;
	}

	public void setAssigndeDate(Date assigndeDate) {
		this.assigndeDate = assigndeDate;
	}

	public Date getCommittedDate() {
		return committedDate;
	}

	public void setCommittedDate(Date committedDate) {
		this.committedDate = committedDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	@Override
	public String toString() {
		return "RequestDetails \n reqId: " + reqId + ", userId: " + userId
				+ ", cubicalNo: " + cubicalNo + ", department: " + department
				+ ", location: " + location + ", requiredByDate: "
				+ requiredByDate + ", reqTypeId: " + reqTypeId
				+ ", justification: " + justification + ", rejectionReason: "
				+ rejectionReason + ", cancellationReason: "
				+ cancellationReason + ", statusId: " + statusId
				+ ", requestedDate: " + requestedDate + ", assigndeDate: "
				+ assigndeDate + ", committedDate: " + committedDate
				+ ", completedDate: " + completedDate;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return userId;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean isSame = false;
		RequestDetails details = (RequestDetails) obj;
		if ((this.reqId == details.reqId)
				&& (this.statusId == details.statusId)) {
			isSame = true;
		}
		return isSame;
	}
}
