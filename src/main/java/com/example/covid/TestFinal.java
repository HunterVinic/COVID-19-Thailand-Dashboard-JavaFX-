package com.example.covid;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;


public class TestFinal extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request getRequest = new Request.Builder()
                .url("http://covid19.ddc.moph.go.th/api/Cases/today-cases-all")
                .build();
        try {
            Response response = client.newCall(getRequest).execute();
//            System.out.println(response.body().string());
            String jsonString = response.body().string();
            JSONParser parser = new JSONParser();
            Object jsonObj;
            jsonObj = parser.parse(jsonString);
            System.out.println(jsonObj);
            JSONArray jsonArray = (JSONArray) jsonObj;
            System.out.println(jsonArray.get(0));
            JSONObject jsonData = (JSONObject) jsonArray.get(0);
            System.out.println(jsonData.get("txn_date"));
            System.out.println(jsonData.get("new_case"));
            System.out.println(jsonData.get("total_case"));
            System.out.println(jsonData.get("new_case_excludeabroad"));
            System.out.println(jsonData.get("total_case_excludeabroad"));
            System.out.println(jsonData.get("new_death"));
            System.out.println(jsonData.get("total_death"));
            System.out.println(jsonData.get("new_recovered"));
            System.out.println(jsonData.get("total_recovered"));
            System.out.println(jsonData.get("update_date"));

            VBox Main = new VBox(10);
            Main.setPadding(new Insets(100,100,100,100));

            VBox date = new VBox(10);
            date.setPadding(new Insets(20,20,20,110));
            date.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txndate = new Text();
            txndate.setText((String) jsonData.get("txn_date"));
            date.getChildren().add(txndate);
            //txndate.setTextAlignment(TextAlignment.CENTER);


            VBox concase = new VBox(10);
            concase.setPadding(new Insets(20,20,20,110));
            concase.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text confiremd_case = new Text("Confirmed case");
            concase.getChildren().add(confiremd_case);

            VBox tcase = new VBox(10);
            tcase.setPadding(new Insets(40,20,40,120));
            tcase.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txtotal = new Text();
            txtotal.setText("Total Case");
            Text totalcase= new Text(String.valueOf(jsonData.get("total_case")));
            //totalcase.setFill(Color.YELLOW);
            tcase.getChildren().addAll(txtotal, totalcase);

            HBox hBox = new HBox(20);
            hBox.setSpacing(4);

            VBox ncase = new VBox(10);
            ncase.setPadding(new Insets(20,20,20,20));
            ncase.setBorder(new Border(new BorderStroke(Color.LIGHTBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txtncase = new Text();
            txtncase.setText("New Case");
            Text newcase= new Text(String.valueOf(jsonData.get("new_case")));
            ncase.getChildren().addAll(txtncase, newcase);

            VBox ncased = new VBox(10);
            ncased.setPadding(new Insets(20,20,20,20));
            ncased.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txtncased = new Text();
            txtncased.setText("New Case \ninclude \ndashboard");
            Text newcasedashboard= new Text(String.valueOf(jsonData.get("new_case_excludeabroad")));
            ncased.getChildren().addAll(txtncased, newcasedashboard);

            VBox tcased = new VBox(10);
            tcased.setPadding(new Insets(20,20,20,20));
            tcased.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txttcased = new Text();
            txttcased.setText("Total Case \ninclude \ndashboard");
            Text totalcasedashboard= new Text(String.valueOf(jsonData.get("total_case_excludeabroad")));
            tcased.getChildren().addAll(txttcased, totalcasedashboard);

            HBox hBox1 = new HBox(30);
            hBox1.setSpacing(4);

            VBox ndeath = new VBox(10);
            ndeath.setPadding(new Insets(20,43,20,43));
            ndeath.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txtndeath = new Text();
            txtndeath.setText("New Death");
            Text newdeath= new Text(String.valueOf(jsonData.get("new_death")));
            ndeath.getChildren().addAll(txtndeath, newdeath);


            VBox tdeath = new VBox(10);
            tdeath.setPadding(new Insets(20,43,20,43));
            tdeath.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txttdeath = new Text();
            txttdeath.setText("Total Death");
            Text totaldeath= new Text(String.valueOf(jsonData.get("total_death")));
            tdeath.getChildren().addAll(txttdeath, totaldeath);


            HBox hBox2 = new HBox(30);
            hBox2.setSpacing(4);

            VBox nrecover = new VBox(10);
            nrecover.setPadding(new Insets(20,31,20,31));
            nrecover.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txtnrecover = new Text();
            txtnrecover.setText("New Recovered");
            Text newrecovered= new Text(String.valueOf(jsonData.get("new_recovered")));
            nrecover.getChildren().addAll(txtnrecover, newrecovered);

            VBox trecover = new VBox(10);
            trecover.setPadding(new Insets(20,31,20,31));
            trecover.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,null)));
            Text txttrecover = new Text();
            txttrecover.setText("Total Recovered");
            Text totalrecovered= new Text(String.valueOf(jsonData.get("total_recovered")));
            trecover.getChildren().addAll(txttrecover, totalrecovered);


            hBox.getChildren().addAll(ncase, ncased, tcased);
            hBox1.getChildren().addAll(ndeath,tdeath);
            hBox2.getChildren().addAll(nrecover,trecover);
            Main.getChildren().addAll(date,concase,tcase,hBox,hBox1,hBox2);


            Scene scene = new Scene(Main, 500, 900);
            stage.setTitle("Current state of COVID-19 in Thailand"); // Set the stage title
            stage.setScene(scene); // Place the scene in the stage
            stage.show(); // Display the stage


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);

    }
}

