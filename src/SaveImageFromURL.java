import java.io.*;
import java.net.URL;

public class SaveImageFromURL {

    public static void main(String[] args) throws Exception {
        System.setProperty("jsse.enableSNIExtension", "false");

        try {
            File file = new File("jefit.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String imageUrl = line;
                String destinationFile = "output/jefit" + i + ".jpg";
                saveImage(imageUrl, destinationFile);
                i++;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }

}