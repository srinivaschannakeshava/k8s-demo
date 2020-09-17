package in.srini91.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.srini91.model.HelloModel;

@RestController
public class HelloController {
	private InetAddress ip;

	@PostConstruct
	public void setHostName() {
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public HelloModel sayhello() {
		return HelloModel.builder().type("HelloModel").version("V2").response("Hello Version 2!!")
				.hostName(ip.getHostName()).ip(ip.toString()).build();
	}
}
