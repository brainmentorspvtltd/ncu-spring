package com.brainmentors.los.operation;

import com.brainmentors.los.customer.ICustomer;

public interface ILOSProcess {
	public void sourcing(ICustomer customer);
	public void checkStage(int applicationNumber);
}
