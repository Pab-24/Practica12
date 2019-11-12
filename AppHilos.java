class Hilo implements Runnable {
    String nombreHilo;
    Hilo(String nombre){
        nombreHilo=nombre;
    }
    // ejecucion de hilos
    public void run(){
        System.out.println("Inicio: "+nombreHilo);
        try {
            for (int contar=0; contar<10; contar++){
                Thread.sleep(400);
                System.out.println("En "+nombreHilo+", cuenta "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(nombreHilo + "Interrumpido.");
        }
        System.out.println("Terminando "+nombreHilo);
    }
}

public class AppHilos{
    public static void main(String[] args) {
        System.out.println("Hilo principal iniciando.");
        //Instanciar un objeto Hilo con parametro "#1".
        Hilo h=new Hilo("1:");
        Hilo h2 = new Hilo("2:");
        //Construir un hilo de ese objeto.
        Thread nuevoHilo=new Thread(h);
        Thread nuevoHilo2 = new Thread(h2);
        //Comienzar la ejecución del hilo.
        nuevoHilo.start();
        nuevoHilo2.start();
        for (int i=0; i<50;i++){
            System.out.print(" .");
        }try{
            Thread.sleep(100);
        }catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}