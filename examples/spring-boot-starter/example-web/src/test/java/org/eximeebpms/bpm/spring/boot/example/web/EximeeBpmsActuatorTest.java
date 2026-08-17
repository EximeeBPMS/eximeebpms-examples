/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eximeebpms.bpm.spring.boot.example.web;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = { RestApplication.class, RestConfig.class},
    webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        "management.endpoint.health.show-details=always"
    }
)
// TestRestTemplate's auto-configuration became opt-in in Spring Boot 4
@AutoConfigureTestRestTemplate
@DirtiesContext
public class EximeeBpmsActuatorTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(EximeeBpmsActuatorTest.class);

  @Autowired
  private TestRestTemplate testRestTemplate;

  // Spring Boot 4's actuator health JSON serializes "details" before "status"
  // (Spring Boot 3 did the opposite); match either key order.
  private static boolean healthComponentIsUp(String body, String component) {
    return Pattern.compile("\"" + component + "\":\\{.*?,\"status\":\"UP\"").matcher(body).find();
  }

  @Test
  public void jobExecutorHealthIndicatorTest() {
    final String body = getHealthBody();
    assertTrue("wrong body " + body, healthComponentIsUp(body, "jobExecutor"));
  }

  @Test
  public void processEngineHealthIndicatorTest() {
    final String body = getHealthBody();
    assertTrue("wrong body " + body, healthComponentIsUp(body, "processEngine"));
  }

  private String getHealthBody() {
    ResponseEntity<String> entity = testRestTemplate.getForEntity("/actuator/health", String.class);
    final String body = entity.getBody();
    LOGGER.info("body: {}", body);
    return body;
  }
}
