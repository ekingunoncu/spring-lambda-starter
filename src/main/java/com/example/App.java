package com.example;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.service.HelloService;

public class App extends AbstractHandler<SpringConfig>
        // we are only using this APIGatewayProxyRequestEvent and APIGatewayProxyResponseEvent because we are using API Gateway
        // for other lambda Triggers we can use our own POJOs as well for instance an SQS event
        implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        HelloService helloService = applicationContext.getBean(HelloService.class);
        String message = helloService.hello();
        System.out.println(message);
        Map<String, String> responseHeaders = new HashMap<>();
        responseHeaders.put("Content-Type", "application/json");
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent().withHeaders(responseHeaders);

        return response
                .withStatusCode(200)
                .withBody(message);
    }

}
