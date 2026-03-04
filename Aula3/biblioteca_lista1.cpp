#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector> //para a lista

using namespace std;

/**
 * @brief metodo que popula uma lista com numeros inteiros aleatorios dentro de uma faixa
 * 
 * @param lista contem os numeros aleatorios gerados
 * @param quantidadeNumeros contem quantos numeros se deseja inserir na lista
 * @param faixaInicial contem o numero inical da faixa
 * @param faixaFinal contem o numero final da faixa
 */
void  popularListaAleatoria(vector<int> &lista, int quantidadeNumeros, int faixaInicial, int faixaFinal) {
        //observe o simbolo & na frente da variavel lista. Isso acontece pq em C++ se houver alteração na lista, é
        //preciso utiliza o simbolo de enreçamento &
        srand(time(NULL));
        int numeroSorteado;
        for (int i = 0; i < quantidadeNumeros; i++) {
            numeroSorteado = faixaInicial + (rand() % faixaFinal);
            lista.push_back(numeroSorteado);
        }
    }
/**
 * @brief metodo que exibe o coneudo de uma lista de inteiros, elemento abaixo de elemento
 * 
 * @param lista contem os numeros inteiros
 */
void exibirLista(vector<int> lista) {
        for (int i = 0; i < lista.size(); i++) {
            cout << lista[i] << "\n";
        }
        cout << "-----------------\n";
        cout << "Total de elementos" << lista.size() << "\n";
    }

 /**
  * @brief metodo que copia os numeos da lista oigem para a lista destino, exceto os repetidos
  * 
  * @param listaOrigem contem os numeros originais da lista
  * @param listaDestino contem os numeros copiados da lista original sem ser repetidos 
  */
void copiarListaSemReplicados(vector<int> listaOrigem, vector<int> &listaDestino) {
    for (int item : listaOrigem) {
        //Em c++, precisamos procurar manualmente se o item ja
        if (find(listaDestino.begin(), listaDestino.end(), item) == listaDestino.end()) {
            listaDestino.push_back(item);
        }
    }
}
