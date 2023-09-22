package com.guidersoft.runners;

import com.guidersoft.webdriver.Driver;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureListener implements StepLifecycleListener {
    @Override
    public void beforeStepStop(StepResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN){
            Allure.attachment("Error:", result.getStatusDetails().getMessage());
            byte[] resim = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(resim));
        }
    }
}
