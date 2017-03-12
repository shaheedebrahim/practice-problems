test = int(input());

for t in range (0, test):
    n = int(input());

    highest = -100000000000;
    index = 1;
    for i in range (0, n):
        a, b, c = input().split(" ");

        a = int(a);
        b = int(b);
        c = int(c);

        r = ((b)/(2*a))
        
        torque = (-a*(r**2)) + (b*r) + c
        if (torque > highest):
            highest = torque;
            index = i+1;

    print(index);




