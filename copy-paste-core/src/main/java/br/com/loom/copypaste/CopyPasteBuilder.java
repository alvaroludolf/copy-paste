package br.com.loom.copypaste;

import br.com.loom.copypaste.configuration.Configuration;
import br.com.loom.copypaste.exception.ConfigurationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Optional;

public class CopyPasteBuilder {

    private static final Logger log = LoggerFactory.getLogger(CopyPasteBuilder.class);

    private static ObjectMapper o = new ObjectMapper(new YAMLFactory());

    private Configuration configuration;

    private CopyPasteBuilder() {
    }

    public static CopyPasteBuilder create() {
        InputStream in = Optional
                .ofNullable(ClassLoader.getSystemResourceAsStream("copyPaste.yaml"))
                .orElseThrow(ConfigurationException::new);
        InputStreamReader source = new InputStreamReader(in);

        return builder(source);
    }

    public static CopyPasteBuilder from(Reader e) {
        Reader source = Optional
                .ofNullable(e)
                .orElseThrow(ConfigurationException::new);

        return builder(source);
    }

    public CopyPaste build() {
        return new CopyPaste(configuration);
    }

    private static CopyPasteBuilder builder(Reader source) {
        try {
            CopyPasteBuilder copyPasteBuilder = new CopyPasteBuilder();
            copyPasteBuilder.configuration = o.readValue(source, Configuration.class);
            return copyPasteBuilder;
        } catch (IOException e) {
            throw new ConfigurationException(e);
        }
    }

}
