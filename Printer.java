import java.util.Scanner;

public class Printer{
	private static Scanner ler = new Scanner(System.in);
	
	public static int mostrarOpcoes(){
		System.out.println("__________________________________");
		System.out.println("|               MENU:            |");
		System.out.println("|1- Cadastrar novo aeroporto     |");
		System.out.println("|2- Cadastrar novo vôo           |");
		System.out.println("|3- Remover vôo                  |");
		System.out.println("|4- Listar Vôos de um aeroporto  |");
		System.out.println("|5- Listar todos os vôos         |");
		System.out.println("----------------------------------");
		System.out.print(">>");

		return ler.nextInt();
	}

	public static String cadastrarAeroporto(){
		System.out.println("\n+Digite o codigo do aeroporto:");
		System.out.print(">>");

		return ler.nextString();
	}

	public static int[] cadastrarVoo(){
		Object[] retorno = new Object[3];
		
		System.out.println("\nDigite o codigo do vôo:");
		System.out.print(">>");
		retorno[0] = ler.nextInt();

		System.out.println("\nDigite o codigo do aeroporto de origem:");
		System.out.print(">>");
		retorno[1] = ler.nextString();

		System.out.println("\nDigite o codigo do aeroporto de destino:");
		System.out.print(">>");
		retorno[2] = ler.nextString();

		return retorno;
	}

	public static int removerVoo(){
		System.out.println("\nDigite o codigo do voo a deletar:");
		System.out.print(">>");

		return ler.nextInt();
	}

	public static String listarVoo(){
		System.out.println("\nDigite o codigo do aeroporto a ser listado:");
		System.out.print(">>");

		return ler.nextString();
	}

	public static void esperar(){
		System.out.println("Aperte [ENTER] para terminar");
		ler.nextInt();
	}
}
