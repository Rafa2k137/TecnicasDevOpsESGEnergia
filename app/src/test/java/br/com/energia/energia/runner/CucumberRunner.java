package br.com.energia.energia.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/energia.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.energia.energia.steps")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty,summary")
public class CucumberRunner {
}
