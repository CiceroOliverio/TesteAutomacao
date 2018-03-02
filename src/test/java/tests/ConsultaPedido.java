package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsultaPedido {

    private final WebDriver navegador;

    public ConsultaPedido() {
        navegador = NavegadorFactory.build();
    }

    @Test
    public void fazerLoginNo() {

        login();
        consultaPedido();
    }

    public void login() {


        //Passando URL do Abacos SAC
        navegador.get("http://hmg4-aw-abac-ap:9000/Default.aspx");

        //Inserindo login e senha
        navegador.findElement(By.id("ctl02_TxtUserName_I")).sendKeys("cicero.silva");
        navegador.findElement(By.id("ctl02_TxtPassword_I")).sendKeys("123456");

        // Clicando no botão login
        navegador.findElement(By.id("ctl02_BtnLogin_CD")).click();

        // Operador loja física
        navegador.findElement(By.id("ctl02_BtnNao_B")).click();

        }

    public void consultaPedido(){

        //Passando a URL da Consulta de pedidos
        navegador.get("http://hmg4-aw-abac-ap:9000/PedidoPesquisar.aspx");

        //Consultando pedido

        navegador.findElement(By.id("ctl00_MainContainer_PnlFiltros_TxtCodigoExterno1_I")).sendKeys("20134844325");
        navegador.findElement(By.id("ctl00_MainContainer_PnlFiltros_BtnPesquisar_CD")).click();

    }
}
