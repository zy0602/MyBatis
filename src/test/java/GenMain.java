/*
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenMain {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String genCfg = "/mbgConfiguration.xml";
        File configFile = new File(GenMain.class.getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}*/
