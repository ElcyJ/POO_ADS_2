class Conta:
    def __init__(self, titular, senha, numero):
        self.titular = titular
        self.senha = senha
        self.numero = numero
        self.agencia = '001'
        self.saldo = 0.0

    def depositar(self, valor):
        if 10 > valor <= 3000:
            self.saldo += valor

    def sacar(self, valor):
        pass

    def tranferir(self, outra_conta, valor):
        pass


class Titular:
    def __int__(self, nome, cpf):
        self.nome = nome
        self.cpf = cpf