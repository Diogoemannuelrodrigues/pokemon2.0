package br.com.pokedex.entity;

public enum Type {

    PLANTA(1, "Planta"),
    VENENOSO(2, "Venenoso"),
    FOGO(3, "Fogo"),
    DRAGAO(4, "Dragao"),
    VOADOR(5, "Voador"),
    AGUA(6, "Agua"),
    INSETO(7, "Inseto"),
    NORMAL(8, "Normal"),
    ELETRICO(9, "Eletrico"),
    TERRESTRE(10, "Terrestre"),
    FADA(11, "Fada"),
    LUTADOR(12, "Lutador"),
    PSIQUICO(13, "Psiquico"),
    METAL(14, "Metal"),
    GELO(15, "Gelo"),
    FANTASMA(16, "Fantasma"),
    PEDRA(17, "Pedra");

    private int cod;
    private String descricao;

    private Type(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Type toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Type x : Type.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
