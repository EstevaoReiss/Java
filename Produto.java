	public class Produto {
		private String nome;
		private  double preco;
		
		public Produto(String nome, double preco) {
			this(nome);
			this.setPreco(preco);
		
		}
		
		public Produto(String nome){
			this.nome = nome;
		}
	
		public String getNome(){
			return this.nome;	
		}
		
		public void setPreco(double preco){
			this.preco = preco;	
		}
		
		public void imprime(){
			System.out.println("Produto: " + this.nome + " valor " + this.preco );
		}
		
	}
