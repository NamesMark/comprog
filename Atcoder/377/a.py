import math
from math import gcd, floor, sqrt, log


if __name__ == "__main__":
    s = input().strip()
    if ''.join(sorted(s)) == "ABC":
        print("Yes")
    else:
        print("No")
