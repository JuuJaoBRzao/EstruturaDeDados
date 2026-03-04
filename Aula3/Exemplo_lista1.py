from biblioteca import popular_lista_aleatoria, exibir_lista, copiar_lista_sem_replicados

#declarando uma lista em python
lista_numeros = []

#recebendo a quatidade de numeros a serem gerados aleatoriamente
quantidade_numeros = int(input("Digite quantos numeros gostaria de armazenar: "))

#definindoa faixa de intervalos dos numeros a serem sorteados
faixa_inicial = 10
faixa_final = 50

popular_lista_aleatoria(lista_numeros, quantidade_numeros, faixa_inicial, faixa_final)

exibir_lista(lista_numeros)

lista_resultado = []
copiar_lista_sem_replicados(lista_numeros, lista_resultado)
lista_resultado.sort()
exibir_lista(lista_resultado)
