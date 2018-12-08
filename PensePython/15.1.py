from math import sqrt
from copy import copy


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Rectangle:
    def __init__(self, width, height, cornerx, cornery):
        self.width = width
        self.height = height
        self.corner = Point(cornerx, cornery)


class Circle:
    def __init__(self, centerx, centery, radios):
        self.center = Point(centerx, centery)
        self.radios = radios


def point_in_circle(circle, point):
    distance = sqrt((circle.center.x - point.x) ** 2 + (circle.center.y - point.y) ** 2)
    if distance <= circle.radios:
        return True
    return False


def rect_in_circle(circle, box):
    p2 = copy(box.corner)

    if not point_in_circle(circle, p2):
        return False

    p2.y -= box.height
    if not point_in_circle(circle, p2):
        return False

    p2.x += box.width
    if not point_in_circle(circle, p2):
        return False

    p2.y += box.height
    if not point_in_circle(circle, p2):
        return False
    return True


def rect_circle_overlap(circle, box):
    p2 = copy(box.corner)

    if point_in_circle(circle, p2):
        return True

    p2.y -= box.height
    if point_in_circle(circle, p2):
        return True

    p2.x += box.width
    if point_in_circle(circle, p2):
        return True

    p2.y += box.height
    if point_in_circle(circle, p2):
        return True
    return False


def main():

    circle = Circle(150, 100, 75)
    point = Point(50, 50)
    print(point_in_circle(circle, point))

    box = Rectangle(100, 200, 150, 100)
    print(rect_in_circle(circle, box))
    print(rect_circle_overlap(circle, box))


if __name__ == '__main__':
    main()