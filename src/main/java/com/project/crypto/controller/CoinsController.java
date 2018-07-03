package com.project.crypto.controller;

import com.project.crypto.model.CoinMarketModel;
import com.project.crypto.service.CoinService;
import com.project.crypto.utils.GeneratePdfRaport;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rafał on 2017-08-30.
 */
@RestController
public class CoinsController {

    private final Log logger = LogFactory.getLog(getClass());
    private final CoinService coinService;

    @Autowired
    public CoinsController(CoinService coinService) {
        this.coinService = coinService;
    }

    @RequestMapping("/pdf")
    public ResponseEntity<InputStreamResource> coinsPDF() throws IOException {
        List<CoinMarketModel> list = /*coinService.findAll();*/ saveCoinsInDB();
        ByteArrayInputStream byteArrayInputStream = GeneratePdfRaport.coinsReport(list);
        logger.info("list size pdf " + list.size());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=coinsreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }


    @RequestMapping("/coins")
    public List<CoinMarketModel> findCoins() {

        List<CoinMarketModel> coins = coinService.findAll();
        return coins;
    }


    @RequestMapping("/coin/{coinName}")
    public CoinMarketModel findCoin(@PathVariable String coinName) {

        CoinMarketModel coin = coinService.findByName(coinName);
        return coin;
    }

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public List<CoinMarketModel> saveCoinsInDB() {
        //Create a Rest template
        RestTemplate restTemplate = new RestTemplate();

//Create a list for the message converters

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

//Add the Jackson Message converter
        messageConverters.add(new MappingJackson2HttpMessageConverter());

//Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);

        List<CoinMarketModel> resultList = Arrays.asList(restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/?limit=10", CoinMarketModel[].class));
        //  logger.info("reusltList size " + resultList.size());

        //    coinService.saveAll(resultList);


        return resultList;
    }
/*

@Autowired
private UserRepository userRepository;

    ///////////////////////users stuff////////////
    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
     //   n.setAge(15);
        n.setEnabled(true);
        n.setConfirmationToken("nwm");
        n.setId(1);
        n.setPassword("root");
        n.setSurname("cos");
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }


*/


}