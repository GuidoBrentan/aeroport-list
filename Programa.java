public class Programa {
    public static void main(String[] args) {
        try
        {
            Voos testeVoos = new Voos();
            Voo testeVoo = new Voo(214, "SSA");
            Voo testeVoo2 = new Voo(555, "GIG");
            Voo testeVoo3 = new Voo(101, "GRU");

            testeVoos.add(testeVoo);
            testeVoos.add(testeVoo2);
            testeVoos.add(testeVoo3);
            Aeroporto aeroporto = new Aeroporto("cnf", testeVoos, "Belo Horizonte");

            System.out.println(aeroporto);
        }
        catch(Exception err){
            System.err.println(err.getMessage());
        }
    }
}