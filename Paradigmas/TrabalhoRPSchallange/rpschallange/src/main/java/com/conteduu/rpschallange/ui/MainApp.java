package com.conteduu.rpschallange.ui;

import com.conteduu.rpschallange.model.Move;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Button btnPlay, btnReset;
    private Label labelStatusDaPartida, labelPlayer, labelCPU, labelRes;
    private ProgressBar progressoPartida;
    private HBox jogadasPossiveis;

    @Override
    public void start(Stage stage) {

        // Campo antes do ComboBox de jogada
        Label labelHeader = new Label("Sua jogada: ");

        // ComboBox com os dados do ENUM Move
        ComboBox<Move> comboBoxHeader = new ComboBox<>(
                FXCollections.observableArrayList(Move.values())
        );
        //Seleciona por padrão o primeiro elemento do ComboBox
        comboBoxHeader.getSelectionModel().selectFirst();

        // Cria botao de play
        btnPlay = new Button("Jogar");

        // Cria botão de resetar o game
        btnReset = new Button("Nova Partida");

        // Header da tela - adiciona todos os componentes a ele
        HBox header = new HBox(
                8,
                labelHeader,
                comboBoxHeader,
                btnPlay,
                btnReset
        );
        // Alinha os componentes do header ao centro e a esquerda
        header.setAlignment(Pos.CENTER_LEFT);


        // Campos com dados dos jogadores
        labelPlayer = new Label("Você: - ");
        labelCPU = new Label("CPU: - ");
        labelRes = new Label("Resultado: - ");

        // Informacoes da rodada atual
        HBox lastInfo = new HBox(
                20,
                labelPlayer,
                labelCPU,
                labelRes
        );

        labelStatusDaPartida = new Label("V: 0 | D:0 | E:0");
        progressoPartida = new ProgressBar(80);

        jogadasPossiveis = new HBox(card("PEDRA"), card("PAPEL"), card("TESOURA"));
        // jogadasPossiveis.setPadding(new Insets(10));

        // Componente com todas as Hbox
        VBox root = new VBox(
                10,
                header,
                lastInfo,
                labelStatusDaPartida,
                progressoPartida,
                jogadasPossiveis

        );

        // -------- EVENTS -------- \\

        btnPlay.setOnAction(e -> playRound(comboBoxHeader.getValue()));

        // Adiciona a vbox principal a Scene(tela padrão) e define o tamanho
        stage.setScene(new Scene(root, 800, 800));
        stage.setTitle("RPS Challenge");
        stage.show();
    }

    private VBox card(String nome){

        Label tipoJogada = new Label(nome);
        tipoJogada.setStyle("-fx-font-size:28;");

        Label qntdDeJogadas = new Label("0");

        VBox box = new VBox(tipoJogada, qntdDeJogadas);
        box.setStyle("-fx-padding:10; -fx-background-color:#f2f2f2; -fx-border-radius:9; -fx-background-radius:8;");

        return box;
    }

    private void playRound(Move jogadaAtual){

    }

    public static void main(String[] args) {
        launch(args);
    }
}
