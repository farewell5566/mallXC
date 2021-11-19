package com.xc.mall.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于MBG代码生成
 */
public class Generator {
    public static void main(String[] args) throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overWrite = true;
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        //创建MBG
        DefaultShellCallback callback = new DefaultShellCallback(overWrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback,warnings);
        //生成执行代码
        myBatisGenerator.generate(null);
        for (String warning:warnings){
            System.out.println(warning);
        }






    }
}
