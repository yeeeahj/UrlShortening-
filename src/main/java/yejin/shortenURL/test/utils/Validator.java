package yejin.shortenURL.test.utils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ByeongChan on 2017. 11. 23..
 */
public class Validator {

    static final String hostName = "localhost";

    public static void validate(String originUrl) {
        URL tempUrl;

        try {

            tempUrl = new URL(originUrl);

            if (!tempUrl.getProtocol().equals("http") || !tempUrl.getProtocol().equals("https")) {

                throw new RuntimeException();
            }

        } catch (MalformedURLException e) {

            try {
                tempUrl = new URL("http://" + originUrl);
            } catch (MalformedURLException e2) {
                throw new RuntimeException();
            }
        }

        validate2(tempUrl);
    }

    private static void validate2(URL originUrl) {
        if (originUrl.getHost().equals(hostName)) {
            throw new RuntimeException();
        }
    }
}
