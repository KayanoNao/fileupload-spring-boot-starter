package com.zhaoluming.upload.configuration;

import com.zhaoluming.upload.service.FileProperties;
import com.zhaoluming.upload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhao Luming(赵路明)
 * @create 2020-10-19 下午 07:28
 */
@Configuration
@EnableConfigurationProperties(FileProperties.class)
public class FileAutoConfiguration {
	@Autowired
	private FileProperties fileProperties;

	@Bean
	@ConditionalOnProperty(prefix = "file",value = "enable",havingValue = "true")
	public FileService fileService(){
		return new FileService(fileProperties);
	}
}
