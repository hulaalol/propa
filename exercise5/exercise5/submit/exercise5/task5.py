#!/usr/bin/env python3

from typing import List, Dict, Optional
from math import floor

# TODO: Annotate all variables and functions (arguments and return value) with the most specific type (e.g., not Any).

# Example using the generic type List:
students: List[str] = ["Gabriel", "Charles", "Beatrice", "Johanna", "Karim"]

submissions: Dict[str, List[int]] = {
    "Gabriel": [3, 0, 10],
    "Johanna": [10, 10, 9],
    "Karim": [5, 5, 5],
    "Charles": [6, 10, 0],
}


def average(values: List[int]) -> float:
    if not values:
        return 0
    sum: int = 0
    for i in values:
        sum += i
    return sum / len(values)


def quantile(values: List[int], q: float = 0.5) -> float:
    if not values:
        return None
    sorted_values: List[int] = sorted(values)
    index: int = floor(len(values) * q)
    return values[index]


all_points = [p for points in submissions.values() for p in points]
quantile_threshold: float = 0.6
point_threshold: float= quantile(all_points, quantile_threshold) or 0
print((quantile_threshold * 100), "percent of all submissions had more than", point_threshold, "points")

for student in students:
    if not student in submissions or average(submissions[student]) < point_threshold:
        print(student, "failed")
    else:
        print(student, "passed")
