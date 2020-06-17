class Program{
	public static void main(String args[]){
		Aeroportos aeroportos = new Aeroportos();

		try{
			aeroportos.add("BSB","Brasília");
			aeroportos.add("CNF", "Belo Horizonte");
			aeroportos.add("GIG", "Rio de Janeiro");
			aeroportos.add("GRU", "São Paulo");
			aeroportos.add("SSA", "Salvador");

			aeroportos.addVoo(107, "BSB", "SSA");

			aeroportos.addVoo(214, "CNF", "SSA");
			aeroportos.addVoo(555, "CNF", "GIG");
			aeroportos.addVoo(101, "CNF", "GRU");

			aeroportos.addVoo(554, "GIG", "CNF");
			aeroportos.addVoo(90, "GIG", "GRU");

			aeroportos.addVoo(50, "GRU", "BSB");
			aeroportos.addVoo(89, "GRU", "GIG");
			aeroportos.addVoo(102, "GRU", "CNF");

			aeroportos.addVoo(215, "SSA", "CNF");
		}
		catch(Exception e){}//não vai da erro

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
