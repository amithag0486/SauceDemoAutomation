package com.saucedemo.runner;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty, html:target/cucumber-reports/report.html"
)
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "com.saucedemo.steps"
)
public class TestRunner {
    // Empty — annotations do all the work!
}