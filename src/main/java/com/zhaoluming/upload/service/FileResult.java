package com.zhaoluming.upload.service;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zhao Luming(赵路明)
 * @create 2020-10-19 下午 07:10
 */
@Data
@AllArgsConstructor
public class FileResult {

	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件访问服务地址
	 */
	private String fileDomain;
	/**
	 * 文件访问url
	 */
	private String fileUrl;
}
