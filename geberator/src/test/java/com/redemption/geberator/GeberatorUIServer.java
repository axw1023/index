package com.redemption.geberator;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.github.davidfantasy.mybatisplus.generatorui.GeneratorConfig;
import com.github.davidfantasy.mybatisplus.generatorui.MybatisPlusToolsApplication;
import com.github.davidfantasy.mybatisplus.generatorui.mbp.NameConverter;
import com.github.davidfantasy.mybatisplus.generatorui.mbp.TemplateVaribleInjecter;
import java.util.HashMap;
import java.util.Map;

public class GeberatorUIServer {

  public static void main(String[] args) {
    GeneratorConfig config = GeneratorConfig.builder().jdbcUrl("jdbc:mysql://49.232.223.214:3306/index")
        .userName("root2")
        .password("root2")
        .driverClassName("com.mysql.cj.jdbc.Driver")
        //数据库schema，MSSQL,PGSQL,ORACLE,DB2类型的数据库需要指定
//        .schemaName("index")
        //如果需要修改entity及其属性的命名规则，以及自定义各类生成文件的命名规则，可自定义一个NameConverter实例，覆盖相应的名称转换方法，详细可查看该接口的说明：
        .nameConverter(new NameConverter() {
          /**
           * 自定义Service类文件的名称规则
           */
          @Override
          public String serviceNameConvert(String tableName) {
            return this.entityNameConvert(tableName) + "Service";
          }

          /**
           * 自定义Controller类文件的名称规则
           */
          @Override
          public String controllerNameConvert(String tableName) {
            return this.entityNameConvert(tableName) + "Action";
          }
        }).templateVaribleInjecter(new TemplateVaribleInjecter() {
          @Override
          public Map<String, Object> getCustomTemplateVaribles(TableInfo tableInfo) {
            Map<String, Object> params = new HashMap<>();
            //swagger类型
            params.put("springdoc", true);
            //使用get/set插件
            params.put("entityLombokModel", true);
            return params;
          }
        })
        //所有生成的java文件的父包名，后续也可单独在界面上设置
        .basePackage("com.redemption.link")
        .port(8068)
        .build();
    MybatisPlusToolsApplication.run(config);
  }

}
