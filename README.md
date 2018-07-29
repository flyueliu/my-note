
# my-note
正解，创建对象可以分解为如下的3行伪代码:
memory=allocate(); //1:分配对象的内存空间
ctorInstance(memory); //2:初始化对象
instance=memory; //3:设置instance指向刚分配的内存地址
上面3行代码中的2和3之间，可能会被重排序导致先3后2,


今天再看这段话有些歧义。假设没有关键字volatile的情况下，两个线程A、B，都是第一次调用该单例方法，线程A先执行instance = new Instance()，该构造方法是一个非原子操作，编译后生成多条字节码指令，由于JAVA的指令重排序，可能会先执行instance的赋值操作，该操作实际只是在内存中开辟一片存储对象的区域后直接返回内存的引用，之后instance便不为空了，但是实际的初始化操作却还没有执行，如果就在此时线程B进入，就会看到一个不为空的但是不完整（没有完成初始化）的Instance对象，所以需要加入volatile关键字，禁止指令重排序优化，从而安全的实现单例。


http://www.iteye.com/topic/652440
