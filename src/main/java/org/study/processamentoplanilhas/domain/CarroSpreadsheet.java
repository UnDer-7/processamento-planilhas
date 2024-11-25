package org.study.processamentoplanilhas.domain;

public class CarroSpreadsheet {

    // Colunas da tabela
    private String data;
    private String abastecido;
    private String hodometro;
    private String preco;
    private String kMparaAcabar;
    private String kMPorLitro;

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public String getAbastecido() {
        return abastecido;
    }

    public void setAbastecido(final String abastecido) {
        this.abastecido = abastecido;
    }

    public String getHodometro() {
        return hodometro;
    }

    public void setHodometro(final String hodometro) {
        this.hodometro = hodometro;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(final String preco) {
        this.preco = preco;
    }

    public String getkMparaAcabar() {
        return kMparaAcabar;
    }

    public void setkMparaAcabar(final String kMparaAcabar) {
        this.kMparaAcabar = kMparaAcabar;
    }

    public String getkMPorLitro() {
        return kMPorLitro;
    }

    public void setkMPorLitro(final String kMPorLitro) {
        this.kMPorLitro = kMPorLitro;
    }

    @Override
    public String toString() {
        return "CarroSpreadsheet{" +
            "data='" + data + '\'' +
            ", abastecido='" + abastecido + '\'' +
            ", hodometro='" + hodometro + '\'' +
            ", preco='" + preco + '\'' +
            ", KMparaAcabar='" + kMparaAcabar + '\'' +
            ", KMPorLitro='" + kMPorLitro + '\'' +
            '}';
    }
}
