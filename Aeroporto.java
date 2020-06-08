public class Aeroporto  implements Cloneable{
    private String codAeroporto;
    private Voos listaDeVoos;
    private String cidade;

    public Aeroporto (String codAeroporto, Voos listaDeVoos, String cidade) throws Exception
    {
        setCodAeroporto(codAeroporto);
        setListaDeVoos(listaDeVoos);
        setCidade(cidade);
    }

    public void setCodAeroporto(String codAeroporto) throws Exception
    {
        if(codAeroporto == null || codAeroporto.length() != 3)
            throw new Exception("codAeroporto invalido");

        this.codAeroporto = codAeroporto.toUpperCase();
    }

    public void setListaDeVoos(Voos listaDeVoos) throws Exception
    {
        if(listaDeVoos == null)
            throw new Exception("listaDeVoos nula");

        this.listaDeVoos = listaDeVoos;
    }

    public void setCidade(String cidade) throws Exception
    {
        if(cidade == null)
            throw new Exception("Falta cidade");

        this.cidade = cidade;
    }

    public String getCodAeroporto()
    {
        return this.codAeroporto;
    }

    public Voos getListaDeVoos()
    {
        return this.listaDeVoos;
    }

    public String getCidade()
    {
        return this.cidade;
    }

    public String toString()
    {
        String ret = "";

        ret = "codAeroporto: " + this.codAeroporto + " | Voos: " + this.listaDeVoos + " | Cidade: " + this.cidade;
        return ret;
    }

    public int hashCode()
    {
        int ret = 10;

        ret += ret * 7 + this.codAeroporto.hashCode() + this.listaDeVoos.hashCode() + this.cidade.hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }

    public boolean equals(Object x)
    {
        if(x == this)
            return true;

        if(x == null)
            return false;

        if(x.getClass() != this.getClass())
            return false;

        Aeroporto modelo = (Aeroporto) x;

        if(!modelo.codAeroporto.equals(this.codAeroporto))
            return false;

        if(!modelo.listaDeVoos.equals(this.listaDeVoos))
            return false;

        if(!modelo.cidade.equals(this.cidade))
            return false;

        return true;
    }

    public Aeroporto (Aeroporto modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("modelo vazio");

        setCodAeroporto(modelo.codAeroporto);
        setListaDeVoos(modelo.listaDeVoos);
        setCidade(modelo.cidade);
    }

    public Object clone()
    {
        Aeroporto ret = null;

        try
        {
            ret = new Aeroporto(this);
        }
        catch(Exception err)
        {}

        return ret;
    }
}
