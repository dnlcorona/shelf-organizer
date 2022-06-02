package JAVA;

import java.util.Scanner;

public class OrganizadorDeEstantes {

    //Quantidade máxima de livros por estante  
    public static int quantidadeMax = 30;
    //Quantidade de categorias de livros
    public static int quantCategorias = 5;
    //Variáveis globais
    public static int maximoDeLivros = 200;
    public static String[][] estanteDeLivros;
    public static String[] categorias = {"Programação", "Banco De Dados", "Redes", "Análise de Sistemas", "Modelagem De Dados"};

    public static void main(String[] args) {
        estanteDeLivros = new String[quantCategorias][quantidadeMax];

        //Inicialização de vetores
        menu:
        for (int i = 0; i < maximoDeLivros; i++) {
            if (i == 0) {
                for (int j = 0; j < estanteDeLivros.length; j++) {
                    for (int k = 0; k < estanteDeLivros[i].length; k++) {
                        estanteDeLivros[j][k] = "";
                    }
                }
            }
            System.out.println("\n");
            System.out.println(
                    "-----------~PRATELEIRA DE LIVROS~----------- \n"
                    + "Digite \"1\" para inserir um livro à prateleira \n"
                    + "Digite \"2\" para retirar um livro da prateleira \n"
                    + "Digite \"3\" para buscar um livro pelo nome \n"
                    + "Digite \"4\" para visualizar todas as prateleiras da estante \n"
                    + "Digite \"5\" para finalizar o programa \n"
                    + "--------------------------------------------");
            System.out.print("\n");
            System.out.print("DIGITE EM QUAL OPÇAO VOCE QUER ENTRAR: ");
            Scanner s = new Scanner(System.in);
            int menu = s.nextInt();
            switch (menu) {
                case 1:

                    inserirLivro();
                    break;
                case 2:
                    retirarLivro();
                    break;
                case 3:
                    buscarLivro();
                    break;
                case 4:
                    mostrarTodasPrateleiras();
                    break;
                case 5:
                    System.out.print("\n");
                    System.out.println("Obrigado por utilizar a prateleira de livros! Finalizando o programa . . . . . . . . . . . .");
                    break menu;
                default:
                    System.out.print("\n");
                    System.out.println("Número inválido, Finalizando o programa . . . . . . . . . . . .");
                    break menu;

            }

        }

    }

    public static void inserirLivro() {
        Scanner s = new Scanner(System.in);
        int ultimoLivro = 29;
        int primeiroLivro = 0;
        System.out.print("Nome do livro a ser adicionado: ");
        String nomeDoLivro = s.nextLine();
        System.out.print("\n");
        System.out.println("-----------~CATEGORIA DE LIVROS~----------- \n"
                + "\"1\" PROGRAMAÇÃO\n"
                + "\"2\" BANCO DE DADOS \n"
                + "\"3\" REDES \n"
                + "\"4\" ANÁLISE DE SISTEMAS \n"
                + "\"5\" MODELAGEM DE DADOS \n"
                + "--------------------------------------------");
        System.out.print("Qual dessas categorias o livro a ser adicionado faz parte: ");
        String numMenu = s.next();
        System.out.print("\n");
        int numMenuInt = Integer.parseInt(numMenu);
        externo:
        for (int i = 0; i < estanteDeLivros[0].length; i++) {
            if (estanteDeLivros[numMenuInt - 1][i].equals("")) {
                estanteDeLivros[numMenuInt - 1][i] = nomeDoLivro;
                System.out.print("O seu livro " + nomeDoLivro + " foi adicionado com sucesso na " + (i + 1) + "º posição, na prateleira dos livros de " + categorias[numMenuInt - 1]);
                if (i > 0) {
                    System.out.print(" e está situado depois do livro " + estanteDeLivros[numMenuInt - 1][i - 1]);
                }
                break;
            } else if (nomeDoLivro.compareTo(estanteDeLivros[numMenuInt - 1][i]) == 0) {
                System.out.println("Esse livro já existe na prateleira");
                break;
            } else if (nomeDoLivro.compareTo(estanteDeLivros[numMenuInt - 1][i]) < 0) {
                String auxP = nomeDoLivro;
                String auxG = "";

                for (int k = i; k < estanteDeLivros[primeiroLivro].length; k++) {
                    auxG = estanteDeLivros[numMenuInt - 1][k];
                    estanteDeLivros[numMenuInt - 1][k] = auxP;
                    auxP = auxG;
                    if (auxP.equals("")) {
                        System.out.print("O seu livro " + nomeDoLivro + " foi adicionado com sucesso na " + (i + 1) + "º posição, na prateleira dos livros de " + categorias[numMenuInt - 1]);
                        if ((!(estanteDeLivros[numMenuInt - 1][k].equals(""))) && (!(nomeDoLivro.equals(estanteDeLivros[numMenuInt - 1][primeiroLivro])))) {
                            System.out.print(" e está situado entre o livro " + (estanteDeLivros[numMenuInt - 1][i - 1]) + " e " + (estanteDeLivros[numMenuInt - 1][i + 1]));
                        } else if (nomeDoLivro.equals(estanteDeLivros[numMenuInt - 1][primeiroLivro])) {
                            System.out.print(" e está situado antes do livro " + estanteDeLivros[numMenuInt - 1][i + 1]);
                        } else if (nomeDoLivro.equals(estanteDeLivros[numMenuInt - 1][ultimoLivro])) {
                            System.out.print(" e está situado na última posiçao da prateleira, depois do livro " + (estanteDeLivros[numMenuInt - 1][k]));
                        }
                        break externo;
                    }
                }

            }

        }

    }

    public static void buscarLivro() {
        Scanner s = new Scanner(System.in);
        int ultimoLivro = 29;
        int primeiroLivro = 0;
        int ultimoLivroDaCateg = 4;
        System.out.print("Digite o nome do livro que deseja buscar na estante: ");
        String livroProcurado = s.nextLine();
        externo:
        for (int i = 0; i < estanteDeLivros.length; i++) {
            for (int j = 0; j < estanteDeLivros[i].length; j++) {
                if (estanteDeLivros[i][j].equals(livroProcurado)) {
                    System.out.print("\n");
                    System.out.println("O livro " + livroProcurado + " foi encontrado na " + (j + 1) + "º posição da categoria dos livros de: " + categorias[i]);
                    if ((!(estanteDeLivros[i][j + 1].equals(""))) && (!(livroProcurado.equals(estanteDeLivros[i][primeiroLivro])))) {
                        System.out.print(" e está situado entre o livro " + (estanteDeLivros[i][j - 1]) + " e " + (estanteDeLivros[i][j + 1]));
                    } else if (livroProcurado.equals(estanteDeLivros[i][primeiroLivro])) {
                        System.out.print(" e está situado antes do livro " + estanteDeLivros[i][j + 1]);
                    } else if (livroProcurado.equals(estanteDeLivros[i][ultimoLivro])) {
                        System.out.print(" e está situado na última posiçao da prateleira, depois do livro " + estanteDeLivros[i][j]);
                    }
                    System.out.print("\n");
                    break externo;
                } else if (i == ultimoLivroDaCateg && j == ultimoLivro) {
                    System.out.print("\n");
                    System.out.println("Esse livro não foi encontrado na estante");
                }
            }
        }

    }

    public static void retirarLivro() {
        Scanner s = new Scanner(System.in);
        System.out.println(" \n "
                + "Digite o nome do livro que deseja retirar da prateleira: ");
        String livroRetirado = s.nextLine();
        externo:
        for (int i = 0; i < estanteDeLivros.length; i++) {
            for (int j = 0; j < estanteDeLivros[i].length; j++) {
                if (estanteDeLivros[i][j].equals(livroRetirado)) {
                    for (int k = j; k < estanteDeLivros[i].length; k++) {
                        estanteDeLivros[i][k] = estanteDeLivros[i][k + 1];
                        if (estanteDeLivros[i][k].equals("")) {
                            System.out.println("O seu livro foi retirado com sucesso!");
                            break externo;
                        }
                    }

                }
            }
        }
    }

    public static void mostrarTodasPrateleiras() {
        for (int j = 0; j < estanteDeLivros.length; j++) {
            for (int k = 0; k < estanteDeLivros[j].length; k++) {
                System.out.println("Categoria: " + categorias[j] + " | Posiçao: " + (k + 1) + " | Livro: " + estanteDeLivros[j][k]);

            }
        }

    }

}
