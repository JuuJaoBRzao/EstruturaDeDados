import random

def popular_lista_aleatoria(lista, quantidade, faixa_inicial, faixa_final):
    """metodo que popula uma lista com números inteiros e aleatórios dentro de uma faixa

    Args:
        lista (int): armazena numeros inteiros e aleatorios
        quantidade (int): total de numeros inteiros a serem inseridos
        faixa_inicial (int): numero inicial da faixa
        faixa_final (int): numero final da faixa
    """


    for i in range(quantidade):
        lista.append(random.randint(faixa_inicial, faixa_final))


def exibir_lista(lista):
    """metodo que recebe uma lista e a exibe, elementos um abaixo do outro

    Args:
        lista (int): lista contendo numeros inteiros
    """

    for item in lista:
        print(item)

    print("-------------------")
    print("Total de elementos", len(lista))

def copiar_lista_sem_replicados(lista_origem, lista_destino):
    """metodo que copia o conteudo da lista origem para dentro da lista dstino retirando os replicados

    Args:
        lsta_origem (int): lista original contendo todos os numeros
        lista_destino (int): lista final contendo somente os numeros não replicados
    """

    for item in lista_origem:
        if item not in lista_destino:
            lista_destino.append(item)
