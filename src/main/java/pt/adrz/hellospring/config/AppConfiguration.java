package pt.adrz.hellospring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("pt.adrz.hellospring")
@Import({ WebInitializer.class,DispatcherConfig.class})
public class AppConfiguration { }
