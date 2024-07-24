import br.dev.drufontael.desafio.dominio.Bootcamp;
import br.dev.drufontael.desafio.dominio.Curso;
import br.dev.drufontael.desafio.dominio.Dev;
import br.dev.drufontael.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso("Java Basico", "Sintaxe, condicionais e loops", 10);
        Curso curso2 = new Curso("Java Intermediario", "Programação Orientada a Objetos", 20);
        Mentoria mentoria = new Mentoria("Java com IA", "Como usar a Inteligência Artificial para programar", LocalDate.now().plusDays(5));

        System.out.println(curso);
        System.out.println(curso2);
        System.out.println(mentoria);
        System.out.println("--------------------------");

        Bootcamp bootcamp=new Bootcamp("Java Developer", "Programação Orientada a Objetos");
        bootcamp.getConteudos().addAll(Arrays.asList(curso,curso2,mentoria));
        System.out.println("Conteudos do Bootcamp: "+bootcamp.getConteudos());
        System.out.println("--------------------------");

        Dev dev = new Dev("Dru");
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Dru: "+dev.getConteudosInscritos());
        System.out.println("-");
        dev.progredir();
        System.out.println("Conteudos Inscritos Dru: "+dev.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Dru: "+dev.getConteudosConcluidos());
        System.out.println("-");
        dev.progredir();
        System.out.println("Conteudos Inscritos Dru: "+dev.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Dru: "+dev.getConteudosConcluidos());
        System.out.println("Total de XP de Dru: "+dev.calcularTotalXp());
        System.out.println("--------------------------");

        Dev dev2 = new Dev("Edu");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Edu: "+dev2.getConteudosInscritos());
        System.out.println("-");
        dev2.progredir();
        System.out.println("Conteudos Inscritos Edu: "+dev2.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Edu: "+dev2.getConteudosConcluidos());
        System.out.println("Total de XP de Edu: "+dev2.calcularTotalXp());


    }
}
