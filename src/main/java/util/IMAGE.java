package util;

import java.io.*;
import java.net.URL;

public class IMAGE {
    public static void download(String imageURL,String name ) throws IOException {
        URL url = new URL(imageURL);
        InputStream in = new BufferedInputStream(url.openStream());
        OutputStream out = new BufferedOutputStream(new FileOutputStream("images/"+name+".jpg"));
        for ( int i; (i = in.read()) != -1; ) {
            out.write(i);
        }
        in.close();
        out.close();
    }
}
