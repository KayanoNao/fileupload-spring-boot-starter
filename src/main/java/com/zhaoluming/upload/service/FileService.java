package com.zhaoluming.upload.service;

import com.sun.org.apache.xpath.internal.operations.Mult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Zhao Luming(赵路明)
 * @create 2020-10-19 下午 07:15
 */
public class FileService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final FileProperties fileProperties;

	public FileService(FileProperties fileProperties) {
		this.fileProperties = fileProperties;
		logger.debug("fileService enable:{}", fileProperties.isEnable());
		logger.debug("fileService upload path:{}", fileProperties.getPath());
		logger.debug("fileService domain:{}", fileProperties.getDomain());
	}

	public FileResult upload(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		logger.debug("未处理的文件名为: " + originalFilename);
		assert originalFilename != null;
		String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
		String fileName = LocalDate.now().toString() + "_" + UUID.randomUUID().toString().replace("-", "") + substring;
		logger.debug("处理后的文件名为: " + fileName);
		File saveFile = new File(fileProperties.getPath(), fileName);
		FileResult fileResult = null;
		try {
			file.transferTo(saveFile);
			 fileResult = new FileResult(fileName,fileProperties.getDomain(),fileProperties.getDomain()+fileName);
		} catch (IOException e) {
			logger.error("保存文件发生错误: ", e);
			e.printStackTrace();
		}
		return fileResult;
	}

	public List<FileResult> upload(MultipartFile[] files){
		ArrayList<FileResult> fileResults = new ArrayList<>();
		Arrays.stream(files).forEach(file -> {
			fileResults.add(upload(file));
		});
		return fileResults;
	}
}
