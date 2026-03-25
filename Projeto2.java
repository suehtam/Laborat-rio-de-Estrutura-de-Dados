// =========================================
// SISTEMA COMPLETO DE ESTOQUE - PROJETO UEPB
// Inclui: Lista, Pilha, Fila(2 pilhas), Hash(chaining), AVL, Heap, JUnit base
// =========================================

import java.util.*;

// ================= LISTA ENCADEADA =================
class No<T> {
    T valor;
    No<T> proximo;

    No(T v) { valor = v; }
}

class ListaEncadeada<T> {
    No<T> head;

    void inserir(T v) {
        No<T> n = new No<>(v);
        n.proximo = head;
        head = n;
    }

    T buscar(java.util.function.Predicate<T> cond) {
        No<T> atual = head;
        while (atual != null) {
            if (cond.test(atual.valor)) return atual.valor;
            atual = atual.proximo;
        }
        return null;
    }
}

// ================= PILHA =================
class Pilha<T> {
    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    void push(T v) { lista.inserir(v); }

    T pop() {
        if (lista.head == null) return null;
        T v = lista.head.valor;
        lista.head = lista.head.proximo;
        return v;
    }

    boolean isEmpty() { return lista.head == null; }
}

// ================= FILA COM 2 PILHAS =================
class Fila<T> {
    private Pilha<T> entrada = new Pilha<>();
    private Pilha<T> saida = new Pilha<>();

    void enqueue(T v) { entrada.push(v); }

    T dequeue() {
        if (saida.isEmpty()) {
            while (!entrada.isEmpty()) {
                saida.push(entrada.pop());
            }
        }
        return saida.pop();
    }
}

// ================= PRODUTO =================
class Produto {
    int id;
    String nome;
    int quantidade;

    Produto(int id, String nome, int qtd) {
        this.id = id;
        this.nome = nome;
        this.quantidade = qtd;
    }

    public String toString() {
        return id + " - " + nome + " (" + quantidade + ")";
    }
}

// ================= HASH COM CHAINING =================
class TabelaHash {
    private ListaEncadeada<Produto>[] tabela;
    private int tamanho = 10;

    TabelaHash() {
        tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) tabela[i] = new ListaEncadeada<>();
    }

    private int hash(int k) { return k % tamanho; }

    void put(Produto p) {
        tabela[hash(p.id)].inserir(p);
    }

    Produto get(int id) {
        return tabela[hash(id)].buscar(p -> p.id == id);
    }
}

// ================= AVL =================
class NoAVL {
    Produto valor;
    NoAVL esq, dir;
    int altura;

    NoAVL(Produto v) { valor = v; altura = 1; }
}

class AVL {
    NoAVL raiz;

    int altura(NoAVL n) { return n == null ? 0 : n.altura; }

    int balance(NoAVL n) { return n == null ? 0 : altura(n.esq) - altura(n.dir); }

    NoAVL rotDir(NoAVL y) {
        NoAVL x = y.esq;
        y.esq = x.dir;
        x.dir = y;
        y.altura = 1 + Math.max(altura(y.esq), altura(y.dir));
        x.altura = 1 + Math.max(altura(x.esq), altura(x.dir));
        return x;
    }

    NoAVL rotEsq(NoAVL x) {
        NoAVL y = x.dir;
        x.dir = y.esq;
        y.esq = x;
        x.altura = 1 + Math.max(altura(x.esq), altura(x.dir));
        y.altura = 1 + Math.max(altura(y.esq), altura(y.dir));
        return y;
    }

    NoAVL inserir(NoAVL n, Produto p) {
        if (n == null) return new NoAVL(p);
        if (p.id < n.valor.id) n.esq = inserir(n.esq, p);
        else n.dir = inserir(n.dir, p);

        n.altura = 1 + Math.max(altura(n.esq), altura(n.dir));
        int b = balance(n);

        if (b > 1 && p.id < n.esq.valor.id) return rotDir(n);
        if (b < -1 && p.id > n.dir.valor.id) return rotEsq(n);
        if (b > 1 && p.id > n.esq.valor.id) {
            n.esq = rotEsq(n.esq);
            return rotDir(n);
        }
        if (b < -1 && p.id < n.dir.valor.id) {
            n.dir = rotDir(n.dir);
            return rotEsq(n);
        }
        return n;
    }

    void inserir(Produto p) { raiz = inserir(raiz, p); }
}

// ================= HEAP =================
class Heap {
    Produto[] heap;
    int tamanho;

    Heap(int cap) { heap = new Produto[cap]; }

    void inserir(Produto p) {
        heap[tamanho] = p;
        subir(tamanho++);
    }

    void subir(int i) {
        while (i > 0 && heap[i].quantidade < heap[(i-1)/2].quantidade) {
            Produto t = heap[i];
            heap[i] = heap[(i-1)/2];
            heap[(i-1)/2] = t;
            i = (i-1)/2;
        }
    }

    Produto remover() {
        if (tamanho == 0) return null;
        Produto raiz = heap[0];
        heap[0] = heap[--tamanho];
        descer(0);
        return raiz;
    }

    void descer(int i) {
        int menor = i;
        int e = 2*i+1, d = 2*i+2;
        if (e < tamanho && heap[e].quantidade < heap[menor].quantidade) menor = e;
        if (d < tamanho && heap[d].quantidade < heap[menor].quantidade) menor = d;
        if (menor != i) {
            Produto t = heap[i];
            heap[i] = heap[menor];
            heap[menor] = t;
            descer(menor);
        }
    }
}

// ================= SISTEMA =================
public class SistemaEstoque {

    TabelaHash hash = new TabelaHash();
    AVL avl = new AVL();
    Fila<String> fila = new Fila<>();
    Heap heap = new Heap(50);

    void cadastrar(int id, String nome, int qtd) {
        Produto p = new Produto(id, nome, qtd);
        hash.put(p);
        avl.inserir(p);
        heap.inserir(p);
    }

    void requisicao(String r) { fila.enqueue(r); }

    void processar() {
        String r;
        while ((r = fila.dequeue()) != null) {
            System.out.println("Processando: " + r);
        }
    }

    public static void main(String[] args) {
        SistemaEstoque s = new SistemaEstoque();

        s.cadastrar(1, "Teclado", 10);
        s.cadastrar(2, "Mouse", 3);
        s.cadastrar(3, "Monitor", 1);

        s.requisicao("Entrada");
        s.requisicao("Saída");

        s.processar();

        System.out.println("Menor estoque: " + s.heap.remover());
    }
}

// ================= JUNIT (EXEMPLO) =================
/*
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TesteSistema {
    @Test
    void testeCadastro() {
        SistemaEstoque s = new SistemaEstoque();
        s.cadastrar(1, "Teste", 5);
        assertNotNull(s.hash.get(1));
    }
}
*/

// ================= ROTEIRO DO VÍDEO =================
/*
1. Apresentação dos integrantes
2. Explicação das estruturas:
   - Lista → base
   - Pilha → LIFO
   - Fila → 2 pilhas (explicar inversão)
   - Hash → acesso O(1)
   - AVL → balanceamento
   - Heap → prioridade
3. Demonstração do sistema rodando
4. Análise de complexidade:
   - Hash: O(1)
   - AVL: O(log n)
   - Heap: O(log n)
   - Fila: O(1) amortizado
5. Conclusão
*/
