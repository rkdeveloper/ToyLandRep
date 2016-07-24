package com.saisha.toyland.dao;

import java.util.List;

import com.saisha.toyland.model.Supplier;

public interface SupplierDAO {

	public void addNewSupplier(Supplier supplier);
	public List<Supplier> getSupplier();
	public Supplier edit(int id, Supplier s);
	public Supplier getSupplier(int id);
	public void delete(int id);
}