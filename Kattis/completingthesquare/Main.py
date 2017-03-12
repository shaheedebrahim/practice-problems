import math;

def findMax(a, b, c):
    temp = max(a, b, c);
    if temp == a:
        return "a";
    elif temp == b:
        return "b";
    else:
        return "c"

def distance(x, y, x2, y2):
    d = math.sqrt(((x2 - x)**2) + ((y2-y)**2));
    return d;

x1, y1 = input().split(" ");
x2, y2 = input().split(" ");
x3, y3 = input().split(" ");

x1 = int(x1)
y1 = int(y1)
x2 = int(x2)
y2 = int(y2)
x3 = int(x3)
y3 = int(y3)

a = distance(x1, y1, x2, y2);
b = distance(x2, y2, x3, y3);
c = distance(x1, y1, x3, y3);

line = findMax(a,b,c);

if line == "a":
    vecX = x2 - x3;
    vecY = y2 - y3;
    print(x1 + vecX, y1 + vecY);
elif line == "b":
    vecX = x2 - x1;
    vecY = y2 - y1;
    print(x3 + vecX, y3 + vecY)
elif line == "c":
    vecX = x1 - x2;
    vecY = y1 - y2;
    print(x3 + vecX, y3 + vecY)


