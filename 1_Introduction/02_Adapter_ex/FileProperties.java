import java.util.Properties;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;

public class FileProperties extends Properties implements FileIO {
    public FileProperties() {
        super();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        load(reader);
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        store(writer, "FileProperties");
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key);
    }
}
