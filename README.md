# Base de microsserviços em java com Eureka (discovery) e Resilience4j (circuit breaker).

Como começa:
Nas dependências de cada serviço, basta você colocar o que colocaria em um API que você quisesse fazer normalmente. Apenas acrescente um Eureka client.

No server discovery, basta fazer um projeto somente com a dependência do Eureka server.

No Gateway basta por a dependência do Eureka client e do cloud gateway.

Lembre-se, que muitas vezes microservisos podem usar as mesmas dependências. Sendo assim, o correto e fazer um POM com elas, que será herdado por parent pelos outras (através dos Pom`s) que precisam.

É bem possível que em mesmo micro serviço precisasse de classes iguais há um outro. Assim sendo, o correto e junta-los e importar o artifact nos Pom`s que precisam deles. Exemplo apenas:
https://github.com/RaphaelStopa/microservice-for-base

Importante! Olhe os application.yml e o ServiceOne é o mais completo. Não ajustei corretamente o Two, ele é só exemplo.

O Resilience4j foi só aplicado no ServiceOne.

Eu fiz em exemplo de compartinhamento entre modulos. Importei o Shared no ServiceOne (Pom). Caso ele fosse nescessarios a todos. Teria que fazer um parent de um Pom acima.

FALTA FAZER:

Autenticação com JWT. De preferencia marcando, agora tera que refatorar tudo

Se tiver tempo aplicar Zipkin e Sleuth.

Retirar files inúteis do Shared.

Lembrar de colocar dependências no arquivo shared e retirar dos demais. O mesmo vale para entityes e afins. (To replicando demais! REVEJA O PROJETO INTEIRO!)

Open feign, se tiver tempo.

Checar gitinores.

Me parece ter algo errado com a config do gateway. Checar.

Fazer um banco para cada quando terminar aqui!

JWT funciona mais precisa melhor a exposicao de erro. Muito generico


