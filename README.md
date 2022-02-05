# Base de microsserviços em java com Eureka

Como começa:
Nas dependências de cada serviço, basta você colocar o que colocaria em um API que você quisesse fazer normalmente. Apenas acrescente um Eureka client.

No server discovery, basta fazer um projeto somente com a dependência do Eureka server.

Lembre-se, que muitas vezes microservisoso podem usar as mesmas dependências. Sendo assim, o correto e fazer um POM com elas, que será herdado por parent pelos outras (através dos Pom`s) que precisam.

É bem possível que em mesmo micro serviço precisasse de classes iguais há um outro. Assim sendo, o correto e junta-los e importar o artifact nos Pom`s que precisam deles. Exemplo apenas:
https://github.com/RaphaelStopa/microservice-for-base

Importante! Olhe os application.yml!

Me baseei nisto:
https://www.youtube.com/watch?v=tGGo15irME8&list=PLyHJZXNdCXsd2e3NMW9sZbto8RB5foBtp&index=2

![alt_text](https://github.com/RaphaelStopa/microsservi-o-base/blob/master/usando%20rest%20templete%2C%20lembre%20que%20poder%20dar%20um%20erro%20se%20o%20outro%20serviso%20caiu%2C%20etao%20ter%20que%20usar%20o%20circuit%20breaker.png)


![alt_text](https://github.com/RaphaelStopa/microsservi-o-base/blob/master/usando%20rest%20templete%2C%20lembre%20que%20poder%20dar%20um%20erro%20se%20o%20outro%20serviso%20caiu%2C%20etao%20ter%20que%20usar%20o%20circuit%20breaker.png)
