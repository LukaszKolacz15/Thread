package pl.akademiakodu;

public class Main {

    public static void main(String[] args) {

//        STARE PODEJSCIE DO WĄTKÓW (do javy 1.5)
//
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0; i<500;i++){
//                    System.out.println("W1("+i+")");
//                    Thread.yield();
//                }
//            }
//        };
//
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0; i<500;i++){
//                    System.out.println(" W2("+i+")");
//                    Thread.yield();
//                }
//            }
//        };
//
//        new Thread(r).start();
//        new Thread(r1).start();
//        System.out.println("Start time!");

//  !!!!!!!!!!!!!!!!!!!! Błąd !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        Operation operation = new Operation();
        for(int i = 0; i < 5000; i++) {
            new Thread1(operation).start();
        }
    }

    private static class Operation {
        private int oskar = 0;
//        Błąd wystąpi tylko jeśli poniżej nie będzie synchronized
        synchronized public int operation() {
            oskar++;
            oskar--;
            return oskar;
        }
    }

    private static class Thread1 extends Thread  {
        Operation operation;

        public Thread1(Operation o ) {
            operation = o;
        }

        @Override
        public void run() {
            for(int i = 0; i <= 100; i++){
                operation.operation();
            }

            System.out.println(operation.oskar);

        }
    }
}
