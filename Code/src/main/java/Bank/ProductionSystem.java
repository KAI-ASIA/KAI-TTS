package Bank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Warehouse {
    private final Queue<Integer> storage = new LinkedList<>();
    private final int capacity;

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    // Thêm hàng hóa vào kho
    public synchronized void add(int item) throws InterruptedException {
        while (storage.size() == capacity) {
            System.out.println("Warehouse is full. Producer is waiting...");
            wait();  // Chờ đến khi có không gian trống
        }
        storage.add(item);
        System.out.println("Produced item: " + item + ". Warehouse size: " + storage.size());
        notifyAll();  // Thông báo cho các Consumer biết rằng có hàng hóa mới
    }

    // Lấy hàng hóa ra khỏi kho
    public synchronized int remove() throws InterruptedException {
        while (storage.isEmpty()) {
            System.out.println("Warehouse is empty. Consumer is waiting...");
            wait();  // Chờ đến khi có hàng hóa
        }
        int item = storage.remove();
        System.out.println("Consumed item: " + item + ". Warehouse size: " + storage.size());
        notifyAll();  // Thông báo cho các Producer biết rằng có không gian trống
        return item;
    }
}

class Producer implements Runnable {
    private final Warehouse warehouse;
    private static int itemCounter = 0;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random() * 1000));  // Giả lập thời gian sản xuất
                synchronized (Producer.class) {
                    warehouse.add(++itemCounter);  // Sản xuất một mặt hàng
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random() * 1500));  // Giả lập thời gian vận chuyển
                warehouse.remove();  // Vận chuyển một mặt hàng
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProductionSystem {
    public static void main(String[] args) {
        final int WAREHOUSE_CAPACITY = 10;
        final int NUM_PRODUCERS = 3;
        final int NUM_CONSUMERS = 2;

        Warehouse warehouse = new Warehouse(WAREHOUSE_CAPACITY);

        // Sử dụng ExecutorService để quản lý các thread của Producer và Consumer
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_PRODUCERS + NUM_CONSUMERS);

        // Khởi tạo và chạy các Producer
        for (int i = 0; i < NUM_PRODUCERS; i++) {
            executorService.submit(new Producer(warehouse));
        }

        // Khởi tạo và chạy các Consumer
        for (int i = 0; i < NUM_CONSUMERS; i++) {
            executorService.submit(new Consumer(warehouse));
        }

        // Đóng ExecutorService khi tất cả các tác vụ hoàn thành (điều này sẽ không xảy ra trong trường hợp này vì các thread chạy liên tục)
        executorService.shutdown();
    }
}

