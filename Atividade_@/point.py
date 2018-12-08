import math


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def get_quadrant(self):

        if self.x == 0 and self.y == 0:
            qua = 'Origem'
        elif self.x == 0:
            qua = 'Eixo y'
        elif self.y == 0:
            qua = 'Eixo x'
        else:
            if self.x > 0:
                if self.y > 0:
                    qua = 1
                else:
                    qua = 4
            elif self.y > 0:
                qua = 2
            else:
                qua = 3

        return qua

    def distance_between(self, p2):
        distance = math.sqrt((self.x - p2.x)**2 + (self.y - p2.y)**2)
        return distance

    def move_point(self, x, y):
        self.x = x
        self.y = y

    def value_point(self):
        x = self.x
        y = self.y
        return x, y


def main():
    p1 = Point(1, 2)
    p2 = Point(-1, 2)

    print(p1.get_quadrant())
    print(p1.distance_between(p2))
    p1.move_point(3, 4)
    print(p1.distance_between(p2))
    print(p1.value_point())
    print(p2.value_point())


if __name__ == '__main__':
    main()



