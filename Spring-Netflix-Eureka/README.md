<h3>Load Balanced RestTemplate</h3></br>
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
<b>Ribbon</b> determine the best available service too use</br>

<h3>Circuit Breaker :</h3></br>
Its basic fuunction is to interupt current flow after a fault is detected</br>
Unlike a fuse, which operates once and then must be replaced, A circuit breaker can be reset (Either manually or automatically) to resume normal operation.
<h4>Circuit Breaker Pattern:</h4></br>
<ul>
  <li>When to break circuit</li>
  <li>what to do when circuit breaks</li>
  <li>When to resume request</li>
</ul>
<h4>Circuit Breaker Parameters:</h4></br>
<b>When does circuit trip ?</b>
<ul>
  <li>Last n requests to considear for the decision</li>
  <li>How many of those should fail ?</li>
  <li>Timeout duration</li>
</ul>
<b>When does the circuit un-trip ?</b>
<ul>
<li>How long after a circuit trip to try again ?</li>
</ul>
<h4>Example</h4>
<ul>
  <li>Last n requests to considear for the decission : 5</li>
  <li>How many of those should fail : 3</li>
  <li>Timeout duration: 2s</li>
  <li>How long to wait(sleep window):10s</li>
</ul>
<h4>We need fallback</h4>
<ul>
  <li>Throw an error</li>
  <li>Return a fallback "default" response</li>
  <li>Save previous responses(cache) and use that when possible</li>
</ul>
<h4>Why circut breakers</h4>
<ul>
  <li>Failing fast</li>
  <li>Fallback finctionality</li>
  <li>Automatic recovery</li>
</ul>
<h4>Circut breakers will implement by using Hystrix framework</h4>
