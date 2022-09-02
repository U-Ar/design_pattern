package pagemaker;

import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;

public class Database {
    private Database() {

    }

    public static Properties getProperties(String dbname) throws IOException {
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        prop.load(new FileReader(filename));
        return prop;
    }
}