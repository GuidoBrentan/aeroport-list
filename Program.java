class Program{
	public static void main(String args[]){
		try{
			Aeroportos aeroportos = new Aeroportos();

			int opcao = 0;

			while(true){
				opcao = Printer.mostrarOpcoes();
				try
				{
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
						}
					}
				}
				catch(Exception err)
				{
					System.err.println(err.toString());
				}
				Printer.esperar();
				for(int i = 0; i < 100; i++)
					System.out.println("");
			}
		}
		catch(Exception err)
		{
			System.err.println(err.toString());
		}
	}
}
