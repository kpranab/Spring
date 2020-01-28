Load Balanced RestTemplate</br>
Create using @LoadBalanced– Spring enhances it to service lookup & load balancing</br>
<b>
 @Bean</br>
 @LoadBalanced</br>
 public RestTemplate restTemplate() {</br>
  return new RestTemplate();</br>
 }
 </b></br>
 Must inject using the same qualifier-

If there are multiple RestTemplate you get the right one.
It can be used to access multiple microservices

<b>
@Autowired</br>
@LoadBalanced</br>
protected RestTemplate restTemplate;
</b></br>
Load Balancing with Ribbon
Our smart RestTemplate automatically integrates two Netflix utilities

<b>Eureka</b> Service Discovery</br>
<b>Ribbon</b> Client Side Load Balancer
</br>  
<b>Eureka</b> returns the URL of all available instances</br>
<b>Ribbon</b> determine the best available service too use
