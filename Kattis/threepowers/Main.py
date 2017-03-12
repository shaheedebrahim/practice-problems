powers = [(2**n)+1 for n in range(0,68)]
threePowers = [3**n for n in range(0,68)]

powers.insert(0, 0)
threePowers.insert(0,0)

n = int(input())
while (n!=0):
    if (n == 1):
        print("{ }")
    else:
        indexToUse = -1;
        for i in range(0, len(powers)):
            if (n < powers[i]):
                indexToUse = i-1;
                break;

        subset = []
        subset.append(threePowers[indexToUse])

        n = n - (powers[indexToUse]-1)

        while (n > 1):
            for i in range (0, len(powers)):
                if (n < powers[i]):
                    indexToUse = i-1;
                    break;
            subset.append(threePowers[indexToUse])
            n = n - (powers[indexToUse]-1)

        print("{ ", end="")

        for i in range(len(subset)-1, -1, -1):
            if (i == 0):
                print(subset[i], " ",sep="", end="")
            else:
                print(subset[i], ", " , sep="", end="") 

        print("}", end="")
        print()
    n = int(input())

            


