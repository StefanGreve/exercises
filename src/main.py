#!/usr/bin/env python3

from __future__ import annotations

from abc import ABC
from enum import Enum, unique

@unique
class BreadType(Enum):
    WhiteBread = 0
    BlackBread = 1
    RyeWheatBread = 2
    Misc = 3

class Grocery(object):
    def __init__(self, name: str, amount: int, detract: int, is_fluid: bool, bread_type: BreadType=None):
        self.name = name
        self.amount = amount
        self.detract = detract
        self.is_fluid = is_fluid
        self.bread_type = bread_type

    def eat(self) -> bool:
        if not self.is_fluid: self.amount = (self.amount - self.detract, 0)[self.amount - self.detract < 0]
        return self.is_fluid is False

    def drink(self) -> bool:
        if self.is_fluid: self.amount = (self.amount - self.detract, 0)[self.amount - self.detract < 0]
        return self.is_fluid is True

    def __repr__(self) -> str:
        return f"{__class__.__name__} (name={self.name},amount={self.amount},detract={self.detract})"

    def __str__(self) -> str:
        return f"{self.name} ({self.amount}{'ml' if self.is_fluid else 'g'})"

class Bread(Grocery):
    def __init__(self, amount: int, bread_type: BreadType):
        super().__init__(name='bread', detract=50, amount=amount, is_fluid=False, bread_type=bread_type)

class Sausage(Grocery):
    def __init__(self, amount: int):
        super().__init__(name='sausage', detract=10, amount=amount, is_fluid=False)

class Water(Grocery):
    def __init__(self, amount: int):
        super().__init__(name='water', detract=200, amount=amount, is_fluid=True)

class Mate(Grocery):
    def __init__(self, amount: int):
        super().__init__(name='mate', detract=100, amount=amount, is_fluid=True)

class Refrigerator(object):
    def __init__(self):
        self.groceries: list[Grocery] = []
        self.fill_level: int = 0

def main():
    refrigerator = Refrigerator()
    refrigerator.groceries.append(Bread(350, BreadType.WhiteBread))
    refrigerator.groceries.append(Water(1000))
    print(refrigerator.groceries)

    for food in refrigerator.groceries:
        food.eat()
        food.drink()

    print(list(map(str, refrigerator.groceries)))

if __name__ == '__main__':
    main()
