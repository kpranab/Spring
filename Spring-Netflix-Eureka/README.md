Load Balanced RestTemplate
Create using @LoadBalanced– Spring enhances it to service lookup & load balancing
<b>
 @Bean
 @LoadBalanced
 public RestTemplate restTemplate() {
  return new RestTemplate();
 }
 </b>
 Must inject using the same qualifier-

If there are multiple RestTemplate you get the right one.
It can be used to access multiple microservices

<b>
@Autowired
@LoadBalanced
protected RestTemplate restTemplate;
</b>
Load Balancing with Ribbon
Our smart RestTemplate automatically integrates two Netflix utilities

<b>Eureka</b> Service Discovery
<b>Ribbon</b> Client Side Load Balancer
  
<b>Eureka</b> returns the URL of all available instances
<b>Ribbon</b> determine the best available service too use
