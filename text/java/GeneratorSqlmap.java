//import org.mybatis.generator.api.MyBatisGenerator;
//import org.mybatis.generator.config.Configuration;
//import org.mybatis.generator.config.xml.ConfigurationParser;
//import org.mybatis.generator.internal.DefaultShellCallback;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * mybatis逆向工程实现类
// * @author Mr.Zhong
// * @create2019-07-23 10:37
// */
//public class GeneratorSqlmap extends Exception {
//
//    public static void generator() throws Exception {
//
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        File configFile = new File("src/main/resources/mybatis/generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
//    }
//    public static void main(String[] args) {
//        try {
//            generator();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
