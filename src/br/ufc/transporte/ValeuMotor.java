package br.ufc.transporte;

import java.lang.reflect.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ValeuMotor {

    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat formatoData =
            new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {

        System.out.println("valeu motor transportes");
        System.out.println("sistema de gestao de transporte urbano\n");

        boolean sistemaAtivo = true;
        List<Object> registrosSistema = new ArrayList<>();

        while (sistemaAtivo) {
            exibirMenu();

            System.out.print("opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    Object novo = cadastrarRecurso();
                    if (novo != null) {
                        registrosSistema.add(novo);
                        System.out.println("total de registros: " + registrosSistema.size());
                    }
                }
                case 2 -> consultarRegistros(registrosSistema);
                case 3 -> operarFrota(registrosSistema);
                case 4 -> calcularEstatisticas(registrosSistema);
                case 5 -> {
                    sistemaAtivo = false;
                    System.out.println("\nobrigado por utilizar o sistema valeu motor");
                }
                default -> System.out.println("opcao invalida");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("menu principal");
        System.out.println("1 - cadastrar recurso");
        System.out.println("2 - consultar registros");
        System.out.println("3 - operar frota");
        System.out.println("4 - estatisticas");
        System.out.println("5 - sair\n");
    }

    private static Object cadastrarRecurso() {

        String[] recursos = {
                "br.ufc.transporte.Onibus",
                "br.ufc.transporte.Metro",
                "br.ufc.transporte.BicicletaCompartilhada",
                "br.ufc.transporte.Passageiro",
                "br.ufc.transporte.Rota",
                "br.ufc.transporte.Horario"
        };

        String[] nomes = {
                "onibus",
                "metro",
                "bicicleta",
                "passageiro",
                "rota",
                "horario"
        };

        System.out.println("tipos disponiveis:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println((i + 1) + " - " + nomes[i]);
        }

        System.out.print("escolha: ");
        int escolha = scanner.nextInt() - 1;
        scanner.nextLine();

        if (escolha < 0 || escolha >= recursos.length) {
            System.out.println("selecao invalida");
            return null;
        }

        try {
            Class<?> classe = Class.forName(recursos[escolha]);
            Constructor<?> construtor = classe.getConstructors()[0];

            Class<?>[] tipos = construtor.getParameterTypes();
            Object[] valores = new Object[tipos.length];

            System.out.println("\npreencha os dados:");

            for (int i = 0; i < tipos.length; i++) {
                String campo = obterNomeCampo(classe, i);
                System.out.print(campo + ": ");
                String entrada = scanner.nextLine();
                valores[i] = converterValor(entrada, tipos[i]);
            }

            Object obj = construtor.newInstance(valores);

            System.out.println("\ncadastro realizado com sucesso");

            try {
                Method desc = classe.getMethod("getDescricao");
                System.out.println(desc.invoke(obj));
            } catch (Exception e) {
                System.out.println(obj);
            }

            return obj;

        } catch (InvocationTargetException e) {
            System.out.println("erro: " + e.getTargetException().getMessage());
        } catch (Exception e) {
            System.out.println("erro no cadastro");
        }

        return null;
    }
    private static String obterNomeCampo(Class<?> classe, int indice) {

        if (classe == Onibus.class) {
            return switch (indice) {
                case 0 -> "ID";
                case 1 -> "Nome";
                case 2 -> "Linha";
                case 3 -> "Capacidade";
                case 4 -> "Custo operacional";
                default -> "Valor";
            };
        }

        if (classe == Metro.class) {
            return switch (indice) {
                case 0 -> "ID";
                case 1 -> "Nome";
                case 2 -> "Capacidade";
                case 3 -> "Custo operacional";
                default -> "Valor";
            };
        }

        if (classe == BicicletaCompartilhada.class) {
            return switch (indice) {
                case 0 -> "ID";
                case 1 -> "Nome";
                case 2 -> "Disponível (sim/nao)";
                default -> "Valor";
            };
        }

        if (classe == Passageiro.class) {
            return switch (indice) {
                case 0 -> "ID";
                case 1 -> "Nome";
                case 2 -> "Saldo";
                default -> "Valor";
            };
        }

        if (classe == Rota.class) {
            return switch (indice) {
                case 0 -> "Codigo";
                case 1 -> "Descricao";
                default -> "Valor";
            };
        }

        if (classe == Horario.class) {
            return switch (indice) {
                case 0 -> "Inicio (dd/MM/yyyy HH:mm)";
                case 1 -> "Fim (dd/MM/yyyy HH:mm)";
                default -> "Valor";
            };
        }

        return "Valor";
    }

    private static Object converterValor(String valor, Class<?> tipo) {
        try {
            if (tipo == int.class) return Integer.parseInt(valor);
            if (tipo == double.class) return Double.parseDouble(valor);
            if (tipo == boolean.class)
                return valor.equalsIgnoreCase("sim") || valor.equals("1");
            if (tipo == String.class) return valor;
            if (tipo == Date.class) return formatoData.parse(valor);
        } catch (Exception e) {
            return obterPadrao(tipo);
        }
        return null;
    }

    private static Object obterPadrao(Class<?> tipo) {
        if (tipo == int.class) return 1;
        if (tipo == double.class) return 1.0;
        if (tipo == boolean.class) return false;
        if (tipo == String.class) return "valeu motor";
        if (tipo == Date.class) return new Date();
        return null;
    }

    private static void consultarRegistros(List<Object> registros) {
        if (registros.isEmpty()) {
            System.out.println("nenhum registro encontrado");
            return;
        }

        System.out.println("registros do sistema:");
        for (Object obj : registros) {
            try {
                Method desc = obj.getClass().getMethod("getDescricao");
                System.out.println(desc.invoke(obj));
            } catch (Exception e) {
                System.out.println(obj);
            }
        }
    }

    private static void operarFrota(List<Object> registros) {

        List<Transportavel> veiculos = new ArrayList<>();

        for (Object obj : registros) {
            if (obj instanceof Transportavel) {
                veiculos.add((Transportavel) obj);
            }
        }

        if (veiculos.isEmpty()) {
            System.out.println("nenhum veiculo disponivel");
            return;
        }

        System.out.println("operando frota:");
        for (Transportavel v : veiculos) {
            v.mover();
        }
    }

    private static void calcularEstatisticas(List<Object> registros) {

        int onibus = 0, metro = 0, bikes = 0;
        List<Passageiro> passageiros = new ArrayList<>();

        for (Object obj : registros) {
            if (obj instanceof Onibus) onibus++;
            else if (obj instanceof Metro) metro++;
            else if (obj instanceof BicicletaCompartilhada) bikes++;
            else if (obj instanceof Passageiro)
                passageiros.add((Passageiro) obj);
        }

        System.out.println("estatisticas:");
        System.out.println("onibus: " + onibus);
        System.out.println("metro: " + metro);
        System.out.println("bicicletas: " + bikes);
        System.out.println("passageiros: " + passageiros.size());
    }
}
