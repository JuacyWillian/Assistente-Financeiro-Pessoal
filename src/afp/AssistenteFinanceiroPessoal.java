package afp;

import afp.gui.view.Navegagor;
import afp.modelo.Categoria;
import afp.modelo.Conta;
import afp.modelo.dao.CategoriaDAO;
import afp.modelo.dao.ContaDAO;
import afp.util.ContaTipo;
import afp.util.TelasEnum;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AssistenteFinanceiroPessoal {// extends Application {

    private ResourceBundle bundle;
    private Stage primaryStage;

    public static void main(String[] args) {
//        launch(args);
        CategoriaDAO daoCategoria = new CategoriaDAO();
        ContaDAO daoConta = new ContaDAO();
//        Categoria cat = new Categoria("Alimentação", "Gastos com supermercado em geral");
//        cat = daoCategoria.insert(cat);
//        
//        Conta conta = new Conta(
//                "Compras do Mes de Maio", 
//                "Gastos com as compras no mes de maio", 
//                ContaTipo.DESPESA, 
//                cat, 
//                150, 
//                LocalDate.now(), 
//                LocalDate.of(2016, Month.JUNE, 7), 
//                false
//        );
//        daoConta.insert(conta);
        
        List<Conta> contasQuitadas = daoConta.findQuitadas();
        List<Conta> contasPendentes = daoConta.findPendentes();
        List<Conta> contasVencidas = daoConta.findVencidas();
        List<Conta> contasPendentesVencidas = daoConta.findPendentesVencidas();
        
        System.out.println("++++++++++++");
        System.out.println("Contas Quitadas");
        contasQuitadas.stream().forEach( 
                (cq) -> System.out.println(cq.toString())
        );
        
        System.out.println("++++++++++++");
        System.out.println("Contas Pendentes");
        contasPendentes.stream().forEach( 
                (cq) -> System.out.println(cq.toString())
        );
        
        System.out.println("++++++++++++");
        System.out.println("Contas Vencidas");
        contasVencidas.stream().forEach( 
                (cq) -> System.out.println(cq.toString())
        );
        
        System.out.println("++++++++++++");
        System.out.println("Contas Pendentes Vencidas");
        contasPendentesVencidas.stream().forEach( 
                (cq) -> System.out.println(cq.toString())
        );
        
    }

//    @Override
//    public void start(Stage stage) throws Exception {
//
//        this.primaryStage = stage;
//        bundle = ResourceBundle.getBundle("afp/i18n/messages", Locale.getDefault());
//        Navegagor.getInstance().setStage(primaryStage);
//        setScene(TelasEnum.PRINCIPAL);
//    }
//
//    public void setScene(TelasEnum screen) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(screen.getPath()), bundle);
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
//
//        } catch (Exception ex) {
//            Logger.getLogger(AssistenteFinanceiroPessoal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
