package com.example.demo.enums;


public enum CategoriaQuarto {
	SIMPLES(0, "Simples"),
	PADRAO(1, "Padrão"),
	APARTAMENTO(2, "Apartamento"),
	DORMITORIO(3, "Dormitório"),
	LUXO(4, "Luxo"),;
	
	private int id;
	private String value;
	
	CategoriaQuarto(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
	public static CategoriaQuarto get(int id) {
		CategoriaQuarto categoriaQuarto = null;
		for(CategoriaQuarto cq : CategoriaQuarto.values()) {
			if(cq.getId() == id) {
				categoriaQuarto = cq;
				break;
			}
		}
		return categoriaQuarto;
	}
}
