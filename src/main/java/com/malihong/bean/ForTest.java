package com.malihong.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malihong.entity.Request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ForTest {
	public static void main(String[] args) throws IOException{
		List<Request> reqs = new ArrayList<Request>();
		Request req=new Request();
		req.setIdAccount(123);
		reqs.add(req);
		req.setIdAccount(123456);
		reqs.add(req);
		ObjectMapper mapper = new ObjectMapper();
	   // OutputStream out = new ByteArrayOutputStream();

		ObjectNode root=mapper.createObjectNode();		
		root.put("status", 0);
		//String json=mapper.writeValueAsString(reqs);
		JsonNode node = mapper.convertValue(reqs, JsonNode.class);

		root.put("options", node);
		System.out.println(root.toString());
	}
}
