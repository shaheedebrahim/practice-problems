import sys;
def main():
    dict = {}
    line = input()
    while line != "":
        value, key = line.split();
        dict[key] = value
        line = input()

    for word in sys.stdin:
        word = word.strip()
        if word in dict:
            print(dict[word])
        else:
            print("eh")

main()
