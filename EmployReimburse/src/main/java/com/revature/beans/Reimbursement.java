package com.revature.beans;

public class Reimbursement {
	
	private int reimburseId;
	private double amount;
	private int status;
	private int employId;
	private String detail;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimburseId, double amount, int status, int employId, String detail) {
		super();
		this.reimburseId = reimburseId;
		this.amount = amount;
		this.status = status;
		this.employId = employId;
		this.detail = detail;
	}

	public int getReimburseId() {
		return reimburseId;
	}

	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEmployId() {
		return employId;
	}

	public void setEmployId(int employId) {
		this.employId = employId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimburseId=" + reimburseId + ", amount=" + amount + ", status=" + status + ", employId="
				+ employId + ", detail=" + detail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + employId;
		result = prime * result + reimburseId;
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (employId != other.employId)
			return false;
		if (reimburseId != other.reimburseId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
