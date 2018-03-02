package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaPedido {

    private final WebDriver navegador;

    public ConsultaPedido() {
        navegador = NavegadorFactory.build();
    }

    @Test
    public void fazerLoginNo() {

        login();
        consultaPedido();
        abreTroca();
        logout();
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

    public void logout() {
        navegador.findElement(By.id("ctl00_LinkSair")).click();
    }


    public void consultaPedido() {

        //Passando a URL da Consulta de pedidos
        navegador.get("http://hmg4-aw-abac-ap:9000/PedidoPesquisar.aspx");

        //Consultando pedido

        navegador.findElement(By.id("ctl00_MainContainer_PnlFiltros_TxtCodigoExterno1_I")).sendKeys("19817071068");
        navegador.findElement(By.id("ctl00_MainContainer_PnlFiltros_BtnPesquisar_CD")).click();


    }

    public void abreTroca() {

        //Clica no botão de troca
        navegador.findElement(By.id("ctl00_MainContainer_btnTroca_CD")).click();

        //Marca check box "objetivo"
        navegador.findElement(By.id("ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_chkProduto_S_D")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Encontra o elemento do combo objetivo
        navegador.findElement(By.xpath("//td[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbObjetivo_B-1']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Seleciona objetivo "Troca"
        navegador.findElement(By.xpath(".//*[@id='ctl00_MainContainer_PageTrocaDevolucao_pnlItensPedido_rptItensPedido_ctl00_cmbObjetivo_DDD_L_LBI1T0']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
