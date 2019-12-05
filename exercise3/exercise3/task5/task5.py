def foo_0(N, P):
    def foo_print():
       print(N)
    def foo_1():
        N = 3
        foo_print()
        #insert something

    #body of foo_0
    if N > 1:
        P()
        #insert something
    else:
        foo_0(N+1,foo_1)
        #insert something

def foo_skip():
    pass #do nothing

foo_0(1, foo_skip) # main program
