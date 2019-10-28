package com.rest.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Georgi Trendafilov
 */
public class Voter {


    public static void main(String[] args) {

        // Load proxies from file
        Map<String, Integer> proxies = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\georgi.trendafilov\\Desktop\\bg_list.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                proxies.put(line.split(":")[0], Integer.parseInt(line.split(":")[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded list of " + proxies.size() + " proxies");

        // Create request
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-requested-with", "XMLHttpRequest");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = "https://fotografsofia.com/wp-admin/admin-ajax.php?callback=jQuery112404247453056139263_1572245504480&action=ow_save_votes&pid=fgBWzWGZ%2BPdiDuocYkfHrQ%3D%3D&termid=UXOBx7kXr%2FGNOQf7%2BpXwVQ%3D%3D";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path("/");
        UriComponents components = builder.build(true);
        URI uri = components.toUri();

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);

        // Create RestTemplate with proxy for each proxy from the list
        for (String ip : proxies.keySet()) {

            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, proxies.get(ip)));
            requestFactory.setProxy(proxy);
            RestTemplate restTemplate = new RestTemplate(requestFactory);

            System.out.print("Trying with " + ip + ":" + proxies.get(ip) +  " -> ");

            try {
                restTemplate.getForObject("https://www.abv.bg/", String.class);
                //restTemplate.getForObject("https://fotografsofia.com/contestants/ivan-2/", String.class);
                //System.out.println(restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody());
                System.out.println("success");
            } catch (Exception e) {
                System.out.println();
            }
        }
    }
}
