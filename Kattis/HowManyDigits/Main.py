import math;
import sys
while True:
    line = sys.stdin.readline();
    if line == '':
        break;
    n = int(line)
    total = 0;
    for i in range (n, 0, -1):
        total = total + math.log(i, 10);

    total = math.floor(total+1);
    print(total);
