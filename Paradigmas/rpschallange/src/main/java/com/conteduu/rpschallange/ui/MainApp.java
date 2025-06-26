package com.conteduu.rpschallange.ui;

import com.conteduu.rpschallange.dao.ScoreDao;
import com.conteduu.rpschallange.model.Move;
import com.conteduu.rpschallange.model.PlayerStats;
import com.conteduu.rpschallange.model.Score;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainApp extends Application {

    private final ScoreDao dao = new ScoreDao();


    private static final int MAX_ROUND = 5;
    private static final int WINDOW_AI = 3;

    // Itens do listView
    private final ObservableList<String> history = FXCollections.observableArrayList();

    private Button btnPlay, btnReset;
    private Label lbsStats, lblPlayer, lblCPU, lblRes;
    private ProgressBar bar;
    private ListView<String> listView;
    private HBox cardBox;
    private int count = 0;
    private ScoreDao scoreDao;
    PlayerStats playerStats;

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

        lblPlayer = new Label("Você: - ");
        lblCPU = new Label("CPU: - ");
        lblRes = new Label("Resultado: - ");

        HBox lastInfo = new HBox(20, lblPlayer, lblCPU, lblRes);

        lbsStats = new Label(); // V:0 D:0 L:0 (0, 0, 0.0%)
        bar = new ProgressBar();

        cardBox = new HBox(15, card("PEDRA"), card("PAPEL"), card("TESOURA"));
        cardBox.setPadding(new Insets(10));

        ListView<String> list = new ListView<>(history);


        // -------------- EVENTOS -------------- //

        btnPlay.setOnAction( e -> playRound(cbo.getValue()));

        btnReset.setOnAction( e -> resetGame());

        listView = new ListView<>();

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

        playerStats = new PlayerStats();

        Move jogadaCPU = Move.random();

        int resultado = player.versus(jogadaCPU);

        playerStats.register(resultado);
        count++;

        bar.setProgress(count / (double) MAX_ROUND);
        lbsStats.setText(lblPlayer.toString());

        lblPlayer.setText("Voce: " + player.toString());

        lblCPU.setText("CPU: " + jogadaCPU.toString());

        lblRes.setText("Resultado: " + ((resultado > 0) ? "Vitoria": resultado == 0 ? "Empate": "Derrota"));

        scoreDao = new ScoreDao();

        Score score = new Score(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                playerStats.getWins(),
                playerStats.getDraws(),
                playerStats.getLosses(),
                playerStats.winRate(),
                WINDOW_AI
                );

        if (count == MAX_ROUND){
            btnPlay.setDisable(true);
            btnReset.setDisable(false);
            scoreDao.save(score);
        }
    }


    private void resetGame(){
        playerStats = new PlayerStats();
        history.clear();
        bar.setProgress(0);
        lbsStats.setText("");

        lblPlayer.setText("Voce: ");

        lblCPU.setText("CPU: ");

        lblRes.setText("Resultado: ");
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
