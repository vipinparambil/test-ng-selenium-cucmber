$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/test.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Test Scenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "Sample test",
  "keyword": "Given "
});
formatter.match({
  "location": "TestSteps.sample_test()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I open  google",
  "keyword": "When "
});
formatter.match({
  "location": "TestSteps.i_open_google()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "google is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "TestSteps.google_is_displayed()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat com.test.project.steps.TestSteps.google_is_displayed(TestSteps.java:37)\r\n\tat ✽.google is displayed(file:src/test/resources/features/test.feature:8)\r\n",
  "status": "pending"
});
});