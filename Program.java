class Program{
	public static void main(String args[]){
		Aeroportos aeroporto = new Aeroportos();
		
		bool acabou = false;
		int opcao = 0;

		while(true){
			opcao = Printer.mostrarOpcoes();
			switch(opcao){
				case 1: {
					aeroportos.add(Printer.cadatrarAeroporto());
					break;
				}
				case 2: {
					int[] dados = Printer.cadastrarVoo();
					aeroportos.addVoo((int)dados[0], (String)dados[1], (String)dados[2]);
					break;	
				}
				case 3: {
					aeroportos.removeVoo(Printer.removerVoo());
					break;
				}
				case 4: {
					aeroportos.listVoo(Printer.listarVoo());
					break;
				}
				case 5: {
					aeroportos.toString();
					break;
				}
				case 6: {
					Printer.esperar();
					return;
				};
			}
			Printer.esperar();
		}
	}
}
