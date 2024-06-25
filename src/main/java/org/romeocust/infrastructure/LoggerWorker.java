package org.romeocust.infrastructure;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import java.io.IOException;

public class LoggerWorker {
    static{
        Configure();
    }


    static void Configure() {
        //Configurator.setLevel(LogManager.getRootLogger(), Level.DEBUG);
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
        //ConfigurationBuilder builder = ConfigurationBuilderFactory.newConfigurationBuilder();
        builder.setStatusLevel(Level.DEBUG);

        AppenderComponentBuilder console = builder.newAppender("console", "Console");
        //console.addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);

        LayoutComponentBuilder standartLayout = builder.newLayout("PatternLayout");
        //standartLayout.addAttribute("pattern", "%date{yyyy-MM-dd HH:mm:ss.SSS} %p %c [%t] %m%n");
        standartLayout
                .addComponent(builder.newComponent(null, "header", "\\r\\n\\r\\n ******************************************************************************** Trace Opened: %date{yyyy-MM-dd HH:mm:ss.SSS}{GMT+0}\\r\\n\\r\\n"))
                .addComponent(builder.newComponent(null, "footer", "\\r\\n\\r\\n ******************************************************************************** Trace Closed: %date{yyyy-MM-dd HH:mm:ss.SSS}{GMT+0}\\r\\n\\r\\n<"))
                .addComponent(builder.newComponent(null, "Pattern", "%date{yyyy-MM-dd HH:mm:ss.SSS}{GMT+0} %-5level [%thread] [%logger] %message%n"));
        console.add(standartLayout);
        builder.add(console);




        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(Level.DEBUG);
        rootLogger.add(builder.newAppenderRef("console"));

        builder.add(rootLogger);

        Configurator.initialize(builder.build());
        Configurator.reconfigure(builder.build());

        try {
            builder.writeXmlConfiguration(System.out);
            System.out.println("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
