public class Estudante implements Comparable<Estudante> {
    private int matricula;
    private String nome;
    private int nota;

    @Override
    public int compareTo(Estudante outro) {
        // Ordenação por nota decrescente
        if (this.nota != outro.nota) {
            return Integer.compare(outro.nota, this.nota);
        }
        // Empate: nome crescente
        int cmpNome = this.nome.compareTo(outro.nome);
        if (cmpNome != 0) return cmpNome;
        // Empate: matrícula crescente
        return Integer.compare(this.matricula, outro.matricula);
    }
}
