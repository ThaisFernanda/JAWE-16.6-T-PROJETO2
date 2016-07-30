package br.com.petshop.modelo;

public class Animal {
	
	private Integer animalID;
	private String nomeAnimal;
	private Pessoa dono;
	private TipoAnimal tipoAnimal;
	
	
	public Integer getAnimalID() {
		return animalID;
	}
	public void setAnimalID(Integer animalID) {
		this.animalID = animalID;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public Pessoa getDono() {
		return dono;
	}
	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}
	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	
	

	
	

}
