package com.dcits.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.TestAttribute;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.*;

public class ExtentTestNGIReporterListener1 implements IReporter {
    private static final String OUTPUT_FOLDER = "test-output/";
    private static final String FILE_NAME = "Extent.html";

    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        init();

        for (ISuite suite : suites) {
            Map<String,ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                buildTestNodes(context.getPassedTests(), Status.PASS);

            }
        }

        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }

        extent.flush();
    }

    private void init() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        htmlReporter.config().setDocumentTitle("TestNG+Selenium+ExtentReport");
        htmlReporter.config().setReportName("ExtentReport");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //图表位置
        //htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName()); //显示方法名称
                //test.createNode("子案例");  //创建子案例

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group); //根据group

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable()); //异常案例，显示log到报告
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
                test.getModel().setDescription("测试案例执行！");
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}