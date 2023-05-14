package eclass.hackthon.mercedesbenz.io.eclassteam.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeeplinkService {
    private final RestTemplate restTemplate;

    public DeeplinkService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

   /**
	* The function fetches a deeplink for a given Mercedes model by calling the Mercedes API.
	* 
	* @param model The model parameter is a string that represents the model of a Mercedes car for
	* which we want to fetch the deeplink. For example, "C-Class" or "E-Class".
	* @return The method `fetchDeeplink` returns a `String` which is the deeplink for the given model
	* fetched from the Mercedes API.
	*/
    public String fetchDeeplink(String model) {
        String deeplink = restTemplate.getForObject("https://dev.api.oneweb.mercedes-benz.com/hackathon/deeplinks/models/" + model, String.class);
        return deeplink;
    }

    

}
