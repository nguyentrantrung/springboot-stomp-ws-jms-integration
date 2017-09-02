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
package hello.model;

import java.io.Serializable;

public class Scoring implements Serializable {

	private final String sessionId;

	private final String content;

	public Scoring(String sessionId, String content) {
		this.content = content;
		this.sessionId = sessionId;
	}

	public String getContent() {
		return content;
	}
	
	public String getSessionId() {
		return sessionId;
	}

}
