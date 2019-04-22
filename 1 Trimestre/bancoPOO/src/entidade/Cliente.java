package entidade;

public class Cliente {
	private int id;
    private String nome;
    private String cpf;
    private String estado;
    private String cidade;
    private String endereco;

    // métodos get e set para id, nome, estado, cidade, endereço.
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstado() {
    	return estado;
    }
    public void setEstado(String estado) {
    	this.estado = estado;
    }
    
    public String getCidade () {
    	return cidade;
    }
    public void setCidade(String novo) {
    	this.cidade = novo;
    }
    
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String novo) {
        this.endereco = novo;
    }
}
