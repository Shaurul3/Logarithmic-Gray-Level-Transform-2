package packWork;

//Clasa Buffer cu sincronizare
public class ImageBuffer {
    private String imagePath;
    private boolean available = false;

    public synchronized String get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return imagePath;
    }

    public synchronized void put(String imagePath) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.imagePath = imagePath;
        available = true;
        notifyAll();
    }
}