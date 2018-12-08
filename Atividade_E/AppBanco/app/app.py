from AppBanco.use_case.bank import Bank


def main():

    banco = Bank()
    conta_logada = None

    menu = '*** BANCO ***' \
           '1 - Abrir Conta\n' \
           '2 - Depósito'''

    while True:
        opcao = int(input(menu))

        if opcao == 1:
            cpf = input('CPF: ')
            nome = input('Nome: ')
            senha, e_confirmacao = map(str, input('Senha e confirmação: ').split())

            if senha == e_confirmacao:
                banco.nova_conta(nome, cpf, senha)
                print('Conta aberta com sucesso')
            else:
                print('Dados Inválidos!')
        if opcao == 2:
            numero_conta = int(input('N. Conta: '))
            valor = float(input('Valor: '))
            if banco.depositar(numero_conta, valor):
                print('OK')
            else:
                print('Not OK')

            for conta in banco.contas:
                if conta.numero == numero_conta:
                    conta.depositar(valor)

        if opcao == 0:
            break


if __name__ == '__main__':
    main()
