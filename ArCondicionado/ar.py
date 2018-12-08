class Ar:
    def __init__(self, status, temp, speed, swing):
        self.status = status
        self.temp = temp
        self.speed = speed
        self.swing = swing

    def turn_onOff(self):
        if self.status == 1:
            self.status = 0
        else:
            self.status = 1

    def temp(self, t:int):
        temp_min = 17
        temp_max = 26
        if self.status == 1:
            if temp_max < t >= temp_min:
                self.temp = t

    def speed_plus(self, value):
        speed_max = 3
        if self.status == 1:
            if self.speed + value <= speed_max:
                self.speed += value

    def speed_minus(self, value):
        speed_min = 1
        if self.status == 1:
            if self.speed - value >= speed_min:
                self.speed += value

    def pw_swing(self):
        if self.status == 1:
            if self.swing == 0:
                self.swing = 1
            else:
                self.swing = 0

    def show_status(self):
        if self.status == 1:
            print("Estado:", self.status)
            print("Temperatura:", self.temp)
            print("Velocidade:", self.speed)
            print("Swing:", self.swing)
        else:
            print('Aparelho desligado.')


def main():
    ar1 = Ar(1, 21, 1, 1)
    ar1.show_status()
    ar1.temp(19)
    ar1.speed_plus(1)
    ar1.pw_swing()
    ar1.turn_onOff()
    ar1.show_status()
    ar1.turn_onOff()
    ar1.show_status()


if __name__ == '__main__':
    main()






