package scripts;
import java.util.Scanner;

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
    listarRecursivo(raiz);
  }

  private void listarRecursivo(No no) {
    if (no != null) {
      listarRecursivo(no.noEsquerdo);
      System.out.print(no.valor + " ");
      listarRecursivo(no.noDireito);
    }
  }

  public Integer buscar(int valor) {
    No resultado = buscarRecursivo(raiz, valor);
    return resultado != null ? resultado.valor : null;
  }

  private No buscarRecursivo(No no, int valor) {
    if (no == null || no.valor == valor) {
      return no;
    }
    if (valor < no.valor) {
      return buscarRecursivo(no.noEsquerdo, valor);
    }
    return buscarRecursivo(no.noDireito, valor);
  }

  public static void main(String[] args) {
    ArvoreBinaria arvore = new ArvoreBinaria();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Insira o valor da raiz: ");
    int raiz = scanner.nextInt();
    arvore.inserir(raiz);

    System.out.println("Insira outros valores ou aperte -1 para sair:");
    while (true) {
      int valor = scanner.nextInt();
      if (valor == -1) {
        break;
      }
      arvore.inserir(valor);
      System.out.println("Árvore atual:");
      arvore.listar();
      System.out.println();
    }

    System.out.println("Árvore final:");
    arvore.listar();

    while (true) {
      System.out.print("\n\nInsira o número a ser buscado ou coloque -1 para encerrar: ");
      int valorBusca = scanner.nextInt();
      if (valorBusca == -1) {
        break;
      }
      Integer resultado = arvore.buscar(valorBusca);
      if (resultado != null) {
        System.out.println("\nO número " + valorBusca + " existe na árvore.");
      } else {
        System.out.println("\nO número " + valorBusca + " não existe na árvore.");
      }
    }
    scanner.close();
  }
}

