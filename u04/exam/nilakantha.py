def piNilakantha(n):
    pi = 3.0
    s = 1.0
    
    for i in range(1,n+1):
        i2 = 2*i
        pi += s*4/(i2*(i2+1)*(i2+2))
        s *= -1
        
    return pi

print(piNilakantha(0))
print(piNilakantha(1))
print(piNilakantha(4))
print(piNilakantha(-2))
print(piNilakantha(1000000))
