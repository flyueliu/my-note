##### Java中的逆变与协变

```java
Number num=new Integer(1);
ArrayList<Number> list=new ArrayList<Integer>(); //type mismatch
List<? extends Number> list1=new ArrayList<Number>();
list1.add(new Integer(1)); //error
list1.add(new Float(1.2f)); //error
```

1.  __里氏替换原则__

   > 所有引用父类的地方必须能透明的使用其子类对象

* 包含以下四层含义：

  * 子类完全拥有父类的方法，且具体子类必须实现父类的抽象方法
  * 子类可以增加自己的方法
  * 当子类覆盖或者实现父类的方法时，方法的形参要比父类更为宽松
  * 当子类覆盖或者实现父类的方法时，方法的返回值要比父类更严格

  ```java
  // 根据里氏替换原则，我们在实例对象时，可以使用其子类进行实例化
  // 左侧需要的是Number 类型的对象，可以使用Integer子类
  Number num=new Integer(1);
  ```

2. __逆变与协变定义__

   逆变与协变用来描述类型转换后的继承关系，其定义:

    如果A、B表示类型, f(.) 表示类型转换，<表示继承关系(比如 A<B, 表示A是B的子类)

   * 当f(.)是__逆变__时，如果A<B，那么f(B)<f(A)
   * 当f(.)是__协变__时，如果A<B，那么f(A)<f(B)
   * 当f(.)是__不变__时，如果A<B，那么上述两个式子都不成立。即f(A)和f(B)没有继承关系

   ```java
   // 数组是协变的  :令f(A)=[]A,有
   // Integer[]数组可以使用Number[]接收，即Number[]的引用可以使用Integer[]对象
   // 所以 Integer[] < Number[] ，Integer[]是Number[]的子类
   Number[] numbers=new Integer[3]; 
   // 泛型是不变的  :令f(A)=ArrayList<A>()
   // ArrayList<Number> 不能接收ArrayList<Integer> ,反之也不行，则俩者之间没有继承关系
   // 所以泛型是不变的
   ArrayList<Number> numList=new ArrayList<Integer>(); //error
   ArrayList<Integer> intList=new ArrayList<Number>(); //error
   // 方法调用： 当调用方法result=method(n);
   // 传入的形参n可以替换为n的子类型，即f(method(n的子类)) > f(method(n))，传入形参是逆变
   // 返回值可以替换为method返回值的父类型 所以f（result父类）>f(result)，所以方法返回值是协变
   public static Number method(Number num){
       return 1;
   }
   Object result=method(new Integer(1)); //correct
   Number numResult=method(new Object()); //error
   Integer result=method(new Integer(2)); //error
   // 方法重写: 
   // java1.5开始，子类覆盖父类方法时，允许返回更为具体的类型()
   // Sub<Super ,返回值 Sub的返回值< Super的返回值，协变
   // 方法的形参必须和父类保持一致（不变）
   class Super{
       public abstract Number method(Number n)
   }
   class Sub extends Super{
       @Override
       public Integer method(NUmber n){ ... }
   }
   ```

3. __总结__

   1. 子类重写父类的方法时，形参类型必须一致，而返回值可以 返回 更具体的类型
   2. java的泛型必须一致，数组可以使用