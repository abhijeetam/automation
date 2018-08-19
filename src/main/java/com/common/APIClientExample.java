package com.common;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.common.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;


public class APIClientExample {

	public static void main(String[] args) throws IOException {
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com");
		Response response = target.path("/posts/1/comments").request(MediaType.APPLICATION_JSON).get();
		String printJson = response.readEntity(String.class);
		//System.out.println(printJson);


		URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		System.out.println(uc.getResponseCode());

		ObjectMapper objectMapper = new ObjectMapper();
		
		Post post = objectMapper.readValue(uc.getInputStream(), Post.class);
		
		System.out.println(post.getId());

		//List<Post> posts = object.readValue(uc.getInputStream(), new TypeReference<List<Post>>(){});

		
		JSONArray jsonarray = new JSONArray(printJson);
		for (int i = 0; i < jsonarray.length(); i++) {
		    JSONObject jsonobject = jsonarray.getJSONObject(i);
		    Integer name = jsonobject.getInt("id");
		    String id = jsonobject.getString("email");
		    System.out.println(name + " " + id);
		}
		

//		for(Post post: posts) {
//			System.out.println(post.getId());
//			System.out.println(post.getUserId());
//			System.out.println(post.getBody());
//			System.out.println(post.getTitle());
//		}

//		url = new URL("https://jsonplaceholder.typicode.com/posts/1/comments");
//		uc = (HttpURLConnection) url.openConnection();
//
//		System.out.println(uc.getResponseCode());
//
//		objectMapper = new ObjectMapper();
//
//		List<Comment> comments = objectMapper.readValue(uc.getInputStream(), new TypeReference<List<Comment>>(){});
//
//
//		for(Comment comment: comments) {
//			System.out.println(comment.getId());
//			System.out.println(comment.getPostId());
//			System.out.println(comment.getEmail());
//			System.out.println(comment.getName());
//			System.out.println(comment.getBody());
//		}

		
		//response.get();
		//System.out.println(response.getStatus());
	}

}
