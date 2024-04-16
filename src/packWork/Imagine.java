//Pachetul curent
package packWork;

//Importuri de functii
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Abstract class where we take image information and declare methods to be used in transformation
public abstract class Imagine {

	// Variable to save the image received through the path
	protected BufferedImage bufferedImage;

	// Constructor that reads the image received through the path
	public Imagine(String path) throws IOException {
		this.bufferedImage = ImageIO.read(new File(path));
	}

	// Method to save the image after the transformation
	public abstract void exportImagine() throws IOException;

	// Method that performs the transformation
	public abstract void executeTransform() throws IOException;

	// Getter for height
	public int getHeight() {
		return bufferedImage.getHeight();
	}

	// Getter for width
	public int getWidth() {
		return bufferedImage.getWidth();
	}

	// Setter for height
	public void setHeight(int height) {
		bufferedImage = new BufferedImage(bufferedImage.getWidth(), height, BufferedImage.TYPE_INT_RGB);
	}

	// Setter for width
	public void setWidth(int width) {
		bufferedImage = new BufferedImage(width, bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
	}

	// Getter for image
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	// Setter for image
	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
}