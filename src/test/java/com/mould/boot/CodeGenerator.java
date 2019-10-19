package com.mould.boot;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 代码自动生成
 * @author 才子
 */
public class CodeGenerator {
	static String projectPath="C:\\lizk\\java\\IDEA\\mould";

	static String[] tableNames= {"pass_word"};//修改成自己的表名,多个用逗号隔开


//放开以下注释
   public static void main(String[] args) {
   	dothings();
  }

    public static void dothings() {
    	 // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/test/java");
        gc.setOutputDir(projectPath);
        gc.setAuthor("lizk");
        gc.setOpen(true);
        gc.setIdType(IdType.INPUT);
        gc.setSwagger2(true);//开启swagger注释
        gc.setFileOverride(true);//临时开启测试/\\
        gc.setServiceName("%sService");
//        gc.setEntityName("%sDO");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.mould.boot");
//        pc.setModuleName(moduleName);
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("dataobject");

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
//         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String path = projectPath + "/src/main/resources/mapper/xml/" + tableInfo.getEntityName() + "Mapper";
                System.out.println(path);
                return path;
//                return projectPath + "/src/main/resources/com/yxt/common/dal/mapper/xml/" + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().length()-2) + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.mould.boot.dataobject.BaseDO");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setVersionFieldName("updateDate");//乐观锁字段
        strategy.setSuperControllerClass("com.mould.boot.controller.base.BaseController");
        strategy.setInclude(tableNames);//包含表
//        strategy.setExclude(tableNames);//排除表
        strategy.setSuperEntityColumns("id","createUserId","createUser","creatDate","updateUserId","updateUser","updateDate");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(new String[] { "t_", "CORE_", "EL_","core_","vo_",});//过滤前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
	}



}
