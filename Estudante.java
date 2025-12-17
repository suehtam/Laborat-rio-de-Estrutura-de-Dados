public class Estudante implements Comparable<Estudante> {
    private int matricula;
    private String nome;
    private int nota;

    public Estudante(int matricula, String nome, int nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public int getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public int getNota() { return nota; }

    @Override
    public int compareTo(Estudante outro) {
        // Nota decrescente
        if (this.nota != outro.nota) {
            return Integer.compare(outro.nota, this.nota);
        }
        // Nome crescente
        int cmpNome = this.nome.compareTo(outro.nome);
        if (cmpNome != 0) return cmpNome;
        // Matrícula crescente
        return Integer.compare(this.matricula, outro.matricula);
    }

    @Override
    public String toString() {
        return String.format("[%d, %s, %d]", matricula, nome, nota);
    }
}
