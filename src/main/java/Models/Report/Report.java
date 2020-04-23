package Models.Report;

import Models.Fine;
import Models.Payment;
import Models.Rental;

public class Report {
    protected String reportName;

    public String getAllInfo(){
        return "";
    };

    public String getReportName() {return reportName;}

    public void setReportName(String newName) {this.reportName = newName;}
}
