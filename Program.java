class Program{
	public static void main(String args[]){
		Aeroportos aeroportos = new Aeroportos();
		int opcao = 0;

		while(true){
			opcao = Printer.mostrarOpcoes();
			try{
				switch(opcao){
					case 1: {
						String[] dados = Printer.cadastrarAeroporto();
						aeroportos.add(dados[0], dados[1]);
						break;
					}
					case 2: {
						Object[] dados = Printer.cadastrarVoo();
						aeroportos.addVoo((int)dados[0], (String)dados[1], (String)dados[2]);
						break;
					}
					case 3: {
						aeroportos.removeVoo(Printer.removerVoo());
						break;
					}
					case 4: {
						System.out.println(aeroportos.listVoo(Printer.listarVoo()));
						break;
					}
					case 5: {
						System.out.println(aeroportos.toString());
						break;
					}
					case 6: {
						Printer.esperar();
						return;
					}
				}
			}
			catch(Exception err){
				Printer.tratarErro(err);
			}

			Printer.esperar();
		}
	}
}
