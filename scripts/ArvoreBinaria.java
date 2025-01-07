package scripts;
public class ArvoreBinaria {
  private No raiz;

  public void inserir(int valor) {
    raiz = inserirRecursivo(raiz, valor);
  }

  private No inserirRecursivo(No no, int valor) {
    if (no == null) {
      no = new No(valor);
      return no;
    }
    if (valor < no.valor) {
      no.noEsquerdo = inserirRecursivo(no.noEsquerdo, valor);
    } else if (valor > no.valor) {
      no.noDireito = inserirRecursivo(no.noDireito, valor);
    }
    return no;
  }

  public void listar() {
    listarRecursivamente(raiz);
  }

  private void listarRecursivamente(No no) {
    if (no != null) {
      listarRecursivamente(no.noEsquerdo);
      System.out.print(no.valor + " ");
      listarRecursivamente(no.noDireito);
    }
  }

  public boolean buscar(int valor){
    return buscarRecursivamente(raiz, valor);
  }

  private No buscarRecursivamente(No no, int valor){
    if(no == null || no.valor == valor){
      return no;
    }
    if(valor<no.valor){
      return buscarRecursivamente(no.noEsquerdo, valor);
    }
    return buscarRecursivamente(no.noDireito, valor);
  }

  public static void main(String[] args) {
    ArvoreBinaria arvore = new ArvoreBinaria();
    arvore.inserir(10);// raiz. Arrumar para que o usuário possa inserir a raiz e o outros valores por conta própria
    arvore.inserir(5);
    arvore.inserir(15);
    arvore.inserir(3);
    arvore.inserir(7);
    arvore.inserir(12);
    arvore.inserir(20);

    System.out.println("A raiz é: " + arvore.raiz.valor);
    System.out.println("Percorrendo em ordem:");
    arvore.listar();

    System.out.println("\nBusca de valores:");
    System.out.println("Buscando o valor 12"+arvore.buscar(12));
    System.out.println("Buscando o valor 15"+arvore.buscar(5));
  }
}

