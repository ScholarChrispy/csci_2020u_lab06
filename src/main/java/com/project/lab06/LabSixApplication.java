package com.project.lab06;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LabSixApplication extends Application {
    // DATA ------------------------------------------------------------------------------------------------------------
    // data for bar chart
    private static final double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static final double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    // data from pie chart
    private static final String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static final int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static final Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    // x-axis titles
    final static String year1 = "Year One";
    final static String year2 = "Year Two";
    final static String year3 = "Year Three";
    final static String year4 = "Year Four";
    final static String year5 = "Year Five";
    final static String year6 = "Year Six";
    final static String year7 = "Year Seven";
    final static String year8 = "Year Eight";

    @Override
    public void start(Stage stage) throws IOException {
        // BAR CHART ---------------------------------------------------------------------------------------------------
        // x-axis
        CategoryAxis xAxis = new CategoryAxis();

        // y-axis
        NumberAxis yAxis = new NumberAxis();

        // creating the bar chart
        BarChart<String, Number> prices = new BarChart<>(xAxis, yAxis);
        prices.setTitle("Average Housing Pricing vs Average Commercial Pricing By Year");

        // adding the data to series, in order to add them to the chart
        XYChart.Series<String, Number> avghousingprice = new XYChart.Series<>();
        avghousingprice.setName("Average Housing Prices");
        avghousingprice.getData().add(new XYChart.Data<>(year1, avgHousingPricesByYear[0]));
        avghousingprice.getData().add(new XYChart.Data<>(year2, avgHousingPricesByYear[1]));
        avghousingprice.getData().add(new XYChart.Data<>(year3, avgHousingPricesByYear[2]));
        avghousingprice.getData().add(new XYChart.Data<>(year4, avgHousingPricesByYear[3]));
        avghousingprice.getData().add(new XYChart.Data<>(year5, avgHousingPricesByYear[4]));
        avghousingprice.getData().add(new XYChart.Data<>(year6, avgHousingPricesByYear[5]));
        avghousingprice.getData().add(new XYChart.Data<>(year7, avgHousingPricesByYear[6]));
        avghousingprice.getData().add(new XYChart.Data<>(year8, avgHousingPricesByYear[7]));

        XYChart.Series<String, Number> avgcommercialprice = new XYChart.Series<>();
        avgcommercialprice.setName("Average Housing Prices");
        avgcommercialprice.getData().add(new XYChart.Data<>(year1, avgCommercialPricesByYear[0]));
        avgcommercialprice.getData().add(new XYChart.Data<>(year2, avgCommercialPricesByYear[1]));
        avgcommercialprice.getData().add(new XYChart.Data<>(year3, avgCommercialPricesByYear[2]));
        avgcommercialprice.getData().add(new XYChart.Data<>(year4, avgCommercialPricesByYear[3]));
        avgcommercialprice.getData().add(new XYChart.Data<>(year5, avgCommercialPricesByYear[4]));
        avgcommercialprice.getData().add(new XYChart.Data<>(year6, avgCommercialPricesByYear[5]));
        avgcommercialprice.getData().add(new XYChart.Data<>(year7, avgCommercialPricesByYear[6]));
        avgcommercialprice.getData().add(new XYChart.Data<>(year8, avgCommercialPricesByYear[7]));

        // adding the year series to the chart
        prices.getData().addAll(avghousingprice, avgcommercialprice);

        // PIE CHART ---------------------------------------------------------------------------------------------------
        // modifying the data to add it to the chart
        ObservableList<PieChart.Data> purchase_data = FXCollections.observableArrayList(
                new PieChart.Data(ageGroups[0], purchasesByAgeGroup[0]),
                new PieChart.Data(ageGroups[1], purchasesByAgeGroup[1]),
                new PieChart.Data(ageGroups[2], purchasesByAgeGroup[2]),
                new PieChart.Data(ageGroups[3], purchasesByAgeGroup[3]),
                new PieChart.Data(ageGroups[4], purchasesByAgeGroup[4]),
                new PieChart.Data(ageGroups[5], purchasesByAgeGroup[5])
        );

        // creating the pie chart
        PieChart purchases = new PieChart(purchase_data);

        // configuring the pie chart
        purchases.setTitle("Number of Purchases per Age Group");
        purchases.setClockwise(true);
        purchases.setLabelLineLength(15);
        purchases.setLabelsVisible(true);
        purchases.setStartAngle(0);

        // changing the colour of the pie chart segments
        purchases.getData().get(0).getNode().setStyle("-fx-pie-color: " + ColorToHex(pieColours[0]) + ";");
        purchases.getData().get(1).getNode().setStyle("-fx-pie-color: " + ColorToHex(pieColours[1]) + ";");
        purchases.getData().get(2).getNode().setStyle("-fx-pie-color: " + ColorToHex(pieColours[2]) + ";");
        purchases.getData().get(3).getNode().setStyle("-fx-pie-color: " + ColorToHex(pieColours[3]) + ";");
        purchases.getData().get(4).getNode().setStyle("-fx-pie-color: " + ColorToHex(pieColours[4]) + ";");
        purchases.getData().get(4).getNode().setStyle("-fx-pie-color: " + ColorToHex(pieColours[5]) + ";");

        // adding the charts to a gridpane
        GridPane gridPane = new GridPane();
        gridPane.add(prices, 0, 0);
        gridPane.add(purchases, 1, 0);
        Scene scene = new Scene(gridPane); // adding the gridpane to a scene

        // configuring the stage, then showing it
        stage.setScene(scene);
        stage.setTitle("Lab 06");
        stage.setWidth(1000);
        stage.setHeight(450);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    // converting from javafx colour to hex
    private String ColorToHex(Color color) {
        return String.format("#%08X", (
                (((int) Math.round(color.getRed()* 255)) << 24) + // red
                (((int) Math.round(color.getGreen()* 255)) << 16) + // green
                (((int) Math.round(color.getBlue()* 255)) << 8) + // blue
                ((int) Math.round(color.getOpacity()* 255)))); // opacity
    }
}