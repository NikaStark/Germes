## Germes

#### Task:
Система Доставка Груза. Предоставление услуг по получению и доставке груза. На сайте 
содержится информация о тарифах и направления доставки. Незарегистрированному пользователю 
доступен просмотр сайта и калькулятор услуг. Зарегистрированный пользователь у себя в 
Кабинете может создать Заявку на получение багажа и адрес доставки. Заявка содержит 
информацию о типе багажа, вес и дату получения. После получения заявки Система формирует 
счет. Пользователь может оплатить его в своем кабинете.

#### Requirements:
- Git
- Maven		 
- PostgreSQL

#### Build:
1. Clone the project
      ```bash 
      https://github.com/NikaStark/Germes.git 
      ```
      
 2. Change directory		
     ```bash		     
        cd Germes
     ```
      		 
 3. Create empty database and add credentials in 
    ```bash 
    src/main/resources/liquibase/liquibase.properties
    ```
 		 		 
 4. Run clean and default lifecycles (inclusive up to install phase)
     ```bash		     
      mvn clean package		    
     ````
     
 5. Put war to webapps folder tomcat`s and start the tomcat. App will be available by http://localhost:8080/germes/