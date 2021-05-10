package app;

import app.resources.GreetingResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class StaticContentTest {

    @TestHTTPResource("index.html")
    URL indexURL;

    @TestHTTPResource
    @TestHTTPEndpoint(GreetingResource.class)
    URL helloURL;

    @Test
    public void testIndexHtml() throws Exception {
        try (InputStream in = indexURL.openStream()) {
            String contents = readStream(in);
            assertTrue(
                    contents.contains("<title>Testing Guide</title>"),
                    "'<title>Testing Guide</title>' not found in:" + indexURL
            );
        }
    }

    @Test
    public void testHello() throws Exception {
        try (InputStream in = helloURL.openStream()) {
            String contents = readStream(in);
            assertTrue(
                    contents.equals("Hello world!"),
                    "'hello' not found in: " + helloURL
                    );
        }
    }

    private static String readStream(InputStream in) throws IOException {
        byte[] data = new byte[1024];
        int r;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((r = in.read(data)) > 0) {
            out.write(data, 0, r);
        }
        return new String(out.toByteArray(), StandardCharsets.UTF_8);
    }
}
