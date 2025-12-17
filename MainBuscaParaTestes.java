public class MainBusca {
    public static void main(String[] args) {
        Estudante[] estudantes = {
            new Estudante(1, "Ana", 90),
            new Estudante(2, "Carlos", 85),
            new Estudante(3, "Bruno", 90),
            new Estudante(4, "Daniela", 70)
        };

        // Ordenar antes de buscar
        java.util.Arrays.sort(estudantes);

        Estudante chave = new Estudante(2, "Carlos", 85);

        System.out.println("Busca Linear Iterativa: " +
            BuscaLinear.buscaLinearIterativa(estudantes, chave));

        System.out.println("Busca Linear Recursiva: " +
            BuscaLinear.buscaLinearRecursiva(estudantes, chave, 0));

        System.out.println("Busca Linear Duas Pontas: " +
            BuscaLinear.buscaLinearDuasPontas(estudantes, chave));

        System.out.println("Busca Binária Iterativa: " +
            BuscaBinaria.buscaBinariaIterativa(estudantes, chave));

        System.out.println("Busca Binária Recursiva: " +
            BuscaBinaria.buscaBinariaRecursiva(estudantes, chave, 0, estudantes.length-1));
    }
}
