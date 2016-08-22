package bani.prabhupada.iskcon.prabhupadamsg;

import android.graphics.Bitmap;

public class ShareImage {
    private static Bitmap image;
    private String title;
    private Bitmap shareimage;

    public ShareImage(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public static Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
