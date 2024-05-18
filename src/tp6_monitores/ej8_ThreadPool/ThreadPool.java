package tp6_monitores.ej8_ThreadPool;

import tp6_monitores.ej3_Buffer.Buffer;

public class ThreadPool {
    Buffer tasks = new Buffer(10);
    Buffer workers;
//    ArrayList<Worker> workers = new ArrayList<>();

    public ThreadPool(int cantWorkers, int cantTareas) throws InterruptedException {
        workers = new Buffer(cantWorkers);
        for (int i = 0; i < cantWorkers; i++) {
            Worker worker = new Worker(tasks);
            workers.produce(worker);
            worker.start();
        }
        for (int i = 0; i < cantTareas; i++) {
            DummyTask task = new DummyTask();
            tasks.produce(task);
        }
    }

    public synchronized void launch() throws InterruptedException {
        Worker w = (Worker) workers.consume();
    }
}