package br.dev.drufontael.desafio.dominio;

import java.util.Objects;

public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conteudo conteudo = (Conteudo) o;

        if (!Objects.equals(titulo, conteudo.titulo)) return false;
        return Objects.equals(descricao, conteudo.descricao);
    }

    @Override
    public int hashCode() {
        int result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    public abstract double calcularXp();
}
