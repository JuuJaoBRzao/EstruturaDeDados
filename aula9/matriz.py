from dado import Dado

class Matriz:

    #public static void inicializarMatriz(int matriz[][], int qtLinhas, int qtdColunas):
    @staticmethod
    def exibir_matriz(matriz, qtd_linhas, qtd_colunas):
        for i in range(qtd_linhas):
            for j in range(qtd_colunas):
                print(f"{matriz[i][j]} + \t", end="")
            
            print()

    @staticmethod
    def converter_matriz(matriz, qtd_linhas, qtd_colunas, lista):
        for i in range(qtd_linhas):
            for j in range(qtd_colunas):
                if matriz[i][j] != 0:
                    lista.append( Dado(matriz[i][j], i, j))

    @staticmethod
    def exibir_lista(lista):
        for item in lista:
            print(item)

        print(f"Total de elementos: {len(lista)}")
