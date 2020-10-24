package com.zhaoluming.upload.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.PrivateKey;

/**
 * @author Zhao Luming(赵路明)
 * @create 2020-10-19 下午 07:13
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "file")
public class FileProperties {
	private String path;
	private String domain;
	private boolean enable;
}
