public class ProdutoDigital extends Produto {
	private String altura;
	
	
	public ProdutoDigital(String nome, String altura) {
		super(nome);
		this.setAltura(altura);
	
	}
	
	public void setAltura(String altura){
		this.altura = altura;	
	}

	public void imprime(){
		System.out.println("Produto: " + this.getNome() + "altura" + altura);
	}
	
}
