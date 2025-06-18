package com.conteduu.rpschallange.ui;

import com.conteduu.rpschallange.dao.ScoreDao;
import com.conteduu.rpschallange.model.Move;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private final ScoreDao dao = new ScoreDao();

    // Itens do listView
    private final ObservableList<String> history = FXCollections.observableArrayList();

    private Button btnPlay, btnReset;
    private Label lbsStats, lblPlayer, lblCPU, lblRes;
    private ProgressBar bar;
    private HBox cardBox;


    @Override
    public void start(Stage stage) {
        ComboBox<Move> cbo = new ComboBox<>(
                FXCollections.observableArrayList(Move.values())
        );
        cbo.getSelectionModel().selectFirst();

        btnPlay = new Button("Jogar");
        btnReset = new Button("Nova Partida");
        btnReset.setDisable(true);

        HBox top = new HBox(8, new Label("Sua Jogada: "), cbo, btnPlay, btnReset);
        top.setAlignment(Pos.CENTER_LEFT);

        lblPlayer = new Label("Você: -");
        lblCPU = new Label("CPU: -");
        lblRes = new Label("Resultado: -");

        HBox lastInfo = new HBox(20, lblPlayer, lblCPU, lblRes);

        lbsStats = new Label(); // V:0 D:0 L:0 (0, 0, 0.0%)
        bar = new ProgressBar();

        cardBox = new HBox(15, card("🪨"), card("🧻"), card("✂️"));
        cardBox.setPadding(new Insets(10));

        ListView<String> list = new ListView<>(history);


        // -------------- EVENTOS -------------- //

        btnPlay.setOnAction( e -> playRound(cbo.getValue()));

        btnReset.setOnAction( e -> resetGame());

        // -------------- Montagem do Layout -------------- //

        VBox root = new VBox(10,
                top,
                lastInfo,
                lbsStats,
                bar,
                cardBox,
                new Label("Partidas Anteriores"),
                list
        );
        root.setPadding(new Insets(10));

        // Carregar histórico existente //
        history.setAll(dao.list());

        resetGame();

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("RPS Challenge");
        stage.show();
    }

    private void playRound(Move player){

    }

    private void resetGame(Move player){

    }

    private VBox card(String nome){
        Label icon = new Label(nome);
        icon.setStyle("-fx-font-size:28;");

        Label count = new Label("0");

        VBox box = new VBox(icon, count);
        box.setStyle("-fx-padding:10; -fx-background-color:#f2f2f2; -fx-border-radius:9; -fx-background-radius:8;");

        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
