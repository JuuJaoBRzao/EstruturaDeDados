from Aluno import Aluno

lista_alunos = []
arquivo = "alunos.csv"

try:
    scanner = open(arquivo, "r", encoding="utf-8")

    for linha in scanner:
        dados = linha.strip().split(",")
        lista_alunos.append(Aluno(dados[0], dados[1], dados[2], dados[3]))

    lista_alunos.sort(key=lambda aluno: aluno.ano_ingresso)
    print("=== Lista de alunos ordenada por ano de ingresso ===")
    for aluno in lista_alunos:
        print(aluno)

    lista_alunos.sort(key=lambda aluno: aluno.nome)
    print("\n=== Lista de alunos ordenada por nome ===")
    for aluno in lista_alunos:
        print(aluno)

    busca_nome = input("\nDigite o nome exato do aluno para fazer a busca: ")
    encontrado = False
    for aluno in lista_alunos:
        if aluno.nome == busca_nome:
            print("Aluno encontrado: ", aluno)
            encontrado = True
        if not encontrado:
            print("Aluno não encontrado")

    calculo_ingresso = {}
    for aluno in lista_alunos:
        if aluno.ano_ingresso in calculo_ingresso:
            calculo_ingresso[aluno.ano_ingresso] += 1
        else:
            calculo_ingresso[aluno.ano_ingresso] = 1

    print("\n=== Quantidade de alunos por ano de ingresso ===")
    for ano, qtde in calculo_ingresso.items():
        print(f"Ano {ano}: {qtde} alunos")

except FileNotFoundError:
    print(f"Arquivo {arquivo} não encontrado")
