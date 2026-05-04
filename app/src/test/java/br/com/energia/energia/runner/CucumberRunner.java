package br.com.energia.energia.runner;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.energia.energia.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,summary")
public class CucumberRunner {
}
