package AnalisisAvanzado;

import UsuariosYSimulaciones.Simulacion;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class VisualizacionDatos {
    private Simulacion simulacion;

    public VisualizacionDatos(Simulacion simulacion) {
        this.simulacion = simulacion;
    }

    public void visualizarResultados() {
        String resultados = simulacion.obtenerResultados();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        JFreeChart chart = ChartFactory.createLineChart(
                "Resultados de la Simulación",
                "Tiempo",
                "Valor",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame();
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void guardarGrafico(String nombreArchivo) {
        JFreeChart chart = ChartFactory.createLineChart(
                "Resultados de la Simulación",
                "Tiempo",
                "Valor",
                new DefaultCategoryDataset()
        );

        try {
            ChartUtils.saveChartAsPNG(new File(nombreArchivo), chart, 800, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}