package org.logink.cloud.railway.callback.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.logink.cloud.railway.callback.dto.CallbackSendData;
import org.logink.cloud.railway.callback.dto.ReturnStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @ClassName: ReceiverController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: yinjd
 * @date: 2017年8月7日 下午4:38:28
 *
 */
@RestController
public class ReceiverController {
	
	@RequestMapping(value = "/receive",  produces = {"application/json;charset=UTF-8",
			"application/json", "text/html;charset=UTF-8" }, consumes = { "application/json;charset=UTF-8",
					"application/json", "text/html;charset=UTF-8" })
	ReturnStatus recieve(@RequestBody CallbackSendData requestBody) throws IOException, InterruptedException {
		ReturnStatus result = new ReturnStatus();
		try {
			System.out.println(new Date().toString() + ": " + "receive data: " + requestBody);
			result.setResultCode("200");
			result.setResultMsg("成功【接收回调成功】");
		} catch (Exception e) {
			System.out.println(new Date().toString() + ": " + "exception: " + e.toString());
			result.setResultCode("500");
			result.setResultMsg("失败【接收回调失败】");
		}
		return result;
	}
	
	@RequestMapping(value = "/receive2",  produces = {"application/xml;charset=UTF-8",
			"application/json", "text/html;charset=UTF-8" }, consumes = { "application/xml;charset=UTF-8",
					"application/json", "text/html;charset=UTF-8" })
	ReturnStatus receive2(HttpServletRequest request) throws IOException {
		ReturnStatus result = new ReturnStatus();
		try {
			request.setCharacterEncoding("utf8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			result.setResultCode("500");
			result.setResultMsg("失败【接收回调失败】");
		}
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
			System.out.println((new Date().toString() + ": " + "receive data: " + json.toString()));
			result.setResultCode("200");
			result.setResultMsg("成功【接收回调成功】");
		} catch (Exception e) {
			System.out.println(new Date().toString() + ": " + "exception: " + e.toString());
			result.setResultCode("500");
			result.setResultMsg("失败【接收回调失败】");
		}
		return result;
	}
}