public class Voo implements Cloneable
{
    private int codVoo;
    private String codAeroportoDestino;

    public Voo (int codVoo, String codAeroportoDestino) throws Exception
    {
        setCodVoo(codVoo);
        setCodAeroportoDestino(codAeroportoDestino);
    }

    public void setCodVoo(int codVoo) throws Exception
    {
        if(codVoo < 0)
            throw new Exception("codVoo inválido");

        this.codVoo = codVoo;
    }

    public void setCodAeroportoDestino(String codAeroportoDestino) throws Exception
    {
        if(codAeroportoDestino == null)
            throw new Exception("codAeroprotoDestino inválido");

        this.codAeroportoDestino = codAeroportoDestino;
    }
    
    public int getCodVoo()
    {
        return this.codVoo;
    }

    public String getCodAeroportoDestino()
    {
        return this.codAeroportoDestino;
    }

    public String toString()
    {
        return "codVoo: " + this.codVoo + "/ codAeroportoDestino: " + this.codAeroportoDestino;
    }

    public boolean equals(Object x)
    {
        if(this == x)
            return true;
            
        if(x == null)
            return false;

        if(x.getClass() != this.getClass())
            return false;

        Voo modelo = (Voo)x;

        if(this.codVoo != modelo.codVoo)
            return false;

        if(this.codAeroportoDestino != modelo.codAeroportoDestino)
            return false;

        return true;
    }

    public Voo (Voo modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("modelo ausente");

        setCodVoo(modelo.codVoo);
        setCodAeroportoDestino(modelo.codAeroportoDestino);
    }

    public Object clone()
    {
        Voo ret = null;

        try
        {
            ret = new Voo(this);
        }
        catch(Exception err)
        {}

        return ret;
    }

    public int hashCode()
    {
        int ret = 10;

        ret += ret * 13 + new Integer(this.codVoo).hashCode();
        ret += ret * 13 + this.codAeroportoDestino.hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }
}
