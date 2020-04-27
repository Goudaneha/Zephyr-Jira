package com.jwt.token;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

public class GenerateAPIToken {

	public static void main(String[] args) throws URISyntaxException, IllegalStateException, IOException {
		// Replace Zephyr BaseUrl with the <ZAPI_CLOUD_URL> shared with ZAPI Cloud Installation
		String zephyrBaseUrl = "https://prod-api.zephyr4jiracloud.com/connect/";
		// zephyr accessKey , we can get from Addons >> zapi section
		String accessKey = "ZTgyMjExMzktZjIwNi0zNjY5LWFjNWYtODE4MGJmYjE4NWRmIDVlODQzNmMyOWUzNGMwMGMxN2RjMzY2YSBVU0VSX0RFRkFVTFRfTkFNRQ";
		// zephyr secretKey , we can get from Addons >> zapi section
		String secretKey = "ieEPiGSIjKkH70p4wobnBylauygEEVyRCn_sloGcl-k";
		// Jira accountId
		String accountId = "5e8436c29e34c00c17dc366a";
		ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId).build();
		JwtGenerator jwtGenerator = client.getJwtGenerator();
		
		// API to which the JWT token has to be generated
		String createCycleUri = zephyrBaseUrl + "/public/rest/api/1.0/cycle?expand=&clonedCycleId=";
		
		URI uri = new URI(createCycleUri);
		int expirationInSec = 360;
		String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);
		
		// Print the URL and JWT token to be used for making the REST call
		System.out.println("FINAL API : " +uri.toString());
		System.out.println("JWT Token : " +jwt);	

	
	}

}
