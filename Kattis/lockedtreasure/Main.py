def buildTree():
    triangle = [[0 for x in range(31)] for y in range(31)]
    triangle[0][0] = 1

    for i in range (1, 31):
        triangle[i][0] = 1
        for j in range (1, 31):
            triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1]
    
    return triangle

def main():
    t = int(input())

    triangle = buildTree()

    for i in range (0,t):
        n, m = input().split(" ")
        n = int(n)
        m = int(m)
        print(triangle[n][m-1])

main()
