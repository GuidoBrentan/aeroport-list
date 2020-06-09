public class Aeroportos  implements Cloneable{
	private class Node{
		private Node next;
		private Aeroporto data;

		public Node(Aeroporto a, Node n){
			next = n;
			data = a;
		}

		public Aeroporto getData(){
			return data;
		}
		public void setData(Aeroporto a){
			data = a;
		}

		public Node getNext(){
			return next;
		}
		public void setNext(Node n){
			next = n;
		}
	}

	private Node first, last;

	public Aeroportos()
	{
		this.first = null;
		this.last = null;
	}

	public void add(Aeroporto a) throws Exception{
		if(a == null){
			throw new Exception("Aeroporto nulo");
		}

		if (last == null){
	            last   = new Node((Aeroporto)a.clone(), null);
	            first = last;
	        }

        	else{
			last.setNext(new Node((Aeroporto)a.clone(), null));
        		last = last.getNext();
        	}
	}

	public void add(String cod, String cidade) throws Exception{
		if(cod == null){
			throw new Exception("Codigo nulo");
		}

		if(cidade == null){
			throw new Exception("Cidade nula");
		}

		Aeroporto aux = new Aeroporto(cod, new Voos(), cidade);

		if (first == null){
			first = new Node(aux, null);
			last = first;
	    }

        else{
			last.setNext(new Node(aux, null));
			last = last.getNext();
        }
	}


	public void remove(Aeroporto a) throws Exception{
		if(a == null){
			throw new Exception("Aeroporto nulo");
		}

	        if(first == null){
			throw new Exception ("Lista vazia");
		}

	        if (a.equals(first.getData())){
            		if(last == first)
                		last = null;

			first = last.getNext();
			return;
        	}

        	Node atual = first;

        	for(;;){
            		if(atual.getNext()==null){
                		throw new Exception ("Informacao inexistente");
			}

			if(a.equals(atual.getNext().getData())){
    		            	if(last == atual.getNext()){
                  	  		last = atual;
					return;
				}

	                	atual.setNext(atual.getNext().getNext());

				return;
			}

			atual = atual.getNext();
		}
	}

	//Que envolvem aeroporto
	public String listVoo(String a) throws Exception{
		a = a.toUpperCase();
		for(Node atual = first; atual != null; atual = atual.getNext()){
			if(atual.getData().getCodAeroporto().equals(a)){
				return atual.getData().toString();
			}
		}

		throw new Exception("Nao existe aeroporto com tal codigo");
	}

	public void addVoo(int codVoo, String codOrigem, String codDestino) throws Exception{
		Node retorno = null;
		int achou = 0;
		codOrigem = codOrigem.toUpperCase();
		codDestino = codDestino.toUpperCase();

		for(Node atual = first; atual != null; atual = atual.getNext()){
			if(atual.getData().getCodAeroporto().equals(codOrigem)){
				retorno = atual;
				achou++;
			}
			if(atual.getData().getCodAeroporto().equals(codDestino)){
				achou++;
			}
			if(achou >= 2){
				retorno.getData().getListaDeVoos().add(new Voo(codVoo, codDestino));
				return;
			}
		}

		throw new Exception("Nao existe aeroporto com tal codigo");
	}

	public void removeVoo(int cod) throws Exception{
		for(Node atual = first; atual != null; atual = atual.getNext()){
			if(atual.getData().getListaDeVoos().existe(cod)){
				atual.getData().getListaDeVoos().remove(cod);
				return;
			}
		}

		throw new Exception("Voo nao existe");
	}

	//obrigatorios
	public Aeroportos(Aeroportos a) throws Exception{
		if(a == null){
			throw new Exception("Modelo nulo");
		}

		if(a.first == null){
			return;
		}

		this.first = new Node(a.first.getData(), null);

		Node atualT   = first;
        	Node atualA = a.first.getNext();

        	while(atualA != null){
            		atualT.setNext (new Node(atualA.getData(), null));
            		atualT = atualT.getNext();
            		atualA = atualA.getNext();
        	}

		last = atualT;
	}

	public String toString(){
		String retorno = "";

		for(Node atual = first; atual != null; atual = atual.getNext()){
			retorno += "\n"+atual.getData().toString();
		}

		return retorno;
	}

	public boolean equals(Object o){
		if(this == o){
			return true;
		}

		if(o == null){
			return false;
		}

		if(this.getClass() != o.getClass()){
			return false;
		}

		Aeroportos a = (Aeroportos) o;

		Node atualT = first;
		Node atualA = a.first;

		while(atualT != null && atualA != null){
			if(!atualT.getData().equals(atualA.getData())){
				return false;
			}

			atualT = atualT.getNext();
			atualA = atualA.getNext();
		}

		if(atualT != null){
			return false;
		}
		if(atualA != null){
			return false;
		}

		return true;
	}

	public int hashCode(){
		int retorno = 7;

		for(Node atual = first; atual != null; atual = atual.getNext()){
			retorno *= 3;
			retorno += atual.getData().hashCode();
		}

		if(retorno < 0){
			retorno *= -1;
		}

		return retorno;
	}

	public Aeroportos clone(){
		Aeroportos retorno = null;

		try{
			retorno = new Aeroportos(this);
		}
		catch(Exception e){}

		return retorno;
	}
}
