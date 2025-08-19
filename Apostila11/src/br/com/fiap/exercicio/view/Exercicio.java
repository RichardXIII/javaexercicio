package br.com.fiap.exercicio.view;

import br.com.fiap.exercicio.model.Aluno;

import java.util.*;

public class Exercicio {

    public static void main(String[] args) {
        //Criar um mapa de aluno
        Map<Integer, Aluno> mapaAluno = new HashMap<>();

        Scanner leitor = new Scanner(System.in);

        do {
            //Ler os dados dos alunos
            System.out.println("Digite o RM do aluno:");
            int rm = leitor.nextInt();

            System.out.println("Digite o nome do aluno");
            String nome = leitor.next() + leitor.nextLine();

            System.out.println("Digite a idade do aluno");
            int idade = leitor.nextInt();

            System.out.println("Digite a nota 1 do aluno");
            double nota1 = leitor.nextDouble();

            System.out.println("Digite a nota 2 do aluno");
            double nota2 = leitor.nextDouble();

            //Criar um aluno
            Aluno aluno = new Aluno(rm, nome, idade, nota1, nota2);

            //Adicionar no mapa o aluno
            mapaAluno.put(rm, aluno);

            //Perguntar se deseja adicionar mais alunos no mapa
            System.out.println("Deseja cadastrar mais aluno? S-Sim N-Não");
        } while(!leitor.next().equalsIgnoreCase("n"));

        //Recuperar todos os alunos (valores do mapa)
        Collection<Aluno> alunos = mapaAluno.values();

        //Exibir todos os alunos cadastrados
        for (Aluno a : alunos){
            System.out.println(a); //Na classe Aluno? implementar o toString()
        }

        //Exibir o total de alunos
        System.out.println("Total de alunos é: " + alunos.size());

        int somaIdades = 0;
        double somaNotas  = 0;
        int maiorIdade = 0;
        int menorIdade = 0;
        for (Aluno a : alunos){
            somaIdades += a.getIdade();
            somaNotas += (a.getNota1() + a.getNota2())/2;
        }

        for (Aluno a : alunos){
            if (a.getIdade() > maiorIdade){
                maiorIdade = a.getIdade();
            }
            if (a.getIdade() < menorIdade || menorIdade == 0) {
                menorIdade = a.getIdade();
            }
        }
        //ex
        int op;
        do {
            System.out.println("Digite opção: \n-Exibir nomes e medias" +
                    "\n2-Alunos cm medias maiores que 6" +
                    "\n3-Alunos com mais de 30 Anos \n4-Excluir alunos medias < 3\n0-Sair");
            op = leitor.nextInt();
            leitor.nextLine();

            switch (op){
                case 1:
                    for (Aluno a : alunos){
                        System.out.println(a.getNome() + " " + ((a.getNota1() + a.getNota2()) /2));
                    }
                    break;
                case 2:
                    for (Aluno churros : alunos){
                        double media = (churros.getNota1() + churros.getNota2()) / 2;
                        if (media >6)
                            System.out.println(churros);
                    }
                    break;
                case 3:
                    for( Aluno aluno : alunos){
                        if(aluno.getIdade() > 30)
                            System.out.println(aluno);
                    }
                    break;
                case 4:
                  for(Aluno a : alunos) {
                      if (((a.getNota1() + a.getNota2()) / 2) < 3)
                          System.out.println("Removendo alunos burros" + alunos.remove(a));
                  }
                    break;
                case 0:
                    System.out.println("Finalizando o programa");
                    break;
                default:
                    System.out.println("Opção invalida");

            }




        }while(op != 0);



        leitor.close();
        //exibir o aluno com maior e menor idade:
        System.out.println("Maior idade entre alunos: " + maiorIdade);
        System.out.println("Menor idade entre alunos: " + menorIdade);
        //Exibir a média de notas
        System.out.println(("Média de notas: " + somaNotas/ alunos.size()));
        //Exibir a média de idade
        System.out.println("Média de idade dos alunos: " + somaIdades/alunos.size());

    }//main
}//class
