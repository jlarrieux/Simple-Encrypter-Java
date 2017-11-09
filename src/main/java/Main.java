import controller.Controller;
import entity.MyJFXDecorator;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Main extends Application {





    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane root = FXMLLoader.load(getClass().getClassLoader().getResource("views/RootLayout.fxml"));

        MyJFXDecorator decorator = new MyJFXDecorator(primaryStage, root, false, true, true);
        decorator.setTitle("Symmetric Encrypter Decrypter");

        double widht =600;
        double height = 450;
        Scene scene = new Scene(decorator, widht, height);

        final ObservableList<String> styleSheets = scene.getStylesheets();
        styleSheets.addAll(getClass().getResource("/css/jfoenix-fonts.css").toExternalForm(),
                                    getClass().getResource("/css/jfoenix-design.css").toExternalForm(),
                                    getClass().getResource(  "/css/jfoenix-main-demo.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
        new Controller(primaryStage);

    }


    public static void main(String[] args) {
        launch(args);
    }







}
