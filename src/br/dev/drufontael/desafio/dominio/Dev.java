package br.dev.drufontael.desafio.dominio;

import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos.addAll(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos.addAll(conteudosConcluidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dev dev = (Dev) o;

        if (!Objects.equals(nome, dev.nome)) return false;
        if (!Objects.equals(conteudosInscritos, dev.conteudosInscritos))
            return false;
        return Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (conteudosInscritos != null ? conteudosInscritos.hashCode() : 0);
        result = 31 * result + (conteudosConcluidos != null ? conteudosConcluidos.hashCode() : 0);
        return result;
    }


    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }


    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public void progredir() {

        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        }else {
            System.err.println("Você não esta matriculado em nenhum conteudo!");
        }

    }

    public void progredir(Conteudo conteudo) {
        if(this.conteudosInscritos.remove(conteudo)) {
            this.conteudosConcluidos.add(conteudo);
        }else {
            System.err.println("Você não esta matriculado nesse conteudo!");
        }
    }
}
