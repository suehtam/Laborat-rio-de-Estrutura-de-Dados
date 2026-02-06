package atividadeEmSala;

/*

ATIVIDADE EM SALA

Altere todas as partes marcadas com //TODO de forma que:

1) A classe FilaDePilhas implemente corretamente uma FILA utilizando duas PILHAS.
2) A classe PilhaDeFilas implemente corretamente uma PILHA utilizando duas FILAS.
3) O método balancoDeParenteses resolva o problema de verificação de parênteses balanceados utilizando PILHA.
4) O método diamantesEAreia resolva o problema de contagem de diamantes utilizando PILHA.

Após concluir, o método main deverá executar corretamente sem nenhuma modificação.

OBSERVAÇÕES:
- Não é permitido utilizar estruturas auxiliares além das já declaradas.
- Trate erros seguindo este padrão:
  if (isEmpty()) throw new RuntimeException("Estrutura vazia");

*/


import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


public class BrincandoComPilhasEFilas {

	public static void main(String[] args) {
		
		final int QTD_ELEMENTOS = 10; 
		
		FilaDePilhas_IF fila = new FilaDePilhas();
		PilhaDeFilas_IF pilha = new PilhaDeFilas();
		
		for (int i = 0; i < QTD_ELEMENTOS; i++) {
			fila.enqueue(i);
			pilha.push(i);
		}
		
		System.out.println("\nFila...");
		for (int i = 0; i < QTD_ELEMENTOS; i++) {
			System.out.println(fila.head()); 
			fila.dequeue();
		}
		
		System.out.println("\nPilha...");
		for (int i = 0; i < QTD_ELEMENTOS; i++) {
			System.out.println(pilha.top()); 
			pilha.pop();
		}
		
		System.out.println("\nBalanço de Parênteses..."); //https://resources.beecrowd.com/repository/UOJ_1068.html
		String[] expressoes = {"a+(b*c)-2-a", "(a+b*(2-c)-2+a)*2", "(a*b-(2+c)", "2*(3-a))", ")3+b*(2-c)("};
		for (String expressao : expressoes) {
			System.out.println(balancoDeParenteses(expressao));
		}
		
		System.out.println("\nDiamantes e Areia..."); //https://resources.beecrowd.com/repository/UOJ_1069.html
		String[] entradas = {"<..><.<..>>", "<<<..<......<<<<....>"};
		for (String e : entradas) {
			System.out.println(diamantesEAreia(e));
		}
		
	}

	private static String balancoDeParenteses(String expressao) {
		PilhaDeFilas_IF p = new PilhaDeFilas();
		//TODO //Retornar "correct" ou "incorrect" conforme o padrão do problema
		return null;
	}
	
	private static int diamantesEAreia(String e) {
		PilhaDeFilas_IF p = new PilhaDeFilas();
		//TODO
		return -1;
	}

}


interface FilaDePilhas_IF {
    void enqueue(int x);
    int dequeue();
    int head();
    boolean isEmpty();
}


interface PilhaDeFilas_IF {
    void push(int x);
    int pop();
    int top();
    boolean isEmpty();
}


class FilaDePilhas implements FilaDePilhas_IF {

    private Stack<Integer> p1, p2;

    public FilaDePilhas() {
        p1 = new Stack<>();
        p2 = new Stack<>();
    }

    public void enqueue(int x) {
        //TODO
    }

    public int dequeue() {
    	//TODO
        return -1;
    }

    public int head() { 
    	//TODO
        return -1;
    }

    public boolean isEmpty() {
    	//TODO
    	return false;
    }

}


class PilhaDeFilas implements PilhaDeFilas_IF {

    private Queue<Integer> f1, f2;

    public PilhaDeFilas() {
        f1 = new LinkedList<>();
        f2 = new LinkedList<>();
    }

	public void push(int x) {
		//TODO
	}

	public int pop() {
		//TODO
        return -1;
	}

	public int top() {
		//TODO
        return -1;
	}
	
	public boolean isEmpty() {
		//TODO
		return false;
	}
    
}
