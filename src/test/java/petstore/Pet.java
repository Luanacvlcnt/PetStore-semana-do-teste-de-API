// 1- Pacote
package petstore;

// 2-Bibliotecas

import io.restassured.specification.Argument;
import org.omg.CORBA.StringHolder;
import org.testng.annotations.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;

// 3- Classe
public class Pet {

    // 3.1 - Atributos (caracteristicas de um objeto)

    String uri = "https://petstore.swagger.io/v2/pet"; //endereço da entidade pet

    // 3.2- Metodos e funções (metodos nao retorna valor e função retorna algum valor)

    //Estrutura para ler arquivo Json e devolver conteúdo
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test (priority = 1)  //identifica o método ou função com um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        //Sintaxe Gherkin
        // Dado - Quando - Então
        // Give - When - Then

        given()
                .contentType("application/json") //comum em API REST - antigos era "text/xml"
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Mari"))
                .body("status", is("available"))
                .body("category.name", is("AAAA"))
                .body("tags.name", contains("data"))
         ;
    }

    @Test (priority = 2)
    public  void  consultarPet(){
        String petId = "12333";

        String token =
        given()
                .contentType("application/json")
                .log().all()
        .when()
            .get(uri + "/" + petId)

        .then()
            .log().all()
            .statusCode(200)
            .body("name", is("Mari"))
            .body("category.name", is("AAAA"))
            .body("status", is("available"))
        .extract()
          .path("category.name")

        ;
    System.out.println("O token é" + token);


    }

    @Test(priority = 3)

    public void alterarPet() throws IOException {
        String jsonBody = lerJson("db/pet2.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(uri)
        .then()
               .log().all()
               .statusCode(200)
               .body("name", is("Mari"))
               .body("status", is("sold"))
           ;
    }
    
}
