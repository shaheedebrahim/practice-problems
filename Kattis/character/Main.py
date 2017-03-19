#Written in Python to avoid overflow as input goes to 30
import math

n = int(input())

answer = 0

for i in range(2, n+1):
    answer = answer + ((math.factorial(n)) / ((math.factorial(i)) * (math.factorial(n-i))))

print(int(answer))
