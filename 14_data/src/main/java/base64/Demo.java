package base64;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Demo {
    public static void main(String[] args) throws Exception {
        byte[] bytes = FileUtils.readFileToByteArray(new File("logo.png"));

        // 0000 0001
        // "00000001"

        String hexString = Hex.encodeHexString(bytes);
        System.out.println(hexString);
        System.out.println(hexString.length());

        // 0-9 A-F

        // Base64
        // a-z 26
        // A-Z 26
        // 0-9 10
        //     62
        // +/  2
        // 64 -> x^6
        // 0000 0001 1001 0001 1110 0001
        // 0    1    7    1    E    1
        // 000000 011001  000111 100001
        // a      7       F      !

        String base64String = Base64.encode(bytes);
        System.out.println(base64String);
        System.out.println(base64String.length());


    }
}
