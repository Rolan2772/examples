package com.rolan.examples.spring.oxm;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class CastorExample {

    public static final String FILE_NAME = "settings.xml";
    private Settings settings;

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public CastorExample() {
        settings = new Settings();
        settings.setEnabled(true);
    }


    public void saveSettings() throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(FILE_NAME);
            marshaller.marshal(settings, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    public void loadSettings() throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(FILE_NAME);
            settings = (Settings) unmarshaller.unmarshal(new StreamSource(is));
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
