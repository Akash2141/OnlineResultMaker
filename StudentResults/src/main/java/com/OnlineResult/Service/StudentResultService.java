package com.OnlineResult.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.OnlineResult.Model.StudentModel;

@Service
public class StudentResultService {

	@Autowired
	DiscoveryClient discoveryClient;

	public List<StudentModel> getAllStudent() {
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("StudentInfo");
		ServiceInstance serviceInstance = serviceInstanceList.get(0);
		System.out.println(serviceInstance);
		String getUrl = serviceInstance.getUri() + "/StudentData/getAllStudent";
		ResponseEntity<List<StudentModel>> response = restTemplate.exchange(getUrl, HttpMethod.GET, getHeaders(),
				new ParameterizedTypeReference<List<StudentModel>>() {
				});
		return response.getBody();
	}

	private static HttpEntity<?> getHeaders() {
		HttpHeaders header = new HttpHeaders();
		header.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		return new HttpEntity<>(header);
	}
}
