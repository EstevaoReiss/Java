class UseProduto{

	public static void main(String[] args){
		Produto tv = new Produto("televosao",44);
		tv.imprime();

		Produto celular = new Produto("celular");
		celular.imprime();
		
		ProdutoDigital walpaper = new ProdutoDigital("walpaper", "3 metros");
		walpaper.imprime();
	}

}
