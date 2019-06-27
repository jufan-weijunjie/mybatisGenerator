import org.apache.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

/**
 * FileName：GeneratorSqlMain
 *
 * @author 魏俊杰
 * @date 11:30 2019/6/27
 */
public class GeneratorSqlMain {

    private static Logger logger = Logger.getLogger(GeneratorSqlMain.class);
    public void generator() throws Exception{
        ArrayList<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String path = this.getClass().getClassLoader().getResource("generatorConfig.xml").getPath();
        path = path.substring(1,path.length());
        System.out.println(path);
        File file = new File(path);
        //创建组态分析器
        ConfigurationParser cp = new ConfigurationParser(warnings);
        //加载配置文件，开始解析组态（generatorConfig.xml）
        Configuration config = cp.parseConfiguration(file);
        //
        DefaultShellCallback call = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, call, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception{
        try {
            GeneratorSqlMain generatorSqlmain = new GeneratorSqlMain();
            generatorSqlmain.generator();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
