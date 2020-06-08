public class Voos implements Cloneable
{
    private class No
    {
        private Voo dado;
        private No prox;

        public No ()
        {
            this.dado = null;
            this.prox = null;
        }

        public void setDado (Voo modelo)
        {
            this.dado = modelo;
        }

        public void setProx (No modelo)
        {
            this.prox = modelo;
        }

        public Voo getVoo ()
        {
            return this.dado;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public int getCodVoo()
        {
            return dado.getCodVoo();
        }
    }

    private No inicio, ultimo;

    public Voos ()
    {
        this.inicio = null;
        this.ultimo = this.inicio;
    }

    public void add(Voo x) throws Exception
    {
        if(x == null)
            throw new Exception("Sem voo");

        if(existe(x))
            throw new Exception("Codigo de voo repetido");

        No aux = new No();
        aux.setDado(x);

        if(inicio == null)
        {
            this.inicio = aux;
            this.ultimo = inicio;
        }
        else
        {
            this.ultimo.setProx(aux);
            this.ultimo = aux;
        }
    }

    public void remove(int codVoo) throws Exception
    {
        if(codVoo <= 0)
            throw new Exception("codVoo invalido");

            if(this.inicio == null)
            throw new Exception("Lista vazia");

        if(codVoo == this.inicio.getCodVoo())
        {
            if(this.inicio == this.ultimo)
                this.ultimo = null;
            else
                this.inicio = this.inicio.getProx();

            return;
        }

        No atual = this.inicio;

        for(;;)
        {
            if(atual.getProx() == null)
                throw new Exception("voo não existe");

            if(codVoo == atual.getProx().getCodVoo())
            {
                if(this.ultimo == atual.getProx())
                    this.ultimo = atual;

                atual.setProx(atual.getProx().getProx());

                return;
            }

            atual.getProx();
        }
    }

    public void remove(Voo x) throws Exception
    {
        if(x == null)
            throw new Exception("Sem voo");

        if(this.inicio == null)
            throw new Exception("Lista vazia");

        if(x.equals(this.inicio.getVoo()))
        {
            if(this.inicio == this.ultimo)
                this.ultimo = null;
            else
                this.inicio = this.inicio.getProx();

            return;
        }

        No atual = this.inicio;

        for(;;)
        {
            if(atual.getProx() == null)
                throw new Exception("voo não existe");

            if(x.equals(atual.getProx().getVoo()))
            {
                if(this.ultimo == atual.getProx())
                    this.ultimo = atual;

                atual.setProx(atual.getProx().getProx());

                return;
            }

            atual.getProx();
        }
    }

    public String toString()
    {
        String ret = "";

        No atual = this.inicio;
        while(atual != null)
        {
            if(atual == this.inicio)
                ret += "(" + atual.getVoo() + ")";
            else
                ret += ",(" + atual.getVoo() + ")";
            
            atual = atual.getProx();
        }

        return ret;
    }

    public boolean existe (Voo x)
    {
        No atual = this.inicio;

        while (atual != null)
        {
            if (x.getCodVoo() == atual.getCodVoo())
                return true;
                
            atual = atual.getProx();
        }
        
        return false;
    }

    public boolean existe (int x)
    {
        No atual = this.inicio;

        while (atual != null)
        {
            if (x == atual.getCodVoo())
                return true;
                
            atual = atual.getProx();
        }
        
        return false;
    }


    public int hashCode ()
    {   
        int ret=10; // qualquer inteiro positivo serve

        for (No atual=this.inicio; atual!=null; atual = atual.getProx())
             ret = 17*ret + atual.getVoo().hashCode();

        if (ret < 0) 
        ret = -ret;

        return ret;
    }

    public Object clone ()
    {
        Voos ret = null;

        try
        {
            ret = new Voos(this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }

    public Voos (Voos modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo ausente");

        if (modelo.inicio == null)
            return; // sai do construtor, pq this.inicio ja é null

        this.inicio = modelo.inicio;

        No atualDoThis   = this.inicio;
        No atualDoModelo = modelo.inicio.getProx();

        while (atualDoModelo!=null)
        {
            atualDoThis.setProx      (atualDoModelo);
            atualDoThis   = atualDoThis  .getProx ();
            atualDoModelo = atualDoModelo.getProx ();
        }

        this.ultimo = atualDoThis;
    }
}
