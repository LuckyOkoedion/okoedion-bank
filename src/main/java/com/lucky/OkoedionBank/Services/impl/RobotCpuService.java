package com.lucky.OkoedionBank.Services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucky.OkoedionBank.Pojo.RobotCpu;
import com.lucky.OkoedionBank.Services.IRobotCpuService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RobotCpuService implements IRobotCpuService {
    private WebClient httpClient;
    private String endpoint;

    public RobotCpuService() {
        httpClient = WebClient.create();
        endpoint = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
    }


    @Override
    public List<RobotCpu> getAll() {
        return theCall();
    }

    @Override
    public RobotCpu getOneById(String id) {
        List<RobotCpu> callResult = theCall();
        List<RobotCpu> filterResult = callResult.stream().filter(theObject -> theObject.getSerialNumber() == id).collect(Collectors.toList());
        return filterResult.get(0);
    }

    private List<RobotCpu> theCall() {
        Mono<Object[]> response =  httpClient.get()
                .uri(endpoint)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object[].class).log();

        Object[] objects = response.block();

        ObjectMapper mapper = new ObjectMapper();

        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, RobotCpu.class))
                .collect(Collectors.toList());

    }
}
