import java.util.Scanner;

public class Printer{
	private static Scanner ler = new Scanner(System.in);

	public static int mostrarOpcoes(){
		System.out.println("__________________________________");
		System.out.println("|               MENU:            |");
		System.out.println("|1- Cadastrar novo aeroporto     |");
		System.out.println("|2- Cadastrar novo voo           |");
		System.out.println("|3- Remover voo                  |");
		System.out.println("|4- Listar voos de um aeroporto  |");
		System.out.println("|5- Listar todos os voos         |");
		System.out.println("|6- Sair                         |");
		System.out.println("----------------------------------");
		System.out.print(">>");

		int retorno =  ler.nextInt();
		ler.nextLine();

		return retorno;
	}

	public static String[] cadastrarAeroporto(){
		String[] retorno = new String[2];
		System.out.println("\nDigite o codigo do aeroporto:");
		System.out.print(">>");
		retorno[0] = ler.nextLine();

		System.out.println("\nDigite a cidade do aeroporto:");
		System.out.print(">>");
		retorno[1] = ler.nextLine();

		return retorno;
	}

	public static Object[] cadastrarVoo(){
		Object[] retorno = new Object[3];

		System.out.println("\nDigite o codigo do voo:");
		System.out.print(">>");
		retorno[0] = ler.nextInt();
		ler.nextLine();

		System.out.println("\nDigite o codigo do aeroporto de origem:");
		System.out.print(">>");
		retorno[1] = ler.nextLine();

		System.out.println("\nDigite o codigo do aeroporto de destino:");
		System.out.print(">>");
		retorno[2] = ler.nextLine();

		return retorno;
	}

	public static int removerVoo(){
		System.out.println("\nDigite o codigo do voo a deletar:");
		System.out.print(">>");

		int retorno = ler.nextInt();
		ler.nextLine();

		return retorno;
	}

	public static String listarVoo(){
		System.out.println("\nDigite o codigo do aeroporto a ser listado:");
		System.out.print(">>");

		String retorno = ler.nextLine();

		return retorno;
	}

	public static void esperar(){
		System.out.println("__________________________________");
		System.out.println("   Aperte [ENTER] para terminar");
		System.out.println("__________________________________");
		ler.nextLine();
	}

	public static void tratarErro(Exception e){
		System.out.println("__________________________________");
		System.out.println(e.getMessage()+"!!!!");
		System.out.println("__________________________________");
	}
}
