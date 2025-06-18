package com.conteduu.ui;

import com.conteduu.dao.PlayerDao;
import com.conteduu.model.Player;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

/*
    A estrutura vai precisar:
    - Uma classe Player
    - Uma classe que tenha conexão com o banco
    - Um classe que conecte o player com o banco criado
*/



/*          --- Estrutura lógica ------

     [TELA JSX] -> chama -> [Player DAO] -> usar -> [MongoUtil] -> conecta ao banco

*/



public class MainApp extends Application {

    private final ObservableList<Player> data = FXCollections.observableArrayList();
    private final PlayerDao pd = new PlayerDao();
    private final Random rnd = new Random();

    public void start(Stage stage){

        // Tabela de dados
        TableView<Player> table = new TableView<>(data);
        table.setPlaceholder(new Label("Nenhum jogador ainda"));

//        // Coluna
//        TableColumn<String, String> column = new TableColumn<>("Nome: ");
//        column.setMinWidth(200);
//
//        // Iserindo coluna na tabela
//        table.getColumns().add(column);

        table.getColumns().addAll(
                col("Nome", "nome", 150), // 1º título coluna | 2º campo a exibir | 3º largura
                col("Pontos", "pontos", 60),
                col("Vitorias", "vitorias", 60)
        );

        // -------- Barra de controles -------------
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome do jogador");

        Button buttonNovo = new Button("Novo");
        buttonNovo.setOnAction(e -> {
            pd.insert(txtNome.getText());
            txtNome.clear();
            refresh();
        });



        Button buttonRole = new Button("Rolar");
        buttonRole.setOnAction(e -> {
            Player p = table.getSelectionModel().getSelectedItem();
            if (p == null) return;

            int dado = rnd.nextInt(6) + 1;
            pd.addPoints(p.id(), p.pontos());
            refresh();
        });

        Button buttonReset = new Button("Reset");
        buttonReset.setOnAction(e -> {
            pd.resetAll();
            data.clear();
        });

        // ##### Até aqui apenas visual ####

        HBox comandos = new HBox(8, new Label("Nome: "),txtNome, buttonNovo, buttonRole, buttonReset);

        comandos.setPadding(new Insets(10));

        // Layout final
        VBox root = new VBox(comandos, table);

        Scene scene = new Scene(root, 380, 420);

        stage.setScene(scene);
        stage.setTitle("Dice game");

        stage.show();
    }

    private static TableColumn<Player, String> col(String title, String field, int width){
        TableColumn<Player, String> column = new TableColumn<>(title);
        column.setMinWidth(width);
        column.setCellValueFactory( cell -> {
            Player player = cell.getValue();

            return switch (field){
                case "nome" -> new ReadOnlyStringWrapper(player.nome());
                case "ponto" -> new ReadOnlyStringWrapper(String.valueOf(player.pontos()));
                default -> new ReadOnlyStringWrapper(String.valueOf(String.valueOf(player.vitorias())));
            };
        });
        return column;
    }

    private void refresh(){
        data.addAll(pd.findAll());
    }

    public static void main( String[] args ){
        launch(args);
    }
}
