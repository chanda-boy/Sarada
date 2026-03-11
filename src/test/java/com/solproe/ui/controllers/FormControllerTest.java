package com.solproe.ui.controllers;

import com.solproe.business.dto.ThresholdInputModel;
import com.solproe.business.repository.ErrorCallback;
import com.solproe.business.repository.SuccessCallback;
import com.solproe.ui.viewModels.ConfigFileViewModel;
import com.solproe.util.logging.ErrorLogger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormControllerTest {

    @Test
    public void generateConfig () {
        ConfigFileViewModel viewModel = new ConfigFileViewModel();

        // Validar entradas
        ThresholdInputModel input = new ThresholdInputModel();
        input.setProjectName("test1");
        input.setIdProject("1");
        input.setCityName("buritica");
        input.setStateName("antioquia");
        input.setSciBoss("daniel");
        input.setSciBossContact(Long.parseLong("3013338304"));
        input.setAuxiliarSciBoss("test");
        input.setAuxiliarSciBossContact(Long.parseLong("123"));
        input.setForestFireThresholdOrange(25);
        input.setForestFireThresholdRed(27);
        input.setPrecipitationThresholdOrange(20);
        input.setPrecipitationThresholdRed(39);
        input.setWindThresholdOrange(40);
        input.setWindThresholdRed(50);
        input.setPrecipitationRainPercentOrange(50);
        input.setPrecipitationRainPercentRed(75);
        input.setCeraunicosThresholdRed(96);

        // Llamada al ViewModel
        SuccessCallback successCallback = () -> {
            System.out.println("success funcionando #######");
            System.out.println("test pasado");
            };

        ErrorCallback errorCallback = t -> {
            ErrorLogger.log(t);
            Platform.runLater(() -> {
                System.out.println("test fallido");
            });
        };
        viewModel.createConfigFileThresholdAsync(successCallback, errorCallback, input);
    }
}