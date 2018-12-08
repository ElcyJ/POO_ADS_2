class Agencia:
    def __init__(self, contas):
        self.contas = contas

    def nova_conta(self, nome, cpf, senha):
        conta = Conta(nome, cpf, senha)
        self.contas.append(conta)
        return conta

    def logar(self, nome, senha):
        for conta in self.contas:
            if conta.nome == nome and conta.senha == senha:
                    conta.logado = True
                    return conta
        return False

    def sair(self, conta):
        if conta.logado is True:
            conta.logado = False

    def deposito(self, nome, valor):
        for conta in self.contas:
            if conta.nome == nome:
                conta.depositar(valor)

    def saque(self,conta, valor):
        conta.saque(valor)

    def trans(self, valor, contaOrigem, outraConta):
        for conta in self.contas:
            if conta.nome == outraConta:
                contaOrigem.transferencia(valor, conta)


class Conta:
    def __init__(self, nome, cpf, senha):
        self.nome = nome
        self.cpf = cpf
        self.saldo = 0
        self.senha = senha
        self.logado = False

    def consultar_saldo(self):
        return self.saldo

    def depositar(self, valor):
        self.saldo += valor

    def saque(self, valor):
        if self.saldo >= valor:
            self.saldo -= valor

    def transferencia(self, valor, outraConta):
        if valor <= self.saldo:
            self.saldo -= valor
            outraConta.saldo += valor






