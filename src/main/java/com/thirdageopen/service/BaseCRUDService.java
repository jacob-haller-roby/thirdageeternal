package com.thirdageopen.service;

import java.util.List;

public abstract interface BaseCRUDService<T> {

	public void create(T object);

	public List<T> retrieve();

	public void update(T object);

	public void delete(T object);

}
