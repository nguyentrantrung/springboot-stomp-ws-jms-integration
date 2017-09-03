/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;

import hello.model.Greeting;
import hello.model.Scoring;

@Controller
public class GreetingController {

	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

	@Autowired
	private JmsTemplate jmsSender;

	@JmsListener(destination = "request")
	public void greeting(Greeting greeting) {
		log.info("Received greeting {}", greeting.getContent());
		jmsSender.convertAndSend("response", new Greeting(greeting.getContent() + " -> Minion"));
	}

	@JmsListener(destination = "requestScore")
	public void scoring(Scoring scoring) {
		log.info("Received scoring {}", scoring.getContent());
		jmsSender.convertAndSend("responseScore",
				new Scoring(scoring.getSessionId(), scoring.getContent() + " -> Score"));
	}

}
