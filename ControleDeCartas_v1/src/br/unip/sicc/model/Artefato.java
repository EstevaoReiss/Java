package br.unip.sicc.model;

public class Artefato {
	private Long id;
	private String nome;
	private Categoria categoria;
	private int forca;
	
	// CONSTRUCTORS
	
	public Artefato() {
	}
	
	public Artefato(String nome, int forca, Categoria categoria) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.forca = forca;
	}
	
	public Artefato(Long id, String nome, Categoria categoria, int forca) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.forca = forca;
	}
	
	//GETTERS AND SETTERS
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public int getForca() {
		return forca;
	}
	
	public void setForca(int forca) {
		this.forca = forca;
	}
	
	
}