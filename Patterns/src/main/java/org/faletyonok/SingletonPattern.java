package org.faletyonok;

/**
 * @author Alexander Victorovich Faletyonok
 * <p>
 *     About singleton pattern: - antipattern
 *     - software pattern that restricts the instantiation
 *     of a class to a singular instance.
 *     The pattern is useful when exactly one object
 *     is needed to coordinate actions across a system.
 *     - reduces memory consumption;
 *     - the same internal state from anywhere.
 * </p>
 * https://github.com/AVFaletyonok/JavaIntensive
 */
public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);
    }
}

class Singleton {

    private static Singleton singleton;
//    3 option
//    private static volatile Singleton singleton; - turn of Out-Of-Order Execution

    private Singleton() {}

    // 1 option - problem: performance
    // all threads are waiting for the one thread
    public synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

//    2 option - double check
//    public Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) { // doesn't work because of Out-Of-Order Execution
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//    Optimization in Java
//    Out-Of-Order Execution
}

// 4 option
// eager singleton
//class Singleton {
//    // will be created when the class is loading first time by ClassLoader
//    private static Singleton ourInstance = new Singleton();
//
//    public static Singleton getInstance() {
//        return ourInstance;
//    }
//
//    private Singleton() {}
//}

// 5 option
// Singleton by enum
//public enum Singleton {
//    INSTANCE;
//
//    public void doWork() {
//        System.out.println("singleton is working...");
//    }
//}
//public static void main(String[] args) {
//    Singleton.INSTANCE.doWork();
//}

