package jclevel6;

import jclevel6.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes image) {
        if (image == ImageTypes.JPG)
            return new JpgReader();
        else if (image == ImageTypes.PNG)
            return new PngReader();
        else if (image == ImageTypes.BMP)
            return new BmpReader();
        else throw new IllegalArgumentException("Unknown image type");
    }
}
