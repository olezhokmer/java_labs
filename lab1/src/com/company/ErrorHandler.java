package com.company;

import com.company.util.DataUtil;
import com.company.views.View;
import org.apache.log4j.Logger;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorHandler {
    private Logger logger = Logger.getLogger(ErrorHandler.class);
    private DataUtil dataUtil;
    private View view;
    private String errorsFileDir;
    public ErrorHandler() {
        this.dataUtil = new DataUtil();
        this.view = new View();
        this.errorsFileDir = this.dataUtil.getDataFolderPath() + "errors.txt";
    }

    public void handleError(Exception exception) {
        String message = this.createErrorMessage(exception);

        view.outputString(message);
        this.dataUtil.writeFile(message, this.errorsFileDir);
        this.logger.error(exception.getMessage());
    }

    private String createErrorMessage(Exception exception) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(new Date());

        String message = date + " | " + exception.getMessage() + "\n";
        return message;
    }
}
