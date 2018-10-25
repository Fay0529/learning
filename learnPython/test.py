import functools 
import time
def normalize(name):
    return list(map(lambda x: x.lower().capitalize(),name))

def str2float(s):
    digit={'0':0,'1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9}
    def char2num(n):
        return digit[n]
    p = s.split('.')
    integer = reduce(lambda x,y:x*10+y,map(char2num,p[0]))
    float = 0
    if len(p)>1:
        float = reduce(lambda x,y:x*10+y,map(char2num,p[1]))/pow(10,len(p[1]))
    return integer+float
def is_palindrome(n):
    return str(n)[::-1] == str(n)
    
def by_name(t):
    return t[0]
    
def by_grade(t):
    return -t[1]
 
def count():
    def f(j):
        def g():
            return j*j
        return g
    fs = []
    for i in range(1, 4):
        fs.append(f(i)) # f(i)立刻被执行，因此i的当前值被传入f()
    return fs
    
def count():
    fs = []
    for i in range(1, 4):
        def f():
             return i*i
        fs.append(f)
    return fs


def createCounter():
    a = 0
    def counter():
        nonlocal a
        a = a+1
        return a
    return counter

def dec(func):
    functools.wraps(func)
    def tmp():
        print('begin call %s' % func.__name__)
        func()
        print('end call %s' % func.__name__)
    return tmp

@dec
def test():
    print('hello,world')
    
def logToFun(par=''):
    def decorate(fun):
        @functools.wraps(fun)
        def wrapper(*arg,**kw):
            print("传入的参数是",par)
            return fun(*arg,**kw)
        return wrapper
    return decorate

@logToFun("hello,world")

def test3_3():
    print("3_3",time.altzone)

@logToFun()

def test3_4():
    print("3_4",time.altzone)


if __name__ == '__main__':
    test3_3()
    test3_4()
    test()