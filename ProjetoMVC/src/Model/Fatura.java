
package Model;


public class Fatura {
     private int valorTotal;
    private String data;
    private String cliente;
    private String animal;
    private String produtVendidos;
    private String procedEfetuados;

    
    //========== CONSTRUTOR ===========
    public Fatura(int valorTotal, String data, String cliente, String animal, String produtVendidos,
            String procedEfetuados) {
        this.valorTotal = valorTotal;
        this.data = data;
        this.cliente = cliente;
        this.animal = animal;
        this.produtVendidos = produtVendidos;
        this.procedEfetuados = procedEfetuados;
    }


    //========== MÉTODOS ESPECÍFICOS ============
    

    //========== GETTERS E SETTERS ============
    public int getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }


    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }


    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


    public String getAnimal() {
        return animal;
    }
    public void setAnimal(String animal) {
        this.animal = animal;
    }


    public String getProdutVendidos() {
        return produtVendidos;
    }
    public void setProdutVendidos(String produtVendidos) {
        this.produtVendidos = produtVendidos;
    }


    public String getProcedEfetuados() {
        return procedEfetuados;
    }
    public void setProcedEfetuados(String procedEfetuados) {
        this.procedEfetuados = procedEfetuados;
    }

}
