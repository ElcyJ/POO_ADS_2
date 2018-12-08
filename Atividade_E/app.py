from model import Agencia
import os


def main():
    contas = []
    agencia = Agencia(contas)

    menu1 = '***** Caixa Eletrônico *****\n' \
            '1 - Abrir Conta\n' \
            '2 - Depósito\n' \
            '3 -Entrar\n' \

    menu2 = '***** Caixa Eletrônico *****\n' \
            '1 - Entrar\n' \
            '2 - Depósito\n' \
            '3 - Saque\n' \
            '4 - Tranferência\n' \
            '5 - Consultar saldo\n' \
            '6 - Sair\n' \

    opcao = int(input(menu1))

    while opcao != 0:
        if opcao == 1:
            nome = input('Nome: ')
            cpf = input('CPF: ')
            senha = input('Senha: ')
            agencia.nova_conta(nome, cpf, senha)
            print("* Faça o Login *")
            while opcao != 0:
                if opcao == 1:
                    nome = input('Nome: ')
                    senha = input('Senha: ')
                    conta = agencia.logar(nome, senha)
                    if conta:
                        print("Login realizado")
                    else:
                        print("Login error")
                elif opcao == 2:
                    con = input('Conta à se depositar: ')
                    valor = float(input('Valor: '))
                    agencia.deposito(con, valor)
                elif opcao == 3:
                    valor = float(input('Valor a se sacar: '))
                    agencia.saque(conta, valor)
                elif opcao == 4:
                    valor = float(input('Valor a se transferir: '))
                    con = input('Conta à se depositar: ')
                    agencia.trans(valor,conta, con)
                elif opcao == 5:
                    print(conta.consultar_saldo())
                elif opcao == 6:
                    agencia.sair(conta)
                    break
                else:
                    print('Opcao Invalida!')

                input('Enter para continuar...')
                os.system('cls')

                opcao = int(input(menu2))

        elif opcao == 2:
            conta = input('Conta à se depositar: ')
            valor = input('Valor: ')
            agencia.deposito(conta, valor)

        else:
            print('Opcao Invalida!')

        input('Enter para continuar...')
        os.system('cls')

        opcao = int(input(menu1))


if __name__ == '__main__':
    main()