package com.thirdageopen.model;

import java.util.List;

public abstract class BaseModel <T>{

	private String url;
	
	private List<T> items;
	
	private T item;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	
	
}
